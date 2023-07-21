package com.radioboos.compactsolarpanels.items;

import com.radioboos.compactsolarpanels.common.CommonPanelItemBlock;
import com.radioboos.compactsolarpanels.config.Configs;
import net.minecraft.block.Block;

public class CompressedSolarPanelItem extends CommonPanelItemBlock {
    public CompressedSolarPanelItem(Block block) {
        super(block, Configs.COMPRESSED_SOLAR_PANEL_CONFIG);
    }
}
