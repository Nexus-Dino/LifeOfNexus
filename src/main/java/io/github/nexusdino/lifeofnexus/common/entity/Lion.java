package io.github.nexusdino.lifeofnexus.common.entity;

import io.github.nexusdino.lifeofnexus.core.init.EntityTypesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.easing.EasingType;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Lion extends Animal implements Enemy, IAnimatable {
	private static final EntityDataAccessor<Boolean> DATA_HUNGRY_ID = SynchedEntityData.defineId(Lion.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<BlockPos> DEN_POS = SynchedEntityData.defineId(Lion.class,
			EntityDataSerializers.BLOCK_POS);
	BlockPos denPos;

	private final AnimationFactory factory = new AnimationFactory(this);

	public Lion(EntityType<? extends Animal> p_27557_, Level p_27558_) {
		super(p_27557_, p_27558_);
	}

	@Override
	public boolean equals(Object p_20245_) {
		return p_20245_ instanceof Lion;
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_HUNGRY_ID, false);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundTag p_27587_) {
		p_27587_.put("DenPosition", NbtUtils.writeBlockPos(denPos));
	}
	
	@Override
	public void readAdditionalSaveData(CompoundTag p_27576_) {
		super.readAdditionalSaveData(p_27576_);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	private <E extends IAnimatable> PlayState huntPredicate(AnimationEvent<E> event) {
		if (event.getLimbSwingAmount() > 1.34f) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("hunting", false));
		}
		return PlayState.CONTINUE;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob parent) {
		return EntityTypesInit.LION.get().create(level);
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	@Override
	public void registerControllers(AnimationData data) {
		final AnimationController<Lion> huntAnimController = new AnimationController<>(this, "huting", 0.9f,
				EasingType.EaseInOutElastic, this::huntPredicate);

		data.addAnimationController(huntAnimController);
	}
}
