package com.radioboos.industriousbatteries.common;

import cpw.mods.fml.common.FMLCommonHandler;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.info.Info;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.tile.IEnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;

public class CommonEnergyStorageTileEntity extends TileEntity implements IInventory,IEnergySink, IEnergySource, INetworkClientTileEntityEventListener, IEnergyStorage {
    public double storedEnergy;
    public double maxStoredEnergy;

    public double chargePendingEnergy;
    public double dischargePendingEnergy;

    public ItemStack inventory[];

    public boolean addedToEnergyNet;

    public CommonEnergyStorageTileEntity() {
        super();

        this.storedEnergy = 0.0;
        this.maxStoredEnergy = 1000000000.0;

        this.chargePendingEnergy = 0.0;
        this.dischargePendingEnergy = 0.0;

        this.inventory = new ItemStack[20];

        this.addedToEnergyNet = false;
    }
    /*
    double energyToTransfer = Math.min(energyStored, energyMaxDrain);
    double energyTransferred = ElectricItem.manager.charge(item, energyToTransfer, getSourceTier(), false, false);
    energyStored -= energyTransferred;
    */


    // double charge(ItemStack stack, double amount, int tier, boolean ignoreTransferLimit, boolean simulate);
    // double discharge(ItemStack stack, double amount, int tier, boolean ignoreTransferLimit, boolean externally, boolean simulate);

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound NBT = new NBTTagCompound();
        this.writeToNBT(NBT);
        S35PacketUpdateTileEntity pack = new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, NBT);
        return pack;
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        NBTTagList tagList = new NBTTagList();

        for (int slot = 0; slot < inventory.length; slot++) {
            if (inventory[slot] != null) {
                NBTTagCompound itemCompound = new NBTTagCompound();

                itemCompound.setByte("Slot", (byte) slot);

                inventory[slot].writeToNBT(itemCompound);

                tagList.appendTag(itemCompound);
            }
        }

        compound.setTag("Inventory", tagList);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        NBTTagList tagList = compound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);

        inventory = new ItemStack[getSizeInventory()];

        for (int itemCount = 0; itemCount < tagList.tagCount(); itemCount++)  {
            NBTTagCompound itemCompound = tagList.getCompoundTagAt(itemCount);
            int slot = itemCompound.getByte("Slot") & 0xff;

            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(itemCompound);
            }
        }
    }

    @Override
    public void updateEntity() {
        if (!addedToEnergyNet)
            onLoaded();


        worldObj.markAndNotifyBlock(xCoord, yCoord, zCoord, worldObj.getChunkFromBlockCoords(xCoord,zCoord), worldObj.getBlock(xCoord, yCoord,zCoord), worldObj.getBlock(xCoord, yCoord,zCoord), 2);

        storedEnergy = 0;
        maxStoredEnergy = 0;

        for(int i = 0; i < 16; ++i) {
            if(inventory[i] == null)
                continue;

            // ElectricItem.manager.charge(item, energyToTransfer, getSourceTier(), false, false);
            storedEnergy += ElectricItem.manager.getCharge(inventory[i]);
            maxStoredEnergy += ((IElectricItem) inventory[i].getItem()).getMaxCharge(inventory[i]);

            if(chargePendingEnergy > 0.0) {
                double energyTransferred = ElectricItem.manager.charge(inventory[i], chargePendingEnergy, getSourceTier(), true, false);
                chargePendingEnergy -= energyTransferred;
            }

            if(dischargePendingEnergy > 0.0) {
                double energyTransferred = ElectricItem.manager.discharge(inventory[i], dischargePendingEnergy, getSourceTier(), true, false, false);
                chargePendingEnergy -= energyTransferred;
            }
        }

        System.out.println(chargePendingEnergy + " " + dischargePendingEnergy);

        chargePendingEnergy = 0;
        dischargePendingEnergy = 0;

        markDirty();
    }

    public void onLoaded() {
        if (this.addedToEnergyNet || FMLCommonHandler.instance().getEffectiveSide().isClient() || !Info.isIc2Available()) {
            return;
        }

        worldObj = getWorldObj();

        MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));

        this.addedToEnergyNet = true;
    }

    public boolean acceptsEnergyFrom(TileEntity emitter, ForgeDirection direction) {
        if(direction != ForgeDirection.UP) {
            return false;
        }

        return true;
    }

    public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
        if(direction != ForgeDirection.UP) {
            return true;
        }

        return false;
    }

    public boolean facingMatchesDirection(ForgeDirection direction) {
        return direction.ordinal() == this.getFacing();
    }

    private int getFacing() {
        return 0;
    }

    public double getOfferedEnergy() {
        return storedEnergy;
    }

    public void drawEnergy(double amount) {
        dischargePendingEnergy = amount;
    }

    public double getDemandedEnergy() {
        return (double)this.maxStoredEnergy - this.storedEnergy;
    }

    public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {
        // double toReturn = chargePendingEnergy;
        chargePendingEnergy = amount;

        return amount;
    }

    public int getSourceTier() {
        return 6;
    }

    public int getSinkTier() {
        return 6;
    }

    // @SideOnly(Side.CLIENT)
    // public GuiScreen getGui(EntityPlayer entityPlayer, boolean isAdmin) {
    //     return new GuiElectricBlock(new ContainerElectricBlock(entityPlayer, this));
    // }

    public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
        return this.getFacing() != side;
    }

    public void setFacing(short facing) {
        if (this.addedToEnergyNet) {
            MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
        }

        if (this.addedToEnergyNet) {
            this.addedToEnergyNet = false;
            MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
            this.addedToEnergyNet = true;
        }
    }

    public void onNetworkEvent(EntityPlayer player, int event) {
        // ++this.redstoneMode;
        // if (this.redstoneMode >= redstoneModes) {
        //     this.redstoneMode = 0;
        // }

        // IC2.platform.messagePlayer(player, this.getredstoneMode(), new Object[0]);
    }

    /*
    public String getredstoneMode() {
        return this.redstoneMode <= 6 && this.redstoneMode >= 0 ? StatCollector.translateToLocal("ic2.EUStorage.gui.mod.redstone" + this.redstoneMode) : "";
    }
    */

    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        // ItemStack ret = super.getWrenchDrop(entityPlayer);
        // float energyRetainedInStorageBlockDrops = ConfigUtil.getFloat(MainConfig.get(), "balance/energyRetainedInStorageBlockDrops");
        // if (energyRetainedInStorageBlockDrops > 0.0F) {
        //     NBTTagCompound nbttagcompound = StackUtil.getOrCreateNbtData(ret);
        //     nbttagcompound.setDouble("energy", this.energy * (double)energyRetainedInStorageBlockDrops);
        // }

        return null;
    }

    public int getStored() {
        return (int)this.storedEnergy;
    }

    public int getCapacity() {
        return (int) this.maxStoredEnergy;
    }

    public int getOutput() {
        return (int)this.storedEnergy;
    }

    public double getOutputEnergyUnitsPerTick() {
        return (int)this.storedEnergy;
    }

    public void setStored(int amount) {
        this.storedEnergy = (double)amount;
    }

    public int addEnergy(int amount) {
        chargePendingEnergy = amount;
        return amount;
    }

    public boolean isTeleporterCompatible(ForgeDirection side) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if(inventory[index] == null) {
            return null;
        }

        if(inventory[index].stackSize <= count) {
            ItemStack itemStack = inventory[index];
            inventory[index] = null;
            return itemStack;
        }

        ItemStack itemStack1 = inventory[index].splitStack(count);

        if (inventory[index].stackSize == 0) {
            inventory[index] = null;
        }

        return itemStack1;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        if (inventory[index] == null) {
            return null;
        }

        ItemStack stack = inventory[index];
        inventory[index] = null;
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventory[index] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return "Common Energy storage tile entity";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (stack.getItem() instanceof IElectricItem) {
            return true;
        }

        return false;
    }
}

