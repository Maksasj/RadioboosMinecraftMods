package com.radioboos.compactsolarpanels.blocks;

import com.radioboos.compactsolarpanels.common.CommonPanelBlock;
import com.radioboos.compactsolarpanels.common.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.common.CommonGuiSolarPanel;
import com.radioboos.compactsolarpanels.tiles.panels.CompressedSolarPanelTileEntity;

public class CompressedSolarPanelBlock extends CommonPanelBlock {
    public CompressedSolarPanelBlock(String name) {
        super(name);
    }

    @Override
    public int getGuiID() {
        return CommonGuiSolarPanel.GUI_ID;
    }

    @Override
    public CommonPanelTileEntity getTileEntity() {
        return new CompressedSolarPanelTileEntity();
    }
}
