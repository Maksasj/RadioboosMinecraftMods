package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.configs.Configs;

public class ShimmeringBeekeepersSolarPanelTileEntity extends CommonSolarPanelTileEntity {
    public ShimmeringBeekeepersSolarPanelTileEntity() {
        super(Configs.SHIMMERING_BEEKEEPERS_SOLAR_PANEL);
    }

    @Override
    public String getInventoryName() {
        return "Shimmering Beekeepers Solar Panel";
    }
}
