package com.sulvic.mcf.event;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RecipeCraftedEvent extends Event{

	public EntityPlayer entityPlayer;
	public ItemStack craftingResult;

	public RecipeCraftedEvent(ItemStack result, EntityPlayer player){
		craftingResult = result;
		entityPlayer = player;
	}

}
