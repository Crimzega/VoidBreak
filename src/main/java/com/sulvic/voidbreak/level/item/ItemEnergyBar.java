package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.item.ItemFood;

public class ItemEnergyBar extends ItemFood{

	public ItemEnergyBar(){
		super(5, 0.8f, false);
		setCreativeTab(EDIBLE);
		setTextureName(MODID + ":snacks/energy_bar");
		setUnlocalizedName("energyBar");
	}

}
