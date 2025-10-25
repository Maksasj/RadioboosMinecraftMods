package com.radioboos.industriousbatteries.blocks;

import com.radioboos.industriousbatteries.IndustriousBatteries;
import com.radioboos.industriousbatteries.gui.SimpleBatteryStorageGui;
import com.radioboos.industriousbatteries.tabs.CreativeTabRegister;
import com.radioboos.industriousbatteries.tiles.SimpleBatteryStorageTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class AdvancedBatteryStorageBlock extends BlockContainer {
    public AdvancedBatteryStorageBlock(String name) {
        super(Material.rock);
        setBlockName(name);

        setCreativeTab(CreativeTabRegister.INDUSTRIOUS_BATTERIES_CREATIVE_TAB_CREATIVE_TAB);
    }

    public int getGuiID() {
        return SimpleBatteryStorageGui.GUI_ID;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new SimpleBatteryStorageTileEntity();
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