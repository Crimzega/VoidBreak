package tpod.blocks.subtypes;

import net.minecraft.block.*;
import net.minecraft.item.*;

public class ItemJemBlocks extends ItemBlock{

	private static String[] subBlocks = {"ruby", "pinkPanther", "sapphire", "cassiterite"};

	public ItemJemBlocks(Block blocks){
		super(blocks);
		setHasSubtypes(true);
	}

	public int getMetadata(final int meta){ return meta; }

	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= ItemJemBlocks.subBlocks.length) i = 0;
		return getUnlocalizedName() + "." + ItemJemBlocks.subBlocks[i];
	}

}
