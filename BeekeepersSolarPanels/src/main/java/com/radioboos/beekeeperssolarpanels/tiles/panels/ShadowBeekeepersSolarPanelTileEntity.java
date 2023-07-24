package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import com.radioboos.beekeeperssolarpanels.configs.Configs;

public class ShadowBeekeepersSolarPanelTileEntity extends CommonSolarPanelTileEntity {
    public ShadowBeekeepersSolarPanelTileEntity() {
        super(Configs.SHADOW_BEEKEEPERS_SOLAR_PANEL);
    }

    @Override
    public String getInventoryName() {
        return "Shadow Beekeepers Solar Panel";
    }
}
