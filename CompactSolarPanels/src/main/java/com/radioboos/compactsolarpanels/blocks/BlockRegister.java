package com.radioboos.compactsolarpanels.blocks;

import com.radioboos.compactsolarpanels.common.CommonPanelBlock;
import com.radioboos.compactsolarpanels.common.CommonRegister;
import com.radioboos.compactsolarpanels.items.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister extends CommonRegister {
    public static final CommonPanelBlock COMPRESSED_SOLAR_PANEL = new CompressedSolarPanelBlock("compressedSolarPanelBlock");
    public static final CommonPanelBlock DOUBLE_COMPRESSED_SOLAR_PANEL = new DoubleCompressedSolarPanelBlock("doubleCompressedSolarPanelBlock");
    public static final CommonPanelBlock TRIPLE_COMPRESSED_SOLAR_PANEL = new TripleCompressedSolarPanelBlock("tripleCompressedSolarPanelBlock");
    public static final CommonPanelBlock QUADRUPLE_COMPRESSED_SOLAR_PANEL = new QuadrupleCompressedSolarPanelBlock("quadrupleCompressedSolarPanelBlock");
    public static final CommonPanelBlock QUINTUPLE_COMPRESSED_SOLAR_PANEL = new QuintupleCompressedSolarPanelBlock("quintupleCompressedSolarPanelBlock");
    public static final CommonPanelBlock SEXTUPLE_COMPRESSED_SOLAR_PANEL = new SextupleCompressedSolarPanelBlock("sextupleCompressedSolarPanelBlock");
    public static final CommonPanelBlock SEPTUPLE_COMPRESSED_SOLAR_PANEL = new SeptupleCompressedSolarPanelBlock("septupleCompressedSolarPanelBlock");


    public static void register() {
        GameRegistry.registerBlock(COMPRESSED_SOLAR_PANEL, CompressedSolarPanelItem.class, "CompressedSolarPanelBlock");
        GameRegistry.registerBlock(DOUBLE_COMPRESSED_SOLAR_PANEL, DoubleCompressedSolarPanelItem.class, "DoubleCompressedSolarPanelBlock");
        GameRegistry.registerBlock(TRIPLE_COMPRESSED_SOLAR_PANEL, TripleCompressedSolarPanelItem.class, "TripleCompressedSolarPanelBlock");
        GameRegistry.registerBlock(QUADRUPLE_COMPRESSED_SOLAR_PANEL, QuadrupleCompressedSolarPanelItem.class, "QuadrupleCompressedSolarPanelBlock");
        GameRegistry.registerBlock(QUINTUPLE_COMPRESSED_SOLAR_PANEL, QuintupleCompressedSolarPanelItem.class, "QuintupleCompressedSolarPanelBlock");
        GameRegistry.registerBlock(SEXTUPLE_COMPRESSED_SOLAR_PANEL, SextupleCompressedSolarPanelItem.class, "SextupleCompressedSolarPanelBlock");
        GameRegistry.registerBlock(SEPTUPLE_COMPRESSED_SOLAR_PANEL, SeptupleCompressedSolarPanelItem.class, "SeptupleCompressedSolarPanelBlock");

    }
}
