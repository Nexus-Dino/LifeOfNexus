package io.github.nexusdino.lifeofnexus.common.blockentity;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.core.forge.OvenEnergyStorage;
import io.github.nexusdino.lifeofnexus.core.init.BlockEntityTypesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

public class OvenBlockEntity extends RandomizableContainerBlockEntity {
	
	private static final int CONTAINER_SIZE = 4;
	protected NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
	
	private final OvenEnergyStorage energyStorage;
	
	private final LazyOptional<OvenEnergyStorage> energy;
	private int capacity = 5000, maxExtract = 500, maxRecieval = maxExtract, defaultEnergy = 100;
	private int progress, maxProgress = 15;

	public OvenBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityTypesInit.OVEN.get(), pos, state);
		this.energyStorage = createOvenEnergyStorage();
		this.energy = LazyOptional.of(() -> energyStorage);
	}

	private OvenEnergyStorage createOvenEnergyStorage() {
		return new OvenEnergyStorage(this, capacity, maxRecieval, maxExtract, defaultEnergy);
	}

	@Override
	public int getContainerSize() {
		return CONTAINER_SIZE;
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		return items;
	}
	
	@Override
	protected void setItems(NonNullList<ItemStack> p_59625_) {
		this.items = p_59625_;
	}
	
	@Override
	protected Component getDefaultName() {
		return new TranslatableComponent("container." + LifeOfNexus.MOD_ID + ".oven");
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == CapabilityEnergy.ENERGY ? energy.cast() : super.getCapability(cap, side);
	}
	
	@Override
	protected AbstractContainerMenu createMenu(int id, Inventory inv) {
		return null;
	}
}
