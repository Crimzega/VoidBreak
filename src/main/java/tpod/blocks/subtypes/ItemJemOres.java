package tpod.blocks.subtypes;

import net.minecraft.block.*;
import net.minecraft.item.*;

public class ItemJemOres extends ItemBlock{

	private static String[] subBlocks = {"ruby", "pinkPanther", "sapphire", "cassiterite"};

	public ItemJemOres(Block blocks){
		super(blocks);
		setHasSubtypes(true);
	}

	public int getMetadata(int meta){ return meta; }

	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i < 0 || i >= ItemJemOres.subBlocks.length) i = 0;
		return getUnlocalizedName() + "." + ItemJemOres.subBlocks[i];
	}

}
