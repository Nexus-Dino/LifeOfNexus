package io.github.nexusdino.lifeofnexus.core.data;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.core.data.blockstate.ModBlockStateProvider;
import io.github.nexusdino.lifeofnexus.core.data.lang.ModLangProvider;
import io.github.nexusdino.lifeofnexus.core.data.model.ModItemModelProvider;
import io.github.nexusdino.lifeofnexus.core.data.recipe.ModRecipeProvider;
import io.github.nexusdino.lifeofnexus.core.data.tags.ModBlockTagProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = LifeOfNexus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModDataGenerators {
	private ModDataGenerators() {
	}

	@SubscribeEvent
	public static void addDataGenerators(GatherDataEvent event) {
		var generator = event.getGenerator();
		var exFileHelper = event.getExistingFileHelper();

		generator.addProvider(new ModBlockTagProvider(generator, exFileHelper));

		if (event.includeClient()) {
			generator.addProvider(new ModLangProvider(generator));
			generator.addProvider(new ModBlockStateProvider(generator, exFileHelper));
			generator.addProvider(new ModItemModelProvider(generator, exFileHelper));
		} else if (event.includeServer()) {
			generator.addProvider(new ModRecipeProvider(generator));
		}
	}
}
