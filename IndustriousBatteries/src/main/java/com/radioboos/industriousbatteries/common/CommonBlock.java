package com.radioboos.industriousbatteries.common;

import com.radioboos.industriousbatteries.IndustriousBatteries;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.lwjgl.Sys;

public class CommonBlock extends BlockContainer {
    private String blockName;
    private TileEntity entity;

    public CommonBlock(String name) {
        super(Material.rock);

        this.blockName = name;

        setBlockName(blockName);

        // setCreativeTab(CreativeTabRegister.BEEKEEPERS_SOLAR_PANELS_CREATIVE_TAB);

        entity = null;
    }


    public int getGuiID() {
        return CommonEnergyStorageGui.GUI_ID;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
        if (player.isSneaking()) {
            return false;
        }

        if (world.isRemote) {
            return true;
        }

        player.openGui(IndustriousBatteries.instance, this.getGuiID(), world, x, y, z);

        return true;
    }

    @Override
    public void onBlockPreDestroy(World world, int x, int y, int z, int meta) {
        super.onBlockPreDestroy(world, x, y, z, meta);

        // if(entity == null)
        //     return;

        /*
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
        */
    }

    @SideOnly(Side.CLIENT)
    private IIcon[] textures;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        textures = new IIcon[3];

        textures[0] = iconRegister.registerIcon("industriousbatteries:" + blockName + "/top");
        textures[1] = iconRegister.registerIcon("industriousbatteries:" + blockName + "/side");
        textures[2] = iconRegister.registerIcon("industriousbatteries:" + blockName + "/bottom");
    }

    @Override
    public IIcon getIcon(int i, int j) {
        if(i == 1)
            return textures[0];

        if(i == 0)
            return textures[2];

        return textures[1];
    }

    public TileEntity getTileEntity() {
        return new CommonEnergyStorageTileEntity();
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        System.out.println("Placed storage");
        entity = this.getTileEntity();
        return entity;
    }
}