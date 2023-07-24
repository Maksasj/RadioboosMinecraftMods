package com.radioboos.beekeeperssolarpanels.blocks;

import com.radioboos.beekeeperssolarpanels.common.CommonGuiSolarPanel;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelBlock;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.tiles.panels.DiamondBeekeepersSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.tiles.panels.RipeBeekeepersSolarPanelTileEntity;

public class DiamondBeekeepersSolarPanelBlock extends CommonSolarPanelBlock {
    public DiamondBeekeepersSolarPanelBlock(String name) {
        super(name);
    }

    @Override
    public int getGuiID() {
        return CommonGuiSolarPanel.GUI_ID;
    }

    @Override
    public CommonSolarPanelTileEntity getTileEntity() {
        return new DiamondBeekeepersSolarPanelTileEntity();
    }
}