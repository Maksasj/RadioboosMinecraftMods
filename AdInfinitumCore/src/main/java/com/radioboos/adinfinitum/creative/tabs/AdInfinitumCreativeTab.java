package com.radioboos.adinfinitum.creative.tabs;

import com.radioboos.adinfinitum.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class AdInfinitumCreativeTab extends CreativeTabs {
    public AdInfinitumCreativeTab() {
        super("AdInfinitum");
    }

    @Override
    public Item getTabIconItem() {
        return ExampleMod.silicon_chip_0;
    }
}
