package com.radioboos.beekeeperssolarpanels.gui;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SolarPanelContainer extends Container {
    private CommonSolarPanelTileEntity panel;

    public SolarPanelContainer(IInventory playerInventory, CommonSolarPanelTileEntity panel) {
        this.panel = panel;

        addSlotToContainer(new Slot(panel, 0, 8, 57));
        addSlotToContainer(new Slot(panel, 1, 26, 57));
        addSlotToContainer(new Slot(panel, 2, 44, 57));
        addSlotToContainer(new Slot(panel, 3, 62, 57));

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
