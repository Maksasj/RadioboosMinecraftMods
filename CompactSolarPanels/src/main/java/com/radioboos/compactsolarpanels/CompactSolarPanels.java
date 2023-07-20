package com.radioboos.compactsolarpanels;

import ic2.api.item.IC2Items;

import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.ItemStack;

@Mod(   modid = CompactSolarPanels.MODID,
        version = CompactSolarPanels.VERSION,
        dependencies = "required-after:IC2@[2.0,);required-after:Forge@[9.10,)")
public class CompactSolarPanels {
    public static final String MODID = "compactsolarpanels";
    public static final String VERSION = "1.0";

    private Block compactSolarBlock;

    @Mod.Instance("compactsolarpanels")
    public static CompactSolarPanels instance;

    public CompactSolarPanels() {
        instance = this;
    }

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        compactSolarBlock = new BlockExample();

        GameRegistry.registerBlock(compactSolarBlock, ItemCompactSolar.class, "CompactSolarBlock");
        GameRegistry.registerTileEntity(BasePanelEntity.class, "CompactSolarTileEntity");

        ItemStack solar = IC2Items.getItem("solarPanel");

        GameRegistry.addRecipe(new ItemStack(compactSolarBlock, 1), new Object[]{"###", "###", "###", '#', solar});

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void load(FMLLoadEvent event) {

    }
}
