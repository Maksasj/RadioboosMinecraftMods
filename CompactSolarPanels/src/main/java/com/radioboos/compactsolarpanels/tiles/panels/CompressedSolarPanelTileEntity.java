package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.config.Configs;

public class CompressedSolarPanelTileEntity extends CommonPanelTileEntity {
    public CompressedSolarPanelTileEntity() {
        super(Configs.COMPRESSED_SOLAR_PANEL_CONFIG);
    }

    @Override
    public String getInventoryName() {
        return "Compressed Solar Panel";
    }
}
