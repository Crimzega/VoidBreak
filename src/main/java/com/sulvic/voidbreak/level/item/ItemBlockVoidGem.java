package com.sulvic.voidbreak.level.item;

import com.sulvic.voidbreak.lib.VoidGemstoneData;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockVoidGem extends ItemBlock{

	public ItemBlockVoidGem(Block block){
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata){ return metadata; }

	@Override
	public String getUnlocalizedName(ItemStack stack){
		int metadata = stack.getItemDamage();
		if(metadata < 0 || metadata >= VoidGemstoneData.Type.size()) metadata = 0;
		return getUnlocalizedName() + '.' + VoidGemstoneData.Type.byMetadata(metadata).getUnlocalizedName();
	}

}
