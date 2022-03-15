package io.github.nexusdino.lifeofnexus.data.tag;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator p_126511_, ExistingFileHelper p_126512_) {
		super(p_126511_, LifeOfNexus.MOD_ID, p_126512_);
	}

	@Override
	protected void addTags() {
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(BlockInit.OSMIUM_ORE.get())
			.add(BlockInit.DEEPSLATE_OSMIUM_ORE.get())
			.add(BlockInit.OSMIUM_BLOCK.get())
			.add(BlockInit.RAW_OSMIUM_BLOCK.get())
			.add(BlockInit.SCYTHONITE_ORE.get())
			.add(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get())
			.add(BlockInit.SCYTHONITE_BLOCK.get());
		
		tag(BlockTags.NEEDS_IRON_TOOL)
			.add(BlockInit.OSMIUM_ORE.get())
			.add(BlockInit.DEEPSLATE_OSMIUM_ORE.get())
			.add(BlockInit.OSMIUM_BLOCK.get())
			.add(BlockInit.RAW_OSMIUM_BLOCK.get())
			.add(BlockInit.SCYTHONITE_ORE.get())
			.add(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get())
			.add(BlockInit.SCYTHONITE_BLOCK.get());
	}
}
