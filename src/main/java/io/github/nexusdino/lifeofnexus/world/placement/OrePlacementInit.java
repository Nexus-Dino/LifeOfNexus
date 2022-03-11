package io.github.nexusdino.lifeofnexus.world.placement;

import java.util.List;

import io.github.nexusdino.lifeofnexus.world.feature.OreFeatureInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public final class OrePlacementInit {
	public static final Holder<PlacedFeature> ORE_OSMIUM = PlacementUtils.register("ore_osmium",
			OreFeatureInit.ORE_OSMIUM_SMALL, commonOrePlacement(7,
					HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
	public static final Holder<PlacedFeature> ORE_OSMIUM_LARGE = PlacementUtils.register("ore_osmium_large",
			OreFeatureInit.ORE_OSMIUM_LARGE, rareOrePlacement(9,
					HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
	public static final Holder<PlacedFeature> ORE_OSMIUM_BURIED = PlacementUtils.register("ore_osmium_buried",
			OreFeatureInit.ORE_OSMIUM_BURIED, commonOrePlacement(4,
					HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

	private OrePlacementInit() {
	}

	private static List<PlacementModifier> orePlacement(PlacementModifier rarityModifier,
			PlacementModifier heightModifier) {
		return List.of(rarityModifier, InSquarePlacement.spread(), heightModifier, BiomeFilter.biome());
	}

	private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier heightModifier) {
		return orePlacement(CountPlacement.of(count), heightModifier);
	}

	private static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier heightModifier) {
		return orePlacement(RarityFilter.onAverageOnceEvery(rarity), heightModifier);
	}
}
