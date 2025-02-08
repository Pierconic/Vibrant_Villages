package net.mcreator.takesavillage.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.takesavillage.init.TakesavillageModBlocks;

public class UnbindVillagerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean player_nearby = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!((world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("BoxX"), entity.getPersistentData().getDouble("BoxY"), entity.getPersistentData().getDouble("BoxZ")))).getBlock() == TakesavillageModBlocks.DEED_BOX.get())) {
			entity.getPersistentData().putDouble("BoxX", 0);
			entity.getPersistentData().putDouble("BoxY", 0);
			entity.getPersistentData().putDouble("BoxZ", 0);
		}
	}
}
