package com.radioboos.beekeeperssolarpanels;

import com.radioboos.api.binnie.extrabees.ExtraBeesApi;
import com.radioboos.api.binnie.extrabees.ExtraBeesCombApi;
import com.radioboos.api.ic2.IC2Api;
import com.radioboos.beekeeperssolarpanels.common.CommonProxy;
import com.radioboos.beekeeperssolarpanels.configs.Configs;
import com.radioboos.beekeeperssolarpanels.gui.GuiHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.item.IC2Items;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(   modid = BeekeepersSolarPanels.MODID,
        name = "Beekeepers Solar Panels",
        version = BeekeepersSolarPanels.VERSION,
        dependencies = "required-after:IC2@[2.0,);required-after:Forestry@[4.2,);required-after:ExtraBees@[2.0,);required-after:AdvancedSolarPanel@[1.7.10-3.5,);required-after:Forge@[9.10,)")
public class BeekeepersSolarPanels {
    public static final String MODID = "beekeeperssolarpanels";
    public static final String VERSION = "1.0";

    @SidedProxy(
        clientSide = "com.radioboos.beekeeperssolarpanels.proxy.ClientProxy",
        serverSide = "com.radioboos.beekeeperssolarpanels.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance("beekeeperssolarpanels")
    public static BeekeepersSolarPanels instance;

    public BeekeepersSolarPanels() {
        instance = this;
    }

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        Configs.loadConfig(event);
        proxy.preInit(event);

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void load(FMLLoadEvent event) {
        proxy.load(event);
    }
}
