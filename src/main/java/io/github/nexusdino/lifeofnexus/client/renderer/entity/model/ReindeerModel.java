package io.github.nexusdino.lifeofnexus.client.renderer.entity.model;

import io.github.nexusdino.lifeofnexus.common.entity.Reindeer;
import io.github.nexusdino.lifeofnexus.core.Core;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@OnlyIn(Dist.CLIENT)
public class ReindeerModel extends AnimatedGeoModel<Reindeer> {
	
	private static final ResourceLocation ANIMATION_LOC = Core.pointResource("animations/reindeer.animation.json");
	private static final ResourceLocation MODEL_LOC = Core.pointResource("geo/reindeer.geo.json");

	@Override
	public ResourceLocation getAnimationFileLocation(Reindeer animatable) {
		return ANIMATION_LOC;
	}

	@Override
	public ResourceLocation getModelLocation(Reindeer object) {
		return MODEL_LOC;
	}

	@Override
	public ResourceLocation getTextureLocation(Reindeer object) {
		return null;
	}
}
