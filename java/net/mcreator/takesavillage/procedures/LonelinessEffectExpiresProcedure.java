package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.Entity;

public class LonelinessEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Villager) {
			entity.getPersistentData().putDouble("Friendship", (entity.getPersistentData().getDouble("Friendship") - 1));
		}
	}
}
