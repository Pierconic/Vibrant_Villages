package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class GoodHealthCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (20 > entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedHealth && entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedHealth >= 11) {
			return true;
		}
		return false;
	}
}
