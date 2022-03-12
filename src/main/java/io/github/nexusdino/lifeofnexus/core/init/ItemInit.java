package io.github.nexusdino.lifeofnexus.core.init;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
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

	public static final RegistryObject<Item> SCYTHONITE_HELMET = ITEMS.register("scythonite_helmet",
			() -> new ArmorItem(ArmorInit.SCYTHONITE, EquipmentSlot.HEAD,
					new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> SCYTHONITE_CHESTPLATE = ITEMS.register("scythonite_chestplate",
			() -> new ArmorItem(ArmorInit.SCYTHONITE, EquipmentSlot.CHEST,
					new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> SCYTHONITE_LEGGINGS = ITEMS.register("scythonite_leggings",
			() -> new ArmorItem(ArmorInit.SCYTHONITE, EquipmentSlot.LEGS,
					new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));
	public static final RegistryObject<Item> SCYTHONITE_BOOTS = ITEMS.register("scythonite_boots",
			() -> new ArmorItem(ArmorInit.SCYTHONITE, EquipmentSlot.FEET,
					new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));

	public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot",
			() -> new Item(new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));

	public static final RegistryObject<Item> RAW_OSMIUM = ITEMS.register("raw_osmium",
			() -> new Item(new Item.Properties().tab(LifeOfNexus.TAB_LON_ADDON_MATERIALS).fireResistant()));

	private ItemInit() {
	}
}
