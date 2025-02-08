package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class NeutralHydrationCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedHydration <= 12000 && entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedHydration > 1) {
			return true;
		}
		return false;
	}
}
