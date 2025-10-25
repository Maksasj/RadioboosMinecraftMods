package com.radioboos.industriousbatteries.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CommonItemBlock extends ItemBlock {
    public CommonItemBlock(Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        // lines.add("Day generation: " + config.getDayProduction() + " EU/t");
        // lines.add("Night generation: " + config.getNightProduction() + " EU/t");
        // lines.add("Max Drain: " + config.getMaxDrain() + " EU/t");
        // lines.add("Capacity: " + config.getCapacity() + " EU");
    }
}
