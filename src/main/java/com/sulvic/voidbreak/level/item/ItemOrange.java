package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.item.Item;

public class ItemOrange extends Item{

	public ItemOrange(){
		super();
		setCreativeTab(EDIBLE);
		setTextureName(MODID + ":snacks/orange");
		setUnlocalizedName("orange");
	}

}
