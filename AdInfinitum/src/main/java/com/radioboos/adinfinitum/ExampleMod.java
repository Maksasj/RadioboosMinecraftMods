package com.radioboos.adinfinitum;

import com.radioboos.adinfinitum.creative.tabs.CreativeTabRegister;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "ad-infinitum";
    public static final String VERSION = "1.0";

    public static CommonItem silicon_chip_0;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        silicon_chip_0 = new CommonItem("silicon_chip_0");
        GameRegistry.registerItem(silicon_chip_0, "silicon_chip_0");
        GameRegistry.registerItem(new CommonItem("raw_silicon_wafer_0"), "raw_silicon_wafer_0");
        GameRegistry.registerItem(new CommonItem("raw_silicon_wafer_1"), "raw_silicon_wafer_1");
        GameRegistry.registerItem(new CommonItem("raw_silicon_wafer_2"), "raw_silicon_wafer_2");
        GameRegistry.registerItem(new CommonItem("silicon_monocrystalline_ingot_0"), "silicon_monocrystalline_ingot_0");

        GameRegistry.registerItem(new CommonItem("silicon_chip_1"), "silicon_chip_1");
        GameRegistry.registerItem(new CommonItem("capacitor_0"), "capacitor_0");
        GameRegistry.registerItem(new CommonItem("capacitor_1"), "capacitor_1");
        GameRegistry.registerItem(new CommonItem("diode_0"), "diode_0");
        GameRegistry.registerItem(new CommonItem("diode_1"), "diode_1");
        GameRegistry.registerItem(new CommonItem("iductor_0"), "iductor_0");
        GameRegistry.registerItem(new CommonItem("transistor_0"), "transistor_0");

        CreativeTabRegister.register();
    }
}
