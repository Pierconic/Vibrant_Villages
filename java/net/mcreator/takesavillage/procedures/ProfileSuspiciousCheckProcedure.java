package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

public class ProfileSuspiciousCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((ReturnVillagerStateProcedure.execute(entity)).equals("Suspicious")) {
			return true;
		}
		return false;
	}
}
