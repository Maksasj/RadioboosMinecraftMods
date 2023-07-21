package com.radioboos.compactsolarpanels;

import com.radioboos.compactsolarpanels.common.CommonProxy;
import com.radioboos.compactsolarpanels.config.Configs;
import com.radioboos.compactsolarpanels.gui.GuiHandler;
import cpw.mods.fml.common.SidedProxy;

import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(   modid = CompactSolarPanels.MODID,
        name = "Compact Solar Panels",
        version = CompactSolarPanels.VERSION,
        dependencies = "required-after:IC2@[2.0,);required-after:Forge@[9.10,)")
public class CompactSolarPanels {
    public static final String MODID = "compactsolarpanels";
    public static final String VERSION = "1.0";
    @SidedProxy(clientSide = "com.radioboos.compactsolarpanels.proxy.ClientProxy", serverSide = "com.radioboos.compactsolarpanels.common.ServerProxy")
    public static CommonProxy proxy;
    @Mod.Instance("compactsolarpanels")
    public static CompactSolarPanels instance;

    public CompactSolarPanels() {
        instance = this;
    }

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        Configs.loadConfig(event);
        proxy.preInit(event);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void load(FMLLoadEvent event) {
        proxy.load(event);
    }
}
