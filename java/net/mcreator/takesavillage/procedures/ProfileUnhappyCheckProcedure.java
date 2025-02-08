package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

public class ProfileUnhappyCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((ReturnVillagerStateProcedure.execute(entity)).equals("Unhappy")) {
			return true;
		}
		return false;
	}
}
