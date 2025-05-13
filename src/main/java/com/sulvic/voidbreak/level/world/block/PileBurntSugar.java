package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

public class PileBurntSugar extends BlockPile{

	public PileBurntSugar(){
		super(BURNT_SUGAR_MATERIAL);
		setBlockName("burntSugarPile");
		setBlockTextureName(MODID + ":piles/burnt_sugar");
	}

}
