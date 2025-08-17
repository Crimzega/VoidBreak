package com.sulvic.mcf.common;

import com.sulvic.mcf.event.RecipeCraftedEvent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;

public class CraftingHelper{

	public static void triggerAchievements(ItemStack stack, EntityPlayer player){
		if(stack.getItem() == Item.getItemFromBlock(Blocks.crafting_table)) player.addStat(AchievementList.buildWorkBench, 1);
		if(stack.getItem() instanceof ItemPickaxe) player.addStat(AchievementList.buildPickaxe, 1);
		if(stack.getItem() == Item.getItemFromBlock(Blocks.furnace)) player.addStat(AchievementList.buildFurnace, 1);
		if(stack.getItem() instanceof ItemHoe) player.addStat(AchievementList.buildHoe, 1);
		if(stack.getItem() == Items.bread) player.addStat(AchievementList.makeBread, 1);
		if(stack.getItem() == Items.cake) player.addStat(AchievementList.bakeCake, 1);
		if(stack.getItem() instanceof ItemPickaxe && ((ItemPickaxe)stack.getItem()).func_150913_i() != Item.ToolMaterial.WOOD) player.addStat(AchievementList.buildBetterPickaxe, 1);
		if(stack.getItem() instanceof ItemSword) player.addStat(AchievementList.buildSword, 1);
		if(stack.getItem() == Item.getItemFromBlock(Blocks.enchanting_table)) player.addStat(AchievementList.enchantments, 1);
		if(stack.getItem() == Item.getItemFromBlock(Blocks.bookshelf)) player.addStat(AchievementList.bookcase, 1);
		RecipeCraftedEvent evt = new RecipeCraftedEvent(stack, player);
		if(!MinecraftForge.EVENT_BUS.post(evt)) return;
	}

}
