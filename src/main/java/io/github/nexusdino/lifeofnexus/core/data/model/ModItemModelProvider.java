package io.github.nexusdino.lifeofnexus.core.data.model;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, LifeOfNexus.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		var defaultParent = "item/generated";

		buildItem("scythonite_ingot", defaultParent);
		buildItem("raw_scythonite", defaultParent);
		buildItem("osmium_ingot", defaultParent);
		buildItem("raw_osmium", defaultParent);

		buildBlockItem("scythonite_ore");
		buildBlockItem("deepslate_scythonite_ore");
		buildBlockItem("scythonite_block");
		
		buildBlockItem("osmium_ore");
		buildBlockItem("deepslate_osmium_ore");
		buildBlockItem("osmium_block");
		buildBlockItem("raw_osmium_block");
	}

	private ItemModelBuilder buildBlockItem(String name) {
		return withExistingParent(name, modLoc(BLOCK_FOLDER + "/" + name));
	}
	
	private ItemModelBuilder buildItem(String name, String parent) {
		return getBuilder(name).parent(getExistingFile(mcLoc(parent))).texture("layer0", modLoc("item/" + name));
	}
}
