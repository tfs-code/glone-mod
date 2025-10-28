package net.mcreator.glone.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.glone.network.GloneModVariables;
import net.mcreator.glone.GloneMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlocksBrokenCountProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player == true) {
			{
				double _setval = (entity.getCapability(GloneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GloneModVariables.PlayerVariables())).BlocksBroken + 1;
				entity.getCapability(GloneModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlocksBroken = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			GloneMod.LOGGER.info((entity.getCapability(GloneModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new GloneModVariables.PlayerVariables())).BlocksBroken);
		}
	}
}