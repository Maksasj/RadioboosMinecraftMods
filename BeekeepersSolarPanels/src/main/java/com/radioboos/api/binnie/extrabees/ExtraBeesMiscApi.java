package com.radioboos.api.binnie.extrabees;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtraBeesMiscApi {
    public static ItemStack SCENTED_GEAR = findItem(0);
    public static ItemStack DIAMOND_FRAGMENT = findItem(1);
    public static ItemStack EMERALD_FRAGMENT = findItem(2);
    public static ItemStack LAPIS_FRAGMENT = findItem(5);
    public static ItemStack IRON_GRAINS = findItem(6);
    public static ItemStack GOLD_GRAINS = findItem(7);
    public static ItemStack SILVER_GRAINS = findItem(8);
    public static ItemStack COPPER_GRAINS = findItem(10);
    public static ItemStack TIN_GRAINS = findItem(11);
    public static ItemStack LEAD_GRAINS = findItem(13);
    public static ItemStack RADIOACTIVE_GRAINS = findItem(17);
    public static ItemStack COAL_GRAINS = findItem(18);
    public static ItemStack RED_DYE = findItem(19);
    public static ItemStack YELLOW_DYE = findItem(20);
    public static ItemStack BLUE_DYE = findItem(21);
    public static ItemStack GREEN_DYE = findItem(22);
    public static ItemStack WHITE_DYE = findItem(23);
    public static ItemStack BLACK_DYE = findItem(24);
    public static ItemStack BROWN_DYE = findItem(25);
    public static ItemStack CLAY_DUST = findItem(26);

    private static ItemStack findItem(int meta) {
        Item item = GameRegistry.findItem("ExtraBees", "misc");
        ItemStack stack = new ItemStack(item, 1, meta);
        return stack;
    }
}
