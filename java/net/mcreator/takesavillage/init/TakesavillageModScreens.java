
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.takesavillage.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.takesavillage.client.gui.TradingBlockedGUIScreen;
import net.mcreator.takesavillage.client.gui.DeedBoxInventoryScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TakesavillageModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(TakesavillageModMenus.TRADING_BLOCKED_GUI.get(), TradingBlockedGUIScreen::new);
		event.register(TakesavillageModMenus.DEED_BOX_INVENTORY.get(), DeedBoxInventoryScreen::new);
	}
}
