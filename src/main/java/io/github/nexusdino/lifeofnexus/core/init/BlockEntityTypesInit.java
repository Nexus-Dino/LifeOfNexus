package io.github.nexusdino.lifeofnexus.core.init;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.common.blockentity.OvenBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityTypesInit {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, LifeOfNexus.MOD_ID);

	public static final RegistryObject<BlockEntityType<OvenBlockEntity>> OVEN = BLOCK_ENTITIES.register("oven",
			() -> BlockEntityType.Builder.of(OvenBlockEntity::new, BlockInit.OVEN.get()).build(null));
}
