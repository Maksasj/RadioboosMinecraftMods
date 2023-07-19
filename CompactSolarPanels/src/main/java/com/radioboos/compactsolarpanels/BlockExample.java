package com.radioboos.compactsolarpanels;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockExample extends BlockContainer {
    public BlockExample() {
        super(Material.rock);
        setBlockName("mainBlock");
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
        if (player.isSneaking()) {
            return false;
        }

        if (world.isRemote) {
            return true;
        }

        player.openGui(ExampleMod.instance, GuiSolarPanel.GUI_ID, world, x, y, z);

        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new BasePanelEntity();
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return null;
    }
}