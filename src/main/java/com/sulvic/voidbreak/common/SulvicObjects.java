package com.sulvic.voidbreak.common;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

import com.sulvic.voidbreak.VoidBreak;
import com.sulvic.voidbreak.level.item.*;
import com.sulvic.voidbreak.level.tileentity.*;
import com.sulvic.voidbreak.level.world.biome.*;
import com.sulvic.voidbreak.level.world.block.*;
import com.sulvic.voidbreak.level.world.provider.WorldProviderNothing;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.oredict.OreDictionary;

public class SulvicObjects{

	private static int currentBiomeId = VoidBreak.getConfig().getBiomeStartID();
	private static int currentDimensionId = VoidBreak.getConfig().getDimensionStartID();

	// Biome Section
	public static final BiomeFlatlands FLATLANDS = new BiomeFlatlands();
	public static final BiomeCitrusGrove CITRUS_GROVE = new BiomeCitrusGrove();
	public static final BiomeNothing NOTHING_BIOME = new BiomeNothing();

	// Block Section
	public static final LogCitrus CITRUS_LOG = new LogCitrus();
	public static final LeavesCitrus CITRUS_LEAVES = new LeavesCitrus();
	public static final SaplingCitrus CITRUS_SAPLING = new SaplingCitrus();
	public static final PlanksCitrus CITRUS_PLANKS = new PlanksCitrus();
	public static final StairsCitrus CITRUS_STAIRS = new StairsCitrus();
	public static final SlabCitrus CITRUS_SLAB = new SlabCitrus(false), CITRUS_DOUBLE_SLAB = new SlabCitrus(true);
	public static final OreGem GEM_ORE = new OreGem();
	public static final OreSpecial SPECIAL_ORE = new OreSpecial();
	public static final OreZecha ZECHA_ORE = new OreZecha();
	public static final BlockGem GEM_BLOCK = new BlockGem();
	public static final BlockUltimanium ULTIMANIUM_BLOCK = new BlockUltimanium();
	public static final BlockSpecial SPECIAL_BLOCK = new BlockSpecial();
	public static final BlockSpecialMetal SPECIAL_METAL_BLOCK = new BlockSpecialMetal();
	public static final BlockZecha ZECHA_BLOCK = new BlockZecha();
	public static final BlockUltine ULTINE_BLOCK = new BlockUltine();
	public static final CropSweetPotato SWEET_POTATO_CROP = new CropSweetPotato();
	public static final BlockSugar SUGAR_BLOCK = new BlockSugar();
	public static final PileSugar SUGAR_PILE = new PileSugar();
	public static final BlockBurntSugar BURNT_SUGAR_BLOCK = new BlockBurntSugar();
	public static final PileBurntSugar BURNT_SUGAR_PILE = new PileBurntSugar();
	public static final BlockSpecialWorkbench SPECIAL_WORKBENCH = new BlockSpecialWorkbench();
	public static final BlockZechaDrawer ZECHA_DRAWER = new BlockZechaDrawer();
	public static final BlockVoidGem VOID_GEM_BLOCK = new BlockVoidGem();
	public static final BlockNothing NOTHING_BLOCK = new BlockNothing();

	// Item Section
	public static final ItemGem GEM = new ItemGem();
	public static final ItemUltimaniumIngot ULTIMANIUM_INGOT = new ItemUltimaniumIngot();
	public static final ItemSpecialDust SPECIAL_DUST = new ItemSpecialDust();
	public static final ItemSpecialIngot SPECIAL_INGOT = new ItemSpecialIngot();
	public static final ItemZechaIngot ZECHA_INGOT = new ItemZechaIngot();
	public static final ItemSweetPotato SWEET_POTATO = new ItemSweetPotato();
	public static final ItemBakedSweetPotato BAKED_SWEET_POTATO = new ItemBakedSweetPotato();
	public static final ItemEnergyBar ENERGY_BAR = new ItemEnergyBar();
	public static final ItemOrange ORANGE = new ItemOrange();
	public static final ItemOrangeSlice ORANGE_SLICE = new ItemOrangeSlice();
	public static final ItemOrangeWedge ORANGE_WEDGE = new ItemOrangeWedge();
	public static final ItemOrangePeel ORANGE_PEEL = new ItemOrangePeel();

	public static int getBiomeId(){ return currentBiomeId++; }

	public static int getDimensionId(){ return currentDimensionId++; }

