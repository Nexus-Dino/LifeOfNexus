package io.github.nexusdino.lifeofnexus.world.gen;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LifeOfNexus.MOD_ID)
public final class LevelEvents {

	private LevelEvents() {
	}

	@SubscribeEvent
	public static void loadLevelGeneration(BiomeLoadingEvent event) {
		ModOreGeneration.addOres(event);
	}
}
