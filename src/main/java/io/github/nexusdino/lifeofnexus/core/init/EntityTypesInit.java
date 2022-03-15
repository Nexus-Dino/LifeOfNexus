package io.github.nexusdino.lifeofnexus.core.init;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.common.entity.Lion;
import io.github.nexusdino.lifeofnexus.core.Core;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class EntityTypesInit {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<EntityType<Lion>> LION = ENTITIES.register("lion",
			() -> EntityType.Builder.of(Lion::new, MobCategory.CREATURE).fireImmune().sized(1.39648F, 1.6F)
					.build(Core.pointResource("textures/entity/lion/lion.png").toString()));

	private EntityTypesInit() {
	}
}
