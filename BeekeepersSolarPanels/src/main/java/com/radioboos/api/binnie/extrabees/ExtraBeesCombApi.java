package com.radioboos.api.binnie.extrabees;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExtraBeesCombApi {
    public static ItemStack FOSSILISED_COMB = findItem(4);
    public static ItemStack DAMP_COMB = findItem(6);
    public static ItemStack MILKY_COMB = findItem(7);
    public static ItemStack FRUIT_COMB = findItem(8);
    public static ItemStack SEEDY_COMB = findItem(9);
    public static ItemStack ALCOHOLIC_COMB = findItem(10);
    public static ItemStack AMBER_COMB = findItem(13);
    public static ItemStack IRON_COMB = findItem(15);
    public static ItemStack GOLDEN_COMB = findItem(16);
    public static ItemStack COPPER_COMB = findItem(17);
    public static ItemStack TIN_COMB = findItem(18);
    public static ItemStack SILVER_COMB = findItem(19);
    public static ItemStack RADIOACTIVE_COMB = findItem(20);
    public static ItemStack LATEX_COMB = findItem(25);
    public static ItemStack BRIMSTONE_COMB = findItem(26);
    public static ItemStack VENOMOUS_COMB = findItem(27);
    public static ItemStack CAFFEINATED_COMB = findItem(30);
    public static ItemStack GLACIAL_COMB = findItem(31);
    public static ItemStack SHADOW_COMB = findItem(32);
    public static ItemStack LEADEN_COMB = findItem(33);
    public static ItemStack EMERALD_COMB = findItem(39);
    public static ItemStack DIAMOND_COMB = findItem(42);
    public static ItemStack DECOMPOSED_COMB = findItem(62);

    private static ItemStack findItem(int meta) {
        Item item = GameRegistry.findItem("ExtraBees", "honeyComb");
        ItemStack stack = new ItemStack(item, 1, meta);
        return stack;
    }
}
