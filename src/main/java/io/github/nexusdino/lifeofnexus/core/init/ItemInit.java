package io.github.nexusdino.lifeofnexus.core.init;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<Item> SCYTHONITE_INGOT = ITEMS.register("scythonite_ingot",
			() -> new Item(new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));
	
	public static final RegistryObject<Item> RAW_SCYTHONITE = ITEMS.register("raw_scythonite",
			() -> new Item(new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));
	
	public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot",
			() -> new Item(new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));
	
	public static final RegistryObject<Item> RAW_OSMIUM = ITEMS.register("raw_osmium",
			() -> new Item(new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));

	private ItemInit() {
	}
}
