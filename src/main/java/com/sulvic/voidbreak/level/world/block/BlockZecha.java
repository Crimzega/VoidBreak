package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

import com.sulvic.mcf.network.proxy.ZaranthaClient;

import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockZecha extends Block{

	@ZaranthaClient
	private IIcon bottomIcon, topIcon;

	public BlockZecha(){
		super(ZECHA_MATERIAL);
		setBlockName("zecha");
		setBlockTextureName(MODID + ":zecha/side");
		setCreativeTab(BLOCKS);
		setHardness(25f);
		setHarvestLevel("pickaxe", 3);
		setResistance(50f);
		setStepSound(soundTypeMetal);
	}

	@Override
	@ZaranthaClient
	public IIcon getIcon(int side, int metadata){ return side == 0? bottomIcon: side == 1? topIcon: blockIcon; }

	@Override
	@ZaranthaClient
	public void registerBlockIcons(IIconRegister registry){
		super.registerBlockIcons(registry);
		topIcon = registry.registerIcon(MODID + ":zecha/top");
		bottomIcon = registry.registerIcon(MODID + ":zecha/bottom");
	}

}
