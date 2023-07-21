package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.config.Configs;

public class SeptupleCompressedSolarPanelTileEntity extends CommonPanelTileEntity {
    public SeptupleCompressedSolarPanelTileEntity() {
        super(Configs.SEPTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG);
    }

    @Override
    public String getInventoryName() {
        return "Septuple Compressed Solar Panel";
    }
}
