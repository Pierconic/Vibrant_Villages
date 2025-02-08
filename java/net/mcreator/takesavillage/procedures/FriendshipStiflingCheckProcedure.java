package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class FriendshipStiflingCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedFriendship <= 24 && entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedFriendship > 12) {
			return true;
		}
		return false;
	}
}
