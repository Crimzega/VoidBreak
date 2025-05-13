package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.item.ItemFood;

public class ItemBakedSweetPotato extends ItemFood{

	public ItemBakedSweetPotato(){
		super(1, 0.45f, false);
		setCreativeTab(EDIBLE);
		setTextureName(MODID + ":snacks/baked_sweet_potato");
		setUnlocalizedName("bakedSweetPotato");
	}

}
