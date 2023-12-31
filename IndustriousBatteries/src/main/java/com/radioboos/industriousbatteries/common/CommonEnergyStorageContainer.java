package com.radioboos.industriousbatteries.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class CommonEnergyStorageContainer extends Container {
    private CommonEnergyStorageTileEntity panel;

    public CommonEnergyStorageContainer(IInventory playerInventory, CommonEnergyStorageTileEntity panel) {
        this.panel = panel;

        for(int i = 0; i < 16; ++i) {
            int row = i % 4;
            int collum = i / 4;

            addSlotToContainer(new Slot(panel, i, -1 + 18 * row, 3 + 18 * collum));
        }

        for (int inventoryRow = 0; inventoryRow < 3; inventoryRow++) {
            for (int inventoryColumn = 0; inventoryColumn < 9; inventoryColumn++) {
                addSlotToContainer(new Slot(playerInventory, inventoryColumn + inventoryRow * 9 + 9, 8 + inventoryColumn * 18, 84 + inventoryRow * 18));
            }
        }

        for (int hotbarSlot = 0; hotbarSlot < 9; hotbarSlot++) {
            addSlotToContainer(new Slot(playerInventory, hotbarSlot, 8 + hotbarSlot * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }
        }

        return null;
    }
}
