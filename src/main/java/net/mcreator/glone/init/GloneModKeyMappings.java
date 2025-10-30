/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.glone.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.glone.network.TeleportMessage;
import net.mcreator.glone.network.OpendebugMessage;
import net.mcreator.glone.GloneMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class GloneModKeyMappings {
	public static final KeyMapping TELEPORT = new KeyMapping("key.glone.teleport", GLFW.GLFW_KEY_X, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				GloneMod.PACKET_HANDLER.sendToServer(new TeleportMessage(0, 0));
				TeleportMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPENDEBUG = new KeyMapping("key.glone.opendebug", GLFW.GLFW_KEY_PERIOD, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				GloneMod.PACKET_HANDLER.sendToServer(new OpendebugMessage(0, 0));
				OpendebugMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(TELEPORT);
		event.register(OPENDEBUG);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				TELEPORT.consumeClick();
				OPENDEBUG.consumeClick();
			}
		}
	}
}