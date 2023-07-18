package com.radioboos.compactsolarpanels;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    public static Block compactSolarBlock;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        compactSolarBlock = new BlockExample(Material.rock);
        // GameRegistry.registerTileEntity(TileEntity.class, "CompactSolarBlock");

        GameRegistry.registerBlock(compactSolarBlock, ItemCompactSolar.class, "CompactSolarBlock");
        GameRegistry.registerTileEntity(BasePanel.class, "CompactSolarTileEntity");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
