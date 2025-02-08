package net.mcreator.takesavillage.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DebugTestProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		String message_temp = "";
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.DEBUG_STICK && entity instanceof Villager) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + "(" + ReturnLocalVillagerStateProcedure.execute(entity) + ")~~~~~~~~~~~~~~~~~~~~~")), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Decorum: " + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("Decorum")))), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Hydration: " + (new java.text.DecimalFormat("#####")
						.format((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.HYDRATION) ? _livEnt.getEffect(TakesavillageModMobEffects.HYDRATION).getDuration() : 0) * 0.05)))), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Health:" + (new java.text.DecimalFormat("##").format(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) + " ~~~ Insomnia:"
						+ new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("Insomnia")))), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Fear: "
						+ (new java.text.DecimalFormat("####").format((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.FEAR) ? _livEnt.getEffect(TakesavillageModMobEffects.FEAR).getDuration() : 0) * 0.05))
						+ "~~~" + ("Protection" + new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("Protection"))))), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Friendship: " + new java.text.DecimalFormat("####").format(entity.getPersistentData().getDouble("Friendship")) + "~~~"
						+ ("Gift Progress: " + new java.text.DecimalFormat("######").format(entity.getPersistentData().getDouble("Thriftiness"))))), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Mobility:" + new java.text.DecimalFormat("####").format(entity.getPersistentData().getDouble("Mobility")))), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Starting Pos: " + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("StartingX")) + "~"
						+ new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("StartingY")) + "~" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("StartingZ")))), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Max Pos: " + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("MaxX")) + "~"
						+ new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("MaxY")) + "~" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("MaxZ")))), false);
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Block Pos:" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("BlockX")) + "~"
						+ new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("BlockX")) + "~" + new java.text.DecimalFormat("##").format(entity.getPersistentData().getDouble("BlockZ")))), false);
		}
	}
}
