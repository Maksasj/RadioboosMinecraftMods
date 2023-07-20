package com.radioboos.compactsolarpanels;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = CompactSolarPanels.MODID, version = CompactSolarPanels.VERSION)
public class CompactSolarPanels {
    public static final String MODID = "compactsolarpanels";
    public static final String VERSION = "1.0";

    @Mod.Instance("compactsolarpanels")
    public static CompactSolarPanels instance;

    public CompactSolarPanels() {
        instance = this;
    }

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        Block compactSolarBlock = new BlockExample();

        GameRegistry.registerBlock(compactSolarBlock, ItemCompactSolar.class, "CompactSolarBlock");
        GameRegistry.registerTileEntity(BasePanelEntity.class, "CompactSolarTileEntity");

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void load(FMLInitializationEvent event) {

    }
}
