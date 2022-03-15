package io.github.nexusdino.lifeofnexus.data.recipe;

import java.util.function.Consumer;

import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public ModRecipeProvider(DataGenerator p_125973_) {
		super(p_125973_);
	}

	private static Ingredient makeIngredientOutOf(ItemLike... itemLikes) {
		return Ingredient.of(itemLikes);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> p_176532_) {
		/* Access Transformed */
		nineBlockStorageRecipes(p_176532_, ItemInit.RAW_OSMIUM.get(), BlockInit.RAW_OSMIUM_BLOCK.get());
		nineBlockStorageRecipes(p_176532_, ItemInit.OSMIUM_INGOT.get(), BlockInit.OSMIUM_BLOCK.get());

		ShapedRecipeBuilder.shaped(ItemInit.SCYTHONITE_PICKAXE.get()).define('M',
				makeIngredientOutOf(ItemInit.SCYTHONITE_INGOT.get())).define('S', makeIngredientOutOf(Items.STICK))
			.pattern("MMM")
			.pattern(" S ")
			.pattern(" S ").unlockedBy("has_item", has(ItemInit.SCYTHONITE_INGOT.get())).save(p_176532_);
	}
}
