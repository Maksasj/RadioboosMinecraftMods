package com.radioboos.compactsolarpanels.creative.tabs;

import com.radioboos.compactsolarpanels.CommonPanelBlock;
import com.radioboos.compactsolarpanels.CommonPanelItemBlock;
import com.radioboos.compactsolarpanels.blocks.BlockRegister;
import com.radioboos.compactsolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.lwjgl.Sys;

public class CreativeTabRegister extends CommonRegister {
    public static CreativeTabs COMPACT_SOLAR_PANELS_CREATIVE_TAB;

    public static void register() {
        COMPACT_SOLAR_PANELS_CREATIVE_TAB = new CompactSolarPanelsCreativeTab();
    }
}
