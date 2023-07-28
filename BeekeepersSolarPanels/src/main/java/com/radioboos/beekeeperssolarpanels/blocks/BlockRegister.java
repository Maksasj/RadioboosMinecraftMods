package com.radioboos.beekeeperssolarpanels.blocks;

import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelBlock;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;
import com.radioboos.beekeeperssolarpanels.items.panels.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister extends CommonRegister {
    public static final CommonSolarPanelBlock RIPE_BEEKEEPERS_SOLAR_PANEL = new RipeBeekeepersSolarPanelBlock("ripeBeekeepersSolarPanelBlock");
    public static final CommonSolarPanelBlock SHADOW_BEEKEEPERS_SOLAR_PANEL = new ShadowBeekeepersSolarPanelBlock("shadowBeekeepersSolarPanelBlock");
    public static final CommonSolarPanelBlock SULFURIC_BEEKEEPERS_SOLAR_PANEL = new SulfuricBeekeepersSolarPanelBlock("sulfuricBeekeepersSolarPanelBlock");
    public static final CommonSolarPanelBlock SHIMMERING_BEEKEEPERS_SOLAR_PANEL = new ShimmeringBeekeepersSolarPanelBlock("shimmeringBeekeepersSolarPanelBlock");
    public static final CommonSolarPanelBlock URANIC_BEEKEEPERS_SOLAR_PANEL = new UranicBeekeepersSolarPanelBlock("uranicBeekeepersSolarPanelBlock");
    public static final CommonSolarPanelBlock DIAMOND_BEEKEEPERS_SOLAR_PANEL = new DiamondBeekeepersSolarPanelBlock("diamondBeekeepersSolarPanelBlock");
    public static final CommonSolarPanelBlock PLATINUM_BEEKEEPERS_SOLAR_PANEL = new PlatinumBeekeepersSolarPanelBlock("platinicBeekeepersSolarPanelBlock");
    public static final CommonSolarPanelBlock SINGULAR_BEEKEEPERS_SOLAR_PANEL = new SingularBeekeepersSolarPanelBlock("singularBeekeepersSolarPanelBlock");

    public static void register() {
        GameRegistry.registerBlock(RIPE_BEEKEEPERS_SOLAR_PANEL, RipeBeekeepersSolarPanelItem.class, "RipeBeekeepersSolarPanelBlock");
        GameRegistry.registerBlock(SHADOW_BEEKEEPERS_SOLAR_PANEL, ShadowBeekeepersSolarPanelItem.class, "ShadowBeekeepersSolarPanelBlock");
        GameRegistry.registerBlock(SULFURIC_BEEKEEPERS_SOLAR_PANEL, SulfuricBeekeepersSolarPanelItem.class, "SulfuricBeekeepersSolarPanelBlock");
        GameRegistry.registerBlock(SHIMMERING_BEEKEEPERS_SOLAR_PANEL, ShimmeringBeekeepersSolarPanelItem.class, "ShimmeringBeekeepersSolarPanelBlock");
        GameRegistry.registerBlock(URANIC_BEEKEEPERS_SOLAR_PANEL, UranicBeekeepersSolarPanelItem.class, "UranicBeekeepersSolarPanelBlock");
        GameRegistry.registerBlock(DIAMOND_BEEKEEPERS_SOLAR_PANEL, DiamondBeekeepersSolarPanelItem.class, "DiamondBeekeepersSolarPanelBlock");
        GameRegistry.registerBlock(PLATINUM_BEEKEEPERS_SOLAR_PANEL, PlatinumBeekeepersSolarPanelItem.class, "PlatinumBeekeepersSolarPanelBlock");
        GameRegistry.registerBlock(SINGULAR_BEEKEEPERS_SOLAR_PANEL, SingularBeekeepersSolarPanelItem.class, "SingularBeekeepersSolarPanelBlock");
    }
}
