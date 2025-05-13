package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import java.util.*;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.lib.GemstoneData;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.IBlockAccess;

@SuppressWarnings({"rawtypes", "unchecked"})
public class OreGem extends Block{

	@ZaranthaClient
	private IIcon[] textures;
	private Random blockRand = new Random();

	public OreGem(){
		super(Material.rock);
		setBlockName("gemOre");
		setCreativeTab(BLOCKS);
		setHardness(3f);
		setHarvestLevel("pickaxe", 2);
		setResistance(5f);
		setStepSound(soundTypePiston);
	}

	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune){
		return getItemDropped(metadata, blockRand, fortune) == Item.getItemFromBlock(this)? MathHelper.getRandomIntegerInRange(blockRand, 3, 7): 0;
	}

	@Override
	public int damageDropped(int metadata){ return metadata; }

	@Override
	public int quantityDroppedWithBonus(int fortune, Random rand){
		int i = 1;
		if(fortune > 0 && getItemDropped(0, rand, fortune) != Item.getItemFromBlock(this)) i = Math.min(rand.nextInt(fortune + 2) - 1, 0) + 1;
		return quantityDropped(rand) * i;
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune){ return GEM; }

	@Override
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
		for(GemstoneData.Type type: GemstoneData.Type.values()) textures[type.getMetadata()] = registry.registerIcon(MODID + ":ores/" + type.getTextureName());
	}

}
