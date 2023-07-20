package com.radioboos.compactsolarpanels;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import javax.swing.*;

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

        player.openGui(CompactSolarPanels.instance, GuiSolarPanel.GUI_ID, world, x, y, z);

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

    @SideOnly(Side.CLIENT)
    private IIcon[] textures;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        textures = new IIcon[3];

        textures[0] = iconRegister.registerIcon("compactsolarpanels:solartop");
        textures[1] = iconRegister.registerIcon("compactsolarpanels:side");
        textures[2] = iconRegister.registerIcon("compactsolarpanels:bottom");
    }

    @Override
    public IIcon getIcon(int i, int j) {
        if(i == 1)
            return textures[0];

        if(i == 0)
            return textures[2];

        return textures[1];
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        entity = new BasePanelEntity();
        return entity;
    }
}