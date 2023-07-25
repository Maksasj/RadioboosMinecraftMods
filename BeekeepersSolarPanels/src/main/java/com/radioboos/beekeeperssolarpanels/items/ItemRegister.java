package com.radioboos.beekeeperssolarpanels.items;

import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import com.radioboos.beekeeperssolarpanels.items.misc.*;
import com.radioboos.beekeeperssolarpanels.items.misc.casing.ShadowInfusedMachineCasing;
import com.radioboos.beekeeperssolarpanels.items.misc.casing.SulfuricInfusedMachineCasing;
import com.radioboos.beekeeperssolarpanels.items.misc.circuits.ComputationArrayCircuit;
import com.radioboos.beekeeperssolarpanels.items.misc.circuits.QuantumCircuit;
import com.radioboos.beekeeperssolarpanels.items.misc.cores.*;
import com.radioboos.beekeeperssolarpanels.items.misc.crystals.SulfuricCrystal;
import com.radioboos.beekeeperssolarpanels.items.misc.dust.ConcentratedSulfuricShardExtract;
import com.radioboos.beekeeperssolarpanels.items.misc.dust.CrushedSulfuricShard;
import com.radioboos.beekeeperssolarpanels.items.misc.gears.CrystallizedScentedRipeGear;
import com.radioboos.beekeeperssolarpanels.items.misc.gears.CrystallizedScentedShadowGear;
import com.radioboos.beekeeperssolarpanels.items.misc.gears.CrystallizedScentedSulfuricGear;
import com.radioboos.beekeeperssolarpanels.items.misc.matrices.AbsorbingMatrixFrame;
import com.radioboos.beekeeperssolarpanels.items.misc.matrices.AbsorbingMatrixShadow;
import com.radioboos.beekeeperssolarpanels.items.misc.matrices.AbsorbingMatrixSulfuric;
import com.radioboos.beekeeperssolarpanels.items.misc.shards.CrystallizedRipeShard;
import com.radioboos.beekeeperssolarpanels.items.misc.silk.CompositeWovenSilk;
import com.radioboos.beekeeperssolarpanels.items.misc.silk.CompressedSilkCube;
import com.radioboos.beekeeperssolarpanels.items.misc.silk.SilkCube;
import com.radioboos.beekeeperssolarpanels.items.misc.silk.SilkLump;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemRegister extends CommonRegister {
    public static Item CRYSTALLIZED_RIPE_SHARD_ITEM = new CrystallizedRipeShard("crystallizedRipeShard");
    public static Item CRYSTALLIZED_SHADOW_SHARD_ITEM = new CrystallizedRipeShard("crystallizedShadowShard");
    public static Item CRYSTALLIZED_SULFURIC_SHARD_ITEM = new CrystallizedRipeShard("crystallizedSulfuricShard");
    public static Item CRYSTALLIZED_SHIMMERING_SHARD_ITEM = new CrystallizedRipeShard("crystallizedShimmeringShard");
    public static Item CRYSTALLIZED_URANIC_SHARD_ITEM = new CrystallizedRipeShard("crystallizedUranicShard");
    public static Item CRYSTALLIZED_DIAMOND_SHARD_ITEM = new CrystallizedRipeShard("crystallizedDiamondShard");
    public static Item CRYSTALLIZED_PLATINUM_SHARD_ITEM = new CrystallizedRipeShard("crystallizedPlatinumShard");
    public static Item CRYSTALLIZED_RIPE_CORE_ITEM = new CrystallizedRipeCore("crystallizedRipeCore");
    public static Item CRYSTALLIZED_SHADOW_CORE_ITEM = new CrystallizedShadowCore("crystallizedShadowCore");
    public static Item CRYSTALLIZED_SULFURIC_CORE_ITEM = new CrystallizedSulfuricCore("crystallizedSulfuricCore");
    public static Item CRYSTALLIZED_SHIMMERING_CORE_ITEM = new CrystallizedShimmeringCore("crystallizedShimmeringCore");
    public static Item CRYSTALLIZED_URANIC_CORE_ITEM = new CrystallizedUranicCore("crystallizedUranicCore");
    public static Item CRYSTALLIZED_DIAMOND_CORE_ITEM = new CrystallizedDiamondCore("crystallizedDiamondCore");
    public static Item CRYSTALLIZED_PLATINUM_CORE_ITEM = new CrystallizedPlatinumCore("crystallizedPlatinumCore");
    public static Item REINFORCED_WOVEN_SILK = new IrradiantIridium("reinforcedWovenSilk");
    public static Item COMPOSITE_WOVEN_SILK = new CompositeWovenSilk("compositeWovenSilk");
    public static Item SILK_LUMP = new SilkLump("silkLump");
    public static Item SILK_CUBE = new SilkCube("silkCube");
    public static Item COMPRESSED_SILK_CUBE = new CompressedSilkCube("compressedSilkCube");
    public static Item ABSORBING_MATRIX_FRAME = new AbsorbingMatrixFrame("absorbingMatrixFrame");
    public static Item ABSORBING_MATRIX_SHADOW = new AbsorbingMatrixShadow("absorbingMatrixShadow");
    public static Item ABSORBING_MATRIX_SULFURIC = new AbsorbingMatrixSulfuric("absorbingMatrixSulfuric");
    public static Item CRYSTALLIZED_SCENTED_RIPE_GEAR = new CrystallizedScentedRipeGear("crystallizedScentedRipeGear");
    public static Item CRYSTALLIZED_SCENTED_SHADOW_GEAR = new CrystallizedScentedShadowGear("crystallizedScentedShadowGear");
    public static Item CRYSTALLIZED_SCENTED_SULFURIC_GEAR = new CrystallizedScentedSulfuricGear("crystallizedScentedSulfuricGear");
    public static Item QUANTUM_CIRCUIT = new QuantumCircuit("quantumCircuit");
    public static Item COMPUTATION_ARRAY_CIRCUIT = new ComputationArrayCircuit("computationArrayCircuit");
    public static Item SHADOW_INFUSED_MACHINE_CASING = new ShadowInfusedMachineCasing("shadowInfusedMachineCasing");
    public static Item SULFURIC_INFUSED_MACHINE_CASING = new SulfuricInfusedMachineCasing("sulfuricInfusedMachineCasing");
    public static Item SULFURIC_CRYSTAL = new SulfuricCrystal("sulfuricCrystal");
    public static Item CONCENTRATED_SULFURIC_SHARD_EXTRACT = new ConcentratedSulfuricShardExtract("concentratedSulfuricShardExtract");
    public static Item CRUSHED_SULFURIC_SHARD = new CrushedSulfuricShard("crushedSulfuricShard");
    public static Item IRRADIANT_IRIDIUM_ITEM = new IrradiantIridium("irradiantIridium");
    public static Item ENRICHED_IRRADIANT_IRIDIUM_ALLOY = new EnrichedIrradiantIridiumAlloy("enrichedIrradiantIridiumAlloy");
    public static Item DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY = new DenseEnrichedIrradiantIridiumAlloy("denseEnrichedIrradiantIridiumAlloy");

    public static void register() {
        GameRegistry.registerItem(CRYSTALLIZED_RIPE_SHARD_ITEM, "crystallizedRipeShard");
        GameRegistry.registerItem(CRYSTALLIZED_SHADOW_SHARD_ITEM,"crystallizedShadowShard");
        GameRegistry.registerItem(CRYSTALLIZED_SULFURIC_SHARD_ITEM,"crystallizedSulfuricShard");
        GameRegistry.registerItem(CRYSTALLIZED_SHIMMERING_SHARD_ITEM,"crystallizedShimmeringShard");
        GameRegistry.registerItem(CRYSTALLIZED_URANIC_SHARD_ITEM,"crystallizedUranicShard");
        GameRegistry.registerItem(CRYSTALLIZED_DIAMOND_SHARD_ITEM,"crystallizedDiamondShard");
        GameRegistry.registerItem(CRYSTALLIZED_PLATINUM_SHARD_ITEM,"crystallizedPlatinumShard");

        GameRegistry.registerItem(CRYSTALLIZED_RIPE_CORE_ITEM, "crystallizedRipeCore");
        GameRegistry.registerItem(CRYSTALLIZED_SHADOW_CORE_ITEM, "crystallizedShadowCore");
        GameRegistry.registerItem(CRYSTALLIZED_SULFURIC_CORE_ITEM, "crystallizedSulfuricCore");
        GameRegistry.registerItem(CRYSTALLIZED_SHIMMERING_CORE_ITEM, "crystallizedShimmeringCore");
        GameRegistry.registerItem(CRYSTALLIZED_URANIC_CORE_ITEM, "crystallizedUranicCore");
        GameRegistry.registerItem(CRYSTALLIZED_DIAMOND_CORE_ITEM, "crystallizedDiamondCore");
        GameRegistry.registerItem(CRYSTALLIZED_PLATINUM_CORE_ITEM, "crystallizedPlatinumCore");

        GameRegistry.registerItem(REINFORCED_WOVEN_SILK, "reinforcedWovenSilk");
        GameRegistry.registerItem(COMPOSITE_WOVEN_SILK, "compositeWovenSilk");
        GameRegistry.registerItem(SILK_LUMP, "silkLump");
        GameRegistry.registerItem(SILK_CUBE, "silkCube");
        GameRegistry.registerItem(COMPRESSED_SILK_CUBE, "compressedSilkCube");

        GameRegistry.registerItem(ABSORBING_MATRIX_FRAME, "absorbingMatrixFrame");
        GameRegistry.registerItem(ABSORBING_MATRIX_SHADOW, "absorbingMatrixShadow");
        GameRegistry.registerItem(ABSORBING_MATRIX_SULFURIC, "absorbingMatrixSulfuric");

        GameRegistry.registerItem(CRYSTALLIZED_SCENTED_RIPE_GEAR, "crystallizedScentedRipeGear");
        GameRegistry.registerItem(CRYSTALLIZED_SCENTED_SHADOW_GEAR, "crystallizedScentedShadowGear");
        GameRegistry.registerItem(CRYSTALLIZED_SCENTED_SULFURIC_GEAR, "crystallizedScentedSulfuricGear");

        GameRegistry.registerItem(QUANTUM_CIRCUIT, "quantumCircuit");
        GameRegistry.registerItem(COMPUTATION_ARRAY_CIRCUIT, "computationArrayCircuit");

        GameRegistry.registerItem(SHADOW_INFUSED_MACHINE_CASING, "shadowInfusedMachineCasing");
        GameRegistry.registerItem(SULFURIC_INFUSED_MACHINE_CASING, "sulfuricInfusedMachineCasing");

        GameRegistry.registerItem(CONCENTRATED_SULFURIC_SHARD_EXTRACT, "concentratedSulfuricShardExtract");
        GameRegistry.registerItem(CRUSHED_SULFURIC_SHARD, "crushedSulfuricShard");

        GameRegistry.registerItem(SULFURIC_CRYSTAL, "sulfuricCrystal");

        GameRegistry.registerItem(IRRADIANT_IRIDIUM_ITEM, "irradiantIridium");
        GameRegistry.registerItem(ENRICHED_IRRADIANT_IRIDIUM_ALLOY, "enrichedIrradiantIridiumAlloy");
        GameRegistry.registerItem(DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY, "denseEnrichedIrradiantIridiumAlloy");
    }
}