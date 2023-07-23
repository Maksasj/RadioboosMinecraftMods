package com.radioboos.api.forestry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ForestryMiscApi {
    public static ItemStack WOVEN_SILK = findItem("woven_silk");

    private static ItemStack findItem(String name) {
        Item item = GameRegistry.findItem("Forestry", name);
        ItemStack stack = new ItemStack(item, 1);
        return stack;
    }
}
