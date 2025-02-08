package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

public class ProfileAghastCheckProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TakesavillageModMobEffects.MARK_OF_TERROR)) {
			return true;
		}
		return false;
	}
}
