package com.radioboos.beekeeperssolarpanels.items;

import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import com.radioboos.beekeeperssolarpanels.items.misc.*;
import com.radioboos.beekeeperssolarpanels.items.misc.cores.*;
import com.radioboos.beekeeperssolarpanels.items.misc.shards.CrystallizedRipeShard;
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
    public static Item IRRADIANT_IRIDIUM_ITEM = new IrradiantIridium("irradiantIridium");
    public static Item ENRICHED_IRRADIANT_IRIDIUM_ALLOY = new EnrichedIrradiantIridiumAlloy("enrichedIrradiantIridiumAlloy");
    public static Item DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY = new DenseEnrichedIrradiantIridiumAlloy("denseEnrichedIrradiantIridiumAlloy");
    public static Item CRYSTALLIZED_SCENTED_RIPE_GEAR = new CrystallizedScentedRipeGear("crystallizedScentedRipeGear");

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

        GameRegistry.registerItem(IRRADIANT_IRIDIUM_ITEM, "irradiantIridium");
        GameRegistry.registerItem(ENRICHED_IRRADIANT_IRIDIUM_ALLOY, "enrichedIrradiantIridiumAlloy");
        GameRegistry.registerItem(DENSE_ENRICHED_IRRADIANT_IRIDIUM_ALLOY, "denseEnrichedIrradiantIridiumAlloy");
        GameRegistry.registerItem(CRYSTALLIZED_SCENTED_RIPE_GEAR, "crystallizedScentedRipeGear");
    }
}
