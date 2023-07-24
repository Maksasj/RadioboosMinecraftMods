package com.radioboos.beekeeperssolarpanels.gui;

import com.radioboos.beekeeperssolarpanels.common.CommonGuiSolarPanel;
import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null && entity instanceof CommonSolarPanelTileEntity) {
            CommonSolarPanelTileEntity tile = (CommonSolarPanelTileEntity) entity;
            return new SolarPanelContainer(player.inventory, tile);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null && entity instanceof CommonSolarPanelTileEntity) {
            CommonSolarPanelTileEntity tile = (CommonSolarPanelTileEntity) entity;
            return new CommonGuiSolarPanel(tile, new SolarPanelContainer(player.inventory, tile));
        }

        return null;
    }
}
