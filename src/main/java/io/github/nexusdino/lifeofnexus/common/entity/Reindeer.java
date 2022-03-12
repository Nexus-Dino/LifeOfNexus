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
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Reindeer extends Animal implements ItemSteerable, Saddleable {
	private static final EntityDataAccessor<Integer> DATA_BOOST_TIME = SynchedEntityData.defineId(Reindeer.class,
			EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_SADDLE_ID = SynchedEntityData.defineId(Reindeer.class,
			EntityDataSerializers.BOOLEAN);
	private final ItemBasedSteering steering = new ItemBasedSteering(getEntityData(), DATA_BOOST_TIME, DATA_SADDLE_ID);

	protected Reindeer(EntityType<? extends Animal> p_27557_, Level p_27558_) {
		super(p_27557_, p_27558_);
	}

	@Override
	public boolean boost() {
		return this.steering.boost(getRandom());
	}

	@Override
	public void equipSaddle(SoundSource category) {
		this.steering.setSaddle(true);
		if (category != null)
			this.level.playSound((Player) null, this, SoundEvents.PIG_SADDLE, category, 0.5F, 1.0F);

	}

	@Override
	public Reindeer getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}

	@Override
	public float getSteeringSpeed() {
		return 0;
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

	@Override
	public void travel(Vec3 pTravelVector) {
		super.travel(pTravelVector);
	}
}
