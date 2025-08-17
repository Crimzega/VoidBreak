package com.sulvic.voidbreak.level.container.slot;

import com.sulvic.mcf.common.CraftingHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSpecial extends Slot{

	private EntityPlayer thePlayer;

	public SlotSpecial(EntityPlayer player, IInventory inventory, int id, int x, int y){
		super(inventory, id, x, y);
		thePlayer = player;
	}

	@Override
	public boolean isItemValid(ItemStack stack){ return false; }

	@Override
	protected void onCrafting(ItemStack stack){
		super.onCrafting(stack);
		CraftingHelper.triggerAchievements(stack, thePlayer);
	}

	@Override
	protected void onCrafting(ItemStack stack, int amount){
		super.onCrafting(stack, amount);
		onCrafting(stack);
	}

}
