package com.sulvic.voidbreak.event;

import java.util.List;

import com.google.common.collect.Lists;
import com.sulvic.mcf.common.OreStack;
import com.sulvic.mcf.event.RecipeEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

public class SpecialWorkbenchEvent extends RecipeEvent{

	public List<ItemStack> availableItems;

	public SpecialWorkbenchEvent(IRecipe recipe, List<ItemStack> items){
		super(recipe);
		availableItems = items;
	}

	public static class Craftable extends SpecialWorkbenchEvent{

		public boolean isCraftable;

		public Craftable(IRecipe recipe, List<ItemStack> items){ super(recipe, items); }

	}

	public static class Consumption extends SpecialWorkbenchEvent{

		public int comsumptionAmount;

		public Consumption(IRecipe recipe, List<ItemStack> items){ super(recipe, items); }

	}

	public static class Maximum extends SpecialWorkbenchEvent{

		public int maximumAmount;

		public Maximum(IRecipe recipe, List<ItemStack> items){ super(recipe, items); }

	}

	public static class Crafting extends SpecialWorkbenchEvent{

		public List<ItemStack> standardInputs = Lists.newArrayList();
		public List<OreStack> oreDictInputs = Lists.newArrayList(); 

		public Crafting(IRecipe recipe, List<ItemStack> items){ super(recipe, items); }

	}

}
