package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemUltimaniumIngot extends Item{

	public ItemUltimaniumIngot(){
		super();
		setCreativeTab(ITEMS);
		setTextureName(MODID + ":ultimanium/ingot");
		setUnlocalizedName("ultimaniumIngot");
	}

	@Override
	public int getEntityLifespan(ItemStack stack, World world){ return 288000; }

}
