
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.takesavillage.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.takesavillage.TakesavillageMod;

public class TakesavillageModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, TakesavillageMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> DEED_BOX_OPEN = REGISTRY.register("deed.box.open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("takesavillage", "deed.box.open")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEED_BOX_CLOSE = REGISTRY.register("deed.box.close", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("takesavillage", "deed.box.close")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEED_BOX_DEPOSIT = REGISTRY.register("deed.box.deposit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("takesavillage", "deed.box.deposit")));
}
