package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.configs.Configs;

public class SulfuricBeekeepersSolarPanelTileEntity extends CommonSolarPanelTileEntity {
    public SulfuricBeekeepersSolarPanelTileEntity() {
        super(Configs.SULFURIC_BEEKEEPERS_SOLAR_PANEL);
    }

    @Override
    public String getInventoryName() {
        return "Sulfuric Beekeepers Solar Panel";
    }
}
