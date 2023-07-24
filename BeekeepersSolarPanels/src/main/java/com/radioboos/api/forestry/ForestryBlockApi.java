package com.radioboos.api.forestry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ForestryBlockApi {
    public static ItemStack ALVEARY = findItem("alveary");

    private static ItemStack findItem(String name) {
        Item item = GameRegistry.findItem("Forestry", name);
        ItemStack stack = new ItemStack(item, 1);
        return stack;
    }

    private static ItemStack findItem(String name, int meta) {
        Item item = GameRegistry.findItem("Forestry", name);
        ItemStack stack = new ItemStack(item, meta);
        return stack;
    }
}
