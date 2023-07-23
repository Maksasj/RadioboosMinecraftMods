package com.radioboos.api.forestry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ForestryCombApi {
    public static ItemStack HONEY_COMB = findItem();
    public static ItemStack SIMMERING_COMB = findItem(2);
    public static ItemStack STRINGY_COMB = findItem(3);
    public static ItemStack FROZEN_COMB = findItem(4);
    public static ItemStack DRIPPING_COMB = findItem(5);
    public static ItemStack SILKY_COMB = findItem(6);
    public static ItemStack PARCHED_COMB = findItem(7);
    public static ItemStack MOSSY_COMB = findItem(15);
    public static ItemStack MELLOW_COMB = findItem(16);

    private static ItemStack findItem() {
        Item item = GameRegistry.findItem("Forestry", "beeCombs");
        ItemStack stack = new ItemStack(item, 1);
        return stack;
    }

    private static ItemStack findItem(int meta) {
        Item item = GameRegistry.findItem("Forestry", "beeCombs");
        ItemStack stack = new ItemStack(item, 1, meta);
        return stack;
    }
}
