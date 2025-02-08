package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

public class MurderAbsolutionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(TakesavillageModMobEffects.MARK_OF_SUSPICION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(TakesavillageModMobEffects.MARK_OF_TERROR);
	}
}
