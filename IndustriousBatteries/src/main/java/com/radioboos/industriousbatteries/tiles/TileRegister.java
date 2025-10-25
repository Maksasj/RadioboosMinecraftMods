package com.radioboos.industriousbatteries.tiles;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileRegister {
    static public void register() {
        GameRegistry.registerTileEntity(SimpleBatteryStorageTileEntity.class, "SimpleBatteryStorage");
        GameRegistry.registerTileEntity(AdvancedBatteryStorageTileEntity.class, "AdvancedBatteryStorage");
    }
}
