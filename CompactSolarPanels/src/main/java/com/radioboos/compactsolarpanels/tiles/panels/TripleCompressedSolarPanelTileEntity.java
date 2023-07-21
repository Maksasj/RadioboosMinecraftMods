package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.common.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.config.Configs;

public class TripleCompressedSolarPanelTileEntity extends CommonPanelTileEntity {
    public TripleCompressedSolarPanelTileEntity() {
        super(Configs.TRIPLE_COMPRESSED_SOLAR_PANEL_CONFIG);
    }

    @Override
    public String getInventoryName() {
        return "Triple Compressed Solar Panel";
    }
}
