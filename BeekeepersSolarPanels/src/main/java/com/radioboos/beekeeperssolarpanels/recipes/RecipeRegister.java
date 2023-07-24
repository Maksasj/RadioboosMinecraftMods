package com.radioboos.beekeeperssolarpanels.recipes;

import com.radioboos.api.advsolar.ADVApi;
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

public class RecipeRegister extends CommonRegister {
    public static void register() {
        ItemStack iridiumPlate = IC2Items.getItem("iridiumPlate");
        ItemStack iridiumOre = IC2Items.getItem("iridiumOre");
        ItemStack denseGoldenPlate = IC2Items.getItem("denseplategold");
        ItemStack goldenPlate = IC2Items.getItem("plategold");
        ItemStack advancedAlloy = IC2Items.getItem("advancedAlloy");
        ItemStack glowstonePowder = new ItemStack(Items.glowstone_dust);

        // Compressor
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ForestryCombApi.MELLOW_COMB, 64), null, new ItemStack(ItemRegister.CRYSTALLIZED_RIPE_SHARD_ITEM, 1));

        Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegister.ENRICHED_IRRADIANT_IRIDIUM_ALLOY), 9), null, new ItemStack(ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY, 1));

        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_RIPE_CORE_ITEM, 1),
                "#X#",
                "XOX",
                "#X#",
                '#', ItemRegister.ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'X', denseGoldenPlate,
                'O', ItemRegister.CRYSTALLIZED_RIPE_SHARD_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.IRRADIANT_IRIDIUM_ITEM, 1),
                "#X#",
                "XOX",
                "#X#",
                '#', goldenPlate,
                'X', glowstonePowder,
                'O', iridiumOre
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.ENRICHED_IRRADIANT_IRIDIUM_ALLOY, 1),
                "#X#",
                "XOX",
                "#X#",
                '#', ItemRegister.IRRADIANT_IRIDIUM_ITEM,
                'X', advancedAlloy,
                'O', denseGoldenPlate
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SCENTED_RIPE_GEAR, 1),
                "#X#",
                "XOX",
                "#X#",
                '#', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'X', ItemRegister.CRYSTALLIZED_RIPE_SHARD_ITEM,
                'O', ExtraBeesMiscApi.SCENTED_GEAR
        );
        GameRegistry.addRecipe(new ItemStack(BlockRegister.RIPE_BEEKEEPERS_SOLAR_PANEL, 1),
                "#C#",
                "DQD",
                "XAX",
                'C', ItemRegister.CRYSTALLIZED_RIPE_CORE_ITEM,
                '#', ForestryCraftingMaterialApi.WOVEN_SILK,
                'Q', ADVApi.QUANTUM_SOLAR_PANEL,
                'D', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'X', ItemRegister.CRYSTALLIZED_SCENTED_RIPE_GEAR,
                'A', ForestryBlockApi.ALVEARY
        );
    }
}
