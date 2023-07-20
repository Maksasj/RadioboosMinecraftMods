package com.radioboos.compactsolarpanels.common;

import com.radioboos.compactsolarpanels.blocks.BlockRegister;
import com.radioboos.compactsolarpanels.creative.tabs.CreativeTabRegister;
import com.radioboos.compactsolarpanels.recipes.RecipeRegister;
import com.radioboos.compactsolarpanels.tiles.panels.TileRegister;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        CreativeTabRegister.register();

        BlockRegister.register();
        TileRegister.register();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {
        RecipeRegister.register();
    }

    public void load(FMLLoadEvent event) {

    }
}