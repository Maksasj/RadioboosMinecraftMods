package com.example.examplemod;

import com.ibm.dtfj.phd.parser.Base;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import java.util.List;

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
