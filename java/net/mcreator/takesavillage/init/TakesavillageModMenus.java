
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.takesavillage.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.takesavillage.world.inventory.TradingBlockedGUIMenu;
import net.mcreator.takesavillage.world.inventory.DeedBoxInventoryMenu;
import net.mcreator.takesavillage.TakesavillageMod;

public class TakesavillageModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, TakesavillageMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<TradingBlockedGUIMenu>> TRADING_BLOCKED_GUI = REGISTRY.register("trading_blocked_gui", () -> IMenuTypeExtension.create(TradingBlockedGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DeedBoxInventoryMenu>> DEED_BOX_INVENTORY = REGISTRY.register("deed_box_inventory", () -> IMenuTypeExtension.create(DeedBoxInventoryMenu::new));
}
