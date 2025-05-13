package com.sulvic.voidbreak.level.world.block;

import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;
import com.sulvic.voidbreak.VoidBreak;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.*;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockPile extends Block{

	private static final Set<Block> PILE_DEFAULTS = Sets.newHashSet(Blocks.planks, Blocks.bookshelf, Blocks.quartz_block);
	private static final Set<Block> PILE_CONFIG = Sets.newHashSet();

	protected BlockPile(Material material){
		super(material);
		setBlockBounds(0.0625f, 0f, 0.0625f, 0.9375f, 0.3125f, 0.9375f);
		setStepSound(soundTypeSand);
	}

	public static void addConfigBlocks(){
		if(!PILE_CONFIG.isEmpty()) PILE_CONFIG.clear();
		String[] pileBlocks = VoidBreak.getConfig().getPileBlocks();
		if(pileBlocks != null) for(String blockName: pileBlocks){
			String[] split = blockName.split(":");
			Block block = GameRegistry.findBlock(split[0], split[1]);
			if(block != null) PILE_CONFIG.add(block);
		}
	}

	protected boolean canPlaceBlockOn(Block block){ return PILE_DEFAULTS.contains(block) || PILE_CONFIG.contains(block); }

	@Override
	public boolean canBlockStay(World world, int x, int y, int z){
		if(y >= 0 && y < 256){
			Block block = world.getBlock(x, y - 1, z);
			return canPlaceBlockOn(block);
		}
		else return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){ return null; }

	@Override
	public boolean isOpaqueCube(){ return false; }

	@Override
	public boolean renderAsNormalBlock(){ return false; }

	@Override
	public int getRenderType(){ return 1; }

	@Override
	public int quantityDropped(int metadata, int fortune, Random rand){ return 1; }

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune){ return Items.sugar; }

}
