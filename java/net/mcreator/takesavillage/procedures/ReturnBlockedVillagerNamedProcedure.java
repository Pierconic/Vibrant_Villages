package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class ReturnBlockedVillagerNamedProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).SavedName + " - " + Component.translatable("translation.key.grumpy_villager").getString();
	}
}
