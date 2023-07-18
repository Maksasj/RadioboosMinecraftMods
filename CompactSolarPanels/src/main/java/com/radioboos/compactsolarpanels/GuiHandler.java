package com.radioboos.compactsolarpanels;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GuiSolarPanel.GUI_ID) {
            System.out.print("create gui.\n");
            BasePanelEntity block = (BasePanelEntity) world.getTileEntity(x, y, z);
            return new GuiSolarPanel(new SolarPanelContainer(player.inventory, block));
        }
        return null;
    }
}