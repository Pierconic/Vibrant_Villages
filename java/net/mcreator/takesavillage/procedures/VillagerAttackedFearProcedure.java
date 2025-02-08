package net.mcreator.takesavillage.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VillagerAttackedFearProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Villager) {
			if (entity.getPersistentData().getDouble("Protection") > 0) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.FEAR, 1600, 0, false, false));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.FEAR, 2500, 0, false, false));
			}
			if (sourceentity instanceof Player) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.MARK_OF_SUSPICION,
							(int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.MARK_OF_SUSPICION) ? _livEnt.getEffect(TakesavillageModMobEffects.MARK_OF_SUSPICION).getDuration() : 0) + 1800), 0,
							false, false));
			}
		}
	}
}
