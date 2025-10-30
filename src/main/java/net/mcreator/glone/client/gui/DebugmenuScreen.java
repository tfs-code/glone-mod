package net.mcreator.glone.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.glone.world.inventory.DebugmenuMenu;
import net.mcreator.glone.network.DebugmenuButtonMessage;
import net.mcreator.glone.init.GloneModScreens;
import net.mcreator.glone.GloneMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class DebugmenuScreen extends AbstractContainerScreen<DebugmenuMenu> implements GloneModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_overworld;
	Button button_afterlife;

	public DebugmenuScreen(DebugmenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("glone:textures/screens/debugmenu.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	}

	@Override
	public void init() {
		super.init();
		button_overworld = Button.builder(Component.translatable("gui.glone.debugmenu.button_overworld"), e -> {
			int x = DebugmenuScreen.this.x;
			int y = DebugmenuScreen.this.y;
			if (true) {
				GloneMod.PACKET_HANDLER.sendToServer(new DebugmenuButtonMessage(0, x, y, z));
				DebugmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 17, this.topPos + 16, 72, 20).build();
		this.addRenderableWidget(button_overworld);
		button_afterlife = Button.builder(Component.translatable("gui.glone.debugmenu.button_afterlife"), e -> {
			int x = DebugmenuScreen.this.x;
			int y = DebugmenuScreen.this.y;
			if (true) {
				GloneMod.PACKET_HANDLER.sendToServer(new DebugmenuButtonMessage(1, x, y, z));
				DebugmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 18, this.topPos + 43, 72, 20).build();
		this.addRenderableWidget(button_afterlife);
	}
}