//package io.github.nexusdino.lifeofnexus.common.block;
//
//import io.github.nexusdino.lifeofnexus.common.blockentity.OvenBlockEntity;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.context.BlockPlaceContext;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.EntityBlock;
//import net.minecraft.world.level.block.HorizontalDirectionalBlock;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.block.state.properties.BooleanProperty;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraftforge.network.NetworkHooks;
//
//public class OvenBlock extends HorizontalDirectionalBlock implements EntityBlock {
//	
//	public static final BooleanProperty LIT = BlockStateProperties.LIT;
//
//	public OvenBlock(Properties p_54120_) {
//		super(p_54120_);
//		registerDefaultState(defaultBlockState().setValue(LIT, false).setValue(FACING, Direction.NORTH));
//	}
//	
//	@Override
//	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
//		return null;
//	}
//	
//	@Override
//	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
//		super.createBlockStateDefinition(p_49915_);
//		p_49915_.add(FACING, LIT);
//	}
//	
//	@Override
//	public BlockState getStateForPlacement(BlockPlaceContext p_49820_) {
//		return defaultBlockState().setValue(FACING, p_49820_.getHorizontalDirection().getOpposite());
//	}
//	
//	@Override
//	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
//			InteractionHand hand, BlockHitResult result) {
//		if (level.isClientSide() && level.getBlockEntity(pos) instanceof OvenBlockEntity oven) {
//			NetworkHooks.openGui((ServerPlayer)player, oven, pos);
//			return InteractionResult.SUCCESS;
//		}
//		return InteractionResult.FAIL;
//	}
//}
