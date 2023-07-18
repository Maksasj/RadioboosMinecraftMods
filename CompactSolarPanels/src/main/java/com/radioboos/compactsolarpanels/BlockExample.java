package com.radioboos.compactsolarpanels;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockExample extends BlockContainer {
    public BlockExample(Material mat) {
        super(mat);
        setBlockName("mainBlock");
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new BasePanel();
    }
}