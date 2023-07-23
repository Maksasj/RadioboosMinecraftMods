package com.radioboos.api.advsolar;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import scala.io.StdIn;

public class ADVApi {
    public static ItemStack QUANTUM_SOLAR_PANEL  = findItem("BlockAdvSolarPanel", 3);

    private static ItemStack findItem(String name, int meta) {
        Item item = GameRegistry.findItem("AdvancedSolarPanel", name);
        ItemStack stack = new ItemStack(item, 1, meta);
        return stack;
    }
}
