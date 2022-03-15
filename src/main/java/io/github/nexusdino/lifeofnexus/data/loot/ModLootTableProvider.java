package io.github.nexusdino.lifeofnexus.data.loot;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import io.github.nexusdino.lifeofnexus.core.init.BlockInit;
import io.github.nexusdino.lifeofnexus.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

public class ModLootTableProvider extends LootTableProvider {
	private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = ImmutableList
			.of(Pair.of(ModBlockLoot::new, LootContextParamSets.BLOCK));

	public ModLootTableProvider(DataGenerator p_124437_) {
		super(p_124437_);
	}

	@Override
	public List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
		return tables;
	}

	public static class ModBlockLoot extends BlockLoot {

		@Override
		protected void addTables() {
			add(BlockInit.OSMIUM_ORE.get(),
					block -> createOreDrop(BlockInit.OSMIUM_ORE.get(), ItemInit.RAW_OSMIUM.get()));

			add(BlockInit.DEEPSLATE_OSMIUM_ORE.get(),
					block -> createOreDrop(BlockInit.DEEPSLATE_OSMIUM_ORE.get(), ItemInit.RAW_OSMIUM.get()));

			add(BlockInit.SCYTHONITE_ORE.get(),
					block -> createOreDrop(BlockInit.SCYTHONITE_ORE.get(), ItemInit.RAW_SCYTHONITE.get()));

			add(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get(),
					block -> createOreDrop(BlockInit.DEEPSLATE_SCYTHONITE_ORE.get(), ItemInit.RAW_SCYTHONITE.get()));
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
		}
	}
}
