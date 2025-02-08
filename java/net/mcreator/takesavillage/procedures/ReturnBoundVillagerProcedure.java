package net.mcreator.takesavillage.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.takesavillage.init.TakesavillageModGameRules;

import java.util.List;
import java.util.Comparator;

public class ReturnBoundVillagerProcedure {
	public static Entity execute(LevelAccessor world, double x, double y, double z) {
		Entity chosen_villager = null;
		chosen_villager = null;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(((world.getLevelData().getGameRules().getInt(TakesavillageModGameRules.DEED_BOX_DETECTION_RANGE)) * 2) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((entityiterator.getStringUUID()).equals(new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), "BoundVillager"))) {
					chosen_villager = entityiterator;
				}
			}
		}
		return chosen_villager;
	}
}
