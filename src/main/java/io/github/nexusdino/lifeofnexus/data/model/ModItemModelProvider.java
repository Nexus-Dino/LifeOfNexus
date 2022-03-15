package io.github.nexusdino.lifeofnexus.data.model;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, LifeOfNexus.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		var itemGenerated = "item/generated";

		buildItem(ItemInit.SCYTHONITE_INGOT, itemGenerated);
		buildItem(ItemInit.RAW_SCYTHONITE, itemGenerated);
		buildItem(ItemInit.OSMIUM_INGOT, itemGenerated);
		buildItem(ItemInit.RAW_OSMIUM, itemGenerated);
		
		buildBlockItem(BlockInit.SCYTHONITE_ORE);
		buildBlockItem(BlockInit.DEEPSLATE_SCYTHONITE_ORE);
		buildBlockItem(BlockInit.SCYTHONITE_BLOCK);
		buildBlockItem(BlockInit.OSMIUM_ORE);
		buildBlockItem(BlockInit.DEEPSLATE_OSMIUM_ORE);
		buildBlockItem(BlockInit.OSMIUM_BLOCK);
		buildBlockItem(BlockInit.RAW_OSMIUM_BLOCK);
	}

	private ItemModelBuilder buildItem(RegistryObject<? extends Item> item, String parent) {
		var id = item.get().getRegistryName().getPath();
		return getBuilder(id).parent(getExistingFile(mcLoc(parent)))
				.texture("layer0", "item/" + id);
	}

	private ItemModelBuilder buildBlockItem(RegistryObject<? extends Block> block) {
		var id = block.get().getRegistryName().getPath();
		return getBuilder(id).parent(getExistingFile(modLoc("block/" + id)));
	}
}
