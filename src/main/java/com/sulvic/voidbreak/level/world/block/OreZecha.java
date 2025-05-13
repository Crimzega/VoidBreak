package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import com.sulvic.voidbreak.common.JemurinMaterial;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.world.IBlockAccess;

public class OreZecha extends Block{

	public OreZecha(){
		super(JemurinMaterial.ZECHA_MATERIAL);
		setBlockName("zechaOre");
		setBlockTextureName(MODID + ":ores/zecha");
		setCreativeTab(BLOCKS);
		setHardness(3f);
		setHarvestLevel("pickaxe", 2);
		setResistance(5f);
		setStepSound(soundTypePiston);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity){
		return !(entity instanceof EntityDragon) && !(entity instanceof EntityWither) && !(entity instanceof EntityWitherSkull);
	}

}
