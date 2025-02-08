package net.mcreator.takesavillage.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.takesavillage.network.TakesavillageModVariables;
import net.mcreator.takesavillage.init.TakesavillageModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class IncrementVillagerTimerProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if ((world.getLevelData().getGameRules().getInt(TakesavillageModGameRules.VILLAGER_CHECK_INTERVAL)) < TakesavillageModVariables.MapVariables.get(world).VillagerCheckTimer) {
			TakesavillageModVariables.MapVariables.get(world).VillagerCheckTimer = 0;
			TakesavillageModVariables.MapVariables.get(world).syncData(world);
		} else {
			TakesavillageModVariables.MapVariables.get(world).VillagerCheckTimer = TakesavillageModVariables.MapVariables.get(world).VillagerCheckTimer + 1;
			TakesavillageModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
