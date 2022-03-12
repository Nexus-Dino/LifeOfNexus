package io.github.nexusdino.lifeofnexus.client.renderer.entity;

import io.github.nexusdino.lifeofnexus.common.entity.Reindeer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@OnlyIn(Dist.CLIENT)
public class ReindeerRenderer extends GeoEntityRenderer<Reindeer> {

	public ReindeerRenderer(EntityRendererProvider.Context renderManager, AnimatedGeoModel<Reindeer> modelProvider) {
		super(renderManager, modelProvider);
	}
}
