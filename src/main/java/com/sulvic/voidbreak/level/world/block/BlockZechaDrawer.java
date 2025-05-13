package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.client.gui.SulvicGuis.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;
import static com.sulvic.voidbreak.network.proxy.ClientVB.*;
import static net.minecraftforge.common.util.ForgeDirection.*;

import com.sulvic.mcf.util.ZimedaMath;
import com.sulvic.voidbreak.VoidBreak;
import com.sulvic.voidbreak.level.tileentity.TileZechaDrawer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockZechaDrawer extends BlockContainer{

	public BlockZechaDrawer(){
		super(ZECHA_MATERIAL);
		setBlockBounds(0.0625f, 0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
		setBlockName("zechaDrawer");
		setBlockTextureName(MODID + ":zecha/drawer");
		setCreativeTab(BLOCKS);
		setHardness(12f);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.5f);
		setResistance(48f);
		setStepSound(soundTypeMetal);
	}

	private TileZechaDrawer getAvailableDrawer(World world, int x, int y, int z, int side){
		TileEntity tile = world.getTileEntity(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		if(tile == null) return null;
		if(tile instanceof TileZechaDrawer){
			TileZechaDrawer drawer = (TileZechaDrawer)tile;
			Block block = null;
			boolean solidSide = false;
			switch(metadata){
				case 2:
					block = world.getBlock(x, y, z - 1);
					solidSide = block.isSideSolid(world, x, y, z - 1, SOUTH);
				break;
				case 3:
					block = world.getBlock(x, y, z + 1);
					solidSide = block.isSideSolid(world, x, y, z + 1, NORTH);
				break;
				case 4:
					block = world.getBlock(x - 1, y, z);
					solidSide = block.isSideSolid(world, x - 1, y, z, EAST);
				break;
				case 5:
					block = world.getBlock(x + 1, y, z);
					solidSide = block.isSideSolid(world, x + 1, y, z, WEST);
				break;
			}
			return block == null || block.getMaterial() == Material.air || !solidSide? drawer: null;
		}
		else return null;
	}

	@Override
	public boolean isOpaqueCube(){ return false; }

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote) return true;
		else{
			TileEntity tile = world.getTileEntity(x, y, z);
			if(tile instanceof TileZechaDrawer){
				TileZechaDrawer drawer = getAvailableDrawer(world, x, y, z, side);
				VoidBreak.getLogger().info(drawer);
				if(drawer != null) player.openGui(VoidBreak.instance, zechaDrawerID, world, x, y, z);
			}
			return true;
		}
	}

	@Override
	public boolean renderAsNormalBlock(){ return false; }

	@Override
	public int getRenderType(){ return zechaDrawerRenderID; }

	@Override
	public TileEntity createNewTileEntity(World world, int metadata){ return new TileZechaDrawer(); }

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata){
		TileZechaDrawer drawer = (TileZechaDrawer)world.getTileEntity(x, y, z);
		if(drawer != null) ZimedaMath.dropAllItems(drawer, world, x, y, z, block, world.rand);
		super.breakBlock(world, x, y, z, block, metadata);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z){
		if(!world.isRemote){
			Block block = world.getBlock(x, y, z - 1), block1 = world.getBlock(x, y, z + 1), block2 = world.getBlock(x - 1, y, z), block3 = world.getBlock(x + 1, y, z);
			int metadata = 3;
			if(block.func_149730_j() && !block1.func_149730_j()) metadata = 3;
			if(block1.func_149730_j() && !block.func_149730_j()) metadata = 2;
			if(block2.func_149730_j() && !block3.func_149730_j()) metadata = 5;
			if(block3.func_149730_j() && !block2.func_149730_j()) metadata = 4;
			world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack stack){
		byte metadata = 0;
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
		world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
		if(stack.hasDisplayName()){
			TileZechaDrawer drawer = (TileZechaDrawer)world.getTileEntity(x, y, z);
			drawer.setCustomInventoryName(stack.getDisplayName());
		}
	}

}
