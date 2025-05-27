package tpod.blocks.subtypes;

import net.minecraft.block.*;
import net.minecraft.item.*;

public class ItemVoidJemBlocks extends ItemBlock{

	private static String[] subBlocks = {"hyperizedDiamond", "negatizedRuby", "hyperizedPinkPanther", "negatizedSapphire", "hyperizedEmerald", "negatizedCassiterite"};

	public ItemVoidJemBlocks(Block blocks){
		super(blocks);
		setHasSubtypes(true);
	}

	public int getMetadata(final int meta){ return meta; }

	public String getUnlocalizedName(ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i < 0 || i >= ItemVoidJemBlocks.subBlocks.length) i = 0;
		return getUnlocalizedName() + "." + ItemVoidJemBlocks.subBlocks[i];
	}

}
