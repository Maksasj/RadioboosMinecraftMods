package com.radioboos.compactsolarpanels;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiSolarPanel extends GuiContainer {
        public static final ResourceLocation guiTexture = new ResourceLocation("textures/gui/container/furnace.png");

        public static final int GUI_ID = 20;

        public GuiSolarPanel(Container container) {
            super(container);
            System.out.print("gui constructor.\n");
        }

        @Override
        public void initGui() {
            // buttonList.clear();
            // buttonList.add(new GuiButton(0, 100, 100, 60, 60, "Button"));
        }

        @Override
        public boolean doesGuiPauseGame() {
            return false;
        }

        // @Override
        // public void drawScreen(int i, int j, float f) {
        //     drawDefaultBackground();
        //     // super.drawScreen(i, j, f);
        //     // System.out.print("drawing gui.\n");
//
        //     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //     mc.renderEngine.bindTexture(gui);
        //     int l = (width - this.xSize) / 2;
        //     int i1 = (height - this.ySize) / 2;
        //     drawTexturedModalRect(l, i1, 0, 0, this.xSize, this.ySize);
        //     if (container.tile.theSunIsVisible) {
        //         drawTexturedModalRect(l + 80, i1 + 45, 176, 0, 14, 14);
        //     }
        // }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0f, 1.0f ,1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(guiTexture);
        int k = (width - this.xSize) / 2;
        int l = (height - this.ySize) / 2;
        drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }

    @Override
        public void actionPerformed(GuiButton button) {
            // System.out.print("button clicked.\n");
        }
    }