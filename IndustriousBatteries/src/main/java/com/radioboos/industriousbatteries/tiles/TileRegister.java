package com.radioboos.industriousbatteries.tiles;

import com.radioboos.industriousbatteries.common.BatteryStorageTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class TileRegister {
    static public void register() {
        GameRegistry.registerTileEntity(BatteryStorageTileEntity.class, "testTileEntity");
    }
}
