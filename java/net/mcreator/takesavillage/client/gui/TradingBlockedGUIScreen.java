package net.mcreator.takesavillage.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.takesavillage.world.inventory.TradingBlockedGUIMenu;
import net.mcreator.takesavillage.procedures.TroubleDescriptionProcedure;
import net.mcreator.takesavillage.procedures.TerrorCheckProcedure;
import net.mcreator.takesavillage.procedures.TerribleMobilityCheckProcedure;
import net.mcreator.takesavillage.procedures.TerribleHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.ReturnBoxPositionProcedure;
import net.mcreator.takesavillage.procedures.ReturnBlockedVillagerNamedProcedure;
import net.mcreator.takesavillage.procedures.ProtectedCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileUnhappyCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileTiredCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileSuspiciousCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileAngryCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileAghastCheckProcedure;
import net.mcreator.takesavillage.procedures.NeutralMobilityCheckProcedure;
import net.mcreator.takesavillage.procedures.NeutralHydrationCheckProcedure;
import net.mcreator.takesavillage.procedures.NeutralDecorumCheckProcedure;
import net.mcreator.takesavillage.procedures.GoodHydrationCheckProcedure;
import net.mcreator.takesavillage.procedures.GoodHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.GoodDecorumCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipTerribleCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipStiflingCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipOverloadCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipGoodCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipExceptionalCheckProcedure;
import net.mcreator.takesavillage.procedures.FriendshipBadCheckProcedure;
import net.mcreator.takesavillage.procedures.FearlessCheckProcedure;
import net.mcreator.takesavillage.procedures.FearCheckProcedure;
import net.mcreator.takesavillage.procedures.ExceptionalMobilityCheckProcedure;
import net.mcreator.takesavillage.procedures.ExceptionalHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.ExceptionalDecorumCheckProcedure;
import net.mcreator.takesavillage.procedures.BadHydrationCheckProcedure;
import net.mcreator.takesavillage.procedures.BadHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.BadDecorumCheckProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TradingBlockedGUIScreen extends AbstractContainerScreen<TradingBlockedGUIMenu> {
	private final static HashMap<String, Object> guistate = TradingBlockedGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public TradingBlockedGUIScreen(TradingBlockedGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("takesavillage:textures/screens/trading_blocked_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 133 && mouseX < leftPos + 157 && mouseY > topPos + 34 && mouseY < topPos + 58)
			guiGraphics.renderTooltip(font, Component.literal(TroubleDescriptionProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/angry_villager_interface.png"), this.leftPos + -51, this.topPos + 0, 0, 0, 276, 166, 276, 166);

		guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/profile_bar_negative.png"), this.leftPos + 198, this.topPos + 24, 0, 0, 22, 16, 22, 16);

		guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/villager_cord_negative.png"), this.leftPos + 122, this.topPos + 70, 0, 0, 11, 11, 11, 11);

		if (TerrorCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/profile_aghast.png"), this.leftPos + 203, this.topPos + 0, 0, 0, 16, 22, 16, 22);
		}
		if (ExceptionalDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/decorum_full.png"), this.leftPos + 194, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (ProfileTiredCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/profile_tired.png"), this.leftPos + 203, this.topPos + 0, 0, 0, 16, 22, 16, 22);
		}
		if (TerribleHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/profile_wounded.png"), this.leftPos + 203, this.topPos + 0, 0, 0, 16, 22, 16, 22);
		}
		if (ProfileUnhappyCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/profile_unhappy.png"), this.leftPos + 203, this.topPos + 0, 0, 0, 16, 22, 16, 22);
		}
		if (GoodDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/decorum_good.png"), this.leftPos + 194, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (NeutralDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/decorum_neutral.png"), this.leftPos + 194, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (BadDecorumCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/decorum_bad.png"), this.leftPos + 194, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (GoodHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/hydration_full.png"), this.leftPos + 194, this.topPos + 46, 0, 0, 11, 11, 11, 11);
		}
		if (NeutralHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/hydration_neutral.png"), this.leftPos + 194, this.topPos + 46, 0, 0, 11, 11, 11, 11);
		}
		if (BadHydrationCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/hydration_bad.png"), this.leftPos + 194, this.topPos + 46, 0, 0, 11, 11, 11, 11);
		}
		if (FriendshipOverloadCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_terrible.png"), this.leftPos + 194, this.topPos + 58, 0, 0, 11, 11, 11, 11);
		}
		if (FriendshipStiflingCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_extreme.png"), this.leftPos + 194, this.topPos + 58, 0, 0, 11, 11, 11, 11);
		}
		if (FriendshipExceptionalCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_full.png"), this.leftPos + 194, this.topPos + 58, 0, 0, 11, 11, 11, 11);
		}
		if (FriendshipGoodCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_good.png"), this.leftPos + 194, this.topPos + 58, 0, 0, 11, 11, 11, 11);
		}
		if (FriendshipBadCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_neutral.png"), this.leftPos + 194, this.topPos + 58, 0, 0, 11, 11, 11, 11);
		}
		if (FriendshipTerribleCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_bad.png"), this.leftPos + 194, this.topPos + 59, 0, 0, 11, 11, 11, 11);
		}
		if (ExceptionalHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/great_health.png"), this.leftPos + 207, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (TerribleHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/terrible_health.png"), this.leftPos + 207, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (ExceptionalHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/great_health.png"), this.leftPos + 207, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (GoodHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/good_health.png"), this.leftPos + 207, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (BadHealthCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/bad_health.png"), this.leftPos + 207, this.topPos + 35, 0, 0, 11, 11, 11, 11);
		}
		if (ProtectedCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/fear_protected.png"), this.leftPos + 207, this.topPos + 47, 0, 0, 11, 11, 11, 11);
		}
		if (FearCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/fear_bad.png"), this.leftPos + 207, this.topPos + 46, 0, 0, 11, 11, 11, 11);
		}
		if (FearlessCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/fear_good.png"), this.leftPos + 207, this.topPos + 46, 0, 0, 11, 11, 11, 11);
		}
		if (TerrorCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/fear_extreme.png"), this.leftPos + 207, this.topPos + 46, 0, 0, 11, 11, 11, 11);
		}
		if (TerribleMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/mobility_bad.png"), this.leftPos + 207, this.topPos + 59, 0, 0, 11, 11, 11, 11);
		}
		if (NeutralMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/mobility_good.png"), this.leftPos + 207, this.topPos + 59, 0, 0, 11, 11, 11, 11);
		}
		if (ExceptionalMobilityCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/mobility_exceptional.png"), this.leftPos + 207, this.topPos + 59, 0, 0, 11, 11, 11, 11);
		}
		if (ProfileSuspiciousCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/profile_suspicious.png"), this.leftPos + 203, this.topPos + 0, 0, 0, 16, 22, 16, 22);
		}
		if (ProfileAghastCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/profile_aghast.png"), this.leftPos + 203, this.topPos + 0, 0, 0, 16, 22, 16, 22);
		}
		if (ProfileAngryCheckProcedure.execute(entity)) {
			guiGraphics.blit(ResourceLocation.parse("takesavillage:textures/screens/profile_angry.png"), this.leftPos + 203, this.topPos + 0, 0, 0, 16, 22, 16, 22);
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

				ReturnBlockedVillagerNamedProcedure.execute(entity), 95, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnBoxPositionProcedure.execute(entity), 134, 72, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.takesavillage.trading_blocked_gui.label_inventory"), 57, 72, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
