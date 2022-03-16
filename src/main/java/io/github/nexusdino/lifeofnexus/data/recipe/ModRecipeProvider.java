package io.github.nexusdino.lifeofnexus.data.recipe;

import java.util.function.Consumer;

import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator p_125973_) {
		super(p_125973_);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> p_176532_) {
		SimpleCookingRecipeBuilder
				.smelting(Ingredient.of(ItemInit.RAW_OSMIUM.get()), ItemInit.OSMIUM_INGOT.get(), 5f, 200)
				.unlockedBy("has_item", has(ItemInit.RAW_OSMIUM.get())).save(p_176532_);
		
		nineBlockStorageRecipesRecipesWithCustomUnpacking(p_176532_, ItemInit.OSMIUM_INGOT.get(),
				BlockInit.OSMIUM_BLOCK.get(), "osmium_ingot_from_block", "osmium_ingot");
	}
}
