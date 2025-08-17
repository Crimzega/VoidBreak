package com.sulvic.mcf.event;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.item.crafting.IRecipe;

public class RecipeEvent extends Event{

	public IRecipe craftingRecipe;

	public RecipeEvent(IRecipe recipe){ craftingRecipe = recipe; }

}
