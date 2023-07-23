package com.radioboos.beekeeperssolarpanels.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CommonSolarPanelItemBlock extends ItemBlock {
    private final CommonSolarPanelConfig config;

    public CommonSolarPanelItemBlock(net.minecraft.block.Block block, CommonSolarPanelConfig config) {
        super(block);

        this.config = config;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add("Day generation: " + config.getDayProduction() + " EU/t");
        lines.add("Night generation: " + config.getNightProduction() + " EU/t");
        lines.add("Max Drain: " + config.getMaxDrain() + " EU/t");
        lines.add("Capacity: " + config.getCapacity() + " EU");
    }
}
