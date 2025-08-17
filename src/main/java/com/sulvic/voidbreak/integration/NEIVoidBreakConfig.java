package com.sulvic.voidbreak.integration;

import com.sulvic.voidbreak.common.SulvicObjects;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import net.minecraft.item.ItemStack;

public class NEIVoidBreakConfig implements IConfigureNEI{

	@Override
	public String getName(){ return "VoidBreak NEI"; }

	@Override
	public String getVersion(){ return "1.0.0"; }

	@Override
	public void loadConfig(){
		API.hideItem(new ItemStack(SulvicObjects.CITRUS_DOUBLE_SLAB));
		API.hideItem(new ItemStack(SulvicObjects.SWEET_POTATO_CROP));
		API.hideItem(new ItemStack(SulvicObjects.SUGAR_PILE));
		API.hideItem(new ItemStack(SulvicObjects.BURNT_SUGAR_PILE));
	}

}
