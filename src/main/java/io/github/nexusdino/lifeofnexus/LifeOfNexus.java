package io.github.nexusdino.lifeofnexus;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LifeOfNexus.MOD_ID)
public class LifeOfNexus {
	public static final String MOD_ID = "lifeofnexus";
	public static final Logger LOGGER = LogUtils.getLogger();

	public static final CreativeModeTab TAB_LON_ADDON_MATERIALS = new CreativeModeTab(MOD_ID) {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.SCYTHONITE_INGOT.get());
		}
	};
	
	public static final CreativeModeTab TAB_LON_ADDON_BLOCKS = new CreativeModeTab(MOD_ID) {
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(BlockInit.SCYTHONITE_ORE.get());
		}
	};
	
	public LifeOfNexus() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		bus.addListener(this::setup);
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {});
	}
}
