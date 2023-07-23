package com.radioboos.beekeeperssolarpanels.creative.tabs;

import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabRegister extends CommonRegister {
    public static CreativeTabs BEEKEEPERS_SOLAR_PANELS_CREATIVE_TAB;

    public static void register() {
        BEEKEEPERS_SOLAR_PANELS_CREATIVE_TAB = new BeekeepersSolarPanelsCreativeTab();
    }
}
