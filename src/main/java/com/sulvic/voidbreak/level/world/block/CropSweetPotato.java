package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;

import com.sulvic.mcf.network.proxy.ZaranthaClient;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CropSweetPotato extends BlockCrops{

	@ZaranthaClient
	private IIcon[] textures;

	public CropSweetPotato(){
		super();
		setBlockName("sweetPotato");
	}

	@Override
	@ZaranthaClient
	public IIcon getIcon(int side, int metadata){
		if(metadata < 7){
			if(metadata == 6) metadata = 5;
			return textures[metadata >> 1];
		}
		return textures[3];
	}

	@Override
	protected Item func_149865_P(){ return SWEET_POTATO; }

	@Override
	protected Item func_149866_i(){ return SWEET_POTATO; }

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
		Block block1 = world.getBlock(x, y - 1, z);
		if(block1 != Blocks.farmland && !world.isRemote){
			dropBlockAsItem(world, x, y, z, new ItemStack(SWEET_POTATO));
			world.setBlockToAir(x, y, z);
		}
	}

	@Override
	@ZaranthaClient
	public void registerBlockIcons(IIconRegister registry){
		textures = new IIcon[4];
		for(int i = 0; i < textures.length; i++) textures[i] = registry.registerIcon(MODID + ":crops/sweet_potato" + i);
	}

}
