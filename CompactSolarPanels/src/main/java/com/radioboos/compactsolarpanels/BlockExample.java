package com.radioboos.compactsolarpanels;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockExample extends BlockContainer {

    private BasePanelEntity entity;

    public BlockExample() {
        super(Material.rock);

        setBlockName("mainBlock");
        setCreativeTab(CreativeTabs.tabRedstone);

        entity = null;
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
    public void onBlockPreDestroy(World world, int x, int y, int z, int meta) {
        super.onBlockPreDestroy(world, x, y, z, meta);

        if(entity == null)
            return;

        for(ItemStack stack : entity.getContents()) {
            if(stack == null)
                continue;

            if (!world.isRemote && stack != null && stack.stackSize > 0) {
                EntityItem entityItem = new EntityItem(world, x, y, z, stack.copy());

                entityItem.motionX = 0;
                entityItem.motionY = 0;
                entityItem.motionZ = 0;

                world.spawnEntityInWorld(entityItem);
            }
        }
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        entity = new BasePanelEntity();
        return entity;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return null;
    }
}