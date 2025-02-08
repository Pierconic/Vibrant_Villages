package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.takesavillage.network.TakesavillageModVariables;
import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

public class TroubleDescriptionProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String villager_name = "";
		villager_name = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TakesavillageModMobEffects.MARK_OF_TERROR)) {
			return (Component.translatable("villager.problem.horror").getString()).replace("Testificate", entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName);
		} else if (TerrorCheckProcedure.execute(entity)) {
			return (Component.translatable("villager.problem.terror").getString()).replace("Testificate", entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName);
		} else if (ProfileWoundedCheckProcedure.execute(entity)) {
			return (Component.translatable("villager.problem.wounded").getString()).replace("Testificate", entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName);
		} else if (ProfileTiredCheckProcedure.execute(entity)) {
			return (Component.translatable("villager.problem.tired").getString()).replace("Testificate", entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName);
		} else if (ProfileSuspiciousCheckProcedure.execute(entity)) {
			return (Component.translatable("villager.problem.suspicious").getString()).replace("Testificate", entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName);
		} else if (ProfileAngryCheckProcedure.execute(entity)) {
			return (Component.translatable("villager.problem.angry").getString()).replace("Testificate", entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName);
		} else if (ProfileUnhappyCheckProcedure.execute(entity)) {
			return (Component.translatable("villager.problem.unhappy").getString()).replace("Testificate", entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName);
		}
		return "error";
	}
}
