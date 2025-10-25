package com.radioboos.industriousbatteries.common;

import com.radioboos.industriousbatteries.blocks.BlockRegister;
import com.radioboos.industriousbatteries.tabs.CreativeTabRegister;
import com.radioboos.industriousbatteries.tiles.TileRegister;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        CreativeTabRegister.register();

        BlockRegister.register();
        TileRegister.register();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void load(FMLLoadEvent event) {

    }
}
