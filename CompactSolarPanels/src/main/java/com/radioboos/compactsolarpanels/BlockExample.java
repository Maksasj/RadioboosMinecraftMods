package com.radioboos.compactsolarpanels;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockExample extends BlockContainer {
    public BlockExample(Material mat) {
        super(mat);
        setBlockName("mainBlock");
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
        if (world.isRemote) {
            System.out.print("block clicked, open gui.\n");
            System.out.print(ExampleMod.instance == null);
            player.openGui(ExampleMod.instance, GuiSolarPanel.GUI_ID, world, x, y, z);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new BasePanel();
    }
}