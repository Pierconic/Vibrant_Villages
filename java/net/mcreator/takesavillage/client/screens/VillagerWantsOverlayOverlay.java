
package net.mcreator.takesavillage.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.takesavillage.procedures.TerrorCheckProcedure;
import net.mcreator.takesavillage.procedures.TerribleMobilityCheckProcedure;
import net.mcreator.takesavillage.procedures.TerribleHealthCheckProcedure;
import net.mcreator.takesavillage.procedures.ReturnBoxPositionProcedure;
import net.mcreator.takesavillage.procedures.ProtectedCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileWoundedCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileUnhappyCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileTiredCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileSuspiciousCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileRelievedCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileNeutralCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileMiffedCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileJoyfulCheckProcedure;
import net.mcreator.takesavillage.procedures.ProfileHappyCheckProcedure;
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

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@EventBusSubscriber({Dist.CLIENT})
public class VillagerWantsOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(ScreenEvent.Render.Post event) {
		if (event.getScreen() instanceof MerchantScreen) {
			int w = event.getGuiGraphics().guiWidth();
			int h = event.getGuiGraphics().guiHeight();
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level();
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (true) {
				if (ProfileNeutralCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_alright.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_bar.png"), w / 2 + 107, h / 2 + -59, 0, 0, 22, 16, 22, 16);

				if (ExceptionalDecorumCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/decorum_full.png"), w / 2 + 107, h / 2 + -48, 0, 0, 11, 11, 11, 11);
				}
				if (GoodHydrationCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/hydration_full.png"), w / 2 + 107, h / 2 + -37, 0, 0, 11, 11, 11, 11);
				}
				if (FearlessCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/fear_good.png"), w / 2 + 118, h / 2 + -37, 0, 0, 11, 11, 11, 11);
				}
				if (FriendshipExceptionalCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_full.png"), w / 2 + 107, h / 2 + -25, 0, 0, 11, 11, 11, 11);
				}
				if (NeutralMobilityCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/mobility_good.png"), w / 2 + 119, h / 2 + -25, 0, 0, 11, 11, 11, 11);
				}
				if (GoodDecorumCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/decorum_good.png"), w / 2 + 107, h / 2 + -48, 0, 0, 11, 11, 11, 11);
				}
				if (NeutralDecorumCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/decorum_neutral.png"), w / 2 + 107, h / 2 + -48, 0, 0, 11, 11, 11, 11);
				}
				if (BadDecorumCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/decorum_bad.png"), w / 2 + 107, h / 2 + -48, 0, 0, 11, 11, 11, 11);
				}
				if (NeutralHydrationCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/hydration_neutral.png"), w / 2 + 107, h / 2 + -37, 0, 0, 11, 11, 11, 11);
				}
				if (BadHydrationCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/hydration_bad.png"), w / 2 + 107, h / 2 + -37, 0, 0, 11, 11, 11, 11);
				}
				if (ExceptionalHealthCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/great_health.png"), w / 2 + 118, h / 2 + -47, 0, 0, 11, 11, 11, 11);
				}
				if (GoodHealthCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/good_health.png"), w / 2 + 118, h / 2 + -47, 0, 0, 11, 11, 11, 11);
				}
				if (BadHealthCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/bad_health.png"), w / 2 + 118, h / 2 + -47, 0, 0, 11, 11, 11, 11);
				}
				if (TerribleHealthCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/terrible_health.png"), w / 2 + 118, h / 2 + -47, 0, 0, 11, 11, 11, 11);
				}
				if (FearCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/fear_bad.png"), w / 2 + 118, h / 2 + -37, 0, 0, 11, 11, 11, 11);
				}
				if (TerrorCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/fear_extreme.png"), w / 2 + 118, h / 2 + -37, 0, 0, 11, 11, 11, 11);
				}
				if (FriendshipGoodCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_good.png"), w / 2 + 107, h / 2 + -25, 0, 0, 11, 11, 11, 11);
				}
				if (FriendshipBadCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_neutral.png"), w / 2 + 107, h / 2 + -25, 0, 0, 11, 11, 11, 11);
				}
				if (FriendshipTerribleCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_bad.png"), w / 2 + 107, h / 2 + -24, 0, 0, 11, 11, 11, 11);
				}
				if (FriendshipStiflingCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_extreme.png"), w / 2 + 107, h / 2 + -25, 0, 0, 11, 11, 11, 11);
				}
				if (FriendshipOverloadCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/friendship_terrible.png"), w / 2 + 107, h / 2 + -25, 0, 0, 11, 11, 11, 11);
				}
				if (ProtectedCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/fear_protected.png"), w / 2 + 118, h / 2 + -36, 0, 0, 11, 11, 11, 11);
				}
				event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/villager_cord.png"), w / 2 + 30, h / 2 + -14, 0, 0, 11, 11, 11, 11);

				if (ProfileAghastCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_aghast.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileAngryCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_angry.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileHappyCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_happy.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileJoyfulCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_joyful.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileMiffedCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_miffed.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileRelievedCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_relieved.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileSuspiciousCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_suspicious.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileTiredCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_tired.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileUnhappyCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_unhappy.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ProfileWoundedCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/profile_wounded.png"), w / 2 + 112, h / 2 + -82, 0, 0, 16, 22, 16, 22);
				}
				if (ExceptionalMobilityCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/mobility_exceptional.png"), w / 2 + 119, h / 2 + -25, 0, 0, 11, 11, 11, 11);
				}
				if (TerribleMobilityCheckProcedure.execute(entity)) {
					event.getGuiGraphics().blit(ResourceLocation.parse("takesavillage:textures/screens/mobility_bad.png"), w / 2 + 119, h / 2 + -25, 0, 0, 11, 11, 11, 11);
				}
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						ReturnBoxPositionProcedure.execute(entity), w / 2 + 44, h / 2 + -12, -1, false);
			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
