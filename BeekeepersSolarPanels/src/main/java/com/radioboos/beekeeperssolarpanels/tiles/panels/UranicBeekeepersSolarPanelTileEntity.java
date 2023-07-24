package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.configs.Configs;

public class UranicBeekeepersSolarPanelTileEntity extends CommonSolarPanelTileEntity {
    public UranicBeekeepersSolarPanelTileEntity() {
        super(Configs.URANIC_BEEKEEPERS_SOLAR_PANEL);
    }

    @Override
    public String getInventoryName() {
        return "Uranic Beekeepers Solar Panel";
    }
}
