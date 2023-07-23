package com.radioboos.beekeeperssolarpanels.common;

import cpw.mods.fml.common.FMLCommonHandler;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.info.Info;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.tile.IWrenchable;
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

public class CommonSolarPanelTileEntity extends TileEntity implements IEnergySource, IWrenchable, IInventory {
    private ItemStack[] inventory;

    private boolean initialized;
    private boolean addedToEnet;

    private int tick;
    private boolean canRain;
    private boolean noSunlight;
    private boolean theSkyIsVisible;
    private boolean theSunIsVisible;

    // Energy stuff
    private final double energyCapacity;
    private final double energyMaxDrain;
    private final double energyDayProduction;
    private final double energyNightProduction;
    private double energyStored;

    public CommonSolarPanelTileEntity(CommonSolarPanelConfig config) {
        super();

        inventory = new ItemStack[4];
        tick = Utils.random.nextInt(64);

        theSkyIsVisible = false;
        theSunIsVisible = false;

        energyCapacity = config.getCapacity();
        energyStored = 0;
        energyMaxDrain = config.getMaxDrain();
        energyDayProduction = config.getDayProduction();
        energyNightProduction = config.getNightProduction();

        addedToEnet = false;
    }

    public double getEnergyProduction() {
        if (!theSkyIsVisible) {
            return 0;
        }

        if (!theSunIsVisible) {
            return energyNightProduction;
        }

        return energyDayProduction;
    }

    @Override
    public void updateEntity() {
        if (!addedToEnet)
            onLoaded();

        if (!initialized && worldObj != null) {
            canRain = worldObj.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord).getIntRainfall() > 0;
            noSunlight = worldObj.provider.hasNoSky;
            initialized = true;
        }

        if (noSunlight)
            return;

        if (tick-- == 0) {
            updateSunState();
            tick = 64;
        }

        energyStored += getEnergyProduction();
        energyStored = Math.min(energyStored, energyCapacity);

        for (ItemStack itemStack : inventory) {
            if (itemStack == null || !(itemStack.getItem() instanceof IElectricItem))
                continue;

            charge(itemStack);
        }

        worldObj.markAndNotifyBlock(xCoord, yCoord, zCoord, worldObj.getChunkFromBlockCoords(xCoord, zCoord), worldObj.getBlock(xCoord, yCoord, zCoord), worldObj.getBlock(xCoord, yCoord, zCoord), 2);

        markDirty();
    }

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

    private void charge(ItemStack item) {
        double energyToTransfer = Math.min(energyStored, energyMaxDrain);
        double energyTransferred = ElectricItem.manager.charge(item, energyToTransfer, getSourceTier(), false, false);
        energyStored -= energyTransferred;
    }

    public void onLoaded() {
        if (addedToEnet || FMLCommonHandler.instance().getEffectiveSide().isClient() || !Info.isIc2Available()) {
            return;
        }

        worldObj = getWorldObj();

        MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));

        addedToEnet = true;
    }

    private void updateSunState() {
        boolean isRaining = canRain && (worldObj.isRaining() || worldObj.isThundering());

        theSkyIsVisible = worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord);
        theSunIsVisible = Utils.isDaytime(getWorldObj()) && !isRaining && theSkyIsVisible;
    }

    public double getEnergyStored() {
        return energyStored;
    }

    public double getEnergyCapacity() {
        return energyCapacity;
    }

    public double getEnergyMaxDrain() {
        return energyMaxDrain;
    }

    public boolean isSkyIsVisible() {
        return theSkyIsVisible;
    }

    public boolean isSunIsVisible() {
        return theSunIsVisible;
    }

    public ItemStack[] getContents() {
        return inventory;
    }

    @Override
    public boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int side) {
        return false;
    }

    @Override
    public short getFacing() {
        return 0;
    }

    @Override
    public void setFacing(short facing) {

    }

    @Override
    public boolean wrenchCanRemove(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public float getWrenchDropRate() {
        return 1.0F;
    }

    @Override
    public ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return null;
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
        compound.setDouble("EnergyStored", energyStored);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        NBTTagList tagList = compound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);

        inventory = new ItemStack[getSizeInventory()];

        for (int itemCount = 0; itemCount < tagList.tagCount(); itemCount++) {
            NBTTagCompound itemCompound = tagList.getCompoundTagAt(itemCount);
            int slot = itemCompound.getByte("Slot") & 0xff;

            if (slot >= 0 && slot < inventory.length) {
                inventory[slot] = ItemStack.loadItemStackFromNBT(itemCompound);
            }
        }

        energyStored = compound.getDouble("EnergyStored");
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
        if (inventory[index] == null) {
            return null;
        }

        if (inventory[index].stackSize <= count) {
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

        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return "Compressed Solar Panel";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
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
        if (stack == null || !(stack.getItem() instanceof IElectricItem)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
        return true;
    }

    @Override
    public double getOfferedEnergy() {
        return Math.min(energyStored, energyMaxDrain);
    }

    @Override
    public void drawEnergy(double energyAmount) {
        energyStored -= energyAmount;
    }

    @Override
    public int getSourceTier() {
        return 6;
    }
}
