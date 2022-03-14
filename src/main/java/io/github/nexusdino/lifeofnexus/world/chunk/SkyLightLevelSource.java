package io.github.nexusdino.lifeofnexus.world.chunk;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.github.nexusdino.lifeofnexus.core.Core;
import io.github.nexusdino.lifeofnexus.world.biome.SkyLightBiomeSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class SkyLightLevelSource extends ChunkGenerator {

	public static final Codec<Settings> SETTINGS_CODEC = RecordCodecBuilder.create(instance -> instance
			.group(Codec.INT.fieldOf("baseHeight").forGetter(Settings::baseHeight),
					Codec.FLOAT.fieldOf("horizontalVariance").forGetter(Settings::horizontalVariance),
					Codec.FLOAT.fieldOf("verticalVariance").forGetter(Settings::verticalVariance))
			.apply(instance, Settings::new));

	public static final Codec<SkyLightLevelSource> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			RegistryOps.retrieveRegistry(Registry.STRUCTURE_SET_REGISTRY)
					.forGetter(SkyLightLevelSource::getStructureSetRegistry),
			RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter(SkyLightLevelSource::getBiomeRegistry),
			SETTINGS_CODEC.fieldOf("settings").forGetter(SkyLightLevelSource::getSettings))
			.apply(instance, SkyLightLevelSource::new));

	private final Settings settings;

	public SkyLightLevelSource(Registry<StructureSet> structureSetRegistry, Registry<Biome> biomeRegistry,
			Settings settings) {
		super(structureSetRegistry, getSet(structureSetRegistry), new SkyLightBiomeSource(biomeRegistry));
		this.settings = settings;
	}

	public Registry<Biome> getBiomeRegistry() {
		return ((SkyLightBiomeSource) biomeSource).getBiomeRegistry();
	}

	public Registry<StructureSet> getStructureSetRegistry() {
		return structureSets;
	}

	public Settings getSettings() {
		return settings;
	}

	private static Optional<HolderSet<StructureSet>> getSet(Registry<StructureSet> structureSetRegistry) {
		return Optional.of(structureSetRegistry
				.getOrCreateTag(TagKey.create(Registry.STRUCTURE_SET_REGISTRY, Core.SKYLIGHT_DIMENSION_SET)));
	}

	@Override
	protected Codec<? extends ChunkGenerator> codec() {
		return CODEC;
	}

	@Override
	public ChunkGenerator withSeed(long p_62156_) {
		return new SkyLightLevelSource(getStructureSetRegistry(), getBiomeRegistry(), getSettings());
	}

	@Override
	public Climate.Sampler climateSampler() {
		return new Climate.Sampler(DensityFunctions.constant(1.69), null, null, null, null, null, Collections.emptyList());
	}

	@Override
	public void applyCarvers(WorldGenRegion p_187691_, long p_187692_, BiomeManager p_187693_,
			StructureFeatureManager p_187694_, ChunkAccess p_187695_, GenerationStep.Carving p_187696_) {
	}

	@Override
	public void buildSurface(WorldGenRegion p_187697_, StructureFeatureManager p_187698_, ChunkAccess p_187699_) {
	}

	@Override
	public void spawnOriginalMobs(WorldGenRegion p_62167_) {
	}

	@Override
	public int getGenDepth() {
		return 0;
	}

	@Override
	public CompletableFuture<ChunkAccess> fillFromNoise(Executor p_187748_, Blender p_187749_,
			StructureFeatureManager p_187750_, ChunkAccess p_187751_) {
		return null;
	}

	@Override
	public int getSeaLevel() {
		return 0;
	}

	@Override
	public int getMinY() {
		return 0;
	}

	@Override
	public int getBaseHeight(int p_156153_, int p_156154_, Types p_156155_, LevelHeightAccessor p_156156_) {
		return 0;
	}

	@Override
	public NoiseColumn getBaseColumn(int p_156150_, int p_156151_, LevelHeightAccessor p_156152_) {
		return new NoiseColumn(getMinY(), new BlockState[0]);
	}

	@Override
	public void addDebugScreenInfo(List<String> p_208054_, BlockPos p_208055_) {
	}

	private record Settings(int baseHeight, float horizontalVariance, float verticalVariance) {
	}
}
