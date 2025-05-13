package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class BlockUltine extends Block{

	public BlockUltine(){
		super(ULTINE_MATERIAL);
		setBlockName("ultine");
		setBlockTextureName(MODID + ":ultine");
		setCreativeTab(BLOCKS);
		setHardness(45f);
		setHarvestLevel("pickaxe", 2);
		setResistance(180f);
		setStepSound(soundTypeMetal);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess blockAccess, int x, int y, int z, int beaconX, int beaconY, int beaconZ){ return true; }

}
