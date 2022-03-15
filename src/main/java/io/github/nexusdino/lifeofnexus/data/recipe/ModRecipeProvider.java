package io.github.nexusdino.lifeofnexus.data.recipe;

import java.util.function.Consumer;

import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public ModRecipeProvider(DataGenerator p_125973_) {
		super(p_125973_);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> p_176532_) {
		/* Access Transformed */
		nineBlockStorageRecipesWithCustomPacking(p_176532_, ItemInit.OSMIUM_INGOT.get(),
				BlockInit.OSMIUM_BLOCK.get(), getName(), getName());
	}
}
