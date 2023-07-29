package com.radioboos.industriousbatteries;

import com.radioboos.industriousbatteries.common.CommonProxy;
import com.radioboos.industriousbatteries.gui.GuiHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = IndustriousBatteries.MODID, version = IndustriousBatteries.VERSION)
public class IndustriousBatteries
{
    public static final String MODID = "industriousbatteries";
    public static final String VERSION = "1.0";

    @SidedProxy(
            clientSide = "com.radioboos.industriousbatteries.proxy.ClientProxy",
            serverSide = "com.radioboos.industriousbatteries.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance("industriousbatteries")
    public static IndustriousBatteries instance;

    public IndustriousBatteries() {
        instance = this;
    }
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preInit(event);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void load(FMLLoadEvent event) {
        proxy.load(event);
    }
}
