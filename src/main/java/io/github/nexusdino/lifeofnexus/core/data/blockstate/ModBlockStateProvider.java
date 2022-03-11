package io.github.nexusdino.lifeofnexus.core.data.blockstate;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
		super(gen, LifeOfNexus.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(BlockInit.SCYTHONITE_ORE.get());
		simpleBlock(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get());
		simpleBlock(BlockInit.SCYTHONITE_BLOCK.get());
		
		simpleBlock(BlockInit.OSMIUM_BLOCK.get());
		simpleBlock(BlockInit.OSMIUM_ORE.get());
		simpleBlock(BlockInit.DEEPSLATE_OSMIUM_ORE.get());
		simpleBlock(BlockInit.RAW_OSMIUM_BLOCK.get());
	}
}
