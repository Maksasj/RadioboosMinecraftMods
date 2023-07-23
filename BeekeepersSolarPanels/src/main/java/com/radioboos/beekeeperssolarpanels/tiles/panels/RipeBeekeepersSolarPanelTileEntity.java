package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.configs.Configs;

public class RipeBeekeepersSolarPanelTileEntity extends CommonSolarPanelTileEntity {
    public RipeBeekeepersSolarPanelTileEntity() {
        super(Configs.RIPE_BEEKEEPERS_SOLAR_PANEL);
    }

    @Override
    public String getInventoryName() {
        return "Ripe Beekeepers Solar Panel";
    }
}
