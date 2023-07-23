package com.radioboos.api.ic2;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class IC2Api {
    protected static Class<?> itemRegister;

    public static ItemStack getItem(String name) {
        try {
            if (itemRegister == null) {
                itemRegister = Class.forName("ic2.core.Ic2Items");
            }

            Object ret = itemRegister.getField(name).get((Object)null);
            return ret instanceof ItemStack ? (ItemStack)ret : null;
        } catch (Exception var2) {
            return null;
        }
    }

    public static Block getBlock(String name) {
        return null;
    }
}
