package io.github.nexusdino.lifeofnexus.core;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import net.minecraft.resources.ResourceLocation;

public final class Core {
	public static final ResourceLocation SKYLIGHT_DIMENSION_SET = new ResourceLocation(LifeOfNexus.MOD_ID,
			"skylight_dimension_set");
	
	public static ResourceLocation pointResource(String idOrLoc) {
		return new ResourceLocation(LifeOfNexus.MOD_ID, idOrLoc);
	}
}
