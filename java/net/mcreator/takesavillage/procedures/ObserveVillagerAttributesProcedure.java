package net.mcreator.takesavillage.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.takesavillage.world.inventory.TradingBlockedGUIMenu;
import net.mcreator.takesavillage.network.TakesavillageModVariables;
import net.mcreator.takesavillage.init.TakesavillageModMobEffects;
import net.mcreator.takesavillage.TakesavillageMod;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

@EventBusSubscriber
public class ObserveVillagerAttributesProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		String message_temp = "";
		if (entity instanceof Villager) {
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedDecorum = entity.getPersistentData().getDouble("Decorum");
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedHydration = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.HYDRATION) ? _livEnt.getEffect(TakesavillageModMobEffects.HYDRATION).getDuration() : 0;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedHealth = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedFear = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TakesavillageModMobEffects.FEAR) ? _livEnt.getEffect(TakesavillageModMobEffects.FEAR).getDuration() : 0;
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedFriendship = entity.getPersistentData().getDouble("Friendship");
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedMobility = entity.getPersistentData().getDouble("Mobility");
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedInsomnia = entity.getPersistentData().getDouble("Insomnia");
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedBoxX = entity.getPersistentData().getDouble("BoxX");
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedBoxY = entity.getPersistentData().getDouble("BoxY");
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.ObservedBoxZ = entity.getPersistentData().getDouble("BoxZ");
				_vars.syncPlayerVariables(sourceentity);
			}
			{
				TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
				_vars.SavedName = entity.getDisplayName().getString();
				_vars.syncPlayerVariables(sourceentity);
			}
			if (entity.getPersistentData().getDouble("Protection") > 0) {
				{
					TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
					_vars.ObservedProtection = true;
					_vars.syncPlayerVariables(sourceentity);
				}
			} else {
				{
					TakesavillageModVariables.PlayerVariables _vars = sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES);
					_vars.ObservedProtection = false;
					_vars.syncPlayerVariables(sourceentity);
				}
			}
			if (sourceentity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(TakesavillageModMobEffects.MARK_OF_SUSPICION) || sourceentity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(TakesavillageModMobEffects.MARK_OF_TERROR)
					|| sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedFear > 19200 || sourceentity.getData(TakesavillageModVariables.PLAYER_VARIABLES).ObservedInsomnia > 8
					|| (ReturnLocalVillagerStateProcedure.execute(entity)).equals("Unhappy") || (ReturnLocalVillagerStateProcedure.execute(entity)).equals("Angry")) {
				TakesavillageMod.queueServerWork(1, () -> {
					if (sourceentity instanceof Player _player)
						_player.closeContainer();
				});
				TakesavillageMod.queueServerWork(2, () -> {
					if (sourceentity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("TradingBlockedGUI");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new TradingBlockedGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				});
			}
		}
	}
}
