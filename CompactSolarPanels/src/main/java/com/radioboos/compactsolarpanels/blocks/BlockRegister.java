package com.radioboos.compactsolarpanels.blocks;

import com.radioboos.compactsolarpanels.CommonPanelBlock;
import com.radioboos.compactsolarpanels.CommonPanelItemBlock;
import com.radioboos.compactsolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister extends CommonRegister {
    public static final CommonPanelBlock SOLAR_PANEL = new CommonPanelBlock();

    public static void register() {
        GameRegistry.registerBlock(SOLAR_PANEL, CommonPanelItemBlock.class, "CompactSolarBlock");
    }
}
