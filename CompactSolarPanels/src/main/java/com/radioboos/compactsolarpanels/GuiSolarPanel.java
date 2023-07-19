package com.radioboos.compactsolarpanels;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiSolarPanel extends GuiContainer {
    public static final ResourceLocation guiTexture = new ResourceLocation("compactsolarpanels", "textures/gui/GUICompactSolarPanels.png");

    public static final int GUI_ID = 0;

    public GuiSolarPanel(Container container) {
        super(container);
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0f, 1.0f ,1.0f, 1.0f);

        this.mc.getTextureManager().bindTexture(guiTexture);
        int xStart = (width - this.xSize) / 2 - 9;
        int yStart = (height - this.ySize) / 2 - 2;
        drawTexturedModalRect(xStart, yStart, 0, 0, 194, 168);
    }
}