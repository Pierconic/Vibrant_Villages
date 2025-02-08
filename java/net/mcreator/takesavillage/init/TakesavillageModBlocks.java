
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.takesavillage.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.takesavillage.block.DeedBoxBlock;
import net.mcreator.takesavillage.TakesavillageMod;

public class TakesavillageModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(TakesavillageMod.MODID);
	public static final DeferredBlock<Block> DEED_BOX = REGISTRY.register("deed_box", DeedBoxBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
