package io.github.nexusdino.lifeofnexus.core.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class TierInit {
	public static final ForgeTier SCYTHONITE = new ForgeTier(3, 9000, 9f, 8f, 20, BlockTags.NEEDS_IRON_TOOL,
			() -> Ingredient.of(ItemInit.SCYTHONITE_INGOT.get()));
	public static final ForgeTier OSMIUM = new ForgeTier(4, 15000, 15f, 16f, 69, BlockTags.NEEDS_DIAMOND_TOOL,
			() -> Ingredient.of(ItemInit.OSMIUM_INGOT.get()));
}
