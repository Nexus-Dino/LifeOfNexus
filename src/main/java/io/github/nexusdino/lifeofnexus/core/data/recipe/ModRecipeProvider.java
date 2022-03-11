package io.github.nexusdino.lifeofnexus.core.data.recipe;

import java.util.function.Consumer;

import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public ModRecipeProvider(DataGenerator pGenerator) {
		super(pGenerator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemInit.RAW_SCYTHONITE.get()),
				ItemInit.SCYTHONITE_INGOT.get(), 0.9f, 300);
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(BlockInit.SCYTHONITE_ORE.get()),
				ItemInit.SCYTHONITE_INGOT.get(), 0.9f, 300);

		nineBlockStorageRecipesWithCustomPacking(pFinishedRecipeConsumer, ItemInit.SCYTHONITE_INGOT.get(),
				BlockInit.SCYTHONITE_BLOCK.get(), "scythonite_block_from_scythonite_ingot", "scythonite_ingot");

		nineBlockStorageRecipesRecipesWithCustomUnpacking(pFinishedRecipeConsumer, ItemInit.SCYTHONITE_INGOT.get(),
				BlockInit.SCYTHONITE_BLOCK.get(), "scythonite_ingot_from_scythonite_block", "scythonite_block");
		
		nineBlockStorageRecipesWithCustomPacking(pFinishedRecipeConsumer, ItemInit.OSMIUM_INGOT.get(),
				BlockInit.OSMIUM_BLOCK.get(), "osmium_block_from_osmium_ingot", "osmium_ingot");
		
		nineBlockStorageRecipesRecipesWithCustomUnpacking(pFinishedRecipeConsumer, ItemInit.RAW_OSMIUM.get(),
				BlockInit.RAW_OSMIUM_BLOCK.get(), "osmium_ingot_from_osmium_block", "osmium_block");
	}
}
