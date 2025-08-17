package com.sulvic.voidbreak.level.tileentity;

import java.util.*;

import com.google.common.collect.*;
import com.sulvic.mcf.common.OreStack;
import com.sulvic.mcf.util.*;
import com.sulvic.voidbreak.event.SpecialWorkbenchEvent;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.*;

@SuppressWarnings({"unchecked"})
public class TileSpecialWorkbench extends TileEntity{

	private static CraftingManager manager = CraftingManager.getInstance();
	private List<ItemStack> craftableItems = Lists.newArrayList();
	private Map<ItemStack, Integer> craftableItemIndices = Maps.newHashMap();
	private String customName, targetName;

	@Incomplete
	private boolean canCraftOreDict(List<ItemStack> playerItems, Object... recipeItems){
		List<ItemStack> invItems = Lists.newArrayList(playerItems), requiredBasic = Lists.newArrayList();
		List<OreStack> requiredOres = Lists.newArrayList();
		for(Object obj: recipeItems){
			if(obj instanceof ItemStack) requiredBasic.add((ItemStack)obj);
			if(obj instanceof ArrayList){
				ArrayList<ItemStack> oreList = (ArrayList<ItemStack>)obj;
				OreStack oreStack = ZimedaForge.findOreDictionary(oreList);
				if(oreStack != null) requiredOres.add(oreStack);
			}
		}
		for(ItemStack required: requiredBasic){
			boolean found = false;
			for(ItemStack stack: invItems){
				if(stack != null && ItemStack.areItemStacksEqual(stack, required) && stack.stackSize >= required.stackSize){
					stack.stackSize -= required.stackSize;
					if(stack.stackSize <+ 0) invItems.remove(stack);
					found = true;
					break;
				}
			}
			if(!found) return false;
		}
		for(OreStack requiredOre: requiredOres){
			boolean matchFound = false;
			for(ItemStack stack: invItems){
				if(stack != null && requiredOre.hasMatchingItem(stack) && stack.stackSize >= requiredOre.stackSize){
					stack.stackSize -= requiredOre.stackSize;
					if(stack.stackSize <= 0) invItems.remove(stack);
					matchFound = true;
					break;
				}
				if(!matchFound) return false;
			}
		}
		return true;
	}

	private boolean canCraftVanilla(List<ItemStack> playerItems, ItemStack... recipeItems){
		List<ItemStack> invItems = Lists.newArrayList(playerItems), required = Lists.newArrayList(recipeItems);
		for(ItemStack entry: required){
			boolean found = false;
			for(ItemStack stack: invItems) if(stack != null && ItemStack.areItemStacksEqual(stack, entry) && stack.stackSize >= entry.stackSize){
				stack.stackSize -= entry.stackSize;
				found = true;
				break;
			}
			if(!found) return false;
		}
		return true;
	}

	public boolean canCraft(List<ItemStack> items, IRecipe recipe){
		if(recipe instanceof ShapedRecipes)
			return canCraftVanilla(items, ((ShapedRecipes)recipe).recipeItems);
		else if(recipe instanceof ShapelessRecipes){
			ShapelessRecipes shapelessRecipe = (ShapelessRecipes)recipe;
			List<ItemStack> entries = Lists.newArrayList();
			for(Object obj: shapelessRecipe.recipeItems) entries.add((ItemStack)obj);
			return canCraftVanilla(items, entries.toArray(new ItemStack[0]));
		}
		else if(recipe instanceof ShapedOreRecipe){
			ShapedOreRecipe shapedOreRecipe = (ShapedOreRecipe)recipe;
			shapedOreRecipe.getInput();
			return canCraftOreDict(items, shapedOreRecipe.getInput());
		}
		else if(recipe instanceof ShapelessOreRecipe){
			ShapelessOreRecipe shapelessOreRecipe = (ShapelessOreRecipe)recipe;
			shapelessOreRecipe.getInput();
			return canCraftOreDict(items, shapelessOreRecipe.getInput().toArray());
		}
		else{
			SpecialWorkbenchEvent.Craftable evt = new SpecialWorkbenchEvent.Craftable(recipe, items);
			if(MinecraftForge.EVENT_BUS.post(evt)) return evt.isCraftable;
			else return false;
		}
	}

	public boolean hasCustomInventoryName(){ return !ZimedaString.isNullOrEmpty(customName); }

	public boolean isUseableByPlayer(EntityPlayer player){ return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && ZimedaMath.tileEntityWithinRange(this, player, 64d); }

	public int getCraftableItemIndex(ItemStack stack){ return craftableItemIndices.get(stack); }

	public List<ItemStack> getCraftableItems(){
		if(!ZimedaString.isNullOrEmpty(targetName)){
			List<ItemStack> filtered = new ArrayList<>();
			for(ItemStack stack: craftableItems) if(stack.getDisplayName().toLowerCase().contains(targetName.toLowerCase())) filtered.add(stack);
			return Collections.unmodifiableList(filtered);
		}
		return Collections.unmodifiableList(craftableItems);
	}

	public List<ItemStack> getPlayerItems(EntityPlayer player){
		List<ItemStack> result = Lists.newArrayList(), playerItems = StackHelper.getPlayerMainInventory(player);
		for(ItemStack stack: playerItems) if(stack != null) result.add(stack.copy());
		return result;
	}

	public String getInventoryName(){ return hasCustomInventoryName()? customName: "container.specialWorkbench"; }

	public void clearTargetName(){ targetName = ""; }

	public void setCustomInventoryName(String name){ customName = name; }

	public void setTargetItemName(String name){ targetName = name; }

	public void updateCraftableItems(EntityPlayer player){
		craftableItems.clear();
		craftableItemIndices.clear();
		List<ItemStack> playerItems = getPlayerItems(player);
		int index = 0;
		for(Object obj: manager.getRecipeList()){
			IRecipe recipe = (IRecipe)obj;
			if(canCraft(playerItems, recipe)){
				ItemStack output = recipe.getRecipeOutput();
				if(output != null){
					craftableItems.add(output);
					craftableItemIndices.put(output, index++);
				}
			}
		}
	}

}
