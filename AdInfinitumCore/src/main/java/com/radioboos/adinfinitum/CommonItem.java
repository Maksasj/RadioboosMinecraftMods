package com.radioboos.adinfinitum;

import com.radioboos.adinfinitum.creative.tabs.CreativeTabRegister;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class CommonItem extends Item {
    private final String name;

    public CommonItem(String name) {
        this.name = name;

        setUnlocalizedName(name);
        setCreativeTab(CreativeTabRegister.COMPACT_SOLAR_PANELS_CREATIVE_TAB);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("adinfinitum:" + name);
    }
}
