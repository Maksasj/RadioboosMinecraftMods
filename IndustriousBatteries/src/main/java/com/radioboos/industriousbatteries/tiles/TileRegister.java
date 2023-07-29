package com.radioboos.industriousbatteries.tiles;

import com.radioboos.industriousbatteries.common.CommonEnergyStorageTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class TileRegister {
    static public TileEntity TEST_TILE_ENTITY = new CommonEnergyStorageTileEntity();

    static public void register() {
        GameRegistry.registerTileEntity(CommonEnergyStorageTileEntity.class, "testTileEntity");
    }
}
