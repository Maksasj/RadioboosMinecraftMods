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
import net.minecraft.init.Blocks;
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
        ItemStack diamondDust = IC2Items.getItem("diamondDust");
        ItemStack glassFiberCable = IC2Items.getItem("glassFiberCableItem");
        ItemStack glowstonePowder = new ItemStack(Items.glowstone_dust);
        ItemStack string = new ItemStack(Items.string);
        ItemStack glass = new ItemStack(Blocks.glass);

        ItemStack ripeSolarPanel = new ItemStack(BlockRegister.RIPE_BEEKEEPERS_SOLAR_PANEL);
        ItemStack shadowSolarPanel = new ItemStack(BlockRegister.SHADOW_BEEKEEPERS_SOLAR_PANEL);
        ItemStack sulfuricSolarPanel = new ItemStack(BlockRegister.SULFURIC_BEEKEEPERS_SOLAR_PANEL);
        ItemStack shimmeringSolarPanel = new ItemStack(BlockRegister.SHIMMERING_BEEKEEPERS_SOLAR_PANEL);
        ItemStack uranicSolarPanel = new ItemStack(BlockRegister.URANIC_BEEKEEPERS_SOLAR_PANEL);
        ItemStack diamondSolarPanel = new ItemStack(BlockRegister.DIAMOND_BEEKEEPERS_SOLAR_PANEL);
        ItemStack platinumSolarPanel = new ItemStack(BlockRegister.PLATINUM_BEEKEEPERS_SOLAR_PANEL);

        // Compressor
        CompressorRecipesRegister.register();

        // Macerator
        MaceratorRecipesRegister.register();

        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_PLATINUM_CORE_ITEM, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.PLATINUM_INFUSED_DENSE_PLATE,
                'M', ItemRegister.SINGULAR_COMPUTATION_PROCESSOR,
                'U', ItemRegister.CRYSTALLIZED_DIAMOND_CORE_ITEM,
                'O', ItemRegister.SINGULAR_INFUSED_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.PLATINUM_INFUSED_MACHINE_CASING, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.PLATINUM_INFUSED_DENSE_PLATE,
                'M', ItemRegister.SINGULAR_INFUSED_ABSORBING_MATRIX_FRAME,
                'U', ItemRegister.DIAMOND_INFUSED_MACHINE_CASING,
                'O', ItemRegister.SINGULAR_COMPUTATION_PROCESSOR
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SCENTED_PLATINUM_GEAR, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.PLATINUM_CRYSTAL,
                'M', ItemRegister.CRYSTALLIZED_SCENTED_DIAMOND_GEAR,
                'U', ItemRegister.PLATINUM_INFUSED_DENSE_PLATE,
                'O', ItemRegister.SINGULAR_COMPUTATION_PROCESSOR
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SINGULAR_COMPUTATION_PROCESSOR, 1),
                "CUC",
                "UOU",
                "CUC",
                'C', ItemRegister.PLATINUM_INFUSED_DENSE_PLATE,
                'U', ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT,
                'O', ItemRegister.SINGULAR_INFUSED_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.ABSORBING_MATRIX_PLATINUM, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.SINGULAR_COMPUTATION_PROCESSOR,
                'M', ItemRegister.ABSORBING_MATRIX_DIAMOND,
                'U', ItemRegister.CRYSTALLIZED_PLATINUM_CORE_ITEM,
                'O', ItemRegister.SINGULAR_INFUSED_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SINGULAR_INFUSED_ABSORBING_MATRIX_FRAME, 1),
                "POP",
                "MCM",
                "POP",
                'P', ItemRegister.DIAMOND_INFUSED_DENSE_PLATE,
                'M', ItemRegister.OPTIC_CONCENTRATING_ABSORBING_MATRIX_FRAME,
                'C', ItemRegister.DIAMOND_CRYSTAL,
                'O', ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.ABSORBING_MATRIX_DIAMOND, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.DIAMOND_INFUSED_DENSE_PLATE,
                'M', ItemRegister.ABSORBING_MATRIX_URANIC,
                'U', ItemRegister.CRYSTALLIZED_DIAMOND_CORE_ITEM,
                'O', ItemRegister.SINGULAR_INFUSED_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SCENTED_DIAMOND_GEAR, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.DIAMOND_CRYSTAL,
                'M', ItemRegister.CRYSTALLIZED_SCENTED_URANIC_GEAR,
                'U', ItemRegister.DIAMOND_INFUSED_DENSE_PLATE,
                'O', ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_DIAMOND_CORE_ITEM, 1),
                "CMP",
                "UOU",
                "PMC",
                'C', ItemRegister.DIAMOND_CRYSTAL,
                'P', ItemRegister.DIAMOND_INFUSED_DENSE_PLATE,
                'M', ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT,
                'U', ItemRegister.CRYSTALLIZED_URANIC_CORE_ITEM,
                'O', ItemRegister.SINGULAR_INFUSED_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.DIAMOND_INFUSED_MACHINE_CASING, 1),
                "CMP",
                "UOU",
                "PMC",
                'C', ItemRegister.DIAMOND_CRYSTAL,
                'P', ItemRegister.DIAMOND_INFUSED_DENSE_PLATE,
                'M', ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT,
                'U', ItemRegister.URANIC_INFUSED_MACHINE_CASING,
                'O', ItemRegister.SINGULAR_INFUSED_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.PLATINUM_INFUSED_PLATE, 1),
                "CPC",
                "PDP",
                "CPC",
                'C', ItemRegister.PLATINUM_CRYSTAL,
                'P', ItemRegister.DIAMOND_INFUSED_PLATE,
                'D', ItemRegister.OPTICAL_CRYSTAL_DUST
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.DIAMOND_INFUSED_PLATE, 1),
                "CPC",
                "PDP",
                "CPC",
                'C', ItemRegister.DIAMOND_CRYSTAL,
                'P', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'D', ItemRegister.OPTICAL_CRYSTAL_DUST
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.OPTICAL_FIBER, 1),
                "CMC",
                "MOM",
                "CMC",
                'C', ItemRegister.OPTICAL_CRYSTAL,
                'M', ItemRegister.SHIMMERING_WOVEN_SILK,
                'O', glassFiberCable
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_URANIC_CORE_ITEM, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.URANIC_CRYSTAL,
                'M', ItemRegister.OPTIMIZED_COMPUTATION_ARRAY_CIRCUIT,
                'U', ItemRegister.OPTIC_CONCENTRATING_ABSORBING_MATRIX_FRAME,
                'O', ItemRegister.CRYSTALLIZED_SHIMMERING_CORE_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.URANIC_INFUSED_MACHINE_CASING, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.URANIC_CRYSTAL,
                'M', ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT,
                'U', ItemRegister.SHIMMERING_INFUSED_MACHINE_CASING,
                'O', ItemRegister.OPTIC_CONCENTRATING_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SCENTED_URANIC_GEAR, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.URANIC_CRYSTAL,
                'M', ItemRegister.CRYSTALLIZED_SCENTED_SHIMMERING_GEAR,
                'U', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'O', ItemRegister.OPTIMIZED_COMPUTATION_ARRAY_CIRCUIT
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.ABSORBING_MATRIX_URANIC, 1),
                "CMC",
                "UOU",
                "CMC",
                'C', ItemRegister.URANIC_CRYSTAL,
                'M', ItemRegister.ABSORBING_MATRIX_SHIMMERING,
                'U', ItemRegister.CRYSTALLIZED_URANIC_CORE_ITEM,
                'O', ItemRegister.OPTIC_CONCENTRATING_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.OPTIC_CONCENTRATING_ABSORBING_MATRIX_FRAME, 1),
                "FOF",
                "MCM",
                "FOF",
                'M', ItemRegister.SHIMMERING_INFUSED_ABSORBING_MATRIX_FRAME,
                'F', ItemRegister.OPTICAL_FIBER,
                'O', ItemRegister.OPTIMIZED_COMPUTATION_ARRAY_CIRCUIT,
                'C', ItemRegister.OPTICAL_CRYSTAL
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT, 1),
                "DCD",
                "CMC",
                "DCD",
                'D', ItemRegister.OPTICAL_CRYSTAL,
                'C', ItemRegister.OPTIMIZED_COMPUTATION_ARRAY_CIRCUIT,
                'M', ItemRegister.OPTIC_CONCENTRATING_ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.OPTICAL_CRYSTAL_DUST, 1),
                "DID",
                "IGI",
                "DID",
                'D', diamondDust,
                'I', iridiumPlate,
                'G', glass
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SHIMMERING_CORE_ITEM, 1),
                "CAC",
                "FSF",
                "CAC",
                'C', ItemRegister.SHIMMERING_CRYSTAL,
                'A', ItemRegister.OPTIMIZED_COMPUTATION_ARRAY_CIRCUIT,
                'F', ItemRegister.SHIMMERING_WOVEN_SILK,
                'S', ItemRegister.CRYSTALLIZED_SULFURIC_CORE_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SHIMMERING_SILK_LUMP, 1),
                "SMS",
                "MSM",
                "SMS",
                'M', ItemRegister.SILK_LUMP,
                'S', ItemRegister.SHIMMERING_STRING
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SHIMMERING_WOVEN_SILK, 1),
                "SMS",
                "MCM",
                "SMS",
                'C', Items.ender_eye,
                'M', ItemRegister.REINFORCED_WOVEN_SILK,
                'S', ItemRegister.SHIMMERING_SILK_LUMP
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SHIMMERING_STRING, 1),
                "SMS",
                "MCM",
                "SMS",
                'C', Items.string,
                'M', ForestryCraftingMaterialApi.PULSATING_MESH,
                'S', ItemRegister.CRYSTALLIZED_SHIMMERING_SHARD_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SCENTED_SHIMMERING_GEAR, 1),
                "CPC",
                "PGP",
                "CPC",
                'C', ItemRegister.CRYSTALLIZED_SHIMMERING_SHARD_ITEM,
                'P', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_SULFURIC_GEAR
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SCENTED_SULFURIC_GEAR, 1),
                "CPC",
                "PGP",
                "CPC",
                'C', ItemRegister.CRYSTALLIZED_SULFURIC_SHARD_ITEM,
                'P', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_SHADOW_GEAR
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SHIMMERING_INFUSED_MACHINE_CASING, 1),
                "CRS",
                "MPM",
                "SRC",
                'C', ItemRegister.SHIMMERING_CRYSTAL,
                'R', ItemRegister.SHIMMERING_WOVEN_SILK,
                'S', ItemRegister.CRYSTALLIZED_SHIMMERING_SHARD_ITEM,
                'M', ItemRegister.SULFURIC_INFUSED_MACHINE_CASING,
                'P', ItemRegister.OPTIMIZED_COMPUTATION_ARRAY_CIRCUIT
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SULFURIC_INFUSED_MACHINE_CASING, 1),
                "CRS",
                "MPM",
                "SRC",
                'C', ItemRegister.SULFURIC_CRYSTAL,
                'R', ItemRegister.REINFORCED_WOVEN_SILK,
                'S', ItemRegister.CRYSTALLIZED_SULFURIC_SHARD_ITEM,
                'M', ItemRegister.SHADOW_INFUSED_MACHINE_CASING,
                'P', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_SULFURIC_CORE_ITEM, 1),
                "CQC",
                "PSP",
                "CQC",
                'C', ItemRegister.SULFURIC_CRYSTAL,
                'Q', ItemRegister.COMPUTATION_ARRAY_CIRCUIT,
                'P', ItemRegister.DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY,
                'S', ItemRegister.CRYSTALLIZED_SHADOW_CORE_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.ABSORBING_MATRIX_SULFURIC, 1),
                "CSC",
                "MOM",
                "CSC",
                'C', ItemRegister.CRYSTALLIZED_SULFURIC_SHARD_ITEM,
                'S', ItemRegister.ABSORBING_MATRIX_SHADOW,
                'M', ItemRegister.ABSORBING_MATRIX_FRAME,
                'O', ItemRegister.CRYSTALLIZED_SULFURIC_CORE_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.COMPUTATION_ARRAY_CIRCUIT, 1),
                "QAQ",
                "CMC",
                "QAQ",
                'Q', ItemRegister.QUANTUM_CIRCUIT,
                'A', advancedCircuit,
                'C', ItemRegister.REINFORCED_WOVEN_SILK,
                'M', ItemRegister.ABSORBING_MATRIX_FRAME
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CONCENTRATED_SULFURIC_SHARD_EXTRACT, 4),
                "SDS",
                "DCD",
                "SDS",
                'S', ItemRegister.CRUSHED_SULFURIC_SHARD,
                'D', diamondDust,
                'C', ItemRegister.CRYSTALLIZED_SULFURIC_SHARD_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CONCENTRATED_SHIMMERING_SHARD_EXTRACT, 4),
                "SDS",
                "DCD",
                "SDS",
                'S', ItemRegister.CRUSHED_SHIMMERING_SHARD,
                'D', diamondDust,
                'C', ItemRegister.CRYSTALLIZED_SHIMMERING_SHARD_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CONCENTRATED_URANIC_SHARD_EXTRACT, 4),
                "SDS",
                "DCD",
                "SDS",
                'S', ItemRegister.CRUSHED_URANIC_SHARD,
                'D', diamondDust,
                'C', ItemRegister.CRYSTALLIZED_URANIC_SHARD_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CONCENTRATED_DIAMOND_SHARD_EXTRACT, 4),
                "SDS",
                "DCD",
                "SDS",
                'S', ItemRegister.CRUSHED_DIAMOND_SHARD,
                'D', diamondDust,
                'C', ItemRegister.CRYSTALLIZED_DIAMOND_SHARD_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.CONCENTRATED_PLATINUM_SHARD_EXTRACT, 4),
                "SDS",
                "DCD",
                "SDS",
                'S', ItemRegister.CRUSHED_PLATINUM_SHARD,
                'D', diamondDust,
                'C', ItemRegister.CRYSTALLIZED_PLATINUM_SHARD_ITEM
        );
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
        GameRegistry.addRecipe(new ItemStack(ItemRegister.ABSORBING_MATRIX_SHIMMERING, 1),
                "CMC",
                "FKF",
                "CMC",
                'C', ItemRegister.SHIMMERING_CRYSTAL,
                'M', ItemRegister.ABSORBING_MATRIX_SULFURIC,
                'F', ItemRegister.SHIMMERING_INFUSED_ABSORBING_MATRIX_FRAME,
                'K', ItemRegister.CRYSTALLIZED_SHIMMERING_CORE_ITEM
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.SHIMMERING_INFUSED_ABSORBING_MATRIX_FRAME, 1),
                "SMS",
                "MQM",
                "SMS",
                'S', ItemRegister.SHIMMERING_WOVEN_SILK,
                'M', ItemRegister.ABSORBING_MATRIX_FRAME,
                'Q', ItemRegister.COMPUTATION_ARRAY_CIRCUIT
        );
        GameRegistry.addRecipe(new ItemStack(ItemRegister.OPTIMIZED_COMPUTATION_ARRAY_CIRCUIT, 1),
                "ACA",
                "FMF",
                "ACA",
                'A', ItemRegister.COMPUTATION_ARRAY_CIRCUIT,
                'C', glassFiberCable,
                'F', ItemRegister.SHIMMERING_WOVEN_SILK,
                'M', ItemRegister.SHIMMERING_INFUSED_ABSORBING_MATRIX_FRAME
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
        GameRegistry.addRecipe(new ItemStack(BlockRegister.SULFURIC_BEEKEEPERS_SOLAR_PANEL, 1),
                "MCM",
                "PAP",
                "GSG",
                'C', ItemRegister.CRYSTALLIZED_SULFURIC_CORE_ITEM,
                'M', ItemRegister.ABSORBING_MATRIX_SULFURIC,
                'P', shadowSolarPanel,
                'A', ItemRegister.COMPUTATION_ARRAY_CIRCUIT,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_SULFURIC_GEAR,
                'S', ItemRegister.SULFURIC_INFUSED_MACHINE_CASING
        );
        GameRegistry.addRecipe(new ItemStack(BlockRegister.SHIMMERING_BEEKEEPERS_SOLAR_PANEL, 1),
                "MIM",
                "QPQ",
                "GCG",
                'M', ItemRegister.ABSORBING_MATRIX_SHIMMERING,
                'I', ItemRegister.CRYSTALLIZED_SHIMMERING_CORE_ITEM,
                'Q', ItemRegister.OPTIMIZED_COMPUTATION_ARRAY_CIRCUIT,
                'P', sulfuricSolarPanel,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_SHIMMERING_GEAR,
                'C', ItemRegister.SHIMMERING_INFUSED_MACHINE_CASING
        );
        GameRegistry.addRecipe(new ItemStack(BlockRegister.URANIC_BEEKEEPERS_SOLAR_PANEL, 1),
                "MCM",
                "PAP",
                "GSG",
                'C', ItemRegister.CRYSTALLIZED_URANIC_CORE_ITEM,
                'M', ItemRegister.ABSORBING_MATRIX_URANIC,
                'P', shimmeringSolarPanel,
                'A', ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_URANIC_GEAR,
                'S', ItemRegister.URANIC_INFUSED_MACHINE_CASING
        );
        GameRegistry.addRecipe(new ItemStack(BlockRegister.DIAMOND_BEEKEEPERS_SOLAR_PANEL, 1),
                "MCM",
                "PAP",
                "GSG",
                'C', ItemRegister.CRYSTALLIZED_DIAMOND_CORE_ITEM,
                'M', ItemRegister.ABSORBING_MATRIX_DIAMOND,
                'P', uranicSolarPanel,
                'A', ItemRegister.OPTICAL_COMPUTATION_ARRAY_CIRCUIT,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_DIAMOND_GEAR,
                'S', ItemRegister.DIAMOND_INFUSED_MACHINE_CASING
        );
        GameRegistry.addRecipe(new ItemStack(BlockRegister.PLATINUM_BEEKEEPERS_SOLAR_PANEL, 1),
                "MIM",
                "QPQ",
                "GCG",
                'M', ItemRegister.ABSORBING_MATRIX_PLATINUM,
                'I', ItemRegister.CRYSTALLIZED_PLATINUM_CORE_ITEM,
                'Q', ItemRegister.SINGULAR_COMPUTATION_PROCESSOR,
                'P', diamondSolarPanel,
                'G', ItemRegister.CRYSTALLIZED_SCENTED_PLATINUM_GEAR,
                'C', ItemRegister.PLATINUM_INFUSED_MACHINE_CASING
        );
        GameRegistry.addRecipe(new ItemStack(BlockRegister.SINGULAR_BEEKEEPERS_SOLAR_PANEL, 1),
                "DQU",
                "HPS",
                "SQR",
                'S', shadowSolarPanel,
                'H', shimmeringSolarPanel,
                'D', diamondSolarPanel,
                'U', uranicSolarPanel,
                'S', sulfuricSolarPanel,
                'R', ripeSolarPanel,
                'P', platinumSolarPanel,
                'Q', ItemRegister.SINGULAR_COMPUTATION_PROCESSOR
        );
    }
}
