package net.mcreator.takesavillage.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class RandomNameGeneratorPartDeuxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double name_seed = 0;
		String Secret_Name = "";
		if (Math.random() < 0.5) {
			if (Math.random() < 0.01) {
				name_seed = Mth.nextInt(RandomSource.create(), 1, 16);
				Secret_Name = Component.translatable(("villager.name.rare.m.x".replace("x", new java.text.DecimalFormat("###").format(name_seed)))).getString();
			} else if (Math.random() < 0.1) {
				name_seed = Mth.nextInt(RandomSource.create(), 1, 24);
				Secret_Name = Component.translatable(("villager.name.uncommon.m.x".replace("x", new java.text.DecimalFormat("###").format(name_seed)))).getString();
			} else {
				name_seed = Mth.nextInt(RandomSource.create(), 1, 100);
				Secret_Name = Component.translatable(("villager.name.common.m.x".replace("x", new java.text.DecimalFormat("###").format(name_seed)))).getString();
			}
		} else {
			if (Math.random() < 0.01) {
				name_seed = Mth.nextInt(RandomSource.create(), 1, 16);
				Secret_Name = Component.translatable(("villager.name.rare.f.x".replace("x", new java.text.DecimalFormat("###").format(name_seed)))).getString();
			} else if (Math.random() < 0.1) {
				name_seed = Mth.nextInt(RandomSource.create(), 1, 24);
				Secret_Name = Component.translatable(("villager.name.uncommon.f.x".replace("x", new java.text.DecimalFormat("###").format(name_seed)))).getString();
			} else {
				name_seed = Mth.nextInt(RandomSource.create(), 1, 48);
				Secret_Name = Component.translatable(("villager.name.common.f.x".replace("x", new java.text.DecimalFormat("###").format(name_seed)))).getString();
			}
		}
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					("/data merge entity @e[type=villager,sort=nearest,limit=1] {CustomName:'{\"text\":\"Testificate\"}'}".replace("Testificate", Secret_Name)));
	}
}
