package net.mcreator.takesavillage.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class InsomniaCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:beds")))
					|| (world.getBlockState(BlockPos.containing(x, y - 0.4, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:beds")))) {
				if (entity.getPersistentData().getDouble("Insomnia") > 0) {
					entity.getPersistentData().putDouble("Insomnia", (entity.getPersistentData().getDouble("Insomnia") - 1));
				}
			} else {
				if (entity.getPersistentData().getDouble("Insomnia") < 15) {
					entity.getPersistentData().putDouble("Insomnia", (entity.getPersistentData().getDouble("Insomnia") + 1));
				}
			}
		}
	}
}
