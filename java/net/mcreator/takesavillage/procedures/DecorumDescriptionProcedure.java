package net.mcreator.takesavillage.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class DecorumDescriptionProcedure {
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
		if (ExceptionalDecorumCheckProcedure.execute(entity)) {
			return (Component.translatable("deed_box.decorum.exceptional").getString()).replace("Testificate", villager_name);
		} else if (GoodDecorumCheckProcedure.execute(entity)) {
			return (Component.translatable("deed_box.decorum.good").getString()).replace("Testificate", villager_name);
		} else if (NeutralDecorumCheckProcedure.execute(entity)) {
			return (Component.translatable("deed_box.decorum.neutral").getString()).replace("Testificate", villager_name);
		} else if (BadDecorumCheckProcedure.execute(entity)) {
			return (Component.translatable("deed_box.decorum.bad").getString()).replace("Testificate", villager_name);
		}
		return "Error";
	}
}
