package com.radioboos.compactsolarpanels;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.List;

public class SolarPanelContainer extends Container {
    public SolarPanelContainer(IInventory playerInventory, BasePanelEntity inventory) {
        layoutContainer(playerInventory, inventory);
    }

    private void layoutContainer(IInventory playerInventory, IInventory inventory) {
        addSlotToContainer(new Slot(inventory, 0, 80, 26));

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
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int i) {
        ItemStack itemstack = null;
        Slot slot = (Slot) inventorySlots.get(i);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i == 0) {
                if (!mergeItemStack(itemstack1, 1, 37, true)) {
                    return null;
                }
            } else if (i >= 1 && i < 28) {
                if (!mergeItemStack(itemstack1, 28, 37, false)) {
                    return null;
                }
            } else if (i >= 28 && i < 37) {
                if (!mergeItemStack(itemstack1, 1, 27, false)) {
                    return null;
                }
            } else if (!mergeItemStack(itemstack1, 1, 37, false)) {
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize != itemstack.stackSize) {
                slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
            } else {
                return null;
            }
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }
}
