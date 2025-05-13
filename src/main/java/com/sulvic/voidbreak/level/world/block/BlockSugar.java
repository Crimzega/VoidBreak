package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.block.Block;

public class BlockSugar extends Block{

	public BlockSugar(){
		super(SUGAR_MATERIAL);
		setBlockName("sugar");
		setBlockTextureName(MODID + ":sugar");
		setCreativeTab(BLOCKS);
		setHardness(2f);
		setResistance(3f);
		setStepSound(soundTypeSand);
	}

}
