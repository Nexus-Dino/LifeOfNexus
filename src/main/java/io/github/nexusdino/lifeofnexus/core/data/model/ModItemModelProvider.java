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

		withExistingParent("scythonite_ingot", defaultParent);
		withExistingParent("raw_scythonite", defaultParent);

		buildBlockItem("scythonite_ore");
		buildBlockItem("deepslate_scythonite_ore");
		buildBlockItem("scythonite_block");
	}

	private ItemModelBuilder buildBlockItem(String name) {
		return withExistingParent(name, modLoc(BLOCK_FOLDER + "/" + name));
	}
}
