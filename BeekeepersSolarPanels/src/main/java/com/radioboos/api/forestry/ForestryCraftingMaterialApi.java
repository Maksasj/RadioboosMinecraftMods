package com.radioboos.api.forestry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ForestryCraftingMaterialApi {
    public static ItemStack PULSATING_DUST = findItem(0);
    public static ItemStack PULSATING_MESH = findItem(1);
    public static ItemStack SILK_WISP = findItem(2);
    public static ItemStack WOVEN_SILK = findItem(3);
    public static ItemStack DISSIPATION_CHARGE = findItem(4);
    public static ItemStack ICE_SHARD = findItem(5);
    public static ItemStack SCENTED_PANELING = findItem(6);

    private static ItemStack findItem(int meta) {
        Item item = GameRegistry.findItem("Forestry", "craftingMaterial");
        ItemStack stack = new ItemStack(item, 1, meta);
        return stack;
    }
}
