package com.sulvic.voidbreak.client.gui;

import static org.lwjgl.opengl.GL11.*;

import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.sulvic.mcf.util.Incomplete;
import com.sulvic.mcf.util.ZimedaMath;
import com.sulvic.voidbreak.ReferenceVB;
import com.sulvic.voidbreak.level.container.ContainerSpecialWorkbench;
import com.sulvic.voidbreak.level.tileentity.TileSpecialWorkbench;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiSpecialWorkbench extends GuiContainer{

	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(ReferenceVB.MODID, "textures/gui/special_workbench.png");
	private ContainerSpecialWorkbench containerWorkbench;
	private boolean isScrolling = false, canScroll = false;
	private GuiTextField searchField;
	private float currentScroll = 0f;
	private TileSpecialWorkbench specialWorkbench;

	public GuiSpecialWorkbench(InventoryPlayer playerInv, TileSpecialWorkbench workbench){
		super(new ContainerSpecialWorkbench(playerInv, workbench));
		containerWorkbench = (ContainerSpecialWorkbench)inventorySlots;
		specialWorkbench = workbench;
		xSize = 226;
		ySize = 212;
	}

	private void updateSearch(){
		specialWorkbench.setTargetItemName(searchField.getText());
		specialWorkbench.updateCraftableItems(mc.thePlayer);
		containerWorkbench.updateDisplaySlots();
	}

	@Override
	protected void handleMouseClick(Slot slot, int slotIndex, int clientState, int par){
		super.handleMouseClick(slot, slotIndex, clientState, par);
		ItemStack toCraft = slot.getStack();
		if(toCraft == null || toCraft.getItem() == null) return;
		boolean batchCraft = GuiScreen.isShiftKeyDown();
		containerWorkbench.craftItem(mc.thePlayer, toCraft, batchCraft);
	}

	@Override
	protected void mouseClickMove(int mouseX, int mouseY, int btnId, long lastClickTime){
		if(canScroll){
			if(isScrolling){
				int minY = guiTop + 26, maxY = minY + 88;
				currentScroll = ((float)(mouseY - minY) - 7.5f) / ((float)(maxY - minY) - 15f);
				currentScroll = ZimedaMath.clampFloat(currentScroll, 0f, 1f);
				containerWorkbench.scrollTo(currentScroll);
			}
		}
		super.mouseClickMove(mouseX, mouseY, btnId, lastClickTime);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int btn){
		super.mouseClicked(mouseX, mouseY, btn);
		searchField.mouseClicked(mouseX, mouseY, btn);
		int scrollbarX = guiLeft + 206, scrollbarY = guiTop + 26;
		if(mouseX > scrollbarX && mouseX < scrollbarX + 12 && mouseY >= scrollbarY && mouseY < scrollbarY + 88) isScrolling = true;
	}

	@Override
	protected void mouseMovedOrUp(int mouseX, int mouseY, int state){
		super.mouseMovedOrUp(mouseX, mouseY, state);
		isScrolling = false;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
		glPushMatrix();
		glColor4f(1f, 1f, 1f, 1f);
		mc.getTextureManager().bindTexture(GUI_TEXTURE);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int minScrollY = guiTop + 26;
		int maxScrollY = minScrollY + 88;
		int scrollThumbY = minScrollY + (int)((maxScrollY - minScrollY - 15) * currentScroll);
		drawTexturedModalRect(guiLeft + 206, scrollThumbY, 226, canScroll? 0: 15, 12, 15);
		glPopMatrix();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int clientX, int clientY){
		String tileName = specialWorkbench.getInventoryName();
		if(!specialWorkbench.hasCustomInventoryName()) tileName = I18n.format(tileName, new Object[0]);
		fontRendererObj.drawString(tileName, 7, 12, 0x404040);
		fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 32, 116, 0x404040);
	}

	@Override
	public void handleMouseInput(){
		super.handleMouseInput();
		int dWheel = Mouse.getEventDWheel();
		if(dWheel != 0){
			int maxRows = Math.max(0, containerWorkbench.getCraftableItems().size() - 55);
			if(maxRows > 0){
				currentScroll = currentScroll - (float)dWheel / 120f / (float)maxRows;
				currentScroll = ZimedaMath.clampFloat(currentScroll, 0f, 1f);
				containerWorkbench.scrollTo(currentScroll);
			}
		}
	}

	@Override
	protected void keyTyped(char ch, int code){
		if(searchField.textboxKeyTyped(ch, code)) updateSearch();
		else super.keyTyped(ch, code);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		super.drawScreen(mouseX, mouseY, partialTicks);
		searchField.drawTextBox();
	}

	@Override
	public void initGui(){
		super.initGui();
		Keyboard.enableRepeatEvents(true);
		searchField = new GuiTextField(fontRendererObj, guiLeft + 116, guiTop + 10, 102, 14);
		searchField.setMaxStringLength(32);
		searchField.setEnableBackgroundDrawing(false);
		searchField.setTextColor(0xFFFFFF);
		searchField.setVisible(false);
		searchField.setText("");
	}

	@Override
	public void onGuiClosed(){
		Keyboard.enableRepeatEvents(false);
		super.onGuiClosed();
	}

	@Override
	@Incomplete
	public void updateScreen(){
		List<ItemStack> craftables = specialWorkbench.getCraftableItems();
		canScroll = craftables.size() > 55;
		super.updateScreen();
		// TODO: Render craftable items based on scroll wheel position.
	}

}
