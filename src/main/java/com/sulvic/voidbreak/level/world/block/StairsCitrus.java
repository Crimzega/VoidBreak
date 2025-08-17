package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.common.FolkrumTabs.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;

import net.minecraft.block.BlockStairs;

public class StairsCitrus extends BlockStairs{

	public StairsCitrus(){
		super(CITRUS_PLANKS, 0);
		setBlockName("stairsCitrus");
		setCreativeTab(BLOCKS);
	}

}
