package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class DismissTabOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
			_vars.DismissVillagerTab = !entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).DismissVillagerTab;
			_vars.syncPlayerVariables(entity);
		}
	}
}
