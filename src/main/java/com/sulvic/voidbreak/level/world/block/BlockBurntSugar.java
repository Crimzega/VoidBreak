package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.block.Block;

public class BlockBurntSugar extends Block{

	public BlockBurntSugar(){
		super(SUGAR_MATERIAL);
		setBlockName("burntSugar");
		setBlockTextureName(MODID + ":burnt_sugar");
		setCreativeTab(BLOCKS);
		setHardness(2f);
		setResistance(3f);
		setStepSound(soundTypeSand);
	}

}
