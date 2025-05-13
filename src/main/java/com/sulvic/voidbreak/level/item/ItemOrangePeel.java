package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.item.Item;

public class ItemOrangePeel extends Item{

	public ItemOrangePeel(){
		super();
		setCreativeTab(EDIBLE);
		setTextureName(MODID + ":snacks/orange_peel");
		setUnlocalizedName("orangePeel");
	}

}
