package com.radioboos.beekeeperssolarpanels.recipes;

import com.radioboos.api.advsolar.ADVApi;
import com.radioboos.api.binnie.extrabees.ExtraBeesCombApi;
import com.radioboos.api.forestry.ForestryCombApi;
import com.radioboos.api.forestry.ForestryMiscApi;
import com.radioboos.beekeeperssolarpanels.blocks.BlockRegister;
import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import com.radioboos.beekeeperssolarpanels.items.ItemRegister;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.core.ForestryAPI;
import ic2.api.item.IC2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.lwjgl.Sys;

public class RecipeRegister extends CommonRegister {
    public static void register() {
        // ItemStack denseGoldenPlate = new ItemStack(IC2Items.getItem("itemDensePlates").getItem(), 1, 3);
        // ItemStack denseGoldenPlate = IC2Items.getItem("iridiumPlate");
        // denseGoldenPlate.setItemDamage(3);

        ItemStack iridiumPlate = IC2Items.getItem("iridiumPlate");
        ItemStack iridiumOre = IC2Items.getItem("iridiumOre");
        ItemStack denseGoldenPlate = IC2Items.getItem("denseplategold");
        ItemStack advancedAlloy = IC2Items.getItem("advancedAlloy");
        ItemStack glowstonePowder = new ItemStack(Items.glowstone_dust);

        if(ADVApi.QUANTUM_SOLAR_PANEL == null) {
            System.out.println("Super Saddd");
        }

        // Compressor
        Recipes.compressor.addRecipe(new RecipeInputItemStack(ForestryCombApi.MELLOW_COMB, 9), null, new ItemStack(ItemRegister.CRYSTALLIZED_RIPE_SHARD_ITEM, 1));

        GameRegistry.addRecipe(new ItemStack(ItemRegister.CRYSTALLIZED_RIPE_CORE_ITEM, 1), new Object[]{"#X#", "XOX", "#X#", '#', iridiumPlate, 'X', denseGoldenPlate, 'O', ItemRegister.CRYSTALLIZED_RIPE_SHARD_ITEM});
        // GameRegistry.addRecipe(new ItemStack(ItemRegister.IRRADIANT_IRIDIUM_ITEM, 1), new Object[]{"#X#", "XOX", "#X#", '#', denseGoldenPlate, 'X', glowstonePowder, 'O', iridiumOre});

        GameRegistry.addRecipe(new ItemStack(BlockRegister.RIPE_BEEKEEPERS_SOLAR_PANEL, 1), new Object[]{"#X#", "XOX", "EEE", '#', denseGoldenPlate, 'X', glowstonePowder, 'O', ADVApi.QUANTUM_SOLAR_PANEL, 'E', iridiumPlate});
    }
}
