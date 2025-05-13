package com.sulvic.voidbreak.level.world.gen.tree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenSulvicTree extends WorldGenAbstractTree{

	protected Block blockLog, blockLeaves, blockSapling;
	protected final int minTreeHeight;

	public WorldGenSulvicTree(boolean notify, int minHeight, Block log, Block leaves, BlockSapling sapling){
		super(notify);
		minTreeHeight = minHeight;
		blockLog = log;
		blockLeaves = leaves;
		blockSapling = sapling;
	}

	protected boolean func_150523_a(Block block){ return super.func_150523_a(block) || block == blockLog || block == blockLeaves || block == blockSapling; }

}
