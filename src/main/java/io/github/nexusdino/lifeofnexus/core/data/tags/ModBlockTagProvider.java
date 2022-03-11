package io.github.nexusdino.lifeofnexus.core.data.tags;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider {

	public ModBlockTagProvider(DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
		super(pGenerator, LifeOfNexus.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		tag(BlockTags.NEEDS_IRON_TOOL).add(BlockInit.OSMIUM_ORE.get()).add(BlockInit.DEEPSLATE_OSMIUM_ORE.get())
				.add(BlockInit.SCYTHONITE_ORE.get()).add(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get())
				.add(BlockInit.SCYTHONITE_BLOCK.get()).add(BlockInit.OSMIUM_BLOCK.get());
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BlockInit.OSMIUM_ORE.get()).add(BlockInit.DEEPSLATE_OSMIUM_ORE.get())
				.add(BlockInit.SCYTHONITE_ORE.get()).add(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get())
				.add(BlockInit.SCYTHONITE_BLOCK.get()).add(BlockInit.OSMIUM_BLOCK.get());
	}
}
