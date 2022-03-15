//package io.github.nexusdino.lifeofnexus.core.forge;
//
//import io.github.nexusdino.lifeofnexus.common.blockentity.OvenBlockEntity;
//import net.minecraft.util.Mth;
//import net.minecraftforge.energy.EnergyStorage;
//
//public class OvenEnergyStorage extends EnergyStorage {
//	private final OvenBlockEntity blockEntity;
//
//	public OvenEnergyStorage(OvenBlockEntity blockEntity, int capacity, int maxReceive, int maxExtract, int energy) {
//		super(capacity, maxReceive, maxExtract, energy);
//		this.blockEntity = blockEntity;
//	}
//
//	public OvenEnergyStorage(OvenBlockEntity blockEntity, int capacity, int maxReceive, int maxExtract) {
//		super(capacity, maxReceive, maxExtract);
//		this.blockEntity = blockEntity;
//	}
//
//	public OvenEnergyStorage(OvenBlockEntity blockEntity, int capacity, int maxTransfer) {
//		super(capacity, maxTransfer);
//		this.blockEntity = blockEntity;
//	}
//
//	public OvenEnergyStorage(OvenBlockEntity blockEntity, int capacity) {
//		super(capacity);
//		this.blockEntity = blockEntity;
//	}
//
//	@Override
//	public int extractEnergy(int maxExtract, boolean simulate) {
//		this.blockEntity.setChanged();
//		return super.extractEnergy(maxExtract, simulate);
//	}
//
//	@Override
//	public int receiveEnergy(int maxReceive, boolean simulate) {
//		this.blockEntity.setChanged();
//		return super.receiveEnergy(maxReceive, simulate);
//	}
//	
//	public void setEnergy(int energy) {
//		this.energy = Mth.clamp(0, energy, capacity);
//	}
//}
