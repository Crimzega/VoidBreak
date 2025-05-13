package com.sulvic.voidbreak.common;

import static com.sulvic.voidbreak.common.SulvicObjects.*;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FolkrumTabs{

	public static final CreativeTabs BLOCKS = new CreativeTabs("blocksVB"){

		@Override
		public Item getTabIconItem(){ return Item.getItemFromBlock(ULTINE_BLOCK); }

	};

	public static final CreativeTabs ITEMS = new CreativeTabs("itemsVB"){
		
		public Item getTabIconItem(){ return ZECHA_INGOT; };
		
	};

	public static final CreativeTabs EDIBLE = new CreativeTabs("edibleVB"){

		public Item getTabIconItem(){ return SWEET_POTATO; }

	};

//	public static final CreativeTabs TOOLS = new CreativeTabs("tooldVB"){
//		
//		public Item getTabIconItem(){ return RUBY_SPADE; }
//		
//	};
//
//	public static final CreativeTabs EQUIP = new CreativeTabs("equipVB"){
//		
//		public Item getTabIconItem(){ return ZETA_SWORD; }
//		
//	};

}
