package net.mcreator.takesavillage.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

public class VillagerNormalGiftProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double randymcranderton = 0;
		if (Math.random() < 0.05) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(), new ItemStack(Items.BOOK), 20,
						(true)
								? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
								: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
						.copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
		} else if (Math.random() < 0.05) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(),
						new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:villager_enchanted_gifts"))).getRandomElement(RandomSource.create())
								.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())),
						20,
						(true)
								? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
								: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
						.copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
		} else if (Math.random() < 0.2) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(
						(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:villager_normal_gifts"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
						.copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
		} else {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:villager_normal_gifts_bulk"))).getRandomElement(RandomSource.create())
						.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())).copy();
				_setstack.setCount(Mth.nextInt(RandomSource.create(), 5, 15));
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
		}
	}
}
