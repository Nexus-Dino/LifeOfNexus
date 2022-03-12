package io.github.nexusdino.lifeofnexus.world.chunk;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.synth.NormalNoise.NoiseParameters;

public class SkyLightLevelSource extends NoiseBasedChunkGenerator {

	public SkyLightLevelSource(Registry<StructureSet> p_209106_, Registry<NoiseParameters> p_209107_,
			BiomeSource p_209108_, long p_209109_, Holder<NoiseGeneratorSettings> p_209110_) {
		super(p_209106_, p_209107_, p_209108_, p_209109_, p_209110_);
	}
}
