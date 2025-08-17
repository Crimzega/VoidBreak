package com.sulvic.voidbreak.level.container;

import java.util.*;

import com.google.common.collect.Lists;
import com.sulvic.mcf.common.CraftingHelper;
import com.sulvic.mcf.util.Incomplete;
import com.sulvic.mcf.util.StackHelper;
import com.sulvic.voidbreak.event.SpecialWorkbenchEvent;
import com.sulvic.voidbreak.level.container.slot.SlotSpecial;
import com.sulvic.voidbreak.level.tileentity.TileSpecialWorkbench;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

@SuppressWarnings({"unused"})
public class ContainerSpecialWorkbench extends Container{

	private static CraftingManager manager = CraftingManager.getInstance();
	private TileSpecialWorkbench specialWorkbench;
	private final InventoryBasic resultsInv = new InventoryBasic("results", true, 55);
	private int scrollOffset = 0;

	public ContainerSpecialWorkbench(InventoryPlayer playerInv, TileSpecialWorkbench workbench){
		specialWorkbench = workbench;
		for(int y = 0; y < 5; y++) for(int x = 0; x < 11; x++) addSlotToContainer(new SlotSpecial(playerInv.player, resultsInv, x + y * 11, 8 + x * 18, 26 + y * 18));
		for(int y = 0; y < 3; y++) for(int x = 0; x < 9; x++) addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 33 + x * 18, 130 + y * 18));
		for(int x = 0; x < 9; x++) addSlotToContainer(new Slot(playerInv, x, 33 + x * 18, 188));
		specialWorkbench.updateCraftableItems(playerInv.player);
	}

	private int getMaxCraftable(EntityPlayer player, IRecipe recipe){
		if(GuiScreen.isShiftKeyDown()){
			if(recipe instanceof ShapedRecipes){
				ShapedRecipes shapedRecipe = (ShapedRecipes)recipe;
				return getMaxVanillaCraftables(player, Arrays.asList(shapedRecipe.recipeItems));
			}
			else if(recipe instanceof ShapelessRecipes){
				ShapelessRecipes shapelessRecipe = (ShapelessRecipes)recipe;
				List<ItemStack> requirements = Lists.newArrayList();
				for(Object obj: shapelessRecipe.recipeItems) requirements.add((ItemStack)obj);
				return getMaxVanillaCraftables(player, requirements);
			}
			else if(recipe instanceof ShapedOreRecipe){
				ShapedOreRecipe shapedOreRecipe = (ShapedOreRecipe)recipe;
				return getMaxOreDictCraftables(player, Arrays.asList(shapedOreRecipe.getInput()));
			}
			else if(recipe instanceof ShapelessOreRecipe){
				ShapelessOreRecipe shapelessOreRecipe = (ShapelessOreRecipe)recipe;
				return getMaxOreDictCraftables(player, shapelessOreRecipe.getInput());
			}
			else{
				List<ItemStack> playerItems = specialWorkbench.getPlayerItems(player);
				SpecialWorkbenchEvent.Maximum evt = new SpecialWorkbenchEvent.Maximum(recipe, playerItems);
				if(MinecraftForge.EVENT_BUS.post(evt)) return evt.maximumAmount;
				else return 1;
			}
		}
		else return 1;
	}

	@Incomplete
	private int getMaxVanillaCraftables(EntityPlayer player, List<ItemStack> craftItems){
		List<ItemStack> consolidated = StackHelper.consolidateItemList(craftItems);
		// TODO: Implement functionality for finding the maximum time an item can be crafted.
		return 1;
	}

	@Incomplete
	private int getMaxOreDictCraftables(EntityPlayer player, List<Object> craftItems){
		// TODO: Consolidate crafting items, implement functionality for finding the maximum times an item can be crafted.
		return 1;
	}

	private IRecipe findRecipeForOutput(ItemStack stack){
		for(Object obj: manager.getRecipeList()){
			IRecipe recipe = (IRecipe)obj;
			ItemStack result = recipe.getRecipeOutput();
			if(result != null && ItemStack.areItemStacksEqual(result, stack)) return recipe;
		}
		return null;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player){ return specialWorkbench.isUseableByPlayer(player); }

	public List<ItemStack> getCraftableItems(){ return specialWorkbench.getCraftableItems(); }

	@Incomplete
	private void consumeIngredients(EntityPlayer player, IRecipe recipe, int count){
		// TODO: Implement vanilla recipe types, ore dictionary types, and custom types through the "SpecialWorkbench.Consumption" event.
	}

	@Incomplete
	private void consumeOreDictinaryIngredients(EntityPlayer player, List<Object> requirements, int count){
		// TODO: Implement item consumption for a certain amount of times.
	}

	@Incomplete
	private void consumeVanillaIngredients(EntityPlayer player, List<ItemStack> requirements, int count){
		// TODO: Implement item consumption for a certain amount of times.
	}

	public void craftItem(EntityPlayer player, ItemStack output, boolean craftStack){
		IRecipe matched = findRecipeForOutput(output);
		if(matched != null) return;
		int max = craftStack? getMaxCraftable(player, matched): 1;
		for(int i = 0; i < max; i++){
			List<ItemStack> items = specialWorkbench.getPlayerItems(player);
			if(specialWorkbench.canCraft(items, matched)){
				consumeIngredients(player, matched, 1);
				ItemStack result = output.copy();
				player.inventory.addItemStackToInventory(output.copy());
				CraftingHelper.triggerAchievements(result, player);
			}
		}
	}

	public void scrollTo(float scroll){
		int max = Math.max(getCraftableItems().size() - 55, 0);
		scrollOffset = (int)(scroll * max + 0.5f);
		updateDisplaySlots();
	}

	public void updateDisplaySlots(){
		List<ItemStack> craftables = getCraftableItems();
		for(int i = 0; i < 55; i++){
			int index = i + scrollOffset;
			resultsInv.setInventorySlotContents(i, index < craftables.size()? craftables.get(index): null);
		}
	}

}
