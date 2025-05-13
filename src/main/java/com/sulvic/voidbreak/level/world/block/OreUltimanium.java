package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import com.sulvic.voidbreak.common.JemurinMaterial;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.world.IBlockAccess;

public class OreUltimanium extends Block{

	public OreUltimanium(){
		super(JemurinMaterial.ULTIMANIUM_MATERIAL);
		setBlockName("ultimaniumOre");
		setBlockTextureName(MODID + ":ores/ultimanium");
		setCreativeTab(BLOCKS);
		setHardness(15f);
		setHarvestLevel("pickaxe", 3);
		setResistance(25f);
		setStepSound(soundTypePiston);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity){
		return !(entity instanceof EntityWither) && !(entity instanceof EntityWitherSkull) && !(entity instanceof EntityDragon);
	}

}
