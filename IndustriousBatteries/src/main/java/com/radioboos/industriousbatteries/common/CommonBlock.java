package com.radioboos.industriousbatteries.common;

import com.radioboos.industriousbatteries.IndustriousBatteries;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.Sys;

public class CommonBlock extends BlockContainer {
    public CommonBlock(String name) {
        super(Material.rock);
        setBlockName(name);
    }

    public int getGuiID() {
        return CommonEnergyStorageGui.GUI_ID;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new BatteryStorageTileEntity();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
        if (player.isSneaking())
            return false;

        if (world.isRemote)
            return true;

        player.openGui(IndustriousBatteries.instance, this.getGuiID(), world, x, y, z);

        return true;
    }

    @SideOnly(Side.CLIENT)
    private IIcon topTexture;
    @SideOnly(Side.CLIENT)
    private IIcon sideTexture;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        topTexture = iconRegister.registerIcon("industriousbatteries:testBlock/top");
        sideTexture = iconRegister.registerIcon("industriousbatteries:testBlock/side");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if(meta == side)
            return topTexture;

        return sideTexture;
    }
}