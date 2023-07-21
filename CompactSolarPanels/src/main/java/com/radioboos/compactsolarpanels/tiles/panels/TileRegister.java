package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class TileRegister extends CommonRegister {
    public static final TileEntity COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new CompressedSolarPanelTileEntity();
    public static final TileEntity DOUBLE_COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new DoubleCompressedSolarPanelTileEntity();
    public static final TileEntity TRIPLE_COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new TripleCompressedSolarPanelTileEntity();
    public static final TileEntity QUADRUPLE_COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new QuadrupleCompressedSolarPanelTileEntity();
    public static final TileEntity QUINTUPLE_COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new QuintupleCompressedSolarPanelTileEntity();
    public static final TileEntity SEXTUPLE_COMPRESSED_SOLAR_PANEL_TILE_ENTITY = new SextupleCompressedSolarPanelTileEntity();

    public static void register() {
        GameRegistry.registerTileEntity(CompressedSolarPanelTileEntity.class, "CompressedSolarPanel");
        GameRegistry.registerTileEntity(DoubleCompressedSolarPanelTileEntity.class, "DoubleCompressedSolarPanel");
        GameRegistry.registerTileEntity(TripleCompressedSolarPanelTileEntity.class, "TripleCompressedSolarPanel");
        GameRegistry.registerTileEntity(QuadrupleCompressedSolarPanelTileEntity.class, "QuadrupleCompressedSolarPanel");
        GameRegistry.registerTileEntity(QuintupleCompressedSolarPanelTileEntity.class, "QuintupleCompressedSolarPanel");
        GameRegistry.registerTileEntity(SextupleCompressedSolarPanelTileEntity.class, "SextupleCompressedSolarPanel");
    }
}
