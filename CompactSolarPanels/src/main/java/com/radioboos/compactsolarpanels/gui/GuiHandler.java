package com.radioboos.compactsolarpanels.gui;

import com.radioboos.compactsolarpanels.CommonPanelTileEntity;
import com.radioboos.compactsolarpanels.SolarPanelContainer;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null && entity instanceof CommonPanelTileEntity) {
            CommonPanelTileEntity tile = (CommonPanelTileEntity) entity;
            return new SolarPanelContainer(player.inventory, tile);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null && entity instanceof CommonPanelTileEntity) {
            CommonPanelTileEntity tile = (CommonPanelTileEntity) entity;
            return new GuiSolarPanel(tile, new SolarPanelContainer(player.inventory, tile));
        }

        return null;
    }
}