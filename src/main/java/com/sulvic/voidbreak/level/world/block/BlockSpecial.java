package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import com.sulvic.voidbreak.common.JemurinMaterial;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.world.IBlockAccess;

public class BlockSpecial extends Block{

	public BlockSpecial(){
		super(JemurinMaterial.SPECIAL_MATERIAL);
		setBlockName("special");
		setBlockTextureName(MODID + ":z\u00E9ta/dust");
		setCreativeTab(BLOCKS);
		setHardness(25f);
		setHarvestLevel("pickaxe", 3);
		setResistance(50f);
		setStepSound(soundTypeStone);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity){ return !(entity instanceof EntityFireball); }

}
