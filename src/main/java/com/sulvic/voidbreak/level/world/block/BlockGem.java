package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import java.util.List;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.lib.GemstoneData;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.IBlockAccess;

@SuppressWarnings({"rawtypes", "unchecked"})
public class BlockGem extends Block{

	@ZaranthaClient
	private IIcon[] textures;

	public BlockGem(){
		super(GEM_MATERIAL);
		setBlockName("gem");
		setCreativeTab(BLOCKS);
		setHardness(3f);
		setHarvestLevel("pickaxe", 2);
		setResistance(5f);
		setStepSound(soundTypePiston);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess blockAccess, int x, int y, int z, int x1, int y1, int z1){ return true; }

	@Override
	public MapColor getMapColor(int metadata){
		GemstoneData.Type type = GemstoneData.Type.byMetadata(metadata);
		switch(type){
			case PINK_PANTHER:
				return MapColor.pinkColor;
			case SAPPHIRE:
				return MapColor.purpleColor;
			case CASSITERITE:
				return MapColor.blackColor;
			case ENSTATITE:
				return MapColor.goldColor;
			case MOONSTONE:
				return MapColor.yellowColor;
			default:
				return super.getMapColor(metadata);
		}
	}

	@Override
	public int damageDropped(int metadata){ return metadata; }

	@Override
	@ZaranthaClient
	public IIcon getIcon(int side, int metadata){ return textures[metadata]; }

	@Override
	@ZaranthaClient
	public void getSubBlocks(Item item, CreativeTabs tab, List list){
		if(tab == CreativeTabs.tabAllSearch || tab == BLOCKS) for(GemstoneData.Type type: GemstoneData.Type.values()) list.add(new ItemStack(item, 1, type.getMetadata()));
	}

	@Override
	@ZaranthaClient
	public void registerBlockIcons(IIconRegister registry){
		textures = new IIcon[GemstoneData.Type.size()];
		for(GemstoneData.Type type: GemstoneData.Type.values()) textures[type.getMetadata()] = registry.registerIcon(MODID + ":gems/" + type.getTextureName());
	}

}
