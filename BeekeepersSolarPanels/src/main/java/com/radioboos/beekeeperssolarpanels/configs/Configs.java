package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.blocks.RipeBeekeepersSolarPanelBlock;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Configs {
    public static CommonSolarPanelConfig RIPE_BEEKEEPERS_SOLAR_PANEL = new RipeBeekeepersSolarPanelConfig("ripeBeekeepersSolarPanelConfig");
    public static CommonSolarPanelConfig DIAMOND_BEEKEEPERS_SOLAR_PANEL = new DiamondBeekeepersSolarPanelConfig("diamondBeekeepersSolarPanelConfig");
    public static CommonSolarPanelConfig PLATINUM_BEEKEEPERS_SOLAR_PANEL = new PlatinumBeekeepersSolarPanelConfig("platinumBeekeepersSolarPanelConfig");
    public static CommonSolarPanelConfig SHADOW_BEEKEEPERS_SOLAR_PANEL = new ShadowBeekeepersSolarPanelConfig("shadowBeekeepersSolarPanelConfig");
    public static CommonSolarPanelConfig SHIMMERING_BEEKEEPERS_SOLAR_PANEL = new ShimmeringBeekeepersSolarPanelConfig("shimmeringBeekeepersSolarPanelConfig");
    public static CommonSolarPanelConfig SULFURIC_BEEKEEPERS_SOLAR_PANEL = new SulfuricBeekeepersSolarPanelConfig("sulfuricBeekeepersSolarPanelConfig");
    public static CommonSolarPanelConfig URANIC_BEEKEEPERS_SOLAR_PANEL = new UranicBeekeepersSolarPanelConfig("uranicBeekeepersSolarPanelConfig");
    public static CommonSolarPanelConfig SINGULAR_BEEKEEPERS_SOLAR_PANEL = new SingularBeekeepersSolarPanelConfig("singularBeekeepersSolarPanelConfig");

    public static void loadConfig(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();

            RIPE_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
            DIAMOND_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
            PLATINUM_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
            SHADOW_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
            SHIMMERING_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
            SULFURIC_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
            URANIC_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
            SINGULAR_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
        } catch (Exception e) {
            System.out.println("Beekeepers Solar Panels was unable to load it's configuration successfully");
            throw new RuntimeException(e);
        } finally {
            cfg.save();
        }
    }
}
