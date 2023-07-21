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
    }
}
