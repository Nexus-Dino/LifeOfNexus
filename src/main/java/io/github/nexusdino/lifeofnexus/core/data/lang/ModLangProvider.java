package io.github.nexusdino.lifeofnexus.core.data.lang;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {

	public ModLangProvider(DataGenerator gen) {
		super(gen, LifeOfNexus.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add(ItemInit.SCYTHONITE_INGOT.get(), "Scythonite Ingot");
		add(ItemInit.RAW_SCYTHONITE.get(), "Raw Scythonite");
		
		add(BlockInit.SCYTHONITE_ORE.get(), "Scythonite Ore");
		add(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get(), "Deepslate Scythonite Ore");
		add(BlockInit.SCYTHONITE_BLOCK.get(), "Scythonite Block");
		
		add(BlockInit.OSMIUM_ORE.get(), "Osmium Ore");
		add(BlockInit.DEEPSLATE_OSMIUM_ORE.get(), "Deepslate Osmium Ore");
		add(BlockInit.OSMIUM_BLOCK.get(), "Osmium Block");
		add(BlockInit.RAW_OSMIUM_BLOCK.get(), "Raw Osmium Block");
	}
}
