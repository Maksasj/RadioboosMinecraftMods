package com.radioboos.compactsolarpanels;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.info.Info;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.tile.IWrenchable;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.Sys;

public class BasePanelEntity extends TileEntity implements IEnergySource, IWrenchable, IInventory {
    private static final Random random = new Random();

    private ItemStack[] inventory;
    private boolean initialized;
    private int tick;
    private boolean canRain;
    private boolean noSunlight;


    private boolean theSkyIsVisible;
    private boolean theSunIsVisible;


    private final double energyCapacity;
    private final double energyMaxDrain;
    private final double energyDayProduction;
    private final double energyNightProduction;
    private double energyStored;


    private boolean addedToEnet;

    public BasePanelEntity() {
        super();

        this.inventory = new ItemStack[4];
        this.tick = random.nextInt(64);

        this.theSkyIsVisible = false;
        this.theSunIsVisible = false;

        this.energyCapacity = 256000;
        this.energyStored = 0;
        this.energyMaxDrain = 10000;
        this.energyDayProduction = 1000;
        this.energyNightProduction = 100;

        this.addedToEnet = false;
    }

    public double getEnergyStored() {
        return this.energyStored;
    }

    public double getEnergyCapacity() {
        return this.energyCapacity;
    }

    public double getEnergyMaxDrain() {
        return this.energyMaxDrain;
    }

    public double getEnergyProduction() {
        if(!this.theSkyIsVisible) {
            return 0;
        }

        if(!this.theSunIsVisible) {
            return this.energyNightProduction;
        }

        return this.energyDayProduction;
    }

    public boolean isSkyIsVisible() {
        return theSkyIsVisible;
    }

    public boolean isSunIsVisible() {
        return theSunIsVisible;
    }

    @Override
    public void updateEntity() {
        if (!addedToEnet)
            onLoaded();

        if (!this.initialized && this.worldObj != null) {
            this.canRain = this.worldObj.getWorldChunkManager().getBiomeGenAt(this.xCoord, this.zCoord).getIntRainfall() > 0;
            this.noSunlight = this.worldObj.provider.hasNoSky;
            this.initialized = true;
        }

        if (this.noSunlight)
            return;

        if (this.tick-- == 0) {
            updateSunState();
            this.tick = 64;
        }

        this.energyStored += this.getEnergyProduction();
        this.energyStored = Math.min(this.energyStored, this.energyCapacity);

        for (ItemStack itemStack : this.inventory) {
            if(itemStack == null || !(itemStack.getItem() instanceof IElectricItem))
                continue;

            charge(itemStack);
        }
    }

    private void charge(ItemStack item) {
        double energyToTransfer = Math.min(this.energyStored, this.energyMaxDrain);
        double energyTransferred = ElectricItem.manager.charge(item, energyToTransfer, this.getSourceTier(), false, false);
        this.energyStored -= energyTransferred;
    }

    public void onLoaded() {
        if (!this.addedToEnet &&
                !FMLCommonHandler.instance().getEffectiveSide().isClient() &&
                Info.isIc2Available()) {

            this.worldObj = this.getWorldObj();

            MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));

            this.addedToEnet = true;
        }
    }


    public boolean isDaytime(World world) {
        long time = world.getWorldTime() % 24000;
        
        return time >= 0 && time < 12000;
    }


    private void updateSunState() {
        boolean isRaining = this.canRain && (this.worldObj.isRaining() || this.worldObj.isThundering());

        this.theSkyIsVisible = this.worldObj.canBlockSeeTheSky(this.xCoord, this.yCoord + 1, this.zCoord);

        System.out.println(this.isDaytime(this.getWorldObj()) + " | " + !isRaining + " | " + this.theSkyIsVisible);

        this.theSunIsVisible = this.isDaytime(this.getWorldObj()) && !isRaining && this.theSkyIsVisible;
    }

    public ItemStack[] getContents() {
        return this.inventory;
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

        for (int slot = 0; slot < this.inventory.length; slot++) {
            if (this.inventory[slot] != null) {
                NBTTagCompound itemCompound = new NBTTagCompound();

                itemCompound.setByte("Slot", (byte) slot);

                this.inventory[slot].writeToNBT(itemCompound);

                tagList.appendTag(itemCompound);
            }
        }

        compound.setTag("Inventory", tagList);

        // energySource.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        NBTTagList tagList = compound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);

        this.inventory = new ItemStack[getSizeInventory()];

        for (int itemCount = 0; itemCount < tagList.tagCount(); itemCount++)  {
            NBTTagCompound itemCompound = tagList.getCompoundTagAt(itemCount);
            int slot = itemCompound.getByte("Slot") & 0xff;

            if (slot >= 0 && slot < this.inventory.length) {
                this.inventory[slot] = ItemStack.loadItemStackFromNBT(itemCompound);
            }
        }

        // energySource.readFromNBT(compound);
    }

    @Override
    public int getSizeInventory() {
        return this.inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return this.inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if(this.inventory[index] == null) {
            return null;
        }

        if(this.inventory[index].stackSize <= count) {
            ItemStack itemStack = inventory[index];
            inventory[index] = null;
            return itemStack;
        }

        ItemStack itemStack1 = this.inventory[index].splitStack(count);

        if (this.inventory[index].stackSize == 0) {
            this.inventory[index] = null;
        }

        return itemStack1;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        if (this.inventory[index] == null) {
            return null;
        }

        ItemStack stack = this.inventory[index];
        this.inventory[index] = null;
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        this.inventory[index] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
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
        return 64;
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
        if(stack == null || !(stack.getItem() instanceof IElectricItem)) {
            return false;
        }

        return true;
    }

    @Override
    public double getOfferedEnergy() {
        return Math.min(this.energyStored, this.energyMaxDrain);
    }

    @Override
    public void drawEnergy(double energyAmount) {
        this.energyStored -= energyAmount;
    }

    @Override
    public int getSourceTier() {
        return 6;
    }

    @Override
    public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
        return true;
    }
}