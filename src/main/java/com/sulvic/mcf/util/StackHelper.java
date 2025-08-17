package com.sulvic.mcf.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class StackHelper{

	public static boolean isStackNull(ItemStack stack){ return stack == null; }

	public static boolean areItemsEqual(ItemStack stack, ItemStack stack1){
		if(stack == null && stack1 == null) return false;
		if(stack != null && stack1 != null) {
			if(stack.getItem() != stack1.getItem()) return false;
			if(stack.getItemDamage() != stack.getItemDamage()) return false;
			return true;
		}
		else return false;
	}

	public static boolean hasItem(List<ItemStack> list, ItemStack stack){
		for(ItemStack stack1: list) if(areItemsEqual(stack1, stack)) return true;
		return false;
	}

	public static boolean hasAllItems(List<ItemStack> list, List<ItemStack> containables){
		int maxCount = 0;
		for(ItemStack stack: containables) if(hasItem(list, stack)){
			maxCount++;
			continue;
		}
		return maxCount == list.size();
	}

	public static boolean hasAnyOreItems(List<ItemStack> list, List<ItemStack> oreDictContainables){
		for(ItemStack stack: list) for(ItemStack stack1: oreDictContainables) if(stack.isItemEqual(stack1)) return true;
		return false;
	}

	public static List<ItemStack> consolidateItemList(List<ItemStack> list){
		Map<Item, Integer> itemCountMap = Maps.newHashMap();
		for(ItemStack stack: list) if(stack != null){
			Item item = stack.getItem();
			int count = stack.stackSize;
			itemCountMap.put(item, itemCountMap.getOrDefault(item, 0) + count);
		}
		List<ItemStack> result = Lists.newArrayList();
		for(Map.Entry<Item, Integer> entry: itemCountMap.entrySet()) result.add(new ItemStack(entry.getKey(), entry.getValue()));
		return result;
	}

	public static List<ItemStack> consolidateItemList(ItemStack... stacks){ return consolidateItemList(Arrays.asList(stacks)); }

	public static boolean areStacksEqual(ItemStack stack, ItemStack stack1){
		if(!areItemsEqual(stack, stack1)) return false;
		if(stack.hasTagCompound() != stack1.hasTagCompound()) return false;
		if(stack.hasTagCompound() && !stack.getTagCompound().equals(stack1.getTagCompound())) return false;
		return true;
	}

	public static ItemStack findBlockInInv(IInventory inv, Block block){ return findItemInInv(inv, Item.getItemFromBlock(block)); }

	public static ItemStack findItemInInv(IInventory inv, Item item){
		for(int i = 0; i < inv.getSizeInventory(); i++){
			ItemStack stack = inv.getStackInSlot(i);
			if(stack != null && stack.getItem() != null && stack.getItem() == item) return stack;
		}
		return null;
	}

	public static List<ItemStack> findBlocksInInv(IInventory inv, Block block){ return findItemsInInv(inv, Item.getItemFromBlock(block)); }

	public static List<ItemStack> findItemsInInv(IInventory inv, Item item){
		List<ItemStack> result = Lists.newArrayList();
		for(int i = 0; i < inv.getSizeInventory(); i++){
			ItemStack stack = inv.getStackInSlot(i);
			if(stack != null && stack.getItem() != null && stack.getItem() == item) result.add(stack);
		}
		return result;
	}

	public static ItemStack findBlockInPlayerHotbar(EntityPlayer player, Block block){ return findItemInPlayerHotbar(player, Item.getItemFromBlock(block)); }

	public static ItemStack findItemInPlayerHotbar(EntityPlayer player, Item item){
		InventoryPlayer playerInv = player.inventory;
		for(int i = 0; i < 9; i++){
			ItemStack stack = playerInv.getStackInSlot(i);
			if(stack != null && stack.getItem() != null && stack.getItem() == item) return stack;
		}
		return null;
	}

	public static ItemStack findBlockInPlayerInv(EntityPlayer player, Block block){ return findItemInInv(player.inventory, Item.getItemFromBlock(block)); }

	public static ItemStack findItemInPlayerInv(EntityPlayer player, Item item){ return findItemInInv(player.inventory, item); }

	public static List<ItemStack> findBlocksInPlayerHotbar(EntityPlayer player, Block block){ return findItemsInPlayerHotbar(player, Item.getItemFromBlock(block)); }

	public static List<ItemStack> findItemsInPlayerHotbar(EntityPlayer player, Item item){
		List<ItemStack> result = Lists.newArrayList();
		InventoryPlayer playerInv = player.inventory;
		for(int i = 0; i < 9; i++){
			ItemStack stack = playerInv.getStackInSlot(i);
			if(stack != null && stack.getItem() != null && stack.getItem() == item) result.add(stack);
		}
		return result;
	}

	public static List<ItemStack> findBlocksInPlayerInv(EntityPlayer player, Block block){ return findItemsInPlayerInv(player, Item.getItemFromBlock(block)); }

	public static List<ItemStack> findItemsInPlayerInv(EntityPlayer player, Item item){ return findItemsInInv(player.inventory, item); }

	public static List<ItemStack> getPlayerMainInventory(EntityPlayer player){
		List<ItemStack> result = Lists.newArrayList();
		for(ItemStack stack: player.inventory.mainInventory) if(stack != null) result.add(stack);
		return result;
	}

	public static int countBlockInPlayerInventory(EntityPlayer player, Block block){ return countItemInPlayerInventory(player, Item.getItemFromBlock(block)); }

	public static int countItemInPlayerInventory(EntityPlayer player, Item item){ return countStackInPlayerInventory(player, new ItemStack(item)); }

	public static int countStackInPlayerInventory(EntityPlayer player, ItemStack stack){
		int result = 0;
		InventoryPlayer playerInv = player.inventory;
		for(ItemStack stack1: playerInv.mainInventory) if(stack1 != null && stack1.getItem() != null) if(areItemsEqual(stack, stack1)) result += stack1.stackSize;
		return result;
	}

	public static int decrBlocksInPlayerInventory(EntityPlayer player, Block block, int amount){ return decrItemsInPlayerInventory(player, Item.getItemFromBlock(block), amount); }

	public static int decrItemsInPlayerInventory(EntityPlayer player, Item item, int amount){ return dectStackInPlayerInventory(player, new ItemStack(item, amount)); }

	public static int dectStackInPlayerInventory(EntityPlayer player, ItemStack stack){
		int result = stack.stackSize;
		InventoryPlayer playerInv = player.inventory;
		int index = 0;
		for(ItemStack stack1: playerInv.mainInventory){
			if(stack1 != null && stack1.getItem() != null){
				if(areItemsEqual(stack, stack1)){
					if(stack1.stackSize < result){
						result -= stack1.stackSize;
						playerInv.setInventorySlotContents(index, null);
					}
					else stack1.stackSize -= result;
					if(stack1.stackSize == 0) playerInv.setInventorySlotContents(index, null);
				}
			}
			index++;
		}
		return result;
	}

}
