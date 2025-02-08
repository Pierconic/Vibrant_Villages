package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class TerrorCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (19200 <= entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedFear) {
			return true;
		}
		return false;
	}
}
