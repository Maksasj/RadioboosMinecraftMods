package com.example.examplemod;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CommonItem extends Item {
    private final String name;

    public CommonItem(String name) {
        this.name = name;

        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("examplemod:" + name);
    }
}
