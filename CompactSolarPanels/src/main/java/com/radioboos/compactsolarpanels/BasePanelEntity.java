package com.radioboos.compactsolarpanels;

import ic2.api.item.IElectricItem;
import ic2.api.tile.IWrenchable;
import ic2.api.energy.prefab.BasicSource;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class BasePanelEntity extends TileEntity implements IWrenchable, IInventory {
    private BasicSource energySource;
    private static Random random = new Random();
    private ItemStack[] inventory;
    private boolean initialized;
    public boolean theSunIsVisible;
    private int tick;
    private boolean canRain;
    private boolean noSunlight;

    // public SolarPanelContainer container;

    public BasePanelEntity() {
        super();
        this.inventory = new ItemStack[4];
        this.tick = random.nextInt(64);
        this.energySource = new BasicSource(this, 256000, 6);
    }

    @Override
    public void updateEntity() {
        energySource.updateEntity();

        if (!initialized && worldObj != null) {
            canRain = worldObj.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord).getIntRainfall() > 0;
            noSunlight = worldObj.provider.hasNoSky;
            initialized = true;
        }

        if (noSunlight) {
            return;
        }

        if (tick-- == 0) {
            updateSunState();
            tick = 64;
        }

        int energyProduction = 0;

        if (theSunIsVisible) {
            energyProduction = generateEnergy();
        }

        energySource.addEnergy(energyProduction);

        for (ItemStack itemStack : inventory) {
            if(itemStack == null || !(itemStack.getItem() instanceof IElectricItem)) {
                continue;
            }

            energySource.charge(itemStack);
        }
    }

    private void updateSunState() {
        boolean isRaining = canRain && (worldObj.isRaining() || worldObj.isThundering());
        theSunIsVisible = worldObj.isDaytime() && !isRaining && worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord);
    }

    private int generateEnergy() {
        return 1;
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

        for (int slot = 0; slot < this.inventory.length; slot++) {
            if (this.inventory[slot] != null) {
                NBTTagCompound itemCompound = new NBTTagCompound();

                itemCompound.setByte("Slot", (byte) slot);

                this.inventory[slot].writeToNBT(itemCompound);

                tagList.appendTag(itemCompound);
            }
        }

        compound.setTag("Inventory", tagList);

        energySource.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        System.out.println(compound.toString());

        super.readFromNBT(compound);

        NBTTagList tagList = compound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);

        inventory = new ItemStack[getSizeInventory()];

        System.out.println(tagList.tagCount());

        for (int itemCount = 0; itemCount < tagList.tagCount(); itemCount++)  {
            NBTTagCompound itemCompound = tagList.getCompoundTagAt(itemCount);
            int slot = itemCompound.getByte("Slot") & 0xff;

            if (slot >= 0 && slot < this.inventory.length) {
                System.out.println("Loading item stack from nbt");

                this.inventory[slot] = ItemStack.loadItemStackFromNBT(itemCompound);
            }
        }

        energySource.readFromNBT(compound);
    }

    @Override
    public void onChunkUnload() {
        energySource.onChunkUnload();
        super.onChunkUnload();
    }

    @Override
    public void invalidate() {
        energySource.invalidate();
        super.invalidate();
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
        if (this.inventory[index] == null) {
            return null;
        }

        ItemStack stack = this.inventory[index];
        this.inventory[index] = null;
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
}