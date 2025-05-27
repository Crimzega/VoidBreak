package tpod.util;

import tpod.mods.*;

public class ConfigVBD2{

	public static final boolean ER_DEFAULT = false;
	public static final int BID_DEFAULT = 200;
	public static final int EID_DEFAULT = 300;
	public static boolean enchantedRecipes;
	public static int biomeIDs;
	public static int entityIDs;

	public static void setupDefaults() {
//		FMLCommonHandler.instance().bus().register((Object)VoidBreakDemo2.instance);
		VoidBreakDemo2.config.addCustomCategoryComment("Recipes", (String)null);
		ConfigVBD2.enchantedRecipes = VoidBreakDemo2.config.get("Recipes", "recipes", false).getBoolean(false);
		VoidBreakDemo2.log.info("Enchanted Recipes: " + ConfigVBD2.enchantedRecipes);
		VoidBreakDemo2.config.addCustomCategoryComment("BiomeIds", (String)null);
		ConfigVBD2.biomeIDs = VoidBreakDemo2.config.get("BiomeIds", "biomes", 200).getInt(200);
		VoidBreakDemo2.log.info("Starting Biome ID: " + ConfigVBD2.biomeIDs);
		VoidBreakDemo2.config.addCustomCategoryComment("EntityIds", (String)null);
		ConfigVBD2.entityIDs = VoidBreakDemo2.config.get("EntityIds", "entities", 300).getInt(300);
		VoidBreakDemo2.log.info("Starting Entity ID: " + ConfigVBD2.entityIDs);
	}

}
