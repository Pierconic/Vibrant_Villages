
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.takesavillage.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.takesavillage.TakesavillageMod;

public class TakesavillageModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TakesavillageMod.MODID);
	public static final DeferredItem<Item> DEED_BOX = block(TakesavillageModBlocks.DEED_BOX);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
