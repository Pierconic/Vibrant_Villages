package net.mcreator.takesavillage.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

public class ReturnLocalVillagerStateProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double mood = 0;
		if (mood > 19200) {
			return "Aghast";
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 6) {
			return "Wounded";
		} else if (entity.getPersistentData().getDouble("Insomnia") > 8) {
			return "Tired";
		} else {
			if (entity.getPersistentData().getDouble("Decorum") > 20) {
				mood = mood + 3;
			} else if (entity.getPersistentData().getDouble("Decorum") > 10) {
				mood = mood + 2;
			} else if (entity.getPersistentData().getDouble("Decorum") == 0) {
				mood = mood - 2;
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.HYDRATION) ? _livEnt.getEffect(TakesavillageModMobEffects.HYDRATION).getDuration() : 0) > 12000) {
				mood = mood + 2;
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.HYDRATION) ? _livEnt.getEffect(TakesavillageModMobEffects.HYDRATION).getDuration() : 0) > 0) {
				mood = mood + 1;
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.HYDRATION) ? _livEnt.getEffect(TakesavillageModMobEffects.HYDRATION).getDuration() : 0) == 0) {
				mood = mood - 2;
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 20) {
				mood = mood + 2;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 11) {
				mood = mood - 2;
			}
			if (entity.getPersistentData().getDouble("Friendship") > 24 || entity.getPersistentData().getDouble("Friendship") < 0) {
				mood = mood - 3;
			} else if (entity.getPersistentData().getDouble("Friendship") > 12) {
				mood = mood - 1;
			} else if (entity.getPersistentData().getDouble("Friendship") > 5) {
				mood = mood + 2;
			} else if (entity.getPersistentData().getDouble("Friendship") > 0) {
				mood = mood + 1;
			}
			if (entity.getPersistentData().getDouble("Protection") > 0) {
				mood = mood + 1;
			} else if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(TakesavillageModMobEffects.FEAR)) {
				mood = mood - 2;
			}
			if (entity.getPersistentData().getDouble("Mobility") >= 2) {
				mood = mood + 1;
			} else if (entity.getPersistentData().getDouble("Mobility") == 0) {
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
