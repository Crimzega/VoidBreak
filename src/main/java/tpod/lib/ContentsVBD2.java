package tpod.lib;

import net.minecraftforge.common.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.world.biome.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;

public class ContentsVBD2{

	public static final int guiUltimaniumFurnace = 0;
	public static final String MODID = "VoidBreakDemo2";
	public static final String NAME = "Void Break (Demo 2)";
	public static final String VERSION = "PreBeta v1 r1";
	public static final String CLIENT = "tpod.lib.ClientVBD2";
	public static final String SERVER = "tpod.lib.ServerVBD2";
	public static String[][] basics = {{ "TT", "TT" }, { "TTT", "TTT", "TTT" }, { "TTT", "TPT", "TTT" }, { "TTT", "T T", "TTT" }, { "T", "T" }, { "T T", " T " }};;
	public static String[][] armor = {{ "TTT", "T T" }, { "T T", "TTT", "TTT" }, { "TTT", "T T", "T T" }, { "T T", "T T" }};
	public static String[][] tools = {{ "T", "T", "P" }, { "T", "P", "P" }, { "TTT", " P ", " P " }, { "TT", "TP", " P" }, { "TT", " P", " P" }};
	public static Item spawnSpheres;
	public static AchievementPage voidBreakAP;
	public static Achievement[] achievements;
	public static ItemArmor.ArmorMaterial[] armorMaterials;
	public static BiomeGenBase[] biomes;
	public static Block[] ores;
	public static Block[] blocks;
	public static Block[] interactive;
	public static Block[] portals;
	public static CreativeTabs[] creativeTabs;
	public static Item.ToolMaterial[] toolMaterials;
	public static Item[] items;
	public static Item[] food;
	public static Item[] drinks;
	public static Item[] swords;
	public static Item[] spades;
	public static Item[] pickaxes;
	public static Item[] axes;
	public static Item[] hoes;
	public static Item[] helmets;
	public static Item[] chestplates;
	public static Item[] leggings;
	public static Item[] boots;

	public ContentsVBD2(){
		ContentsVBD2.biomes = new BiomeGenBase[1];
		ContentsVBD2.achievements = new Achievement[20];
		ContentsVBD2.creativeTabs = new CreativeTabs[5];
		ContentsVBD2.ores = new Block[4];
		ContentsVBD2.blocks = new Block[12];
		ContentsVBD2.interactive = new Block[4];
		ContentsVBD2.portals = new Block[1];
		ContentsVBD2.armorMaterials = new ItemArmor.ArmorMaterial[4];
		ContentsVBD2.toolMaterials = new Item.ToolMaterial[4];
		ContentsVBD2.items = new Item[18];
		ContentsVBD2.food = new Item[3];
		ContentsVBD2.drinks = new Item[3];
		ContentsVBD2.swords = new Item[14];
		ContentsVBD2.spades = new Item[14];
		ContentsVBD2.pickaxes = new Item[14];
		ContentsVBD2.axes = new Item[14];
		ContentsVBD2.hoes = new Item[14];
		ContentsVBD2.helmets = new Item[14];
		ContentsVBD2.chestplates = new Item[14];
		ContentsVBD2.leggings = new Item[14];
		ContentsVBD2.boots = new Item[14];
	}

}
