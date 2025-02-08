package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class FriendshipExceptionalCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedFriendship <= 12 && entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedFriendship > 5) {
			return true;
		}
		return false;
	}
}
