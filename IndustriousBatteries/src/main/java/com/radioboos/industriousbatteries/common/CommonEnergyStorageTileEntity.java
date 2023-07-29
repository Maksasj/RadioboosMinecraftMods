package com.radioboos.industriousbatteries.common;

import cpw.mods.fml.common.FMLCommonHandler;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.info.Info;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.tile.IEnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

public class CommonEnergyStorageTileEntity extends TileEntity implements IInventory,IEnergySink, IEnergySource, INetworkClientTileEntityEventListener, IEnergyStorage {
    public double storedEnergy;
    public double maxStoredEnergy;


    // public boolean hasRedstone = false;
    // public byte redstoneMode = 0;
    // public static byte redstoneModes = 7;
    // private boolean isEmittingRedstone = false;
    // private int redstoneUpdateInhibit = 5;
    public boolean addedToEnergyNet;

    public CommonEnergyStorageTileEntity(int tier1, int output1, int maxStorage1) {
        this.storedEnergy = 0.0;
        this.maxStoredEnergy = 1000000000.0;

        this.addedToEnergyNet = false;
    }
    /*

     double energyToTransfer = Math.min(energyStored, energyMaxDrain);
        double energyTransferred = ElectricItem.manager.charge(item, energyToTransfer, getSourceTier(), false, false);
        energyStored -= energyTransferred;
        
     */

    // double charge(ItemStack stack, double amount, int tier, boolean ignoreTransferLimit, boolean simulate);
    // double discharge(ItemStack stack, double amount, int tier, boolean ignoreTransferLimit, boolean externally, boolean simulate);

    public void readFromNBT(NBTTagCompound nbttagcompound) {
        // super.readFromNBT(nbttagcompound);
        // this.energy = Util.limit(nbttagcompound.getDouble("energy"), 0.0, (double)this.maxStorage + EnergyNet.instance.getPowerFromTier(this.tier));
        // this.redstoneMode = nbttagcompound.getByte("redstoneMode");
    }

    public void writeToNBT(NBTTagCompound nbttagcompound) {
        // super.writeToNBT(nbttagcompound);
        // nbttagcompound.setDouble("energy", this.energy);
        // nbttagcompound.setBoolean("active", this.getActive());
        // nbttagcompound.setByte("redstoneMode", this.redstoneMode);
    }

    @Override
    public void updateEntity() {
        if (!addedToEnergyNet)
            onLoaded();

        System.out.println(storedEnergy + " " + maxStoredEnergy);

        worldObj.markAndNotifyBlock(xCoord, yCoord, zCoord, worldObj.getChunkFromBlockCoords(xCoord,zCoord), worldObj.getBlock(xCoord, yCoord,zCoord), worldObj.getBlock(xCoord, yCoord,zCoord), 2);

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
        // return !(this.energy >= (double)this.output) || this.redstoneMode == 5 && this.hasRedstone || this.redstoneMode == 6 && this.hasRedstone && !(this.energy >= (double)this.maxStorage) ? 0.0 : Math.min(this.energy, (double)this.output);

        return storedEnergy;
    }

    public void drawEnergy(double amount) {
        this.storedEnergy -= amount;
    }

    public double getDemandedEnergy() {
        return (double)this.maxStoredEnergy - this.storedEnergy;
    }

    public double injectEnergy(ForgeDirection directionFrom, double amount, double voltage) {
        if (this.storedEnergy >= (double)this.maxStoredEnergy) {
            return amount;
        } else {
            this.storedEnergy += amount;
            return 0.0;
        }
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

    public void onGuiClosed(EntityPlayer entityPlayer) {
    }

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

    public void setStored(int energy1) {
        this.storedEnergy = (double)energy1;
    }

    public int addEnergy(int amount) {
        this.storedEnergy += (double)amount;
        return amount;
    }

    public boolean isTeleporterCompatible(ForgeDirection side) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }
}

