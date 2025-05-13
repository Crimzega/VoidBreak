package com.sulvic.voidbreak.common;

import static com.sulvic.voidbreak.common.SulvicObjects.*;
import static com.sulvic.voidbreak.lib.GemstoneData.Type.*;

import static net.minecraft.stats.AchievementList.*;

import java.util.List;

import com.google.common.collect.Lists;
import com.sulvic.mcf.util.StackHelper;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AcroxliAchievement extends Achievement{

	private static final List<AcroxliAchievement> ACHIEVEMENTS = Lists.newArrayList();
	public static final AcroxliAchievement NEW_GEMS = new AcroxliAchievement("newGems", 3, 1, new ItemStack(GEM, 1, ENSTATITE.getMetadata()), acquireIron).setCollection(Type.PICK_UP, GEM);
	private Type collectionType;
	private ItemStack collectionStack;

	public AcroxliAchievement(String id, int x, int y, Block block){ this(id, x, y, block, null); }

	public AcroxliAchievement(String id, int x, int y, Block block, Achievement parent){ this(id, x, y, Item.getItemFromBlock(block), parent); }

	public AcroxliAchievement(String id, int x, int y, Item item){ this(id, x, y, item, null); }

	public AcroxliAchievement(String id, int x, int y, Item item, Achievement parent){ this(id, x, y, new ItemStack(item), parent); }

	public AcroxliAchievement(String id, int x, int y, ItemStack stack){ this(id, x, y, stack, null); }

	public AcroxliAchievement(String id, int x, int y, ItemStack stack, Achievement parent){
		super(id, id, x, y, stack, parent);
		ACHIEVEMENTS.add(this);
	}

	public static AcroxliAchievement grabAchievement(Type type, Block block){ return grabAchievement(type, new ItemStack(block)); }

	public static AcroxliAchievement grabAchievement(Type type, Item item){ return grabAchievement(type, new ItemStack(item)); }

	public static AcroxliAchievement grabAchievement(Type type, ItemStack stack){
		if(stack == null || stack.getItem() == null) return null;
		for(AcroxliAchievement achievement: ACHIEVEMENTS) if(achievement.hasCollected(type, stack)) return achievement;
		return null;
	}

	public static void registerAchievements(){
		for(AcroxliAchievement achievement: ACHIEVEMENTS) achievement.registerStat();
		AchievementPage achievementPage = new AchievementPage("VoidBreak", ACHIEVEMENTS.toArray(new AcroxliAchievement[0]));
		AchievementPage.registerAchievementPage(achievementPage);
	}

	public AcroxliAchievement special(){
		setSpecial();
		return this;
	}

	public AcroxliAchievement setCollection(Type type, Block block){ return setCollection(type, new ItemStack(block)); }

	public AcroxliAchievement setCollection(Type type, Item item){ return setCollection(type, new ItemStack(item)); }

	public AcroxliAchievement setCollection(Type type, ItemStack stack){
		collectionType = type;
		collectionStack = stack;
		return this;
	}

	public boolean hasCollected(Type type, Block block){ return hasCollected(type, new ItemStack(block)); }

	public boolean hasCollected(Type type, Item item){ return hasCollected(type, new ItemStack(item)); }

	public boolean hasCollected(Type type, ItemStack stack){ return collectionType == type && StackHelper.areStacksEqual(collectionStack, stack); }

	public static enum Type{

		PICK_UP,
		CRAFT,
		SMELT,
		FUSE;

	}

}
