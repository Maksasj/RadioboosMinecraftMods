package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class TileRegister extends CommonRegister {
    public static final TileEntity RIPE_BEEKEEPERS_SOLAR_PANEL = new RipeBeekeepersSolarPanelTileEntity();

    public static void register() {
        GameRegistry.registerTileEntity(RipeBeekeepersSolarPanelTileEntity.class, "RipeBeekeepersSolarPanel");
    }
}
