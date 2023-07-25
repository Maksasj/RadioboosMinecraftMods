package com.radioboos.beekeeperssolarpanels.recipes;

import com.radioboos.api.advsolar.ADVApi;
import com.radioboos.api.binnie.extrabees.ExtraBeesCombApi;
import com.radioboos.api.binnie.extrabees.ExtraBeesMiscApi;
import com.radioboos.api.forestry.ForestryApi;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipeRegister extends CommonRegister {
    public static void register() {
        ItemStack iridiumPlate = IC2Items.getItem("iridiumPlate");
        ItemStack iridiumOre = IC2Items.getItem("iridiumOre");
        ItemStack denseGoldenPlate = IC2Items.getItem("denseplategold");
        ItemStack goldenPlate = IC2Items.getItem("plategold");
        ItemStack advancedAlloy = IC2Items.getItem("advancedAlloy");
        ItemStack energiumDust = IC2Items.getItem("energiumDust");
        ItemStack lapisDust = IC2Items.getItem("lapiDust");
        ItemStack carbonMesh = IC2Items.getItem("carbonMesh");
        ItemStack insulatedGoldCable = IC2Items.getItem("insulatedGoldCableItem");
        ItemStack advancedCircuit = IC2Items.getItem("advancedCircuit");
        ItemStack glowstonePowder = new ItemStack(Items.glowstone_dust);
        ItemStack string = new ItemStack(Items.string);

        ItemStack ripeSolarPanel = new ItemStack(BlockRegister.RIPE_BEEKEEPERS_SOLAR_PANEL);

        // Compressor
        CompressorRecipesRegister.register();

        GameRegistry.addRecipe(new ItemStack(ItemRegister.QUANTUM_CIRCUIT, 1),
                "CDC",
                "AIA",
                "CDC",
                'C', insulatedGoldCable,
                'D', lapisDust,
                'A', advancedCircuit,
                'I', iridiumOre
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SHADOW_INFUSED_MACHINE_CASING, 1),
                "SRS",
                "MPM",
                "SRS",
                'S', ItemRegister.CRYSTALLIZED_SHADOW_SHARD_ITEM,
                'R', ItemRegister.REINFORCED_WOVEN_SILK,
                'P', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'M', ForestryApi.HARDENED_MACHINE
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SHADOW_CORE_ITEM, 1),
                "DSD",
                "SCS",
                "DSD",
                'S', ItemRegister.CRYSTALLIZED_SHADOW_SHARD_ITEM,
                'D', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'C', ItemRegister.CRYSTALLIZED_RIPE_CORE_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SCENTED_SHADOW_GEAR, 1),
                "DSD",
                "SGS",
                "DSD",
                'S', ItemRegister.CRYSTALLIZED_SHADOW_SHARD_ITEM,
                'D', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_RIPE_GEAR
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.ABSORBING_MATRIX_SHADOW, 1),
                "SMS",
                "MCM",
                "SMS",
                'S', ItemRegister.CRYSTALLIZED_SHADOW_SHARD_ITEM,
                'M', ItemRegister.ABSORBING_MATRIX_FRAME,
                'C', ItemRegister.CRYSTALLIZED_SHADOW_CORE_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SILK_LUMP, 1),
                "#X#",
                "X#X",
                "#X#",
                '#', ForestryCraftingMaterialApi.SILK_WISP,
                'X', string
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SILK_CUBE, 1),
                "#X#",
                "X#X",
                "#X#",
                '#', ForestryCraftingMaterialApi.WOVEN_SILK,
                'X', ItemRegister.SILK_LUMP
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.COMPOSITE_WOVEN_SILK, 1),
                "#X#",
                "XRX",
                "#X#",
                '#', ItemRegister.ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'X', ItemRegister.COMPRESSED_SILK_CUBE,
                'R', advancedAlloy
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.REINFORCED_WOVEN_SILK, 1),
                "#X#",
                "XRX",
                "#X#",
                '#', ItemRegister.COMPOSITE_WOVEN_SILK,
                'X', carbonMesh,
                'R', ForestryCraftingMaterialApi.WOVEN_SILK
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.ABSORBING_MATRIX_FRAME, 1),
                "#X#",
                "CDC",
                "#X#",
                '#', ItemRegister.COMPOSITE_WOVEN_SILK,
                'X', ItemRegister.REINFORCED_WOVEN_SILK,
                'D', energiumDust,
                'C', ItemRegister.QUANTUM_CIRCUIT
        );
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
        GameRegistry.addRecipe(new ItemStack(BlockRegister.SHADOW_BEEKEEPERS_SOLAR_PANEL, 1),
                "MSM",
                "QRQ",
                "GCG",
                'M', ItemRegister.ABSORBING_MATRIX_SHADOW,
                'S', ItemRegister.CRYSTALLIZED_SHADOW_CORE_ITEM,
                'Q', ItemRegister.QUANTUM_CIRCUIT,
                'R', ripeSolarPanel,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_SHADOW_GEAR,
                'C', ItemRegister.SHADOW_INFUSED_MACHINE_CASING
        );
    }
}
