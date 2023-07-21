package com.radioboos.compactsolarpanels.creative.tabs;

import com.radioboos.compactsolarpanels.common.CommonRegister;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabRegister extends CommonRegister {
    public static CreativeTabs COMPACT_SOLAR_PANELS_CREATIVE_TAB;

    public static void register() {
        COMPACT_SOLAR_PANELS_CREATIVE_TAB = new CompactSolarPanelsCreativeTab();
    }
}
