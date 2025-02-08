
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.takesavillage.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TakesavillageModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> VILLAGER_CHECK_INTERVAL;
	public static GameRules.Key<GameRules.IntegerValue> DEED_BOX_DETECTION_RANGE;
	public static GameRules.Key<GameRules.IntegerValue> VILLAGER_GIFT_INTERVAL;
	public static GameRules.Key<GameRules.IntegerValue> VILLAGER_SUMMONING_INTERVAL;
	public static GameRules.Key<GameRules.BooleanValue> DO_VILLAGER_SUMMONING;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		VILLAGER_CHECK_INTERVAL = GameRules.register("villagerCheckInterval", GameRules.Category.UPDATES, GameRules.IntegerValue.create(200));
		DEED_BOX_DETECTION_RANGE = GameRules.register("deedBoxDetectionRange", GameRules.Category.MOBS, GameRules.IntegerValue.create(64));
		VILLAGER_GIFT_INTERVAL = GameRules.register("villagerGiftInterval", GameRules.Category.MOBS, GameRules.IntegerValue.create(20));
		VILLAGER_SUMMONING_INTERVAL = GameRules.register("villagerSummoningInterval", GameRules.Category.MOBS, GameRules.IntegerValue.create(20));
		DO_VILLAGER_SUMMONING = GameRules.register("doVillagerSummoning", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
	}
}
