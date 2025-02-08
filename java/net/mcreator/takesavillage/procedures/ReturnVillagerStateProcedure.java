package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.takesavillage.network.TakesavillageModVariables;
import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

public class ReturnVillagerStateProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double mood = 0;
		if (TerribleHealthCheckProcedure.execute(entity)) {
			return "Wounded";
		} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)) {
			return "Relieved";
		} else if (TerrorCheckProcedure.execute(entity) && entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(TakesavillageModMobEffects.MARK_OF_TERROR)) {
			return "Aghast";
		} else if (entity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedInsomnia > 8) {
			return "Tired";
		} else if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(TakesavillageModMobEffects.MARK_OF_SUSPICION)) {
			return "Suspicious";
		} else {
			if (ExceptionalDecorumCheckProcedure.execute(entity)) {
				mood = mood + 3;
			} else if (GoodDecorumCheckProcedure.execute(entity)) {
				mood = mood + 2;
			} else if (BadDecorumCheckProcedure.execute(entity)) {
				mood = mood - 2;
			}
			if (GoodHydrationCheckProcedure.execute(entity)) {
				mood = mood + 2;
			} else if (NeutralHydrationCheckProcedure.execute(entity)) {
				mood = mood + 1;
			} else if (BadHydrationCheckProcedure.execute(entity)) {
				mood = mood - 2;
			}
			if (ExceptionalHealthCheckProcedure.execute(entity)) {
				mood = mood + 2;
			} else if (BadHealthCheckProcedure.execute(entity)) {
				mood = mood - 2;
			}
			if (FriendshipOverloadCheckProcedure.execute(entity) || FriendshipTerribleCheckProcedure.execute(entity)) {
				mood = mood - 3;
			} else if (FriendshipStiflingCheckProcedure.execute(entity)) {
				mood = mood - 1;
			} else if (FriendshipExceptionalCheckProcedure.execute(entity)) {
				mood = mood + 2;
			} else if (FriendshipGoodCheckProcedure.execute(entity)) {
				mood = mood + 1;
			}
			if (ProtectedCheckProcedure.execute(entity)) {
				mood = mood + 1;
			} else if (FearCheckProcedure.execute(entity)) {
				mood = mood - 2;
			}
			if (ExceptionalMobilityCheckProcedure.execute(entity)) {
				mood = mood + 1;
			} else if (TerribleMobilityCheckProcedure.execute(entity)) {
				mood = mood - 3;
			}
			if (mood > 9) {
				return "Joyful";
			} else if (mood > 5) {
				return "Happy";
			} else if (mood > -1) {
				return "Alright";
			} else if (mood > -5) {
				return "Miffed";
			} else if (mood > -9) {
				return "Unhappy";
			} else {
				return "Angry";
			}
		}
	}
}
