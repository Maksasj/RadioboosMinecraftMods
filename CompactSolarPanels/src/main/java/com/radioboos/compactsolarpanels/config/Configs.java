package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Configs {
    public static CommonSolarPanelConfig COMPRESSED_SOLAR_PANEL_CONFIG = new CompressedSolarPanelConfig("compressedSolarPanel");
    public static CommonSolarPanelConfig DOUBLE_COMPRESSED_SOLAR_PANEL_CONFIG = new DoubleCompressedSolarPanelConfig("doubleCompressedSolarPanel");
    public static CommonSolarPanelConfig TRIPLE_COMPRESSED_SOLAR_PANEL_CONFIG = new TripleCompressedSolarPanelConfig("tripleCompressedSolarPanel");

    public static void loadConfig(FMLPreInitializationEvent event) {
        System.out.println(event.getSuggestedConfigurationFile());
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();

            COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
            DOUBLE_COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
        } catch (Exception e) {
            System.out.println("CompactSolarPanels was unable to load it's configuration successfully");
            throw new RuntimeException(e);
        } finally {
            cfg.save();
        }
    }
}
