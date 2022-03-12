package io.github.nexusdino.lifeofnexus.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OvenBlock extends HorizontalDirectionalBlock implements EntityBlock {

	protected OvenBlock(Properties p_54120_) {
		super(p_54120_);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return null;
	}
}
