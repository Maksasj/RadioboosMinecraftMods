package com.radioboos.beekeeperssolarpanels.blocks;

import com.radioboos.beekeeperssolarpanels.common.CommonGuiSolarPanel;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelBlock;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.tiles.panels.RipeBeekeepersSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.tiles.panels.SulfuricBeekeepersSolarPanelTileEntity;

public class SulfuricBeekeepersSolarPanelBlock extends CommonSolarPanelBlock {
    public SulfuricBeekeepersSolarPanelBlock(String name) {
        super(name);
    }

    @Override
    public int getGuiID() {
        return CommonGuiSolarPanel.GUI_ID;
    }

    @Override
    public CommonSolarPanelTileEntity getTileEntity() {
        return new SulfuricBeekeepersSolarPanelTileEntity();
    }
}