package com.sulvic.voidbreak.level.container;

import java.util.*;

import com.google.common.collect.*;
import com.sulvic.mcf.event.RecipeEvent;
import com.sulvic.mcf.util.StackHelper;
import com.sulvic.voidbreak.level.tileentity.TileSpecialWorkbench;

import net.minecraft.block.Block;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.*;

@SuppressWarnings({"unchecked"})
public class ContainerSpecialWorkbench extends Container{

	private static CraftingManager manager = CraftingManager.getInstance();
	private final InventoryBasic basicInv = new InventoryBasic("results", true, 55);
	private boolean shiftHeld = false;
	private TileSpecialWorkbench specialWorkbench;
	private int scrollOffset;

	public ContainerSpecialWorkbench(InventoryPlayer playerInv, TileSpecialWorkbench workbench){
		specialWorkbench = workbench;
		for(int y = 0; y < 5; y++) for(int x = 0; x < 11; x++) addSlotToContainer(new Slot(basicInv, x + y * 11, 8 + x * 18, 18 + y * 18));
		for(int y = 0; y < 3; y++) for(int x = 0; x < 9; x++) addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 33 + x * 18, 122 + y * 18));
		for(int x = 0; x < 9; x++) addSlotToContainer(new Slot(playerInv, x, 33 + x * 18, 180));
		specialWorkbench.updateCraftableItems(playerInv.player);
		scrollTo(0f);
	}

	private void consumeOreDictIngredients(EntityPlayer player, List<Object> oreDictInputs, int amount){
		List<ItemStack> stdItems = Lists.newArrayList();
		List<List<ItemStack>> oreDictItems = Lists.newArrayList();
		for(Object obj: oreDictInputs) if(obj != null){
			if(obj instanceof ItemStack) stdItems.add((ItemStack)obj);
			if(obj instanceof List) oreDictItems.add((List<ItemStack>)obj);
		}
		for(ItemStack stack: stdItems) StackHelper.decrItemsInPlayerInventory(player, stack.getItem(), amount);
		for(List<ItemStack> stacks: oreDictItems){
			int finalAmount = amount;
			for(ItemStack stack: stacks) if(finalAmount > 0) finalAmount = StackHelper.decrItemsInPlayerInventory(player, stack.getItem(), finalAmount);
		}
	}

	private void consumeIngredients(EntityPlayer player, IRecipe recipe, int amount){
		if(recipe instanceof ShapedRecipes){
			ShapedRecipes shapedRecipe = (ShapedRecipes)recipe;
			for(ItemStack stack: shapedRecipe.recipeItems) if(stack != null && stack.getItem() != null) StackHelper.decrItemsInPlayerInventory(player, stack.getItem(), amount);
		}
		else if(recipe instanceof ShapelessRecipes){
			ShapelessRecipes shapelessRecipe = (ShapelessRecipes)recipe;
			List<ItemStack> inputs = Lists.newArrayList();
			for(Object obj: shapelessRecipe.recipeItems) if(obj != null){
				if(obj instanceof Block) inputs.add(new ItemStack((Block)obj));
				if(obj instanceof Item) inputs.add(new ItemStack((Item)obj));
				if(obj instanceof ItemStack) inputs.add((ItemStack)obj);
			}
			for(ItemStack stack: inputs) StackHelper.decrItemsInPlayerInventory(player, stack.getItem(), amount);
		}
		else if(recipe instanceof ShapedOreRecipe){
			ShapedOreRecipe shapedOreRecipe = (ShapedOreRecipe)recipe;
			Object[] inputs = shapedOreRecipe.getInput();
			consumeOreDictIngredients(player, Arrays.asList(inputs), amount);
		}
		else if(recipe instanceof ShapelessOreRecipe){
			ShapelessOreRecipe shapelessOreRecipe = (ShapelessOreRecipe)recipe;
			List<Object> inputs = shapelessOreRecipe.getInput();
			consumeOreDictIngredients(player, inputs, amount);
		}
		else{
			RecipeEvent.ConsumptionEvent evt = new RecipeEvent.ConsumptionEvent(player, recipe, amount);
			if(!MinecraftForge.EVENT_BUS.post(evt)) return;
		}
	}

	private void updateCraftableItems(EntityPlayer player){ specialWorkbench.updateCraftableItems(player); }

	private void updateDisplaySlots(){
		List<ItemStack> craftableItems = getCraftableItems();
		for(int i = 0; i < 55; i++){
			int index = scrollOffset + i;
			basicInv.setInventorySlotContents(i, index < craftableItems.size()? craftableItems.get(index): null);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){ return specialWorkbench.isUseableByPlayer(player); }

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index){
		if(shiftHeld && index < 50){
			Slot slot = (Slot)inventorySlots.get(index);
			ItemStack stack = slot.getStack();
		}
		return super.transferStackInSlot(player, index);
	}

	public List<ItemStack> getCraftableItems(){ return specialWorkbench.getCraftableItems(); }

	public void scrollTo(float value){
		int maxOffset = Math.max(getCraftableItems().size() - 55, 0);
		scrollOffset = (int)(value * maxOffset);
		updateDisplaySlots();
	}

}
