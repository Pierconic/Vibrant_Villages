package net.mcreator.takesavillage.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;
import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

public class ObserveDeedBoxAttributesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String message_temp = "";
		Entity target_villager = null;
		target_villager = ReturnBoundVillagerProcedure.execute(world, x, y, z);
		if (target_villager instanceof LivingEntity) {
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedDecorum = target_villager.getPersistentData().getDouble("Decorum");
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedHydration = target_villager instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.HYDRATION) ? _livEnt.getEffect(TakesavillageModMobEffects.HYDRATION).getDuration() : 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedHealth = target_villager instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedFear = target_villager instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.FEAR) ? _livEnt.getEffect(TakesavillageModMobEffects.FEAR).getDuration() : 0;
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedFriendship = target_villager.getPersistentData().getDouble("Friendship");
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedMobility = target_villager.getPersistentData().getDouble("Mobility");
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedInsomnia = target_villager.getPersistentData().getDouble("Insomnia");
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedBoxX = target_villager.getPersistentData().getDouble("BoxX");
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedBoxY = target_villager.getPersistentData().getDouble("BoxY");
				_vars.syncPlayerVariables(entity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedBoxZ = target_villager.getPersistentData().getDouble("BoxZ");
				_vars.syncPlayerVariables(entity);
			}
			if (target_villager.getPersistentData().getDouble("Protection") > 0) {
				{
					TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
					_vars.ObservedProtection = true;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
					_vars.ObservedProtection = false;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}
