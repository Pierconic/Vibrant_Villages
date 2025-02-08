package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class BadHealthCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedHealth < 11 && entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedHealth > 6) {
			return true;
		}
		return false;
	}
}
