package com.radioboos.compactsolarpanels.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CommonPanelItemBlock extends ItemBlock {
    public CommonPanelItemBlock(net.minecraft.block.Block block) {
        super(block);

        setUnlocalizedName("panelItemBlock");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add("Day generation: 1000 EU/t");
        lines.add("Night generation: 100 EU/t");
        lines.add("Max Drain: 10000 EU/t");
        lines.add("Capacity: 256000 EU");
    }
}
