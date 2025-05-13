package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

public class PileSugar extends BlockPile{

	public PileSugar(){
		super(SUGAR_MATERIAL);
		setBlockName("sugarPile");
		setBlockTextureName(MODID + ":piles/sugar");
	}

}
