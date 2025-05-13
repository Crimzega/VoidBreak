package com.sulvic.voidbreak.client.gui;

import static org.lwjgl.opengl.GL11.*;

import com.sulvic.voidbreak.ReferenceVB;
import com.sulvic.voidbreak.level.container.ContainerZechaDrawer;
import com.sulvic.voidbreak.level.tileentity.TileZechaDrawer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiZechaDrawer extends GuiContainer{

	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(ReferenceVB.MODID, "textures/gui/zecha_drawer.png");
	private TileZechaDrawer zechaDrawer;

	public GuiZechaDrawer(InventoryPlayer playerInv, TileZechaDrawer drawer){
		super(new ContainerZechaDrawer(playerInv, drawer));
		zechaDrawer = drawer;
		xSize = 238;
		ySize = 256;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int clientX, int clientZ){
		glPushMatrix();
		glColor4f(1f, 1f, 1f, 1f);
		mc.getTextureManager().bindTexture(GUI_TEXTURE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		glPopMatrix();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int clientX, int clientY){
		String tileName = zechaDrawer.getInventoryName();
		if(!zechaDrawer.hasCustomInventoryName()) tileName = I18n.format(tileName, new Object[0]);
		fontRendererObj.drawString(tileName, 12, 6, 0x404040);
		fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 39, 163, 0x404040);
	}

}
