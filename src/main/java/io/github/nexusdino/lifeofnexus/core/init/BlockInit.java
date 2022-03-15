package io.github.nexusdino.lifeofnexus.core.init;

import java.util.function.Supplier;

import io.github.nexusdino.lifeofnexus.LifeOfNexus;
import io.github.nexusdino.lifeofnexus.common.block.OvenBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			LifeOfNexus.MOD_ID);

	public static final RegistryObject<Block> SCYTHONITE_ORE = registerBlock("scythonite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));

	public static final RegistryObject<Block> SCYTHONITE_BLOCK = registerBlock("scythonite_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

	public static final RegistryObject<Block> DEEPSLATE_SCYTHONITE_ORE = registerBlock("deepslate_scythonite_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)));

	public static final RegistryObject<Block> OSMIUM_ORE = registerBlock("osmium_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE)));

	public static final RegistryObject<Block> OSMIUM_BLOCK = registerBlock("osmium_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

	public static final RegistryObject<Block> RAW_OSMIUM_BLOCK = registerBlock("raw_osmium_block",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_COPPER_BLOCK)));

	public static final RegistryObject<Block> DEEPSLATE_OSMIUM_ORE = registerBlock("deepslate_osmium_ore",
			() -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE)));

	public static final RegistryObject<Block> OVEN = registerBlock("oven",
			() -> new OvenBlock(BlockBehaviour.Properties.of(Material.METAL).strength(15f)
					.lightLevel(state -> OvenBlock.LIT != null ? 35 : 0).sound(SoundType.METAL)));

	private BlockInit() {
	}

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		var obj = BLOCKS.register(name, block);
		registerBlockItem(name, obj);
		return obj;
	}

	private static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<T> obj) {
		return ItemInit.ITEMS.register(name,
				() -> new BlockItem(obj.get(), new Item.Properties().tab(LifeOfNexus.CreativeTabs.TAB_LON_ADDON_BLOCKS)));
	}
}
