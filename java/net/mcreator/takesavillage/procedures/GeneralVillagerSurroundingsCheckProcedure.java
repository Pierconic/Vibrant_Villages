package net.mcreator.takesavillage.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.takesavillage.init.TakesavillageModMobEffects;

public class GeneralVillagerSurroundingsCheckProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState target_block = Blocks.AIR.defaultBlockState();
		boolean hydrated = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double decorum = 0;
		double bookshelves = 0;
		double candles = 0;
		double flora = 0;
		double other = 0;
		double initial_decorum = 0;
		double initial_hydration = 0;
		sx = -5;
		for (int index0 = 0; index0 < 11; index0++) {
			sy = -2;
			for (int index1 = 0; index1 < 5; index1++) {
				sz = -5;
				for (int index2 = 0; index2 < 11; index2++) {
					target_block = (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)));
					if (target_block.is(BlockTags.create(ResourceLocation.parse("forge:decorative"))) || target_block.is(BlockTags.create(ResourceLocation.parse("forge:alternate_decorative")))) {
						if (bookshelves < 3 && (target_block.getBlock() == Blocks.BOOKSHELF || target_block.getBlock() == Blocks.CHISELED_BOOKSHELF)) {
							bookshelves = bookshelves + 1;
						} else if (candles < 3 && target_block.is(BlockTags.create(ResourceLocation.parse("minecraft:candles")))) {
							candles = candles + 1;
						} else if (flora < 3 && target_block.is(BlockTags.create(ResourceLocation.parse("forge:floral_decor")))) {
							flora = flora + 1;
						} else if (other < 3 && !(target_block.getBlock() == Blocks.BOOKSHELF || target_block.getBlock() == Blocks.CHISELED_BOOKSHELF) && !target_block.is(BlockTags.create(ResourceLocation.parse("forge:floral_decor")))
								&& !target_block.is(BlockTags.create(ResourceLocation.parse("minecraft:candles")))) {
							other = other + 1;
						}
					} else if (target_block.getBlock().getStateDefinition().getProperty("waterlogged") instanceof BooleanProperty _getbp11 && target_block.getValue(_getbp11) || target_block.getBlock() == Blocks.WATER
							|| target_block.getBlock() == Blocks.WATER || target_block.getBlock() == Blocks.BUBBLE_COLUMN || target_block.getBlock() == Blocks.WATER_CAULDRON) {
						hydrated = true;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (!world.getEntitiesOfClass(Painting.class, AABB.ofSize(new Vec3(x, y, z), 12, 12, 12), e -> true).isEmpty()) {
			other = other + 2;
		}
		decorum = Math.min(10, bookshelves + candles + flora + other);
		entity.getPersistentData().putDouble("Decorum", (entity.getPersistentData().getDouble("Decorum") - 1));
		if (decorum > entity.getPersistentData().getDouble("Decorum")) {
			entity.getPersistentData().putDouble("Decorum", (entity.getPersistentData().getDouble("Decorum") + decorum));
		} else if (decorum >= 7) {
			entity.getPersistentData().putDouble("Decorum", (entity.getPersistentData().getDouble("Decorum") + 2));
		}
		if (entity.getPersistentData().getDouble("Decorum") > 25) {
			entity.getPersistentData().putDouble("Decorum", 25);
		} else if (entity.getPersistentData().getDouble("Decorum") < 0) {
			entity.getPersistentData().putDouble("Decorum", 0);
		}
		if (hydrated) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TakesavillageModMobEffects.HYDRATION);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TakesavillageModMobEffects.HYDRATION, 18000, 0, false, false));
		}
	}
}
