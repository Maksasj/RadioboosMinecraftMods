package com.radioboos.industriousbatteries.gui;

import com.radioboos.industriousbatteries.common.*;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity instanceof CommonEnergyStorageTileEntity) {
            CommonEnergyStorageTileEntity tile = (CommonEnergyStorageTileEntity) entity;
            return new CommonEnergyStorageContainer(player.inventory, tile);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity instanceof CommonEnergyStorageTileEntity) {
            CommonEnergyStorageTileEntity tile = (CommonEnergyStorageTileEntity) entity;
            return new CommonEnergyStorageGui(tile, new CommonEnergyStorageContainer(player.inventory, tile));
        }

        return null;
    }
}