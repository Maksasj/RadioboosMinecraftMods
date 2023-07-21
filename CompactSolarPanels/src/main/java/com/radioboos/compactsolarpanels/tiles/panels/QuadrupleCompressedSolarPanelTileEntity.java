package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.config.Configs;

public class QuadrupleCompressedSolarPanelTileEntity extends CommonPanelTileEntity {
    public QuadrupleCompressedSolarPanelTileEntity() {
        super(Configs.QUADRUPLE_COMPRESSED_SOLAR_PANEL_CONFIG);
    }

    @Override
    public String getInventoryName() {
        return "Quadruple Compressed Solar Panel";
    }
}
