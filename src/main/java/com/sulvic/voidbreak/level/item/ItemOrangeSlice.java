package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import com.sulvic.voidbreak.ReferenceVB;

import net.minecraft.item.Item;

public class ItemOrangeSlice extends Item{

	public ItemOrangeSlice(){
		super();
		setCreativeTab(EDIBLE);
		setTextureName(ReferenceVB.MODID + ":snacks/orange_slice");
		setUnlocalizedName("orangeSlice");
	}

}
