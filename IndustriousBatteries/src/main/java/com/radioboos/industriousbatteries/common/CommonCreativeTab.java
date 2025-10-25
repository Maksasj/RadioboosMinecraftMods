package com.radioboos.industriousbatteries.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CommonCreativeTab extends CreativeTabs {
    public CommonCreativeTab(String label) {
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }
}
