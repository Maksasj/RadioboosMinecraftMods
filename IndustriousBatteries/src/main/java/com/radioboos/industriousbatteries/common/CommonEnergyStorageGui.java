package com.radioboos.industriousbatteries.common;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CommonEnergyStorageGui extends GuiContainer {
    public static final ResourceLocation guiTexture = new ResourceLocation("industriousbatteries", "textures/gui/GuiFirstIndustriousBatteries.png");
    private CommonEnergyStorageTileEntity entity;
    public static final int GUI_ID = 0;

    public CommonEnergyStorageGui(CommonEnergyStorageTileEntity entity, Container container) {
        super(container);

        this.entity = entity;
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

        int xCenter = (width - this.xSize) / 2;
        int yCenter = (height - this.ySize) / 2;

        drawTexturedModalRect(xCenter - 9, yCenter - 15, 0, 0, 194, 178);

        if(entity == null)
            return;

        double energyStored = entity.getStored();
        double energyCapacity = entity.getCapacity();

        mc.fontRenderer.drawString(String.format("Storage: %d/%d", (int) energyStored, (int) energyCapacity), xCenter + 41, yCenter + 20, 0x373737);
        mc.fontRenderer.drawString(String.format("Max Output: %d EU/t", (int) energyCapacity), xCenter + 41, yCenter + 30, 0x373737);

        /*
        double maxDrain = entity.getEnergyMaxDrain();
        double energyGeneration = entity.getEnergyProduction();

        double energyBufferFill = energyStored / energyCapacity;

        drawTexturedModalRect(xCenter + 10, yCenter + 22, 195, 0, (int) (24 * energyBufferFill), 14);

        if(entity.isSkyIsVisible()) {
            if(entity.isSunIsVisible()) {
                drawTexturedModalRect(xCenter + 15, yCenter + 39, 195, 15, 14, 14);
            } else {
                drawTexturedModalRect(xCenter + 15, yCenter + 39, 210, 15, 14, 14);
            }
        }

        String inventoryName = entity.getInventoryName();

        int inventoryNameTextPadding = (180 - mc.fontRenderer.getStringWidth(inventoryName)) / 2;

        mc.fontRenderer.drawStringWithShadow(inventoryName, xCenter + inventoryNameTextPadding, yCenter + 5, 0x807903);

        mc.fontRenderer.drawString(String.format("Storage: %d/%d", (int) energyStored, (int) energyCapacity), xCenter + 41, yCenter + 20, 0x373737);
        mc.fontRenderer.drawString(String.format("Max Output: %d EU/t", (int) maxDrain), xCenter + 41, yCenter + 30, 0x373737);
        mc.fontRenderer.drawString(String.format("Generating: %d EU/t", (int) energyGeneration), xCenter + 41, yCenter + 40, 0x373737);
        */
    }
}
