package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.config.Configs;

public class QuintupleCompressedSolarPanelTileEntity extends CommonPanelTileEntity {
    public QuintupleCompressedSolarPanelTileEntity() {
        super(Configs.QUINTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG);
    }

    @Override
    public String getInventoryName() {
        return "Quintuple Compressed Solar Panel";
    }
}
