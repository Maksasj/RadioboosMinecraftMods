package com.radioboos.compactsolarpanels.blocks;

import com.radioboos.compactsolarpanels.common.CommonRegister;
import com.radioboos.compactsolarpanels.items.CompressedSolarPanelItem;
import com.radioboos.compactsolarpanels.items.DoubleCompressedSolarPanelItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister extends CommonRegister {
    public static final CompressedSolarPanelBlock COMPRESSED_SOLAR_PANEL = new CompressedSolarPanelBlock("compressedSolarPanelBlock");
    public static final DoubleCompressedSolarPanelBlock DOUBLE_COMPRESSED_SOLAR_PANEL = new DoubleCompressedSolarPanelBlock("doubleCompressedSolarPanelBlock");

    public static void register() {
        GameRegistry.registerBlock(COMPRESSED_SOLAR_PANEL, CompressedSolarPanelItem.class, "CompressedSolarPanelBlock");
        GameRegistry.registerBlock(DOUBLE_COMPRESSED_SOLAR_PANEL, DoubleCompressedSolarPanelItem.class, "DoubleCompressedSolarPanelBlock");
    }
}