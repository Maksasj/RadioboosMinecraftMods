package com.radioboos.compactsolarpanels;

import ibxm.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import org.lwjgl.Sys;

import java.io.Console;
import java.util.List;

public class SolarPanelContainer extends Container {
    private BasePanelEntity panel;

    public SolarPanelContainer(IInventory playerInventory, BasePanelEntity panel) {
        this.panel = panel;

        addSlotToContainer(new Slot(panel, 0, 80, 26));

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
        System.out.println(index);
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
