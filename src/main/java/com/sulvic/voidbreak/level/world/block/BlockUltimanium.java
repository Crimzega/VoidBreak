package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.world.IBlockAccess;

public class BlockUltimanium extends Block{

	public BlockUltimanium(){
		super(ULTIMANIUM_MATERIAL);
		setBlockName("ultimanium");
		setBlockTextureName(MODID + ":ultimanium");
		setHardness(25f);
		setResistance(450000000f);
		setHarvestLevel("pickaxe", 3);
		setStepSound(soundTypeMetal);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity){
		return !(entity instanceof EntityWither) && !(entity instanceof EntityWitherSkull) && !(entity instanceof EntityDragon);
	}

}
