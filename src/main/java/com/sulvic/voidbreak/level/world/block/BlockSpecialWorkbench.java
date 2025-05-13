package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.client.gui.SulvicGuis.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.VoidBreak;
import com.sulvic.voidbreak.level.tileentity.TileSpecialWorkbench;

import net.minecraft.block.*;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class BlockSpecialWorkbench extends BlockContainer{

	@ZaranthaClient
	public IIcon topIcon, frontIcon, sideIcon;

	public BlockSpecialWorkbench(){
		super(SPECIAL_MATERIAL);
		setBlockName("specialWorkbench");
		setCreativeTab(BLOCKS);
		setHardness(12f);
		setHarvestLevel("pickaxe", 2);
		setResistance(48f);
		setStepSound(soundTypeMetal);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote) return true;
		else{
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile instanceof TileSpecialWorkbench) player.openGui(VoidBreak.instance, specialWorkbenchID, world, x, y, z);
			return true;
		}
	}

	@Override
	public IIcon getIcon(int side, int metadata){
		switch(side){
			case 1:
				return topIcon;
			case 2:
			case 3:
				return frontIcon;
			case 4:
			case 5:
				return sideIcon;
			default:
				return blockIcon;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata){ return new TileSpecialWorkbench(); }

	@Override
	public void onBlockAdded(World world, int x, int y, int z){
		if(!world.isRemote){
			Block block = world.getBlock(x, y, z - 1), block1 = world.getBlock(x, y, z + z), block2 = world.getBlock(x - 1, y, z), block3 = world.getBlock(x + 1, y, z);
			int metadata = 0;
			if(block.func_149730_j() && !block1.func_149730_j()) metadata = 3;
			if(!block.func_149730_j() && block1.func_149730_j()) metadata = 2;
			if(block2.func_149730_j() && !block3.func_149730_j()) metadata = 5;
			if(!block2.func_149730_j() && block3.func_149730_j()) metadata = 4;
			world.setBlockMetadataWithNotify(x, y, z, metadata, 3);
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack stack){
		int metadata = 0;
		switch(MathHelper.floor_double((double)(livingBase.rotationYaw * 4f / 360f) + 0.5d) & 3){
			case 0:
				metadata = 2;
			break;
			case 1:
				metadata = 5;
			break;
			case 2:
				metadata = 3;
			break;
			case 3:
				metadata = 4;
			break;
		}
		world.setBlockMetadataWithNotify(x, y, z, metadata, 3);
		if(stack.hasDisplayName()) ((TileSpecialWorkbench)world.getTileEntity(x, y, z)).setCustomInventoryName(stack.getDisplayName());
	}

	@Override
	@ZaranthaClient
	public void registerBlockIcons(IIconRegister registry){
		blockIcon = registry.registerIcon(MODID + ":z\u00E9ta/metal");
		topIcon = registry.registerIcon(MODID + ":z\u00E9ta/workbench/top");
		frontIcon = registry.registerIcon(MODID + ":z\u00E9ta/workbench/front");
		sideIcon = registry.registerIcon(MODID + ":z\u00E9ta/workbench/side");
	}

}
