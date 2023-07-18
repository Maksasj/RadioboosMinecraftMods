package com.radioboos.compactsolarpanels;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    @Mod.Instance("compactsolars")
    public static ExampleMod instance;

    public ExampleMod() {
        instance = this;
    }

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        Block compactSolarBlock = new BlockExample(Material.rock);

        GameRegistry.registerBlock(compactSolarBlock, ItemCompactSolar.class, "CompactSolarBlock");
        GameRegistry.registerTileEntity(BasePanelEntity.class, "CompactSolarTileEntity");

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
