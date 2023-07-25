package com.radioboos.beekeeperssolarpanels.recipes;

import com.radioboos.api.advsolar.ADVApi;
import com.radioboos.api.binnie.extrabees.ExtraBeesCombApi;
import com.radioboos.api.binnie.extrabees.ExtraBeesMiscApi;
import com.radioboos.api.forestry.ForestryBlockApi;
import com.radioboos.api.forestry.ForestryCombApi;
import com.radioboos.api.forestry.ForestryCraftingMaterialApi;
import com.radioboos.beekeeperssolarpanels.blocks.BlockRegister;
import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import com.radioboos.beekeeperssolarpanels.items.ItemRegister;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CompressorRecipesRegister extends CommonRegister {
    public static void register() {
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ForestryCombApi.MELLOW_COMB, 64), null, new ItemStack(ItemRegister.CRYSTALLIZED_RIPE_SHARD_ITEM, 1));
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ExtraBeesCombApi.SHADOW_COMB, 64), null, new ItemStack(ItemRegister.CRYSTALLIZED_SHADOW_SHARD_ITEM, 1));
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ExtraBeesCombApi.BRIMSTONE_COMB, 64), null, new ItemStack(ItemRegister.CRYSTALLIZED_SULFURIC_SHARD_ITEM, 1));
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ExtraBeesCombApi.SHIMMERING_COMB, 64), null, new ItemStack(ItemRegister.CRYSTALLIZED_SHIMMERING_SHARD_ITEM, 1));
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ExtraBeesCombApi.RADIOACTIVE_COMB, 64), null, new ItemStack(ItemRegister.CRYSTALLIZED_URANIC_SHARD_ITEM, 1));
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ExtraBeesCombApi.DIAMOND_COMB, 64), null, new ItemStack(ItemRegister.CRYSTALLIZED_DIAMOND_SHARD_ITEM, 1));
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ExtraBeesCombApi.PLATINUM_COMB, 64), null, new ItemStack(ItemRegister.CRYSTALLIZED_PLATINUM_SHARD_ITEM, 1));

        Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegister.SILK_CUBE), 9), null, new ItemStack(ItemRegister.COMPRESSED_SILK_CUBE, 1));

        Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegister.CONCENTRATED_SULFURIC_SHARD_EXTRACT), 9), null, new ItemStack(ItemRegister.SULFURIC_CRYSTAL, 1));

        Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegister.ENRICHED_IRRADIANT_IRIDIUM_ALLOY), 9), null, new ItemStack(ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY, 1));
    }
}
