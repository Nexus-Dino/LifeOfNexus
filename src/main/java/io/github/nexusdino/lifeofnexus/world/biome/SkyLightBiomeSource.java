package io.github.nexusdino.lifeofnexus.world.biome;

import java.util.Collections;
import java.util.List;

import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate.Sampler;

public class SkyLightBiomeSource extends BiomeSource {

	public static final Codec<SkyLightBiomeSource> CODEC = RegistryOps.retrieveRegistry(Registry.BIOME_REGISTRY)
			.xmap(SkyLightBiomeSource::new, SkyLightBiomeSource::getBiomeRegistry).codec();

	private final Holder<Biome> biome;
	private final Registry<Biome> biomeRegistry;
	private static final List<ResourceKey<Biome>> SPAWN = Collections.singletonList(Biomes.PLAINS);

	public SkyLightBiomeSource(Registry<Biome> registry) {
		super(getStartBiomes(registry));
		this.biomeRegistry = registry;
		this.biome = registry.getHolderOrThrow(Biomes.PLAINS);
	}

	private static List<Holder<Biome>> getStartBiomes(Registry<Biome> registry) {
		return SPAWN.stream().map(
				biomeKey -> registry.getHolderOrThrow(ResourceKey.create(Registry.BIOME_REGISTRY, biomeKey.location())))
				.toList();
	}

	public Registry<Biome> getBiomeRegistry() {
		return biomeRegistry;
	}

	@Override
	protected Codec<? extends BiomeSource> codec() {
		return CODEC;
	}

	@Override
	public Holder<Biome> getNoiseBiome(int x, int y, int z, Sampler sampler) {
		return biome;
	}

	@Override
	public BiomeSource withSeed(long pSeed) {
		return this;
	}
}
