package com.radioboos.beekeeperssolarpanels.configs;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class Configs {
    public static void loadConfig(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();

        } catch (Exception e) {
            System.out.println("Beekeepers Solar Panels was unable to load it's configuration successfully");
            throw new RuntimeException(e);
        } finally {
            cfg.save();
        }
    }
}
