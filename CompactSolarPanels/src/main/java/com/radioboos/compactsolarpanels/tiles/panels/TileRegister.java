package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileRegister extends CommonRegister {
    public static final CompressedSolarPanelTileEntity COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new CompressedSolarPanelTileEntity();
    public static final DoubleCompressedSolarPanelTileEntity DOUBLE_COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new DoubleCompressedSolarPanelTileEntity();
    public static final TripleCompressedSolarPanelTileEntity TRIPLE_COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new TripleCompressedSolarPanelTileEntity();

    public static void register() {
        GameRegistry.registerTileEntity(CompressedSolarPanelTileEntity.class, "CompressedSolarPanel");
        GameRegistry.registerTileEntity(DoubleCompressedSolarPanelTileEntity.class, "DoubleCompressedSolarPanel");
        GameRegistry.registerTileEntity(TripleCompressedSolarPanelTileEntity.class, "TripleCompressedSolarPanel");
    }
}
