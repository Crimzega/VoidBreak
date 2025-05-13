package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

import net.minecraft.block.BlockSlab;

public class SlabCitrus extends BlockSlab{

	public SlabCitrus(boolean full){
		super(full, CITRUS_MATERIAL);
		setBlockName("citrusSlab");
		setBlockTextureName(MODID + ":citrus/planks");
		if(!full){
			setCreativeTab(BLOCKS);
			setLightOpacity(0);
		}
		else setLightOpacity(255);
	}

	@Override
	public String func_150002_b(int metadata){ return getUnlocalizedName(); }

}
