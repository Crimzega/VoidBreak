package com.sulvic.mcf.event;

import java.util.List;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class RecipeEvent extends Event{

	public EntityPlayer entityPlayer;
	public IRecipe craftingRecipe;

	public RecipeEvent(EntityPlayer player, IRecipe recipe){
		entityPlayer = player;
		craftingRecipe = recipe;
	}

	public static class CraftableEvent extends RecipeEvent{

		public boolean isCraftable;

		public CraftableEvent(EntityPlayer player, IRecipe recipe){ super(player, recipe); }

	}

	public static class ConsumptionEvent extends RecipeEvent{

		public int consumptionAmount;

		public ConsumptionEvent(EntityPlayer player, IRecipe recipe, int amount){
			super(player, recipe);
			consumptionAmount = amount;
		}

	}

	public static class CraftingEvent extends RecipeEvent{

		public List<ItemStack> standardInputs = Lists.newArrayList();
		public List<List<ItemStack>> oreDictInputs = Lists.newArrayList();

		public CraftingEvent(EntityPlayer player, IRecipe recipe){ super(player, recipe); }

	}

}
