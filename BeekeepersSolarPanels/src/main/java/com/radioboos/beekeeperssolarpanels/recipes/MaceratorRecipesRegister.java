package com.radioboos.beekeeperssolarpanels.recipes;

import com.radioboos.api.binnie.extrabees.ExtraBeesCombApi;
import com.radioboos.api.forestry.ForestryCombApi;
import com.radioboos.beekeeperssolarpanels.common.CommonRegister;
import com.radioboos.beekeeperssolarpanels.items.ItemRegister;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.item.ItemStack;

public class MaceratorRecipesRegister extends CommonRegister {
    public static void register() {
        Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(ItemRegister.CRYSTALLIZED_SULFURIC_SHARD_ITEM), 1), null, new ItemStack(ItemRegister.CRUSHED_SULFURIC_SHARD, 1));
    }
}
