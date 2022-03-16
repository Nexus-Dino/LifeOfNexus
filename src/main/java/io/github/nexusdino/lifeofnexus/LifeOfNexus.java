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
import software.bernie.geckolib3.GeckoLib;

@Mod(LifeOfNexus.MOD_ID)
public class LifeOfNexus {
	public static final String MOD_ID = "lifeofnexus";
	public static final Logger LOGGER = LogUtils.getLogger();

	public LifeOfNexus() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::setup);

		GeckoLib.initialize();
		
		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
		});
	}
	
	public static class CreativeTabs {
		private static final String ITEM_GROUP_PREFIX = "item_group.";

		public static final CreativeModeTab TAB_LON_ADDON_MATERIALS = new CreativeModeTab(ITEM_GROUP_PREFIX + MOD_ID + ".materials") {

			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ItemInit.SCYTHONITE_INGOT.get());
			}
		};

		public static final CreativeModeTab TAB_LON_ADDON_ARMOR = new CreativeModeTab(ITEM_GROUP_PREFIX + MOD_ID + ".armor") {

			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ItemInit.SCYTHONITE_CHESTPLATE.get());
			}
		};

		public static final CreativeModeTab TAB_LON_ADDON_TOOLS = new CreativeModeTab(ITEM_GROUP_PREFIX + MOD_ID + ".tools") {

			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ItemInit.SCYTHONITE_PICKAXE.get());
			}
		};

		public static final CreativeModeTab TAB_LON_ADDON_COMBAT = new CreativeModeTab(ITEM_GROUP_PREFIX + MOD_ID + ".combat") {

			@Override
			public ItemStack makeIcon() {
				return new ItemStack(ItemInit.SCYTHONITE_SWORD.get());
			}
		};

		public static final CreativeModeTab TAB_LON_ADDON_BLOCKS = new CreativeModeTab(ITEM_GROUP_PREFIX + MOD_ID + ".blocks") {

			@Override
			public ItemStack makeIcon() {
				return new ItemStack(BlockInit.SCYTHONITE_ORE.get());
			}
		};
	}
}
