package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockNothing extends Block{

	private static final int MAX_COOK_TIME = 100;
	private boolean allowCreation = false;
	private int cookedTime = 0;

	public BlockNothing(){
		super(NOTHING_MATERIAL);
		setBlockName("nothing");
		setBlockTextureName(MODID + ":nothing");
		setBlockUnbreakable();
		setLightLevel(1f);
		setLightOpacity(255);
		setResistance(720f);
		setTickRandomly(true);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity){ return entity instanceof EntityPlayer; }

	@Override
	public boolean isFireSource(World world, int x, int y, int z, ForgeDirection side){ return world.getBlock(x, y, z) == this && side == ForgeDirection.UP; }

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand){
		int spawnY = y + 1;
		Block block = world.getBlock(x, spawnY, z);
		if(!allowCreation){
			if(block == Blocks.fire){
				if(cookedTime < MAX_COOK_TIME) cookedTime++;
				if(cookedTime == MAX_COOK_TIME) allowCreation = true;
			}
			else cookedTime = 0;
		}
		else{
			if(block != Blocks.fire){
				ItemStack stack = new ItemStack(ULTIMANIUM_INGOT);
				EntityItem itemEntity = new EntityItem(world, (double)x + 0.5d, (double)spawnY + 0.5d, (double)z + 0.5d, stack);
				world.spawnEntityInWorld(itemEntity);
				cookedTime = 0;
				allowCreation = false;
			}
		}
	}

}
