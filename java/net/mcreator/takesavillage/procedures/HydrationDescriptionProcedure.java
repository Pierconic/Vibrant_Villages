package net.mcreator.takesavillage.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class HydrationDescriptionProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		String villager_name = "";
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "Bound")) {
			if (ReturnBoundVillagerProcedure.execute(world, x, y, z) instanceof LivingEntity) {
				villager_name = ReturnBoundVillagerProcedure.execute(world, x, y, z).getDisplayName().getString();
			}
		}
		if (GoodHydrationCheckProcedure.execute(entity)) {
			return (Component.translatable("deed_box.hydration.exceptional").getString()).replace("Testificate", villager_name);
		} else if (NeutralHydrationCheckProcedure.execute(entity)) {
			return (Component.translatable("deed_box.hydration.good").getString()).replace("Testificate", villager_name);
		} else if (BadHydrationCheckProcedure.execute(entity)) {
			return (Component.translatable("deed_box.hydration.bad").getString()).replace("Testificate", villager_name);
		}
		return "Error";
	}
}
