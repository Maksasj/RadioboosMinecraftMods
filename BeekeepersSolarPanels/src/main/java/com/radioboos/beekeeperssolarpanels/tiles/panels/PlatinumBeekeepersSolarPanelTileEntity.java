package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.configs.Configs;

public class PlatinumBeekeepersSolarPanelTileEntity extends CommonSolarPanelTileEntity {
    public PlatinumBeekeepersSolarPanelTileEntity() {
        super(Configs.PLATINUM_BEEKEEPERS_SOLAR_PANEL);
    }

    @Override
    public String getInventoryName() {
        return "Platinum Beekeepers Solar Panel";
    }
}
