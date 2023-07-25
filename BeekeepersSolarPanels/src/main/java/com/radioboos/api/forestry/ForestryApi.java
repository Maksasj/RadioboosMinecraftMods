package com.radioboos.api.forestry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ForestryApi {
    public static ItemStack HARDENED_MACHINE = findItem("hardenedMachine");

    private static ItemStack findItem(String name) {
        Item item = GameRegistry.findItem("Forestry", name);
        ItemStack stack = new ItemStack(item, 1);
        return stack;
    }
}
