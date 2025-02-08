package net.mcreator.takesavillage.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

public class ReturnDismissalWarningProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "Bound")) {
			if (ReturnBoundVillagerProcedure.execute(world, x, y, z) instanceof LivingEntity) {
				return (Component.translatable("deposit_menu.dismissal_warning").getString()).replace("Testificate", ReturnBoundVillagerProcedure.execute(world, x, y, z).getDisplayName().getString());
			}
		}
		return Component.translatable("deposit_menu.no_one_to_dismiss").getString();
	}
}
