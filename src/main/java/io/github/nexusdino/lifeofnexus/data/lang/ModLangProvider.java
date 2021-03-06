package io.github.nexusdino.lifeofnexus.data.lang;

import static io.github.nexusdino.lifeofnexus.LifeOfNexus.MOD_ID;

import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {

	public ModLangProvider(DataGenerator gen) {
		super(gen, MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add(ItemInit.SCYTHONITE_INGOT.get(), "Scythonite Ingot");
		add(ItemInit.RAW_SCYTHONITE.get(), "Raw Scythonite");
		add(ItemInit.SCYTHONITE_HELMET.get(), "Scythonite Helmet");
		add(ItemInit.SCYTHONITE_CHESTPLATE.get(), "Scythonite Chestplate");
		add(ItemInit.SCYTHONITE_LEGGINGS.get(), "Scythonite Leggings");
		add(ItemInit.SCYTHONITE_BOOTS.get(), "Scythonite Boots");
		
		add(BlockInit.SCYTHONITE_ORE.get(), "Scythonite Ore");
		add(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get(), "Deepslate Scythonite Ore");
		add(BlockInit.SCYTHONITE_BLOCK.get(), "Scythonite Block");
		
		add(ItemInit.OSMIUM_INGOT.get(), "Osmium Ingot");
		add(ItemInit.RAW_OSMIUM.get(), "Raw Osmium");
		
		add(BlockInit.OSMIUM_ORE.get(), "Osmium Ore");
		add(BlockInit.OSMIUM_BLOCK.get(), "Osmium Block");
		add(BlockInit.RAW_OSMIUM_BLOCK.get(), "Raw Osmium Block");
		add(BlockInit.DEEPSLATE_OSMIUM_ORE.get(), "Deepslate Osmium Ore");
		
		var creativeTabPrefix = "item_group.";
		add(creativeTabPrefix + MOD_ID + ".materials", "LON Materials!");
		add(creativeTabPrefix + MOD_ID + ".blocks", "LON Blocks!");
		add(creativeTabPrefix + MOD_ID + ".combat", "LON Combat!");
		add(creativeTabPrefix + MOD_ID + ".tools", "LON Tools!");
		add(creativeTabPrefix + MOD_ID + ".armor", "LON Armor!");
	}
}
