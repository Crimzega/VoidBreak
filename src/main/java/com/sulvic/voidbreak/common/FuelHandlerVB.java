package com.sulvic.voidbreak.common;

import static com.sulvic.voidbreak.common.SulvicObjects.*;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelHandlerVB implements IFuelHandler{

	public static FuelHandlerVB instance = new FuelHandlerVB();

	private FuelHandlerVB(){}

	public int getBurnTime(ItemStack stack){
		Item item = stack.getItem();
		if(item == SPECIAL_DUST) return 24000;
		return 0;
	}

}
