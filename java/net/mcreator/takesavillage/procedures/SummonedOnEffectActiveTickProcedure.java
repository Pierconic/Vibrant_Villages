package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class SummonedOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Villager) {
			if (!(entity.getPersistentData().getDouble("BoxX") == 0 && entity.getPersistentData().getDouble("BoxY") == 0 && entity.getPersistentData().getDouble("BoxZ") == 0)) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("BoxX")), (entity.getPersistentData().getDouble("BoxY")), (entity.getPersistentData().getDouble("BoxZ")), 0.5);
			}
		}
	}
}
