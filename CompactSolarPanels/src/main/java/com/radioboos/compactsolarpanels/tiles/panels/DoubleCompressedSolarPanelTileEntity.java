package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.config.Configs;

public class DoubleCompressedSolarPanelTileEntity extends CommonPanelTileEntity {
    public DoubleCompressedSolarPanelTileEntity() {
        super(Configs.DOUBLE_COMPRESSED_SOLAR_PANEL_CONFIG);
    }

    @Override
    public String getInventoryName() {
        return "Double Compressed Solar Panel";
    }
}
