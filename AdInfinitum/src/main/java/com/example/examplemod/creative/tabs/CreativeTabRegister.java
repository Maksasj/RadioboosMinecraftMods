package com.example.examplemod.creative.tabs;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabRegister {
    public static CreativeTabs COMPACT_SOLAR_PANELS_CREATIVE_TAB;

    public static void register() {
        COMPACT_SOLAR_PANELS_CREATIVE_TAB = new CompactSolarPanelsCreativeTab();
    }
}
