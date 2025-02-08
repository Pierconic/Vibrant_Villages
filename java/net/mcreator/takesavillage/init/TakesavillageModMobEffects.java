
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.takesavillage.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.takesavillage.procedures.LonelinessEffectExpiresProcedure;
import net.mcreator.takesavillage.potion.SummonedMobEffect;
import net.mcreator.takesavillage.potion.MarkOfTerrorMobEffect;
import net.mcreator.takesavillage.potion.MarkOfSuspicionMobEffect;
import net.mcreator.takesavillage.potion.LonelinessMobEffect;
import net.mcreator.takesavillage.potion.HydrationMobEffect;
import net.mcreator.takesavillage.potion.FearMobEffect;
import net.mcreator.takesavillage.TakesavillageMod;

@EventBusSubscriber
public class TakesavillageModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, TakesavillageMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> HYDRATION = REGISTRY.register("hydration", () -> new HydrationMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> FEAR = REGISTRY.register("fear", () -> new FearMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> LONELINESS = REGISTRY.register("loneliness", () -> new LonelinessMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MARK_OF_SUSPICION = REGISTRY.register("mark_of_suspicion", () -> new MarkOfSuspicionMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> MARK_OF_TERROR = REGISTRY.register("mark_of_terror", () -> new MarkOfTerrorMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SUMMONED = REGISTRY.register("summoned", () -> new SummonedMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(LONELINESS)) {
			LonelinessEffectExpiresProcedure.execute(entity);
		}
	}
}
