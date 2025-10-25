package com.radioboos.industriousbatteries.gui;

import com.radioboos.industriousbatteries.common.*;
import com.radioboos.industriousbatteries.tiles.AdvancedBatteryStorageTileEntity;
import com.radioboos.industriousbatteries.tiles.SimpleBatteryStorageTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity instanceof SimpleBatteryStorageTileEntity) {
            SimpleBatteryStorageTileEntity tile = (SimpleBatteryStorageTileEntity) entity;
            return new SimpleEnergyStorageContainer(player.inventory, tile);
        }

        if (entity instanceof AdvancedBatteryStorageTileEntity) {
            AdvancedBatteryStorageTileEntity tile = (AdvancedBatteryStorageTileEntity) entity;
            return new AdvancedEnergyStorageContainer(player.inventory, tile);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity instanceof SimpleBatteryStorageTileEntity) {
            SimpleBatteryStorageTileEntity tile = (SimpleBatteryStorageTileEntity) entity;
            return new SimpleBatteryStorageGui(tile, new SimpleEnergyStorageContainer(player.inventory, tile));
        }

        if (entity instanceof AdvancedBatteryStorageTileEntity) {
            AdvancedBatteryStorageTileEntity tile = (AdvancedBatteryStorageTileEntity) entity;
            return new AdvancedBatteryStorageGui(tile, new AdvancedEnergyStorageContainer(player.inventory, tile));
        }

        return null;
    }
}