package com.radioboos.industriousbatteries.tabs;

import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabRegister {
    public static CreativeTabs INDUSTRIOUS_BATTERIES_CREATIVE_TAB_CREATIVE_TAB;

    public static void register() {
        INDUSTRIOUS_BATTERIES_CREATIVE_TAB_CREATIVE_TAB = new IndustriousBatteriesCreativeTab();
    }
}
