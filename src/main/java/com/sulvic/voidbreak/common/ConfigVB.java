package com.sulvic.voidbreak.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sulvic.mcf.common.BezkinConfig;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigVB extends BezkinConfig{

	private static final String CATEGORY_BASE = "VoidBreak";
	private static final String CATEGORY_IDS = CATEGORY_BASE + ".IDs";
	private static final String CATEGORY_RECIPES = CATEGORY_BASE + ".Recipes";
	private static final String CATEGORY_WORLD = CATEGORY_BASE + ".World";
	private static Logger configLog = LogManager.getLogger("VB Config");
	private String[] pileBlocks;
	private boolean allowEnchantedRecipes, enhancedHoes;
	private int biomeStartID, dimensionStartID, entityStartID;

	public ConfigVB(FMLPreInitializationEvent evt){ super(evt, "VoidBreak.cfg", "v1", true); }

	@Override
	protected void makeConfig(){
		theConfig.load();
		try{
			allowEnchantedRecipes = theConfig.getBoolean("allowEnchantedRecipes", CATEGORY_RECIPES, true, "Allows mod items to be enchanted when crafted.");
			biomeStartID = theConfig.getInt("biomeStartID", CATEGORY_IDS, 200, 160, 420, "Sets the mods starting biome ID.");
			entityStartID = theConfig.getInt("eneityStartID", CATEGORY_IDS, 300, 280, 560, "Sets the mods starting entity ID.");
			dimensionStartID = theConfig.getInt("dimensionStartID", CATEGORY_IDS, 6000, 2000, 20000, "Sets the mods starting dimension ID.");
			pileBlocks = theConfig.getStringList("pileBlocks", CATEGORY_WORLD, new String[0], "Adds blocks for the sugar piles to be allowed on. (e.g: modid:blockname)");
			enhancedHoes = theConfig.getBoolean("enhancedHoes", CATEGORY_WORLD, false, "Allows hoes to make farmland over more than one block.");
		}
		catch(Exception ex){
			configLog.warn("An error has occured while compiling the config file.", ex);
		}
		finally{
			if(theConfig.hasChanged()) theConfig.save();
		}
	}

	public String[] getPileBlocks(){ return pileBlocks; }

	public boolean allowEnchantedRecipes(){ return allowEnchantedRecipes; }

	public boolean getEnhancedHoes(){ return enhancedHoes; }

	public int getBiomeStartID(){ return biomeStartID; }

	public int getDimensionStartID(){ return dimensionStartID; }

	public int getEntityStartID(){ return entityStartID; }

}
