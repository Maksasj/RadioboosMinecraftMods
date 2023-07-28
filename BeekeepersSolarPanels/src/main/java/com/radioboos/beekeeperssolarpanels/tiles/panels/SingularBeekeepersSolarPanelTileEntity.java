package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.configs.Configs;

public class SingularBeekeepersSolarPanelTileEntity extends CommonSolarPanelTileEntity {
    public SingularBeekeepersSolarPanelTileEntity() {
        super(Configs.SINGULAR_BEEKEEPERS_SOLAR_PANEL);
    }

    @Override
    public String getInventoryName() {
        return "Singular Beekeepers Solar Panel";
    }
}
