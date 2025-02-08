package net.mcreator.takesavillage.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.takesavillage.init.TakesavillageModMobEffects;
import net.mcreator.takesavillage.init.TakesavillageModGameRules;

import java.util.List;
import java.util.Comparator;

public class VillagerProximityCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double villager_count = 0;
		double current_fear = 0;
		boolean monster_nearby = false;
		boolean golem_nearby = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (entityiterator instanceof Villager) {
						villager_count = villager_count + 1;
					} else if (entityiterator instanceof Monster) {
						monster_nearby = true;
					} else if (entityiterator instanceof IronGolem) {
						golem_nearby = true;
					}
				}
			}
		}
		current_fear = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.FEAR) ? _livEnt.getEffect(TakesavillageModMobEffects.FEAR).getDuration() : 0;
		if (golem_nearby) {
			entity.getPersistentData().putDouble("Protection", 2.4);
		} else if (entity.getPersistentData().getDouble("Protection") > 0) {
			entity.getPersistentData().putDouble("Protection", (entity.getPersistentData().getDouble("Protection") - 0.1));
		}
		if (monster_nearby) {
			if (golem_nearby) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.FEAR, (int) (current_fear + (world.getLevelData().getGameRules().getInt(TakesavillageModGameRules.VILLAGER_CHECK_INTERVAL)) * 1.4), 0, false, false));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.FEAR, (int) (current_fear + (world.getLevelData().getGameRules().getInt(TakesavillageModGameRules.VILLAGER_CHECK_INTERVAL)) * 2), 0, false, false));
			}
		}
		if (villager_count > entity.getPersistentData().getDouble("Friendship")) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TakesavillageModMobEffects.LONELINESS);
			entity.getPersistentData().putDouble("Friendship", villager_count);
		} else if (entity.getPersistentData().getDouble("Friendship") > 0) {
			entity.getPersistentData().putDouble("Friendship", (entity.getPersistentData().getDouble("Friendship") - 0.1));
		} else if (entity.getPersistentData().getDouble("Friendship") <= 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.LONELINESS, 6000, 1, false, false));
		}
	}
}
