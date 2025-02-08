package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class FearCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (0 < entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedFear && 25000 > entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedFear) {
			return true;
		}
		return false;
	}
}
