package com.sulvic.mcf.util;

import java.util.Arrays;
import java.util.List;

import com.sulvic.mcf.common.OreStack;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ZimedaForge{

	public static OreStack findOreDictionary(ItemStack... stackItems){ return findOreDictionary(Arrays.asList(stackItems)); }

	public static OreStack findOreDictionary(List<ItemStack> stackItems){ return findOreDictionary(stackItems, 1); }

	public static OreStack findOreDictionary(List<ItemStack> stackItems, int amount){
		for(String name: OreDictionary.getOreNames()){
			List<ItemStack> items = OreDictionary.getOres(name);
			if(items.containsAll(stackItems)) return new OreStack(name, amount);
		}
		return null;
	}

}
