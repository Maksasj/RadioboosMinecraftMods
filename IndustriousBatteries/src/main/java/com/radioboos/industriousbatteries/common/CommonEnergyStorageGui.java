package com.radioboos.industriousbatteries.common;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CommonEnergyStorageGui extends GuiContainer {
    public static final ResourceLocation guiTexture = new ResourceLocation("industriousbatteries", "textures/gui/GuiFirstIndustriousBatteries.png");

    private final CommonEnergyStorageTileEntity entity;
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
        int energyTransferLimit = entity.getOutput();

        double energyBufferFill = energyStored / energyCapacity;

        if(energyCapacity > 0) {
            drawTexturedModalRect(xCenter + 85, yCenter + 59, 195, 0, (int) (60 * energyBufferFill), 14);
        }

        String energyStoredStr = Utils.euEnergyToString(energyStored);
        String energyCapacityStr = Utils.euEnergyToString(energyCapacity);
        String energyTransferLimitStr = Utils.euEnergyToString(energyTransferLimit);

        mc.fontRenderer.drawString("Storage:", xCenter + 71, yCenter + 5, 0x373737);
        mc.fontRenderer.drawString(String.format("%s/%s EU", energyStoredStr, energyCapacityStr), xCenter + 71, yCenter + 15, 0x373737);
        mc.fontRenderer.drawString("Limit:", xCenter + 71, yCenter + 25, 0x373737);
        mc.fontRenderer.drawString(String.format("%s EU/t", energyTransferLimitStr), xCenter + 71, yCenter + 35, 0x373737);
    }
}
