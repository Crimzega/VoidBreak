package com.sulvic.mcf.util;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ZimedaMath{

	private static float makePositionOffset(Random rand){ return rand.nextFloat() * 0.8f + 0.1f; }

	public static boolean tileEntityWithinRange(TileEntity tile, EntityPlayer player, double maxDist){
		double posX = (double)tile.xCoord + 0.5d, posY = (double)tile.yCoord + 0.5d, posZ = (double)tile.zCoord + 0.5d;
		return player.getDistanceSq(posX, posY, posZ) <= maxDist;
	}

	public static double getDistanceSqrt(double... values){
		double result = 0d;
		for(double value: values) result += Math.pow(value, 2d);
		return Math.sqrt(result);
	}

	public static double getDistanceSqrtBetween(Entity entity, Entity entity1){ return getDistanceSqrt(entity.posX - entity1.posX, entity.posY - entity1.posY, entity.posZ - entity1.posZ); }

	public static AxisAlignedBB getBounds(Entity entity, double dist){ return getBounds(entity.posX, entity.posY, entity.posZ, dist); }

	public static AxisAlignedBB getBounds(int x, int y, int z, double dist){ return getBounds((double)x, (double)y, (double)z, dist); }

	public static AxisAlignedBB getBounds(double x, double y, double z, double dist){ return AxisAlignedBB.getBoundingBox(x - dist, y - dist, z - dist, x + dist, y + dist, z + dist); }

	public static <T extends Entity> List<T> getEntityTypeAround(Entity entity, World world, Class<T> entityCls, double dist){
		List<T> result = Lists.newArrayList();
		AxisAlignedBB bounds = getBounds(entity, dist);
		List<?> list = world.getEntitiesWithinAABBExcludingEntity(entity, bounds);
		for(Object obj: list){
			Class<?> cls = obj.getClass();
			if(cls.isAssignableFrom(entityCls)) result.add(entityCls.cast(obj));
		}
		return result;
	}

	public static <T extends Entity> List<T> getEntityTypeAround(double x, double y, double z, World world, Class<T> entityCls, double dist){
		List<T> result = Lists.newArrayList();
		AxisAlignedBB bounds = getBounds(x, y, z, dist);
		List<?> list = world.getEntitiesWithinAABB(entityCls, bounds);
		for(Object obj: list){
			Class<?> cls = obj.getClass();
			if(cls.isAssignableFrom(entityCls)) result.add(entityCls.cast(obj));
		}
		return result;
	}

	public static <T extends Entity> List<T> getEntityTypeAround(int x, int y, int z, World world, Class<T> entityCls, double dist){
		return getEntityTypeAround((double)x, (double)y, (double)z, world, entityCls, dist);
	}

	public static void dropAllItems(IInventory inv, World world, int x, int y, int z, Block block, Random rand){
		for(int i = 0; i < inv.getSizeInventory(); i++){
			ItemStack stack = inv.getStackInSlot(i);
			if(stack != null){
				float offsetX = makePositionOffset(rand), offsetY = makePositionOffset(rand), offsetZ = makePositionOffset(rand);
				while(stack.stackSize > 0){
					int count = Math.min(MathHelper.getRandomIntegerInRange(rand, 10, 21), stack.stackSize);
					stack.stackSize -= count;
					ItemStack stack1 = new ItemStack(stack.getItem(), count, stack.getItemDamage());
					if(stack.hasTagCompound()) stack1.setTagCompound(stack.getTagCompound());
					EntityItem itemEntity = new EntityItem(world, (double)x + offsetX, (double)y + offsetY, (double)z + offsetZ);
					itemEntity.motionX = (float)rand.nextGaussian() * 0.05f;
					itemEntity.motionY = (float)rand.nextGaussian() * 0.05f + 0.2f;
					itemEntity.motionZ = (float)rand.nextGaussian() * 0.05f;
					world.spawnEntityInWorld(itemEntity);
				}
			}
		}
	}

}
