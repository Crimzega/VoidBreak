package com.sulvic.voidbreak.level.tileentity;

import java.util.*;

import com.google.common.collect.*;
import com.sulvic.mcf.event.RecipeEvent;
import com.sulvic.mcf.util.*;

import net.minecraft.block.Block;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class TileSpecialWorkbench extends TileEntity{

	private List<ItemStack> craftableItems = Lists.newArrayList(), maximumItems = Lists.newArrayList();
	private Map<ItemStack, Integer> craftableItemIndices = Maps.newHashMap();
	private String customName;

	private void getPlayerItems(EntityPlayer player){
		InventoryPlayer playerInv = player.inventory;
		ItemStack[] mainInv = playerInv.mainInventory;
		for(int i = 0; i < mainInv.length; i++){
			ItemStack stack = mainInv[i];
			if(stack != null && stack.getItem() != null){
				boolean hasStack = false;
				for(ItemStack stack1: maximumItems){
					hasStack = StackHelper.areItemsEqual(stack1, stack);
					if(hasStack){
						int index = maximumItems.indexOf(stack1);
						maximumItems.get(index).stackSize += stack1.stackSize;
						break;
					}
				}
				if(!hasStack) maximumItems.add(stack);
			}
		}
	}

	public boolean hasCustomInventoryName(){ return !ZimedaString.isNullOrEmpty(customName); }

	public boolean isUseableByPlayer(EntityPlayer player){ return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && ZimedaMath.tileEntityWithinRange(this, player, 64d); }

	private boolean canCraftOreDict(List<Object> oreDictInputs){
		List<ItemStack> stdInputs = Lists.newArrayList();
		List<List<ItemStack>> oreInputs = Lists.newArrayList();
		for(Object obj: oreDictInputs){
			if(obj instanceof ItemStack) stdInputs.add((ItemStack)obj);
			if(obj instanceof ArrayList) oreInputs.add((ArrayList<ItemStack>)obj);
		}
		boolean hasOreDicts = true;
		for(List<ItemStack> oreStacks: oreInputs) hasOreDicts &= StackHelper.hasAnyOreItems(maximumItems, oreStacks);
		return StackHelper.hasAllItems(maximumItems, stdInputs) && hasOreDicts;
	}

	private boolean canCraft(EntityPlayer player, IRecipe recipe){
		if(recipe instanceof ShapedRecipes){
			ShapedRecipes shapedRecipe = (ShapedRecipes)recipe;
			return StackHelper.hasAllItems(maximumItems, Arrays.asList(shapedRecipe.recipeItems));
		}
		else if(recipe instanceof ShapelessRecipes){
			ShapelessRecipes shapelessRecipe = (ShapelessRecipes)recipe;
			List<ItemStack> requirements = Lists.newArrayList();
			for(Object obj: shapelessRecipe.recipeItems){
				ItemStack stack = null;
				if(obj instanceof ItemStack) stack = (ItemStack)obj;
				if(obj instanceof Item) stack = new ItemStack((Item)obj);
				if(obj instanceof Block) stack = new ItemStack((Block)obj);
				for(ItemStack stack1: requirements) if(!StackHelper.areItemsEqual(stack1, stack)) requirements.add(stack);
			}
			return StackHelper.hasAllItems(maximumItems, requirements);
		}
		else if(recipe instanceof ShapedOreRecipe){
			ShapedOreRecipe shapedOreRecipe = (ShapedOreRecipe)recipe;
			Object[] inputs = shapedOreRecipe.getInput();
			return canCraftOreDict(Arrays.asList(inputs));
		}
		else if(recipe instanceof ShapelessOreRecipe){
			ShapelessOreRecipe shapelessOreRecipe = (ShapelessOreRecipe)recipe;
			List<Object> inputs = shapelessOreRecipe.getInput();
			return canCraftOreDict(inputs);
		}
		else{
			RecipeEvent.CraftableEvent evt = new RecipeEvent.CraftableEvent(player, recipe);
			if(MinecraftForge.EVENT_BUS.post(evt)) return evt.isCraftable;
			else return false;
		}
	}

	public int getCraftableItemIndex(ItemStack stack){ return craftableItemIndices.get(stack); }

	public List<ItemStack> getCraftableItems(){ return Collections.unmodifiableList(craftableItems); }

	public String getInventoryName(){ return hasCustomInventoryName()? customName: "container.specialWorkbench"; }

	public void setCustomInventoryName(String name){ customName = name; }

	public void updateCraftableItems(EntityPlayer player){
		maximumItems.clear();
		craftableItems.clear();
		craftableItemIndices.clear();
		getPlayerItems(player);
		CraftingManager manager = CraftingManager.getInstance();
		List list = manager.getRecipeList();
		int index = 0;
		for(Object obj: list){
			IRecipe recipe = (IRecipe)obj;
			if(canCraft(player, recipe)){
				ItemStack stack = recipe.getRecipeOutput();
				craftableItems.add(stack);
				craftableItemIndices.put(stack, index);
			}
			index++;
		}
	}

}
