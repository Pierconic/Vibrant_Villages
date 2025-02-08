package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class GoodDecorumCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedDecorum <= 20 && entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedDecorum > 10) {
			return true;
		}
		return false;
	}
}
