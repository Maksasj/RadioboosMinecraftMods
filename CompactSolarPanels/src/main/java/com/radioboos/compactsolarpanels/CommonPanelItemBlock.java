package com.radioboos.compactsolarpanels;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CommonPanelItemBlock extends ItemBlock {
    public CommonPanelItemBlock(net.minecraft.block.Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add("Day Power Output: 1000 EU/t");
        lines.add("Night Power Output: 100 EU/t");
        lines.add("Max Drain: 10000 EU/t");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return "panelItemBlock";
    }
}