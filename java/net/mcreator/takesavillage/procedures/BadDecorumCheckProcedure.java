package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class BadDecorumCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedDecorum == 0) {
			return true;
		}
		return false;
	}
}
