package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileRegister extends CommonRegister {
    public static final CompressedSolarPanelTileEntity COMPRESSED_SOLAR_PANEL = new CompressedSolarPanelTileEntity();
    public static final DoubleCompressedSolarPanelTileEntity DOUBLE_COMPRESSED_SOLAR_PANEL = new DoubleCompressedSolarPanelTileEntity();

    public static void register() {
        GameRegistry.registerTileEntity(CompressedSolarPanelTileEntity.class, "CompressedSolarPanel");
        GameRegistry.registerTileEntity(DoubleCompressedSolarPanelTileEntity.class, "DoubleCompressedSolarPanel");
    }
}
