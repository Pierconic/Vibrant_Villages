package net.mcreator.takesavillage.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.takesavillage.init.TakesavillageModGameRules;

public class SummonVillagerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double villager_type = 0;
		boolean found = false;
		if (world.getLevelData().getGameRules().getBoolean(TakesavillageModGameRules.DO_VILLAGER_SUMMONING)) {
			sx = -3;
			for (int index0 = 0; index0 < 6; index0++) {
				sy = -3;
				for (int index1 = 0; index1 < 6; index1++) {
					sz = -3;
					for (int index2 = 0; index2 < 6; index2++) {
						if (!found && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).canOcclude() && world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 1, z + sz))
								&& world.isEmptyBlock(BlockPos.containing(x + sx, y + sy + 2, z + sz)) && Math.random() < 0.03) {
							if (Math.random() < 0.5) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), (y + sy), (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"summon villager ~0.5 ~1 ~0.5");
							} else {
								villager_type = Mth.nextInt(RandomSource.create(), 1, 6);
								if (villager_type == 1) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), (y + sy), (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon villager ~ ~1 ~ {VillagerData:{type:plains,level:1}}");
								} else if (villager_type == 2) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), (y + sy), (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon villager ~ ~1 ~ {VillagerData:{type:taiga,level:1}}");
								} else if (villager_type == 3) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), (y + sy), (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon villager ~ ~1 ~ {VillagerData:{type:desert,level:1}}");
								} else if (villager_type == 4) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), (y + sy), (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon villager ~ ~1 ~ {VillagerData:{type:snow,level:1}}");
								} else if (villager_type == 5) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), (y + sy), (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon villager ~ ~1 ~ {VillagerData:{type:savanna,level:1}}");
								} else if (villager_type == 6) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), (y + sy), (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon villager ~ ~1 ~ {VillagerData:{type:jungle,level:1}}");
								} else if (villager_type == 7) {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3((x + sx), (y + sy), (z + sz)), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"summon villager ~ ~1 ~ {VillagerData:{type:swamp,level:1}}");
								}
							}
							found = true;
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null)
									_blockEntity.getPersistentData().putDouble("Progress", 0);
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
		}
	}
}
