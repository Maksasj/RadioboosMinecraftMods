package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.configs.Configs;

public class DiamondBeekeepersSolarPanelTileEntity extends CommonSolarPanelTileEntity {
    public DiamondBeekeepersSolarPanelTileEntity() {
        super(Configs.DIAMOND_BEEKEEPERS_SOLAR_PANEL);
    }

    @Override
    public String getInventoryName() {
        return "Diamond Beekeepers Solar Panel";
    }
}
