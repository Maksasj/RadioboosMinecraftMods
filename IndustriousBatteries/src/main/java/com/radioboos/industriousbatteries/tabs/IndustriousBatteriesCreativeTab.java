package com.radioboos.industriousbatteries.tabs;

import com.radioboos.industriousbatteries.blocks.BlockRegister;
import com.radioboos.industriousbatteries.common.CommonCreativeTab;
import net.minecraft.item.Item;

public class IndustriousBatteriesCreativeTab extends CommonCreativeTab {
    public IndustriousBatteriesCreativeTab() {
        super("industriousBatteriesCreativeTab");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(BlockRegister.ADVANCED_BATTERY_STORAGE_BLOCK);
    }
}
