package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Configs {
    public static CommonSolarPanelConfig COMPRESSED_SOLAR_PANEL_CONFIG = new CompressedSolarPanelConfig("compressedSolarPanel");
    public static CommonSolarPanelConfig DOUBLE_COMPRESSED_SOLAR_PANEL_CONFIG = new DoubleCompressedSolarPanelConfig("doubleCompressedSolarPanel");
    public static CommonSolarPanelConfig TRIPLE_COMPRESSED_SOLAR_PANEL_CONFIG = new TripleCompressedSolarPanelConfig("tripleCompressedSolarPanel");
    public static CommonSolarPanelConfig QUADRUPLE_COMPRESSED_SOLAR_PANEL_CONFIG = new QuadrupleCompressedSolarPanelConfig("quadrupleCompressedSolarPanel");
    public static CommonSolarPanelConfig QUINTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG = new QuintupleCompressedSolarPanelConfig("quintupleCompressedSolarPanel");
    public static CommonSolarPanelConfig SEXTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG = new SextupleCompressedSolarPanelConfig("sextupleCompressedSolarPanel");
    public static CommonSolarPanelConfig SEPTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG = new SeptupleCompressedSolarPanelConfig("septupleCompressedSolarPanel");

    public static void loadConfig(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();

            COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
            DOUBLE_COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
            TRIPLE_COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
            QUADRUPLE_COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
            QUINTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
            SEXTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
            SEPTUPLE_COMPRESSED_SOLAR_PANEL_CONFIG.loadConfig(cfg);
        } catch (Exception e) {
            System.out.println("CompactSolarPanels was unable to load it's configuration successfully");
            throw new RuntimeException(e);
        } finally {
            cfg.save();
        }
    }
}
