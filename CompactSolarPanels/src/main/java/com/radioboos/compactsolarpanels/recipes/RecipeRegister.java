package com.radioboos.compactsolarpanels.recipes;

import com.radioboos.compactsolarpanels.blocks.BlockRegister;
import com.radioboos.compactsolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.item.ItemStack;

public class RecipeRegister extends CommonRegister {
    public static void register() {
        ItemStack solar = IC2Items.getItem("solarPanel");

        GameRegistry.addRecipe(new ItemStack(BlockRegister.COMPRESSED_SOLAR_PANEL, 1), new Object[]{"###", "###", "###", '#', solar});
        GameRegistry.addRecipe(new ItemStack(BlockRegister.DOUBLE_COMPRESSED_SOLAR_PANEL, 1), new Object[]{"###", "###", "###", '#', BlockRegister.COMPRESSED_SOLAR_PANEL});
        GameRegistry.addRecipe(new ItemStack(BlockRegister.TRIPLE_COMPRESSED_SOLAR_PANEL, 1), new Object[]{"###", "###", "###", '#', BlockRegister.DOUBLE_COMPRESSED_SOLAR_PANEL});
        GameRegistry.addRecipe(new ItemStack(BlockRegister.QUADRUPLE_COMPRESSED_SOLAR_PANEL, 1), new Object[]{"###", "###", "###", '#', BlockRegister.TRIPLE_COMPRESSED_SOLAR_PANEL});
        GameRegistry.addRecipe(new ItemStack(BlockRegister.QUINTUPLE_COMPRESSED_SOLAR_PANEL, 1), new Object[]{"###", "###", "###", '#', BlockRegister.QUADRUPLE_COMPRESSED_SOLAR_PANEL});
        GameRegistry.addRecipe(new ItemStack(BlockRegister.SEXTUPLE_COMPRESSED_SOLAR_PANEL, 1), new Object[]{"###", "###", "###", '#', BlockRegister.QUINTUPLE_COMPRESSED_SOLAR_PANEL});
        GameRegistry.addRecipe(new ItemStack(BlockRegister.SEPTUPLE_COMPRESSED_SOLAR_PANEL, 1), new Object[]{"###", "###", "###", '#', BlockRegister.SEXTUPLE_COMPRESSED_SOLAR_PANEL});
    }
}
