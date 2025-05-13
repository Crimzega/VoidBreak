package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import java.util.Random;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.common.JemurinMaterial;

import net.minecraft.block.BlockBreakable;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public class OreSpecial extends BlockBreakable{

	public OreSpecial(){
		super(MODID + ":ores/z\u00E9ta", JemurinMaterial.SPECIAL_MATERIAL, false);
		setBlockName("specialOre");
		setCreativeTab(BLOCKS);
		setHardness(3f);
		setHarvestLevel("pickaxe", 2);
		setResistance(5f);
		setStepSound(soundTypeGlass);
	}

	@Override
	@ZaranthaClient
	public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side){ return super.shouldSideBeRendered(blockAccess, x, y, z, 1 - side); }

	@Override
	@ZaranthaClient
	public int getRenderBlockPass(){ return 1; }

	@Override
	public int quantityDropped(int metadata, int fortune, Random rand){ return 5 + rand.nextInt(3); }

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune){ return SPECIAL_DUST; }

}
