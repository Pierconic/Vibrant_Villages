package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

public class ProfileTiredCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((ReturnVillagerStateProcedure.execute(entity)).equals("Tired")) {
			return true;
		}
		return false;
	}
}
