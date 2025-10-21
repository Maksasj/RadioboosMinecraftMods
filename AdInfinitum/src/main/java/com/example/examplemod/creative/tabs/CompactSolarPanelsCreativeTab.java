package com.example.examplemod.creative.tabs;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CompactSolarPanelsCreativeTab extends CreativeTabs {
    public CompactSolarPanelsCreativeTab() {
        super("compactSolarPanelsCreativeTab");
    }

    @Override
    public Item getTabIconItem() {
        return ExampleMod.silicon_chip_0;
    }
}
