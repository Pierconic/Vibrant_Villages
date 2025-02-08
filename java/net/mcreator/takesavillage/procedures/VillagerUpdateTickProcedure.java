package net.mcreator.takesavillage.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.takesavillage.network.TakesavillageModVariables;
import net.mcreator.takesavillage.init.TakesavillageModMobEffects;
import net.mcreator.takesavillage.init.TakesavillageModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VillagerUpdateTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		if (entity instanceof Villager) {
			if (world instanceof Level _lvl1 && _lvl1.isDay()) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.isBaby()) && !(entity.getPersistentData().getDouble("BoxX") == 0 && entity.getPersistentData().getDouble("BoxY") == 0 && entity.getPersistentData().getDouble("BoxZ") == 0)) {
					if ((ReturnLocalVillagerStateProcedure.execute(entity)).equals("Joyful")) {
						entity.getPersistentData().putDouble("Thriftiness", (entity.getPersistentData().getDouble("Thriftiness") + 3));
					} else if ((ReturnLocalVillagerStateProcedure.execute(entity)).equals("Relieved") || (ReturnLocalVillagerStateProcedure.execute(entity)).equals("Happy")) {
						entity.getPersistentData().putDouble("Thriftiness", (entity.getPersistentData().getDouble("Thriftiness") + 2));
					} else if ((ReturnLocalVillagerStateProcedure.execute(entity)).equals("Alright")) {
						entity.getPersistentData().putDouble("Thriftiness", (entity.getPersistentData().getDouble("Thriftiness") + 1));
					} else if ((ReturnLocalVillagerStateProcedure.execute(entity)).equals("Suspicious") || (ReturnLocalVillagerStateProcedure.execute(entity)).equals("Unhappy") || (ReturnLocalVillagerStateProcedure.execute(entity)).equals("Tired")) {
						entity.getPersistentData().putDouble("Thriftiness", (entity.getPersistentData().getDouble("Thriftiness") - 1));
					} else if ((ReturnLocalVillagerStateProcedure.execute(entity)).equals("Wounded") || (ReturnLocalVillagerStateProcedure.execute(entity)).equals("Aghast") || (ReturnLocalVillagerStateProcedure.execute(entity)).equals("Angry")) {
						entity.getPersistentData().putDouble("Thriftiness", 0);
					}
				}
				if (entity.getPersistentData().getDouble("Thriftiness") < 0) {
					entity.getPersistentData().putDouble("Thriftiness", 0);
				}
				if (entity.getPersistentData().getDouble("StartingX") == 0 && entity.getPersistentData().getDouble("StartingY") == 0 && entity.getPersistentData().getDouble("StartingZ") == 0) {
					entity.getPersistentData().putDouble("StartingX", x);
					entity.getPersistentData().putDouble("StartingY", y);
					entity.getPersistentData().putDouble("StartingZ", z);
				}
			}
			if (TakesavillageModVariables.MapVariables.get(world).VillagerCheckTimer == (world.getLevelData().getGameRules().getInt(TakesavillageModGameRules.VILLAGER_CHECK_INTERVAL)) - 1) {
				if (world instanceof Level _lvl24 && _lvl24.isDay()) {
					GeneralVillagerSurroundingsCheckProcedure.execute(world, x, y, z, entity);
					VillagerProximityCheckProcedure.execute(world, x, y, z, entity);
					InsomniaCheckProcedure.execute(world, x, y, z, entity);
					if (Math.sqrt(Math.pow(entity.getPersistentData().getDouble("StartingX") - x, 2) + Math.pow(entity.getPersistentData().getDouble("StartingY") - y, 2) + Math.pow(entity.getPersistentData().getDouble("StartingZ") - z, 2)) > Math
							.sqrt(Math.pow(entity.getPersistentData().getDouble("StartingX") - entity.getPersistentData().getDouble("MaxX"), 2)
									+ Math.pow(entity.getPersistentData().getDouble("StartingY") - entity.getPersistentData().getDouble("MaxY"), 2)
									+ Math.pow(entity.getPersistentData().getDouble("StartingZ") - entity.getPersistentData().getDouble("MaxZ"), 2))
							|| entity.getPersistentData().getDouble("MaxX") == 0 && entity.getPersistentData().getDouble("MaxY") == 0 && entity.getPersistentData().getDouble("MaxZ") == 0) {
						entity.getPersistentData().putDouble("MaxX", x);
						entity.getPersistentData().putDouble("MaxY", y);
						entity.getPersistentData().putDouble("MaxZ", z);
					}
				} else {
					InsomniaCheckProcedure.execute(world, x, y, z, entity);
					if (!(entity.getPersistentData().getDouble("MaxX") == 0 && entity.getPersistentData().getDouble("MaxY") == 0 && entity.getPersistentData().getDouble("MaxZ") == 0)) {
						distance = Math.sqrt(Math.pow(entity.getPersistentData().getDouble("StartingX") - entity.getPersistentData().getDouble("MaxX"), 2)
								+ Math.pow(entity.getPersistentData().getDouble("StartingY") - entity.getPersistentData().getDouble("MaxY"), 2)
								+ Math.pow(entity.getPersistentData().getDouble("StartingZ") - entity.getPersistentData().getDouble("MaxZ"), 2));
						if (distance >= 30) {
							entity.getPersistentData().putDouble("Mobility", 2);
						} else if (distance >= 15) {
							entity.getPersistentData().putDouble("Mobility", 1);
						} else {
							entity.getPersistentData().putDouble("Mobility", 0);
						}
						entity.getPersistentData().putDouble("StartingX", 0);
						entity.getPersistentData().putDouble("StartingY", 0);
						entity.getPersistentData().putDouble("StartingZ", 0);
						entity.getPersistentData().putDouble("MaxX", 0);
						entity.getPersistentData().putDouble("MaxY", 0);
						entity.getPersistentData().putDouble("MaxZ", 0);
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.FEAR) ? _livEnt.getEffect(TakesavillageModMobEffects.FEAR).getDuration() : 0) > 36000) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(TakesavillageModMobEffects.FEAR);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.FEAR, 36000, 0, false, false));
				}
				if (!(entity.getPersistentData().getDouble("BoxX") == 0 && entity.getPersistentData().getDouble("BoxY") == 0 && entity.getPersistentData().getDouble("BoxZ") == 0)) {
					UnbindVillagerProcedure.execute(world, entity);
				}
			}
		}
	}
}
