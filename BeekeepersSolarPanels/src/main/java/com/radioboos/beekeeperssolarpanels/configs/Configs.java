package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.blocks.RipeBeekeepersSolarPanelBlock;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Configs {
    public static CommonSolarPanelConfig RIPE_BEEKEEPERS_SOLAR_PANEL = new RipeBeekeepersSolarPanelConfig("ripeBeekeepersSolarPanelConfig");

    public static void loadConfig(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();

            RIPE_BEEKEEPERS_SOLAR_PANEL.loadConfig(cfg);
        } catch (Exception e) {
            System.out.println("Beekeepers Solar Panels was unable to load it's configuration successfully");
            throw new RuntimeException(e);
        } finally {
            cfg.save();
        }
    }
}
