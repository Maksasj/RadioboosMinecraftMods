package com.radioboos.industriousbatteries.blocks;

import com.radioboos.industriousbatteries.items.CommonItemBlock;
import com.radioboos.industriousbatteries.tiles.SimpleBatteryStorageTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister {
    static public SimpleBatteryStorageBlock SIMPLE_BATTERY_STORAGE_BLOCK = new SimpleBatteryStorageBlock("SimpleBatteryStorageBlock");
    static public AdvancedBatteryStorageBlock ADVANCED_BATTERY_STORAGE_BLOCK = new AdvancedBatteryStorageBlock("AdvancedBatteryStorageBlock");

    static public void register() {
        GameRegistry.registerBlock(SIMPLE_BATTERY_STORAGE_BLOCK, CommonItemBlock.class, "SimpleBatteryStorageBlock");
        GameRegistry.registerBlock(ADVANCED_BATTERY_STORAGE_BLOCK, CommonItemBlock.class, "AdvancedBatteryStorageBlock");
    }
}
