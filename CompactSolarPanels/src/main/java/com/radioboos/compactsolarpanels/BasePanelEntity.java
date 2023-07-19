package com.radioboos.compactsolarpanels;

import ic2.api.tile.IWrenchable;
import ic2.api.energy.prefab.BasicSource;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nonnull;

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
        this.inventory = new ItemStack[1];

        this.setInventorySlotContents(0, new ItemStack(new ItemBook(), 13));

        this.tick = random.nextInt(64);
        this.energySource = new BasicSource(this, 10000, 6);
        // this.container = new SolarPanelContainer();
    }

    @Override
    public void updateEntity() {
        energySource.onUpdateEntity();
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

        if (theSunIsVisible && (1 == 1 || random.nextInt(5) == 0)) {
            energyProduction = generateEnergy();
        }
        energySource.addEnergy(energyProduction);

        // if (inventory[0] != null && (Item.itemsList[inventory[0].itemID] instanceof IElectricItem)) {
        //     energySource.charge(inventory[0]);
        // }
    }

    private void updateSunState() {
        boolean isRaining = canRain && (worldObj.isRaining() || worldObj.isThundering());
        theSunIsVisible = worldObj.isDaytime() && !isRaining && worldObj.canBlockSeeTheSky(xCoord, yCoord + 1, zCoord);
    }

    private int generateEnergy() {
        return 96000;
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
    public void writeToNBT(NBTTagCompound nbttagcompound) {
        super.writeToNBT(nbttagcompound);
        /*
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                inventory[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
        energySource.onWriteToNbt(nbttagcompound);
        */
    }

    @Override
    public void readFromNBT(NBTTagCompound nbttagcompound) {
        super.readFromNBT(nbttagcompound);

        // energySource.onReadFromNbt(nbttagcompound);
        // NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        // inventory = new ItemStack[getSizeInventory()];
        // for (int i = 0; i < nbttaglist.tagCount(); i++) {
        //     // NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
        //     // int j = nbttagcompound1.getByte("Slot") & 0xff;
        //     // if (j >= 0 && j < inventory.length) {
        //     //     inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
        //     // }
        // }
    }

    @Override
    public void onChunkUnload() {
        energySource.onChunkUnload();
    }

    // @SideOnly(Side.CLIENT)
    // public GuiScreen getGui(EntityPlayer player, boolean isAdmin) {
    //     return new GUISolar(container);
    //     // return new BackgroundlessDynamicGUI();
    // }

    @Nonnull
    protected String getGuiDef() {
        return "solar_panel_overtime";
    }

    @Override
    public void invalidate() {
        energySource.onInvalidate();
        super.invalidate();
    }

    @Override
    public int getSizeInventory() {
        return 1;
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
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return true;
    }
}