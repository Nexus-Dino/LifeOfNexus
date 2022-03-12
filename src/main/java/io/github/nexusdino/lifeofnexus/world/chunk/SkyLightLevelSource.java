package io.github.nexusdino.lifeofnexus.world.chunk;

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
import net.minecraft.world.level.biome.Climate.Sampler;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep.Carving;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class SkyLightLevelSource extends ChunkGenerator {
	public static final Codec<Settings> SETTINGS_CODEC = RecordCodecBuilder.create(instance -> instance
			.group(Codec.INT.fieldOf("base").forGetter(Settings::baseHeight),
					Codec.FLOAT.fieldOf("vertical_variance").forGetter(Settings::verticalVariance),
					Codec.FLOAT.fieldOf("horizontal_variance").forGetter(Settings::horizontalVariance))
			.apply(instance, Settings::new));

	public static final Codec<SkyLightLevelSource> CODEC = RecordCodecBuilder.create(instance -> instance.group(
			RegistryOps.retrieveRegistry(Registry.STRUCTURE_SET_REGISTRY)
					.forGetter(SkyLightLevelSource::getStructureSetRegistry),
			RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY).forGetter(SkyLightLevelSource::getBiomeRegistry),
			SETTINGS_CODEC.fieldOf("settings").forGetter(SkyLightLevelSource::getSettings))
			.apply(instance, SkyLightLevelSource::new));

	private final Settings settings;

	public SkyLightLevelSource(Registry<StructureSet> p_207960_, Registry<Biome> p_207961_,
			Settings settings) {
		super(p_207960_, getSet(p_207960_), new SkyLightBiomeSource(p_207961_));
		this.settings = settings;
	}

	private static Optional<HolderSet<StructureSet>> getSet(Registry<StructureSet> structureSetRegistry) {
		HolderSet.Named<StructureSet> structureSet = structureSetRegistry
				.getOrCreateTag(TagKey.create(Registry.STRUCTURE_SET_REGISTRY, Core.SKYLIGHT_DIMENSION_SET));
		return Optional.of(structureSet);
	}

	public Settings getSettings() {
		return settings;
	}

	public Registry<Biome> getBiomeRegistry() {
		return ((SkyLightBiomeSource) biomeSource).getBiomeRegistry();
	}

	public Registry<StructureSet> getStructureSetRegistry() {
		return super.structureSets;
	}

	@Override
	protected Codec<? extends ChunkGenerator> codec() {
		return CODEC;
	}

	@Override
	public ChunkGenerator withSeed(long pSeed) {
		return this;
	}

	@Override
	public Sampler climateSampler() {
		return null;
	}

	@Override
	public void applyCarvers(WorldGenRegion pLevel, long pSeed, BiomeManager pBiomeManager,
			StructureFeatureManager pStructureFeatureManager, ChunkAccess pChunk, Carving pStep) {
	}

	@Override
	public void buildSurface(WorldGenRegion pLevel, StructureFeatureManager pStructureFeatureManager,
			ChunkAccess pChunk) {
		BlockState bedrock = Blocks.BEDROCK.defaultBlockState();
		
		BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
		
		int x, z;
		
		for (x = 0; x < 16; x++) {
			for (z = 0; z < 16; z++) {
				pChunk.setBlockState(mutable, bedrock, false);
			}
		}
	}

	@Override
	public void spawnOriginalMobs(WorldGenRegion pLevel) {
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
	public int getBaseHeight(int pX, int pZ, Types pType, LevelHeightAccessor pLevel) {
		return 0;
	}

	@Override
	public NoiseColumn getBaseColumn(int pX, int pZ, LevelHeightAccessor pLevel) {
		return null;
	}

	@Override
	public void addDebugScreenInfo(List<String> p_208054_, BlockPos p_208055_) {
	}

	protected record Settings(int baseHeight, float verticalVariance, float horizontalVariance) {
	}
}
