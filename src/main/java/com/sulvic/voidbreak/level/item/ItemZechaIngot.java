package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.item.Item;

public class ItemZechaIngot extends Item{

	public ItemZechaIngot(){
		super();
		setCreativeTab(ITEMS);
		setTextureName(MODID + ":zecha_ingot");
		setUnlocalizedName("zechaIngot");
	}

}
