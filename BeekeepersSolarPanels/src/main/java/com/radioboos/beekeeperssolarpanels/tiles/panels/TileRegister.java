package com.radioboos.beekeeperssolarpanels.tiles.panels;

import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;

public class TileRegister extends CommonRegister {
    public static final TileEntity RIPE_BEEKEEPERS_SOLAR_PANEL = new RipeBeekeepersSolarPanelTileEntity();
    public static final TileEntity DIAMOND_BEEKEEPERS_SOLAR_PANEL = new DiamondBeekeepersSolarPanelTileEntity();
    public static final TileEntity PLATINUM_BEEKEEPERS_SOLAR_PANEL = new PlatinumBeekeepersSolarPanelTileEntity();
    public static final TileEntity SHADOW_BEEKEEPERS_SOLAR_PANEL = new ShadowBeekeepersSolarPanelTileEntity();
    public static final TileEntity SHIMMERING_BEEKEEPERS_SOLAR_PANEL = new ShimmeringBeekeepersSolarPanelTileEntity();
    public static final TileEntity SULFURIC_BEEKEEPERS_SOLAR_PANEL = new SulfuricBeekeepersSolarPanelTileEntity();
    public static final TileEntity URANIC_BEEKEEPERS_SOLAR_PANEL = new UranicBeekeepersSolarPanelTileEntity();
    public static final TileEntity SINGULAR_BEEKEEPERS_SOLAR_PANEL = new SingularBeekeepersSolarPanelTileEntity();

    public static void register() {
        GameRegistry.registerTileEntity(RipeBeekeepersSolarPanelTileEntity.class, "RipeBeekeepersSolarPanel");
        GameRegistry.registerTileEntity(DiamondBeekeepersSolarPanelTileEntity.class, "DiamondBeekeepersSolarPanel");
        GameRegistry.registerTileEntity(PlatinumBeekeepersSolarPanelTileEntity.class, "PlatinumBeekeepersSolarPanel");
        GameRegistry.registerTileEntity(ShadowBeekeepersSolarPanelTileEntity.class, "ShadowBeekeepersSolarPanel");
        GameRegistry.registerTileEntity(ShimmeringBeekeepersSolarPanelTileEntity.class, "ShimmeringBeekeepersSolarPanel");
        GameRegistry.registerTileEntity(SulfuricBeekeepersSolarPanelTileEntity.class, "SulfuricBeekeepersSolarPanel");
        GameRegistry.registerTileEntity(UranicBeekeepersSolarPanelTileEntity.class, "UranicBeekeepersSolarPanel");
        GameRegistry.registerTileEntity(SingularBeekeepersSolarPanelTileEntity.class, "SingularBeekeepersSolarPanel");
    }
}
