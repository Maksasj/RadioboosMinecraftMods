package com.radioboos.adinfinitumcore.common;

import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.energy.event.EnergyTileUnloadEvent;
import ic2.api.energy.tile.IEnergySink;
import ic2.api.energy.tile.IEnergySource;
import ic2.api.network.INetworkClientTileEntityEventListener;
import ic2.api.tile.IEnergyStorage;
import ic2.api.tile.IWrenchable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

public class CommonEnergyStorage extends TileEntity implements IWrenchable, IEnergySource, IEnergySink, IEnergyStorage, INetworkClientTileEntityEventListener {
    public double storedEnergy;
    public double maxStoredEnergy;

    public double chargePendingEnergy;
    public double dischargePendingEnergy;

    public double transferLimitEnergy;

    public short side;
    public ForgeDirection facingDirection;

    public boolean addedToEnergyNet;

    public CommonEnergyStorage() {
        this.storedEnergy = 0.0;
        this.maxStoredEnergy = 0.0;

        this.chargePendingEnergy = 0.0;
        this.dischargePendingEnergy = 0.0;

        this.transferLimitEnergy = 0.0;

        this.facingDirection = ForgeDirection.VALID_DIRECTIONS[0];
        this.addedToEnergyNet = false;
    }

    // IWrenchable
    @Override
    public final boolean wrenchCanSetFacing(EntityPlayer entityPlayer, int i) {
        return true;
    }

    @Override
    public final short getFacing() {
        return side;
    }

    @Override
    public final void setFacing(short facing) {
        worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, facing, 2);

        this.side = facing;
        this.facingDirection = ForgeDirection.VALID_DIRECTIONS[facing];

        if (this.addedToEnergyNet) {
            MinecraftForge.EVENT_BUS.post(new EnergyTileUnloadEvent(this));
        }

        if (this.addedToEnergyNet) {
            this.addedToEnergyNet = false;
            MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));
            this.addedToEnergyNet = true;
        }
    }

    @Override
    public final boolean wrenchCanRemove(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public final float getWrenchDropRate() {
        return 1.0f;
    }

    @Override
    public final ItemStack getWrenchDrop(EntityPlayer entityPlayer) {
        return null;
    }

    // IEnergySource
    @Override
    public final double getOfferedEnergy() {
        return Math.min(storedEnergy, transferLimitEnergy);
    }

    @Override
    public final void drawEnergy(double amount) {
        dischargePendingEnergy = amount;
    }

    @Override
    public final int getSourceTier() {
        return 6;
    }

    @Override
    public boolean emitsEnergyTo(TileEntity tileEntity, ForgeDirection direction) {
        return direction == facingDirection;
    }

    // IEnergySink
    @Override
    public final double getDemandedEnergy() {
        return this.maxStoredEnergy - this.storedEnergy;
    }

    @Override
    public final int getSinkTier() {
        return 6;
    }

    @Override
    public final double injectEnergy(ForgeDirection forgeDirection, double amount, double voltage) {
        double delta = maxStoredEnergy - storedEnergy;
        chargePendingEnergy = Math.min(amount, Math.min(transferLimitEnergy, delta));
        return amount - chargePendingEnergy;
    }

    @Override
    public final boolean acceptsEnergyFrom(TileEntity tileEntity, ForgeDirection direction) {
        return direction != facingDirection;
    }

    // IEnergyStorage
    @Override
    public final int getStored() {
        return (int) this.storedEnergy;
    }

    @Override
    public final void setStored(int amount) {
        this.storedEnergy = amount;
    }

    @Override
    public final int addEnergy(int amount) {
        double delta = maxStoredEnergy - storedEnergy;
        chargePendingEnergy = Math.min(amount, Math.min(transferLimitEnergy, delta));
        return (int) (amount - chargePendingEnergy);
    }

    @Override
    public final int getCapacity() {
        return (int) this.maxStoredEnergy;
    }

    @Override
    public final int getOutput() {
        return (int) Math.min(this.storedEnergy, this.transferLimitEnergy);
    }

    @Override
    public final double getOutputEnergyUnitsPerTick() {
        return (int) this.transferLimitEnergy;
    }

    @Override
    public final boolean isTeleporterCompatible(ForgeDirection forgeDirection) {
        return false;
    }

    // INetworkClientTileEntityEventListener
    @Override
    public final void onNetworkEvent(EntityPlayer entityPlayer, int i) {

    }
}
