package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

public class ItemSweetPotato extends ItemSeedFood{
	
	public ItemSweetPotato(){
		super(1, 0.45f, SWEET_POTATO_CROP, Blocks.farmland);
		setCreativeTab(EDIBLE);
		setTextureName(MODID + ":snacks/sweet_potato");
		setUnlocalizedName("sweetPotato");
	}

}
