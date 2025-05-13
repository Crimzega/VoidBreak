package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

import net.minecraft.block.Block;

public class PlanksCitrus extends Block{

	public PlanksCitrus(){
		super(CITRUS_MATERIAL);
		setBlockName("planksCitrus");
		setBlockTextureName(MODID + ":citrus/planks");
		setCreativeTab(BLOCKS);
		setHardness(2f);
		setResistance(5f);
		setStepSound(soundTypeWood);
	}

}
