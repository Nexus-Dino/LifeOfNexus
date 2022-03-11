package io.github.nexusdino.lifeofnexus.world.gen;

import java.util.List;

import io.github.nexusdino.lifeofnexus.world.placement.OrePlacementInit;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGeneration {
	public static void addOres(BiomeLoadingEvent event) {
		List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES);
		
		base.add(OrePlacementInit.ORE_OSMIUM);
		base.add(OrePlacementInit.ORE_OSMIUM_BURIED);
		base.add(OrePlacementInit.ORE_OSMIUM_LARGE);
	}
}
