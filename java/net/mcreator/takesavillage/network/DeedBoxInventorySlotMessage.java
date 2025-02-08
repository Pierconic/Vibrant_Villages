
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
import net.mcreator.takesavillage.procedures.GrantLodgingAdvancementProcedure;
import net.mcreator.takesavillage.TakesavillageMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record DeedBoxInventorySlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {

	public static final Type<DeedBoxInventorySlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(TakesavillageMod.MODID, "deed_box_inventory_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, DeedBoxInventorySlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DeedBoxInventorySlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new DeedBoxInventorySlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<DeedBoxInventorySlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final DeedBoxInventorySlotMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = DeedBoxInventoryMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 1) {

			GrantLodgingAdvancementProcedure.execute(entity);
		}
		if (slot == 0 && changeType == 2) {
			int amount = meta;

			GrantLodgingAdvancementProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TakesavillageMod.addNetworkMessage(DeedBoxInventorySlotMessage.TYPE, DeedBoxInventorySlotMessage.STREAM_CODEC, DeedBoxInventorySlotMessage::handleData);
	}
}
