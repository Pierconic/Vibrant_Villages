package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.network.TakesavillageModVariables;

public class ResetDismissalTabProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			TakesavillageModVariables.PlayerVariables _vars = entity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
			_vars.DismissVillagerTab = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}
