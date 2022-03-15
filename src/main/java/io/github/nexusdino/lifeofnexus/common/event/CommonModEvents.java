package io.github.nexusdino.lifeofnexus.common.event;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.data.blockstate.ModBlockStateProvider;
import io.github.nexusdino.lifeofnexus.data.lang.ModLangProvider;
import io.github.nexusdino.lifeofnexus.data.model.ModItemModelProvider;
import io.github.nexusdino.lifeofnexus.data.recipe.ModRecipeProvider;
import io.github.nexusdino.lifeofnexus.data.tag.ModBlockTagsProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = LifeOfNexus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

	@SubscribeEvent
	public static void registerDataGenerators(GatherDataEvent event) {
		var generator = event.getGenerator();
		var exFileHelper = event.getExistingFileHelper();

		generator.addProvider(new ModRecipeProvider(generator));
		generator.addProvider(new ModBlockTagsProvider(generator, exFileHelper));
		generator.addProvider(new ModLangProvider(generator));
		generator.addProvider(new ModBlockStateProvider(generator, exFileHelper));
		generator.addProvider(new ModItemModelProvider(generator, exFileHelper));
	}
}
