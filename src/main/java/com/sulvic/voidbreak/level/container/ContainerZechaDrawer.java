package com.sulvic.voidbreak.level.container;

import com.sulvic.voidbreak.level.tileentity.TileZechaDrawer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerZechaDrawer extends Container{

	private TileZechaDrawer zechaDrawer;

	public ContainerZechaDrawer(InventoryPlayer playerInv, TileZechaDrawer drawer){
		zechaDrawer = drawer;
		drawer.openInventory();
		for(int y = 0; y < 8; y++) for(int x = 0; x < 12; x++) addSlotToContainer(new Slot(drawer, x + y * 12, 12 + x * 18, 17 + y * 18));
		for(int y = 0; y < 3; y++) for(int x = 0; x < 9; x++) addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 39 + x * 18, 174 + y * 18));
		for(int x = 0; x < 9; x++) addSlotToContainer(new Slot(playerInv, x, 39 + x * 18, 232));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){ return zechaDrawer.isUseableByPlayer(player); }

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index){
		ItemStack stack = null;
		Slot slot = (Slot)inventorySlots.get(index);
		if(slot != null && slot.getHasStack()){
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			int invSize = zechaDrawer.getSizeInventory();
			if(index < invSize) if(!mergeItemStack(stack1, invSize, inventorySlots.size(), true)) return null;
			else if(!mergeItemStack(stack1, 0, invSize, false)) return null;
			if(stack1.stackSize == 0) slot.putStack(null);
			else slot.onSlotChanged();
			if(stack1.stackSize == stack.stackSize) return null;
			slot.onPickupFromSlot(player, stack1);
		}
		return stack;
	}

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
		zechaDrawer.closeInventory();
	}

}
