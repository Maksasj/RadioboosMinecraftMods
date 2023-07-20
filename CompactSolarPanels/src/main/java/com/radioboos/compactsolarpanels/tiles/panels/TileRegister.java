package com.radioboos.compactsolarpanels.tiles.panels;

import com.radioboos.compactsolarpanels.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileRegister extends CommonRegister {
    public static final CommonPanelTileEntity SOLAR_PANEL_TILE = new CommonPanelTileEntity();

    public static void register() {
        GameRegistry.registerTileEntity(CommonPanelTileEntity.class, "CompactSolarTileEntity");
    }
}
