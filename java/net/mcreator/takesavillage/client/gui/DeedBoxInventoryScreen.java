package net.mcreator.takesavillage.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.takesavillage.world.inventory.DeedBoxInventoryMenu;
import net.mcreator.takesavillage.procedures.TerrorCheckProcedure;
import net.mcreator.takesavillage.procedures.TerribleMobilityCheckProcedure;
import net.mcreator.takesavillage.procedures.TerribleHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.ShowDismissalTabProcedure;
import net.mcreator.takesavillage.procedures.ReversedCheckBoxBlockerProcedure;
import net.mcreator.takesavillage.procedures.ReturnDismissalWarningProcedure;
import net.mcreator.takesavillage.procedures.ReturnDeedBoxOwnerProcedure;
import net.mcreator.takesavillage.procedures.ProtectedCheckProcedure;
import net.mcreator.takesavillage.procedures.NeutralMobilityCheckProcedure;
import net.mcreator.takesavillage.procedures.NeutralHydrationCheckProcedure;
import net.mcreator.takesavillage.procedures.NeutralDecorumCheckProcedure;
import net.mcreator.takesavillage.procedures.MobilityDescriptionProcedure;
import net.mcreator.takesavillage.procedures.HydrationDescriptionProcedure;
import net.mcreator.takesavillage.procedures.HealthDescriptionProcedure;
import net.mcreator.takesavillage.procedures.GoodHydrationCheckProcedure;
import net.mcreator.takesavillage.procedures.GoodHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.GoodDecorumCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipTerribleCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipStiflingCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipOverloadCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipGoodCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipExceptionalCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipDescriptionProcedure;
import net.mcreator.takesavillage.procedures.FriendshipBadCheckProcedure;
import net.mcreator.takesavillage.procedures.FearlessCheckProcedure;
import net.mcreator.takesavillage.procedures.FearDescriptionProcedure;
import net.mcreator.takesavillage.procedures.FearCheckProcedure;
import net.mcreator.takesavillage.procedures.ExceptionalMobilityCheckProcedure;
import net.mcreator.takesavillage.procedures.ExceptionalHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.ExceptionalDecorumCheckProcedure;
import net.mcreator.takesavillage.procedures.DecorumDescriptionProcedure;
import net.mcreator.takesavillage.procedures.CheckBoxBlockerProcedure;
import net.mcreator.takesavillage.procedures.BadHydrationCheckProcedure;
import net.mcreator.takesavillage.procedures.BadHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.BadDecorumCheckProcedure;
import net.mcreator.takesavillage.network.DeedBoxInventoryButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DeedBoxInventoryScreen extends AbstractContainerScreen<DeedBoxInventoryMenu> {
	private final static HashMap<String, Object> guistate = DeedBoxInventoryMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_dismiss;
	ImageButton imagebutton_dismiss_normal;
	ImageButton imagebutton_summon_normal;

	public DeedBoxInventoryScreen(DeedBoxInventoryMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (ShowDismissalTabProcedure.execute(entity))
			if (mouseX > leftPos + 51 && mouseX < leftPos + 75 && mouseY > topPos + 28 && mouseY < topPos + 52)
				guiGraphics.renderTooltip(font, Component.literal(ReturnDismissalWarningProcedure.execute(world, x, y, z)), mouseX, mouseY);
		if (ReversedCheckBoxBlockerProcedure.execute(world, x, y, z, entity))
			if (mouseX > leftPos + 8 && mouseX < leftPos + 32 && mouseY > topPos + 12 && mouseY < topPos + 36)
				guiGraphics.renderTooltip(font, Component.literal(DecorumDescriptionProcedure.execute(world, x, y, z, entity)), mouseX, mouseY);
		if (ReversedCheckBoxBlockerProcedure.execute(world, x, y, z, entity))
			if (mouseX > leftPos + 7 && mouseX < leftPos + 31 && mouseY > topPos + 36 && mouseY < topPos + 60)
				guiGraphics.renderTooltip(font, Component.literal(HydrationDescriptionProcedure.execute(world, x, y, z, entity)), mouseX, mouseY);
		if (ReversedCheckBoxBlockerProcedure.execute(world, x, y, z, entity))
			if (mouseX > leftPos + 7 && mouseX < leftPos + 31 && mouseY > topPos + 60 && mouseY < topPos + 84)
				guiGraphics.renderTooltip(font, Component.literal(FriendshipDescriptionProcedure.execute(world, x, y, z, entity)), mouseX, mouseY);
		if (ReversedCheckBoxBlockerProcedure.execute(world, x, y, z, entity))
			if (mouseX > leftPos + 60 && mouseX < leftPos + 84 && mouseY > topPos + 20 && mouseY < topPos + 44)
				guiGraphics.renderTooltip(font, Component.literal(HealthDescriptionProcedure.execute(world, x, y, z, entity)), mouseX, mouseY);
		if (ReversedCheckBoxBlockerProcedure.execute(world, x, y, z, entity))
			if (mouseX > leftPos + 60 && mouseX < leftPos + 84 && mouseY > topPos + 38 && mouseY < topPos + 62)
				guiGraphics.renderTooltip(font, Component.literal(FearDescriptionProcedure.execute(world, x, y, z, entity)), mouseX, mouseY);
		if (ReversedCheckBoxBlockerProcedure.execute(world, x, y, z, entity))
			if (mouseX > leftPos + 60 && mouseX < leftPos + 84 && mouseY > topPos + 61 && mouseY < topPos + 85)
				guiGraphics.renderTooltip(font, Component.literal(MobilityDescriptionProcedure.execute(world, x, y, z, entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_inventory_back.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		if (ExceptionalDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_decorated.png"), this.leftPos + 8, this.topPos + 23, 0, 0, 18, 18, 18, 18);
		}
		if (GoodDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_spiffy.png"), this.leftPos + 8, this.topPos + 23, 0, 0, 18, 18, 18, 18);
		}
		if (NeutralDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_plain.png"), this.leftPos + 8, this.topPos + 23, 0, 0, 18, 18, 18, 18);
		}
		if (BadDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_boring.png"), this.leftPos + 8, this.topPos + 23, 0, 0, 18, 18, 18, 18);
		}
		if (GoodHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_hydrated.png"), this.leftPos + 8, this.topPos + 40, 0, 0, 18, 18, 18, 18);
		}
		if (NeutralHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_wet.png"), this.leftPos + 8, this.topPos + 40, 0, 0, 18, 18, 18, 18);
		}
		if (BadHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_thirsty.png"), this.leftPos + 8, this.topPos + 40, 0, 0, 18, 18, 18, 18);
		}
		if (FriendshipExceptionalCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_friendly.png"), this.leftPos + 9, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (FriendshipGoodCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_alright.png"), this.leftPos + 9, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (FriendshipBadCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_lonely.png"), this.leftPos + 9, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (FriendshipTerribleCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_despondent.png"), this.leftPos + 9, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (FriendshipStiflingCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_stifled.png"), this.leftPos + 9, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (FriendshipOverloadCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_overwhelmed.png"), this.leftPos + 9, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (TerribleHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_critical.png"), this.leftPos + 63, this.topPos + 24, 0, 0, 18, 18, 18, 18);
		}
		if (BadHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_wounded.png"), this.leftPos + 63, this.topPos + 24, 0, 0, 18, 18, 18, 18);
		}
		if (GoodHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_hurt.png"), this.leftPos + 63, this.topPos + 24, 0, 0, 18, 18, 18, 18);
		}
		if (ExceptionalHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_healthy.png"), this.leftPos + 63, this.topPos + 24, 0, 0, 18, 18, 18, 18);
		}
		if (ProtectedCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_protected.png"), this.leftPos + 64, this.topPos + 41, 0, 0, 18, 18, 18, 18);
		}
		if (FearlessCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_anxious.png"), this.leftPos + 63, this.topPos + 40, 0, 0, 18, 18, 18, 18);
		}
		if (FearCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_frightened.png"), this.leftPos + 64, this.topPos + 40, 0, 0, 18, 18, 18, 18);
		}
		if (TerrorCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_terrified.png"), this.leftPos + 64, this.topPos + 40, 0, 0, 18, 18, 18, 18);
		}
		if (ExceptionalMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_excercised.png"), this.leftPos + 66, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (NeutralMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_walking.png"), this.leftPos + 66, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (TerribleMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_stuck.png"), this.leftPos + 66, this.topPos + 58, 0, 0, 18, 18, 18, 18);
		}
		if (ExceptionalDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 27, this.topPos + 28, 0, 0, 31, 9, 31, 9);
		}
		if (GoodDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 27, this.topPos + 28, 0, 0, 31, 9, 31, 9);
		}
		if (NeutralDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_yellow.png"), this.leftPos + 27, this.topPos + 28, 0, 0, 31, 9, 31, 9);
		}
		if (BadDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_red.png"), this.leftPos + 27, this.topPos + 28, 0, 0, 31, 9, 31, 9);
		}
		if (GoodHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 26, this.topPos + 45, 0, 0, 31, 9, 31, 9);
		}
		if (NeutralHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_yellow.png"), this.leftPos + 26, this.topPos + 45, 0, 0, 31, 9, 31, 9);
		}
		if (BadHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_red.png"), this.leftPos + 26, this.topPos + 45, 0, 0, 31, 9, 31, 9);
		}
		if (FriendshipExceptionalCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 26, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (FriendshipGoodCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 26, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (FriendshipStiflingCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_yellow.png"), this.leftPos + 26, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (FriendshipBadCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_yellow.png"), this.leftPos + 26, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (FriendshipOverloadCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_red.png"), this.leftPos + 26, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (FriendshipTerribleCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_red.png"), this.leftPos + 26, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (ExceptionalHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 83, this.topPos + 28, 0, 0, 31, 9, 31, 9);
		}
		if (GoodHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 83, this.topPos + 28, 0, 0, 31, 9, 31, 9);
		}
		if (BadHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_yellow.png"), this.leftPos + 83, this.topPos + 28, 0, 0, 31, 9, 31, 9);
		}
		if (TerribleHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_red.png"), this.leftPos + 83, this.topPos + 28, 0, 0, 31, 9, 31, 9);
		}
		if (ProtectedCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 83, this.topPos + 45, 0, 0, 31, 9, 31, 9);
		}
		if (FearlessCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 83, this.topPos + 45, 0, 0, 31, 9, 31, 9);
		}
		if (FearCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_yellow.png"), this.leftPos + 83, this.topPos + 45, 0, 0, 31, 9, 31, 9);
		}
		if (TerrorCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_red.png"), this.leftPos + 83, this.topPos + 45, 0, 0, 31, 9, 31, 9);
		}
		if (ExceptionalMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_green.png"), this.leftPos + 83, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (NeutralMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_yellow.png"), this.leftPos + 83, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (TerribleMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_red.png"), this.leftPos + 83, this.topPos + 61, 0, 0, 31, 9, 31, 9);
		}
		if (CheckBoxBlockerProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/deed_box_block.png"), this.leftPos + 8, this.topPos + 22, 0, 0, 115, 55, 115, 55);
		}
		if (ShowDismissalTabProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/dismissal_tab.png"), this.leftPos + 15, this.topPos + 23, 0, 0, 98, 48, 98, 48);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnDeedBoxOwnerProcedure.execute(world, x, y, z), 11, 13, -12829636, false);
		if (ShowDismissalTabProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.takesavillage.deed_box_inventory.label_dismiss_this_villager"), 19, 27, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_dismiss = Button.builder(Component.translatable("gui.takesavillage.deed_box_inventory.button_dismiss"), e -> {
			if (ShowDismissalTabProcedure.execute(entity)) {
				PacketDistributor.sendToServer(new DeedBoxInventoryButtonMessage(0, x, y, z));
				DeedBoxInventoryButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 26, this.topPos + 42, 76, 20).build(builder -> new Button(builder) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				this.visible = ShowDismissalTabProcedure.execute(entity);
				super.renderWidget(guiGraphics, gx, gy, ticks);
			}
		});
		guistate.put("button:button_dismiss", button_dismiss);
		this.addRenderableWidget(button_dismiss);
		imagebutton_dismiss_normal = new ImageButton(this.leftPos + 152, this.topPos + 29, 17, 29,
				new WidgetSprites(ResourceLocation.parse("takesavillage:textures/screens/dismiss_normal.png"), ResourceLocation.parse("takesavillage:textures/screens/dismiss_hovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DeedBoxInventoryButtonMessage(1, x, y, z));
						DeedBoxInventoryButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_dismiss_normal", imagebutton_dismiss_normal);
		this.addRenderableWidget(imagebutton_dismiss_normal);
		imagebutton_summon_normal = new ImageButton(this.leftPos + 133, this.topPos + 29, 17, 29,
				new WidgetSprites(ResourceLocation.parse("takesavillage:textures/screens/summon_normal.png"), ResourceLocation.parse("takesavillage:textures/screens/summon_hovered.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new DeedBoxInventoryButtonMessage(2, x, y, z));
						DeedBoxInventoryButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_summon_normal", imagebutton_summon_normal);
		this.addRenderableWidget(imagebutton_summon_normal);
	}
}
