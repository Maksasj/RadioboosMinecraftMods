package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.config.Configs;

public class SextupleCompressedSolarPanelTileEntity extends CommonPanelTileEntity {
    public SextupleCompressedSolarPanelTileEntity() {
        super(Configs.SEXTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG);
    }

    @Override
    public String getInventoryName() {
        return "Sextuple Compressed Solar Panel";
    }
}
