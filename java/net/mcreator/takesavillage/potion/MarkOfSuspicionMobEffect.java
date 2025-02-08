
package net.mcreator.takesavillage.potion;

import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.takesavillage.procedures.SuspicionEffectProcedure;

import java.util.Set;

public class MarkOfSuspicionMobEffect extends MobEffect {
	public MarkOfSuspicionMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		SuspicionEffectProcedure.execute();
		return super.applyEffectTick(entity, amplifier);
	}
}
