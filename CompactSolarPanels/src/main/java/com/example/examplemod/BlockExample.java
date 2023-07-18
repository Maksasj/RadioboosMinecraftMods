package com.example.examplemod;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockExample extends BlockContainer {
    int x;
    int y;
    int z;

    public BlockExample(Material mat) {
        super(mat);
        setBlockName("mainBlock");
        setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {

        return new BasePanel();
    }
}