package net.mcreator.takesavillage.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DeathUnbindingProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Villager) {
			if (!(entity.getPersistentData().getDouble("BoxX") == 0 && entity.getPersistentData().getDouble("BoxY") == 0 && entity.getPersistentData().getDouble("BoxZ") == 0)) {
				UnbindBoxProcedure.execute(world, entity.getPersistentData().getDouble("BoxX"), entity.getPersistentData().getDouble("BoxY"), entity.getPersistentData().getDouble("BoxZ"));
			}
		}
	}
}
