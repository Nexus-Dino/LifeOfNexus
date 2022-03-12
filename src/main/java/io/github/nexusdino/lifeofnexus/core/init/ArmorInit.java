package io.github.nexusdino.lifeofnexus.core.init;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

@SuppressWarnings("deprecation")
public enum ArmorInit implements ArmorMaterial {
	SCYTHONITE("scythonite", 7, new int[] { 4, // Boots
			6, // Leggings
			8, // Chestplate
			5 // Helmet
	}, 24, SoundEvents.ARMOR_EQUIP_DIAMOND, 10f, 8f, () -> Ingredient.of(ItemInit.SCYTHONITE_INGOT.get()));

	private static final int[] HEALTH_PER_SLOT = new int[] { 13, 15, 16, 11 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private ArmorInit(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue,
			SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotProtections = slotProtections;
		this.enchantmentValue = enchantmentValue;
		this.sound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlot pSlot) {
		return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot pSlot) {
		return this.slotProtections[pSlot.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
