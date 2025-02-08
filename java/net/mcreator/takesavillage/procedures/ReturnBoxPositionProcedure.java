package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class ReturnBoxPositionProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (!(entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedBoxX == 0 && entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedBoxY == 0
				&& entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedBoxZ == 0)) {
			return new java.text.DecimalFormat("#####").format(entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedBoxX) + "/"
					+ new java.text.DecimalFormat("######").format(entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedBoxY) + "/"
					+ new java.text.DecimalFormat("#######").format(entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedBoxZ);
		}
		return "Unbound Villager";
	}
}
