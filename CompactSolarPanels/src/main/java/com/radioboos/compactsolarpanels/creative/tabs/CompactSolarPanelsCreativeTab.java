package com.radioboos.compactsolarpanels.creative.tabs;

import com.radioboos.compactsolarpanels.blocks.BlockRegister;
import com.radioboos.compactsolarpanels.common.CommonCreativeTab;
import net.minecraft.item.Item;

public class CompactSolarPanelsCreativeTab extends CommonCreativeTab {
    public CompactSolarPanelsCreativeTab() {
        super("compactSolarPanelsCreativeTab");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(BlockRegister.COMPRESSED_SOLAR_PANEL);
    }
}
