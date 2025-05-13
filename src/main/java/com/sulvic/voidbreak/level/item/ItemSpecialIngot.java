package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.item.Item;

public class ItemSpecialIngot extends Item{

	public ItemSpecialIngot(){
		super();
		setCreativeTab(ITEMS);
		setTextureName(MODID + ":z\u00E9ta/ingot");
		setUnlocalizedName("specialIngot");
	}

}
