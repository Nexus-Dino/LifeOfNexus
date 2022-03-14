package io.github.nexusdino.lifeofnexus.world.feature;

import java.util.List;

import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public final class OreFeatureInit {
	public static final RuleTest DRIPSTONE_BLOCK_REPLACABLES = new BlockMatchTest(Blocks.DRIPSTONE_BLOCK);
	
	public static final List<OreConfiguration.TargetBlockState> ORE_SCYTHONITE_TARGET_LIST = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
					BlockInit.SCYTHONITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DRIPSTONE_BLOCK_REPLACABLES,
					BlockInit.DEEPSLATE_SCYTHONITE_ORE.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> ORE_OSMIUM_TARGET_LIST = List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.OSMIUM_ORE.get().defaultBlockState()),
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
					BlockInit.DEEPSLATE_OSMIUM_ORE.get().defaultBlockState()));

	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SCYTHONITE_SMALL = FeatureUtils
			.register("ore_scythonite_small", Feature.ORE, new OreConfiguration(ORE_SCYTHONITE_TARGET_LIST, 4, 0.5F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SCYTHONITE_LARGE = FeatureUtils
			.register("ore_scythonite_large", Feature.ORE, new OreConfiguration(ORE_SCYTHONITE_TARGET_LIST, 12, 0.7F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SCYTHONITE_BURIED = FeatureUtils
			.register("ore_scythonite_buried", Feature.ORE, new OreConfiguration(ORE_SCYTHONITE_TARGET_LIST, 8, 1.0F));

	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_OSMIUM_SMALL = FeatureUtils
			.register("ore_osmium_small", Feature.ORE, new OreConfiguration(ORE_OSMIUM_TARGET_LIST, 4, 0.5F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_OSMIUM_LARGE = FeatureUtils
			.register("ore_osmium_large", Feature.ORE, new OreConfiguration(ORE_OSMIUM_TARGET_LIST, 12, 0.7F));
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_OSMIUM_BURIED = FeatureUtils
			.register("ore_osmium_buried", Feature.ORE, new OreConfiguration(ORE_OSMIUM_TARGET_LIST, 8, 1.0F));

	private OreFeatureInit() {
	}
}
