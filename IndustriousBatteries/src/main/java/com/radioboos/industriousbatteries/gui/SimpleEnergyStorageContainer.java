package com.radioboos.industriousbatteries.gui;

import com.radioboos.industriousbatteries.tiles.SimpleBatteryStorageTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SimpleEnergyStorageContainer extends Container {
    public SimpleEnergyStorageContainer(IInventory playerInventory, SimpleBatteryStorageTileEntity storage) {
        for(int i = 0; i < 16; ++i) {
            int row = i % 4;
            int collum = i / 4;

            addSlotToContainer(new Slot(storage, i, -1 + 18 * row, 3 + 18 * collum));
        }

        // Player inventory
        for (int inventoryRow = 0; inventoryRow < 3; inventoryRow++) {
            for (int inventoryColumn = 0; inventoryColumn < 9; inventoryColumn++) {
                addSlotToContainer(new Slot(playerInventory, inventoryColumn + inventoryRow * 9 + 9, 8 + inventoryColumn * 18, 84 + inventoryRow * 18));
            }
        }

        // Player hotbar
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
        return null;
    }
}
