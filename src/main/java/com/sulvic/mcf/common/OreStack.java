package com.sulvic.mcf.common;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreStack{

	public final String oreDictName;
	public int stackSize;

	public OreStack(String name){ this(name, 1); }

	public OreStack(String name, int amount){
		oreDictName = name;
		stackSize = amount;
	}

	public static boolean areOreStacksEqual(OreStack stack, OreStack stack1){ return stack.equals(stack1); }

	@Override
	public boolean equals(Object obj){
		if(obj instanceof OreStack) return oreDictName.equals(((OreStack)obj).oreDictName);
		return super.equals(obj);
	}

	public boolean hasMatchingItem(ItemStack stack){ return getTypes().contains(stack); }

	@Override
	public int hashCode(){ return 3 * 21 + oreDictName.hashCode(); }

	public List<ItemStack> getTypes(){ return OreDictionary.getOres(oreDictName); }

	public OreStack copy(){ return new OreStack(oreDictName, stackSize); }

}
