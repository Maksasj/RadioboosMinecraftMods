package com.radioboos.beekeeperssolarpanels.blocks;

import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelBlock;
import com.radioboos.beekeeperssolarpanels.items.RipeBeekeepersSolarPanelItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister extends CommonRegister {
    public static final CommonSolarPanelBlock RIPE_BEEKEEPERS_SOLAR_PANEL = new RipeBeekeepersSolarPanelBlock("ripeBeekeepersSolarPanelBlock");

    public static void register() {
        GameRegistry.registerBlock(RIPE_BEEKEEPERS_SOLAR_PANEL, RipeBeekeepersSolarPanelItem.class, "RipeBeekeepersSolarPanelBlock");
    }
}
