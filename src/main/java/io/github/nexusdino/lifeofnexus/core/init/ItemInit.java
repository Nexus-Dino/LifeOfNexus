package io.github.nexusdino.lifeofnexus.core.init;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<Item> SCYTHONITE_INGOT = ITEMS.register("scythonite_ingot", () -> new Item(
			new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_MATERIALS).fireResistant()));

	public static final RegistryObject<Item> RAW_SCYTHONITE = ITEMS.register("raw_scythonite", () -> new Item(
			new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_MATERIALS).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_PICKAXE = ITEMS.register("scythonite_pickaxe",
			() -> new PickaxeItem(TierInit.SCYTHONITE, 6, 3f,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_TOOL).fireResistant()));
	
	public static final RegistryObject<Item> SCYTHONITE_SWORD = ITEMS.register("scythonite_sword",
			() -> new SwordItem(TierInit.SCYTHONITE, 13, 5f,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_TOOL).fireResistant()));
	
	public static final RegistryObject<Item> SCYTHONITE_AXE = ITEMS.register("scythonite_axe",
			() -> new AxeItem(TierInit.SCYTHONITE, 8, 4f,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_TOOL).fireResistant()));
	
	public static final RegistryObject<Item> SCYTHONITE_SHOVEL = ITEMS.register("scythonite_shovel",
			() -> new ShovelItem(TierInit.SCYTHONITE, 4, 9f,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_TOOL).fireResistant()));
	
	public static final RegistryObject<Item> SCYTHONITE_HOE = ITEMS.register("scythonite_hoe",
			() -> new HoeItem(TierInit.SCYTHONITE, 6, 3f,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_TOOL).fireResistant()));
	
	public static final RegistryObject<Item> OSMIUM_PICKAXE = ITEMS.register("osmium_pickaxe",
			() -> new PickaxeItem(TierInit.OSMIUM, 6, 3f,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_TOOL).fireResistant()));

	public static final RegistryObject<Item> SCYTHONITE_HELMET = ITEMS.register("scythonite_helmet",
			() -> new ArmorItem(ArmorInit.SCYTHONITE, EquipmentSlot.HEAD,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_MATERIALS).fireResistant()));
	
	public static final RegistryObject<Item> SCYTHONITE_CHESTPLATE = ITEMS.register("scythonite_chestplate",
			() -> new ArmorItem(ArmorInit.SCYTHONITE, EquipmentSlot.CHEST,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_MATERIALS).fireResistant()));
	
	public static final RegistryObject<Item> SCYTHONITE_LEGGINGS = ITEMS.register("scythonite_leggings",
			() -> new ArmorItem(ArmorInit.SCYTHONITE, EquipmentSlot.LEGS,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_MATERIALS).fireResistant()));
	
	public static final RegistryObject<Item> SCYTHONITE_BOOTS = ITEMS.register("scythonite_boots",
			() -> new ArmorItem(ArmorInit.SCYTHONITE, EquipmentSlot.FEET,
					new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_MATERIALS).fireResistant()));

	public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new Item(
			new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_MATERIALS).fireResistant()));

	public static final RegistryObject<Item> RAW_OSMIUM = ITEMS.register("raw_osmium", () -> new Item(
			new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_MATERIALS).fireResistant()));

	private ItemInit() {
	}
}
