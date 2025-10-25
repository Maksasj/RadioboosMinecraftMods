package com.radioboos.industriousbatteries.common;

import cpw.mods.fml.common.FMLCommonHandler;
import ic2.api.energy.event.EnergyTileLoadEvent;
import ic2.api.info.Info;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Constants;

public class CommonBatteryStorageTileEntity extends CommonEnergyStorage implements IInventory {
    public ItemStack[] inventory;

    public CommonBatteryStorageTileEntity(ItemStack[] inventory) {
        super();

        this.inventory = inventory;
    }

    @Override
    public final Packet getDescriptionPacket() {
        NBTTagCompound NBT = new NBTTagCompound();
        this.writeToNBT(NBT);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, NBT);
    }

    @Override
    public final void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        this.readFromNBT(pkt.func_148857_g());
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    @Override
    public final void writeToNBT(NBTTagCompound compound) {
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
    public final void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        NBTTagList tagList = compound.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);

        inventory = new ItemStack[getSizeInventory()];

        for (int itemCount = 0; itemCount < tagList.tagCount(); itemCount++)  {
            NBTTagCompound itemCompound = tagList.getCompoundTagAt(itemCount);
            int slot = itemCompound.getByte("Slot") & 0xff;

            if (slot < inventory.length)
                inventory[slot] = ItemStack.loadItemStackFromNBT(itemCompound);
        }
    }

    @Override
    public final void updateEntity() {
        if (!addedToEnergyNet)
            onLoaded();

        worldObj.markAndNotifyBlock(xCoord, yCoord, zCoord, worldObj.getChunkFromBlockCoords(xCoord,zCoord), worldObj.getBlock(xCoord, yCoord,zCoord), worldObj.getBlock(xCoord, yCoord,zCoord), 2);

        storedEnergy = 0;
        maxStoredEnergy = 0;
        transferLimitEnergy = 0;

        for(int i = 0; i < 16; ++i) {
            if(inventory[i] == null)
                continue;

            if(!(inventory[i].getItem() instanceof IElectricItem))
                continue;

            // ElectricItem.manager.charge(item, energyToTransfer, getSourceTier(), false, false);
            storedEnergy += ElectricItem.manager.getCharge(inventory[i]);
            maxStoredEnergy += ((IElectricItem) inventory[i].getItem()).getMaxCharge(inventory[i]);
            transferLimitEnergy += ((IElectricItem) inventory[i].getItem()).getTransferLimit(inventory[i]);

            if(chargePendingEnergy > 0.0) {
                double energyTransferred = ElectricItem.manager.charge(inventory[i], chargePendingEnergy, getSourceTier(), false, false);
                chargePendingEnergy -= energyTransferred;
            }

            if(dischargePendingEnergy > 0.0) {
                double energyTransferred = ElectricItem.manager.discharge(inventory[i], dischargePendingEnergy, getSourceTier(), false, false, false);
                dischargePendingEnergy -= energyTransferred;
            }
        }

        chargePendingEnergy = 0;
        dischargePendingEnergy = 0;

        markDirty();
    }

    public final void onLoaded() {
        if (this.addedToEnergyNet || FMLCommonHandler.instance().getEffectiveSide().isClient() || !Info.isIc2Available())
            return;

        worldObj = getWorldObj();

        MinecraftForge.EVENT_BUS.post(new EnergyTileLoadEvent(this));

        this.addedToEnergyNet = true;
    }

    @Override
    public final int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public final ItemStack getStackInSlot(int index) {
        return inventory[index];
    }

    @Override
    public final ItemStack decrStackSize(int index, int count) {
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
    public final ItemStack getStackInSlotOnClosing(int index) {
        if (inventory[index] == null) {
            return null;
        }

        ItemStack stack = inventory[index];
        inventory[index] = null;

        return stack;
    }

    @Override
    public final void setInventorySlotContents(int index, ItemStack stack) {
        inventory[index] = stack;

        if(stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public final String getInventoryName() {
        return "Common Energy storage tile entity";
    }

    @Override
    public final boolean hasCustomInventoryName() {
        return true;
    }

    @Override
    public final int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public final boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public final void openInventory() {}

    @Override
    public final void closeInventory() {}

    @Override
    public final boolean isItemValidForSlot(int index, ItemStack stack) {
        return stack.getItem() instanceof IElectricItem;
    }
}

