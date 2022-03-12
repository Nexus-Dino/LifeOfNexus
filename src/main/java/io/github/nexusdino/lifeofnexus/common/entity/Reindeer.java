package io.github.nexusdino.lifeofnexus.common.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ItemBasedSteering;
import net.minecraft.world.entity.ItemSteerable;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Reindeer extends Animal implements ItemSteerable, Saddleable, IAnimatable {
	private static final EntityDataAccessor<Integer> DATA_BOOST_TIME = SynchedEntityData.defineId(Reindeer.class,
			EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_SADDLE_ID = SynchedEntityData.defineId(Reindeer.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DATA_SUFFOCATING = SynchedEntityData.defineId(Reindeer.class,
			EntityDataSerializers.BOOLEAN);
	private final ItemBasedSteering steering = new ItemBasedSteering(getEntityData(), DATA_BOOST_TIME, DATA_SADDLE_ID);
	private final AnimationFactory factory = new AnimationFactory(this);

	private final AnimationController<Reindeer> walkingController = new AnimationController<>(this,
			"walking_controller", 0.1f, event -> PlayState.CONTINUE);

	public Reindeer(EntityType<? extends Animal> p_27557_, Level p_27558_) {
		super(p_27557_, p_27558_);
	}

	// Not adding this might running into risk of non-equivalent instances of your
	// subclass being seen as equal
	@Override
	public boolean equals(Object pObject) {
		return pObject == this;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 53.0D).add(Attributes.JUMP_STRENGTH)
				.add(Attributes.MOVEMENT_SPEED, 0.1D);
	}

	@Override
	public boolean boost() {
		return this.steering.boost(getRandom());
	}

	@Override
	public void equipSaddle(SoundSource category) {
		this.steering.setSaddle(true);
		if (category != null)
			this.level.playSound((Player) null, this, SoundEvents.STRIDER_SADDLE, category, 0.5F, 1.0F);

	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(walkingController);
	}

	@Override
	public Reindeer getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}

	@Override
	public float getSteeringSpeed() {
		return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) * (this.isSuffocating() ? 0.23F : 0.55F);
	}

	@Override
	public boolean isSaddleable() {
		return isAlive() && !isBaby();
	}

	@Override
	public boolean isSaddled() {
		return this.steering.hasSaddle();
	}

	@Override
	public void travelWithInput(Vec3 pTravelVec) {
		super.travel(pTravelVec);
	}

	public boolean isSuffocating() {
		return this.getVehicle() instanceof Reindeer reindeer ? reindeer.isSuffocating()
				: this.entityData.get(DATA_SUFFOCATING);
	}

	public float getMoveSpeed() {
		return (float) this.getAttributeValue(Attributes.MOVEMENT_SPEED) * (this.isSuffocating() ? 0.66F : 1.0F);
	}

	@Override
	public void travel(Vec3 pTravelVector) {
		this.setSpeed(this.getMoveSpeed());
		this.travel(this, this.steering, pTravelVector);
	}
}
