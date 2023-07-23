package com.radioboos.beekeeperssolarpanels.common;

import com.radioboos.beekeeperssolarpanels.blocks.BlockRegister;
import com.radioboos.beekeeperssolarpanels.creative.tabs.CreativeTabRegister;
import com.radioboos.beekeeperssolarpanels.items.ItemRegister;
import com.radioboos.beekeeperssolarpanels.recipes.RecipeRegister;
import com.radioboos.beekeeperssolarpanels.tiles.panels.TileRegister;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        CreativeTabRegister.register();

        BlockRegister.register();
        ItemRegister.register();
        TileRegister.register();
        RecipeRegister.register();
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void load(FMLLoadEvent event) {

    }
}