	public static void registerItems(){
		// Block Registering Section
		GameRegistry.registerBlock(CITRUS_LOG, "citrus_log");
		GameRegistry.registerBlock(CITRUS_LEAVES, "citrus_leaves");
		GameRegistry.registerBlock(CITRUS_SAPLING, "citrus_sapling");
		GameRegistry.registerBlock(CITRUS_PLANKS, "citrus_planks");
		GameRegistry.registerBlock(CITRUS_STAIRS, "citrus_stairs");
		GameRegistry.registerBlock(CITRUS_SLAB, ItemSlabCitrus.class, "citrus_slab", CITRUS_SLAB, CITRUS_DOUBLE_SLAB, false);
		GameRegistry.registerBlock(CITRUS_DOUBLE_SLAB, ItemSlabCitrus.class, "citrus_slab_double", CITRUS_SLAB, CITRUS_DOUBLE_SLAB, true);
		GameRegistry.registerBlock(GEM_ORE, ItemOreGem.class, "gem_ore");
		GameRegistry.registerBlock(SPECIAL_ORE, "special_ore");
		GameRegistry.registerBlock(ZECHA_ORE, "zecha_ore");
		GameRegistry.registerBlock(GEM_BLOCK, ItemBlockGem.class, "gem_block");
		GameRegistry.registerBlock(ULTIMANIUM_BLOCK, "ultimanium_block");
		GameRegistry.registerBlock(SPECIAL_BLOCK, "special_block");
		GameRegistry.registerBlock(SPECIAL_METAL_BLOCK, "special_metal_block");
		GameRegistry.registerBlock(ZECHA_BLOCK, "zecha_block");
		GameRegistry.registerBlock(ULTINE_BLOCK, "ultine_block");
		GameRegistry.registerBlock(SWEET_POTATO_CROP, "sweet_potato_crop");
		GameRegistry.registerBlock(SUGAR_BLOCK, "sugar_block");
		GameRegistry.registerBlock(SUGAR_PILE, "sugar_pile");
		GameRegistry.registerBlock(BURNT_SUGAR_BLOCK, "burnt_sugar_block");
		GameRegistry.registerBlock(BURNT_SUGAR_PILE, "burnt_sugar_pile");
		GameRegistry.registerBlock(SPECIAL_WORKBENCH, "special_workbench");
		GameRegistry.registerBlock(ZECHA_DRAWER, "zecha_drawer");
		GameRegistry.registerBlock(VOID_GEM_BLOCK, ItemBlockVoidGem.class, "void_gem_block");
		GameRegistry.registerBlock(NOTHING_BLOCK, "nothing_block");

		// Item Registration Section
		GameRegistry.registerItem(GEM, "gem");
		GameRegistry.registerItem(ULTIMANIUM_INGOT, "ultimanium_ingot");
		GameRegistry.registerItem(SPECIAL_DUST, "special_dust");
		GameRegistry.registerItem(SPECIAL_INGOT, "special_ingot");
		GameRegistry.registerItem(ZECHA_INGOT, "zecha_ingot");
		GameRegistry.registerItem(SWEET_POTATO, "sweet_potato");
		GameRegistry.registerItem(BAKED_SWEET_POTATO, "baked_sweet_potato");
		GameRegistry.registerItem(ENERGY_BAR, "energy_bar");
		GameRegistry.registerItem(ORANGE, "orange");
		GameRegistry.registerItem(ORANGE_SLICE, "orange_slice");
		GameRegistry.registerItem(ORANGE_WEDGE, "orange_wedge");
		GameRegistry.registerItem(ORANGE_PEEL, "orange_peel");

		// Ore Dictionary Registration Section
		OreDictionary.registerOre("logWood", CITRUS_LOG);
		OreDictionary.registerOre("plankWood", CITRUS_PLANKS);
		OreDictionary.registerOre("slabWood", CITRUS_SLAB);
		OreDictionary.registerOre("stairWood", CITRUS_STAIRS);
		OreDictionary.registerOre("treeSapling", CITRUS_SAPLING);
		OreDictionary.registerOre("treeLeaves", CITRUS_LEAVES);

		// Tile Entity Registration Section
		GameRegistry.registerTileEntity(TileSpecialWorkbench.class, "SpecialWorkbench");
		GameRegistry.registerTileEntity(TileZechaDrawer.class, "ZechaDrawer");
	}

	public static void registerBiomes(){
		BiomeDictionary.registerBiomeType(FLATLANDS, SPARSE, DRY, PLAINS);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(FLATLANDS, 4));
		BiomeManager.addSpawnBiome(FLATLANDS);
		BiomeDictionary.registerBiomeType(CITRUS_GROVE, LUSH, FOREST);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(CITRUS_GROVE, 6));
		BiomeDictionary.registerBiomeType(NOTHING_BIOME, COLD, SPARSE, DRY, SPOOKY, DEAD, WASTELAND);
	}

	public static void registerDimensions(){
		DimensionManager.registerProviderType(WorldProviderNothing.dimensionID, WorldProviderNothing.class, false);
		DimensionManager.registerDimension(WorldProviderNothing.dimensionID, WorldProviderNothing.dimensionID);
	}

}
