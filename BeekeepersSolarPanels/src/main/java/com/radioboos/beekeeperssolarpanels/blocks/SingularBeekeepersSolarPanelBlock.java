package com.radioboos.beekeeperssolarpanels.blocks;

import com.radioboos.beekeeperssolarpanels.common.CommonGuiSolarPanel;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelBlock;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.tiles.panels.SingularBeekeepersSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.tiles.panels.UranicBeekeepersSolarPanelTileEntity;

public class SingularBeekeepersSolarPanelBlock extends CommonSolarPanelBlock {
    public SingularBeekeepersSolarPanelBlock(String name) {
        super(name);
    }

    @Override
    public int getGuiID() {
        return CommonGuiSolarPanel.GUI_ID;
    }

    @Override
    public CommonSolarPanelTileEntity getTileEntity() {
        return new SingularBeekeepersSolarPanelTileEntity();
    }
}