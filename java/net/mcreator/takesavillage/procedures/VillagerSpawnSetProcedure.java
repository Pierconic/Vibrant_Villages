package net.mcreator.takesavillage.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.takesavillage.init.TakesavillageModMobEffects;
import net.mcreator.takesavillage.TakesavillageMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class VillagerSpawnSetProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double name_seed = 0;
		if (entity instanceof Villager && !entity.getPersistentData().getBoolean("SpeciallyNamed")) {
			entity.getPersistentData().putBoolean("SpeciallyNamed", true);
			entity.getPersistentData().putDouble("Decorum", 9);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.HYDRATION, 18000, 0, false, false));
			entity.getPersistentData().putDouble("Friendship", 5);
			entity.getPersistentData().putDouble("Protection", 1);
			entity.getPersistentData().putDouble("Mobility", 1);
			TakesavillageMod.queueServerWork(2, () -> {
				RandomNameGeneratorPartDeuxProcedure.execute(world, x, y, z);
			});
		}
	}
}
