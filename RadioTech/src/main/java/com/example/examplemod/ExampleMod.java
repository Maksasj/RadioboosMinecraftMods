package com.example.examplemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.Item;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerItem(new CommonItem("silicon_chip_0"), "silicon_chip_0");
        GameRegistry.registerItem(new CommonItem("raw_silicon_wafer_0"), "raw_silicon_wafer_0");
        GameRegistry.registerItem(new CommonItem("raw_silicon_wafer_1"), "raw_silicon_wafer_1");
        GameRegistry.registerItem(new CommonItem("raw_silicon_wafer_2"), "raw_silicon_wafer_2");
        GameRegistry.registerItem(new CommonItem("silicon_monocrystalline_ingot_0"), "silicon_monocrystalline_ingot_0");

        for(int i = 1; i <= 10; ++i) {
            GameRegistry.registerItem(new CommonItem("tech_card_tier_" + i), "tech_card_tier_" + i);
        }
    }
}
