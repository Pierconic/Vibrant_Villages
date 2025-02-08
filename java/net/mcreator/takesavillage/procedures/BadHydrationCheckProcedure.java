package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class BadHydrationCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedHydration == 0) {
			return true;
		}
		return false;
	}
}
