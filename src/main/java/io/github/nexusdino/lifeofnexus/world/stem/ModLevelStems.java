package io.github.nexusdino.lifeofnexus.world.stem;

import io.github.nexusdino.lifeofnexus.core.Core;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;

public class ModLevelStems {
	public static final ResourceKey<LevelStem> SKY_LIGHT = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY,
			Core.pointResource("sky_light"));
}
