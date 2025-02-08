package net.mcreator.takesavillage.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class DismissVillagerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target_villager = null;
		String selected_farewell = "";
		double farewell_number = 0;
		{
			int _value = 3;
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
		if (ReturnBoundVillagerProcedure.execute(world, x, y, z) instanceof LivingEntity) {
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.DismissVillagerTab = false;
				_vars.syncPlayerVariables(entity);
			}
			target_villager = ReturnBoundVillagerProcedure.execute(world, x, y, z);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.POOF, (target_villager.getX()), (target_villager.getY()), (target_villager.getZ()), 18, 0.3, 0.3, 0.3, 0.1);
			farewell_number = Mth.nextInt(RandomSource.create(), 1, 30);
			selected_farewell = Component.translatable(("deed_box.farewell." + new java.text.DecimalFormat("##").format(farewell_number))).getString();
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((Component.translatable("villager.dismissed").getString()).replace("Testificate", target_villager.getDisplayName().getString()) + " " + selected_farewell)), false);
			if (!target_villager.level().isClientSide())
				target_villager.discard();
			UnbindBoxProcedure.execute(world, x, y, z);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Component.translatable("villager.not_dismissed").getString())), false);
		}
	}
}
