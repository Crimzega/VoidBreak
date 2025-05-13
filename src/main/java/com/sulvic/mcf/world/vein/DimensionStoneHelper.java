package com.sulvic.mcf.world.vein;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class DimensionStoneHelper{

	private static final Map<Integer, Block> DIMENSION_STONE = Maps.newHashMap();

	static{
		DIMENSION_STONE.put(-1, Blocks.netherrack);
		DIMENSION_STONE.put(0, Blocks.stone);
		DIMENSION_STONE.put(1, Blocks.end_stone);
	}

	public static boolean hasDimensionStone(int id){ return DIMENSION_STONE.containsKey(id); }

	public static void setDimensionStone(int id, Block block){ DIMENSION_STONE.put(id, block); }

	public static Block getDimensionStone(int id){ return hasDimensionStone(id)? DIMENSION_STONE.get(id): Blocks.stone; }

}
