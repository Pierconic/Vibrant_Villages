
package net.mcreator.takesavillage.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.takesavillage.world.inventory.DeedBoxInventoryMenu;
import net.mcreator.takesavillage.procedures.SummonButtonPressedProcedure;
import net.mcreator.takesavillage.procedures.DismissVillagerProcedure;
import net.mcreator.takesavillage.procedures.DismissTabOpenedProcedure;
import net.mcreator.takesavillage.TakesavillageMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record DeedBoxInventoryButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<DeedBoxInventoryButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TakesavillageMod.MODID, "deed_box_inventory_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, DeedBoxInventoryButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DeedBoxInventoryButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new DeedBoxInventoryButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<DeedBoxInventoryButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final DeedBoxInventoryButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = DeedBoxInventoryMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			DismissVillagerProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			DismissTabOpenedProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SummonButtonPressedProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TakesavillageMod.addNetworkMessage(DeedBoxInventoryButtonMessage.TYPE, DeedBoxInventoryButtonMessage.STREAM_CODEC, DeedBoxInventoryButtonMessage::handleData);
	}
}
