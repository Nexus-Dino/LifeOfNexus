package io.github.nexusdino.lifeofnexus.core.init;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.core.Core;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
			LifeOfNexus.MOD_ID);
		
	protected static RegistryObject<SoundEvent> registerSound(String name) {
		return SOUNDS.register(name, () -> new SoundEvent(Core.pointResource(name)));
	}

	private SoundInit() {
	}
}
