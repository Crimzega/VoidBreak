package tpod.lib;

import net.minecraft.stats.*;
import tpod.util.*;
import tpod.biomes.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import tpod.blocks.*;
import tpod.blocks.subtypes.*;
import net.minecraft.creativetab.*;
import tpod.tabs.*;
import net.minecraftforge.common.util.*;
import tpod.items.*;
import tpod.util.registries.*;
import net.minecraft.item.*;

public class RegistrationVBD2{

	public static void initAchievements(){
		ContentsVBD2.achievements[0] = new Achievement("voidBreak.harderLife", "harderLife", 0, 0, ContentsVBD2.items[13], null).registerStat();
		ContentsVBD2.achievements[1] = new Achievement("voidBreak.nineHells", "nineHells", 2, 2, ContentsVBD2.items[11], ContentsVBD2.achievements[0]).setSpecial().registerStat();
		ContentsVBD2.achievements[2] = new Achievement("voidBreak.rubies", "rubies", 4, -3, new ItemStack(ContentsVBD2.ores[0], 1, 0), AchievementList.acquireIron).registerStat();
		ContentsVBD2.achievements[3] = new Achievement("voidBreak.pinkPanthers", "pinkPanthers", 5, -3, new ItemStack(ContentsVBD2.ores[0], 1, 1), AchievementList.acquireIron).registerStat();
		ContentsVBD2.achievements[4] = new Achievement("voidBreak.sapphires", "sapphires", 6, -3, new ItemStack(ContentsVBD2.ores[0], 1, 2), AchievementList.acquireIron).registerStat();
		AchievementPage.registerAchievementPage(ContentsVBD2.voidBreakAP = new AchievementPage("Void Break", ContentsVBD2.achievements));
	}

	public static void initBiomes() {
		BiomeDictionary.registerBiomeType(ContentsVBD2.biomes[0] = new BiomeGenFlatlands(ConfigVBD2.biomeIDs), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SPARSE);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ContentsVBD2.biomes[0], 100));
		BiomeManager.addSpawnBiome(ContentsVBD2.biomes[0]);
	}

	public static void initBlocks() {
		GameRegistry.registerBlock(ContentsVBD2.ores[0] = new JemOres().setBlockName("jemOre"), ItemJemOres.class, "jemOres");
		ContentsVBD2.ores[1] = new BlockRegistry1T("ultimaniumOre", Material.rock).hardResist(15.0f, 25.0f).harvestLvl("pickaxe", 3).stepSound(Block.soundTypePiston).texture().registerBlock();
		GameRegistry.registerBlock(ContentsVBD2.ores[2] = (Block)new ZetaOre(), "zetaOre");
		GameRegistry.registerBlock(ContentsVBD2.ores[3] = (Block)new ZechaOre(), "zechaOre");
		GameRegistry.registerBlock(ContentsVBD2.blocks[0] = new JemBlocks().setBlockName("jemBlock"), ItemJemBlocks.class, "jemBlocks");
		ContentsVBD2.blocks[1] = new BlockRegistry1T("ultimaniumBlock", Material.iron).hardResist(25.0f, 4.5E8f).harvestLvl("pikaxe", 3).stepSound(Block.soundTypeMetal).texture().registerBlock();
		ContentsVBD2.blocks[2] = new BlockRegistry1T("zetaBlock", Material.iron).hardResist(25.0f, 50.0f).harvestLvl("pickaxe", 3).stepSound(Block.soundTypeMetal).texture().registerBlock();
		GameRegistry.registerBlock(ContentsVBD2.blocks[3] = (Block)new ZechaBlock(), "zechaBlock");
		ContentsVBD2.blocks[4] = new BlockRegistry1T("sugarBlock", Material.rock).hardResist(2.0f, 3.0f).stepSound(Block.soundTypeGravel).texture().registerBlock();
		ContentsVBD2.blocks[5] = new BlockRegistry1T("antiSugarBlock", Material.rock).hardResist(2.0f, 3.0f).stepSound(Block.soundTypeGravel).texture().registerBlock();
		GameRegistry.registerBlock(ContentsVBD2.blocks[6] = new VoidJemBlocks().setBlockName("voidJemBlock"), ItemVoidJemBlocks.class, "voidJemBlocks");
		ContentsVBD2.blocks[7] = new BlockRegistry1T("yingsBlock", Material.cloth).hardResist(1.0f, 2.0f).stepSound(Block.soundTypeCloth).texture().registerBlock();
		ContentsVBD2.blocks[8] = new BlockRegistry1T("yangsBlock", Material.cloth).hardResist(1.0f, 2.0f).stepSound(Block.soundTypeCloth).texture().registerBlock();
		ContentsVBD2.blocks[9] = new BlockRegistry1T("deathFusionBlock", Material.iron).hardResist(45.0f, 90.0f).harvestLvl("pickaxe", 5).stepSound(Block.soundTypeMetal).texture().registerBlock();
		ContentsVBD2.blocks[10] = new BlockRegistry1T("nothingBlock", Material.cloth).hardResist(45.0f, 9.0E8f).lightLvlOpc(1.0f, 255).stepSound(Block.soundTypeCloth).texture().registerBlock();
	}

	public static void initCreativeTabs(){
		ContentsVBD2.creativeTabs[0] = new TabBlocks(CreativeTabs.getNextID(), "blocksVBD2");
		ContentsVBD2.creativeTabs[1] = new TabItems(CreativeTabs.getNextID(), "itemsVBD2");
		ContentsVBD2.creativeTabs[2] = new TabFoodDrinks(CreativeTabs.getNextID(), "foodDrinksVBD2");
		ContentsVBD2.creativeTabs[3] = new TabTools(CreativeTabs.getNextID(), "toolsVBD2");
		ContentsVBD2.creativeTabs[4] = new TabCombat(CreativeTabs.getNextID(), "combatVBD2");
	}

	public static void initDimension(){}

	public static void initEntities(){}

	public static void initEquip(){
		ContentsVBD2.swords[0] = new SwordRegistry("rubySword", ContentsVBD2.toolMaterials[0]).texture().registerSword();
		ContentsVBD2.spades[0] = new SpadeRegistry("rubySpade", ContentsVBD2.toolMaterials[0]).texture(4).registerSpade();
		ContentsVBD2.pickaxes[0] = new PickaxeRegistry("rubyPickaxe", ContentsVBD2.toolMaterials[0]).texture().registerPickaxe();
		ContentsVBD2.axes[0] = new AxeRegistry("rubyAxe", ContentsVBD2.toolMaterials[0]).texture().registerAxe();
		ContentsVBD2.swords[1] = new SwordRegistry("pinkPantherSword", ContentsVBD2.toolMaterials[0]).texture().registerSword();
		ContentsVBD2.spades[1] = new SpadeRegistry("pinkPantherSpade", ContentsVBD2.toolMaterials[0]).texture(11).registerSpade();
		ContentsVBD2.pickaxes[1] = new PickaxeRegistry("pinkPantherPickaxe", ContentsVBD2.toolMaterials[0]).texture().registerPickaxe();
		ContentsVBD2.axes[1] = new AxeRegistry("pinkPantherAxe", ContentsVBD2.toolMaterials[0]).texture().registerAxe();
		ContentsVBD2.swords[2] = new SwordRegistry("sapphireSword", ContentsVBD2.toolMaterials[0]).texture().registerSword();
		ContentsVBD2.spades[2] = new SpadeRegistry("sapphireSpade", ContentsVBD2.toolMaterials[0]).texture(8).registerSpade();
		ContentsVBD2.pickaxes[2] = new PickaxeRegistry("sapphirePickaxe", ContentsVBD2.toolMaterials[0]).texture().registerPickaxe();
		ContentsVBD2.axes[2] = new AxeRegistry("sapphireAxe", ContentsVBD2.toolMaterials[0]).texture().registerAxe();
		ContentsVBD2.swords[3] = new SwordRegistry("ultimaniumSword", ContentsVBD2.toolMaterials[1]).texture().registerSword();
		ContentsVBD2.spades[3] = new SpadeRegistry("ultimaniumSpade", ContentsVBD2.toolMaterials[1]).texture(10).registerSpade();
		ContentsVBD2.pickaxes[3] = new PickaxeRegistry("ultimaniumPickaxe", ContentsVBD2.toolMaterials[1]).texture().registerPickaxe();
		ContentsVBD2.axes[3] = new AxeRegistry("ultimaniumAxe", ContentsVBD2.toolMaterials[1]).texture().registerAxe();
		ContentsVBD2.swords[4] = new SwordRegistry("zetaSword", ContentsVBD2.toolMaterials[1]).texture().registerSword();
		ContentsVBD2.spades[4] = new SpadeRegistry("zetaSpade", ContentsVBD2.toolMaterials[1]).texture(4).registerSpade();
		ContentsVBD2.pickaxes[4] = new PickaxeRegistry("zetaPickaxe", ContentsVBD2.toolMaterials[1]).texture().registerPickaxe();
		ContentsVBD2.axes[4] = new AxeRegistry("zetaAxe", ContentsVBD2.toolMaterials[1]).texture().registerAxe();
		ContentsVBD2.swords[5] = new SwordRegistry("zechaSword", ContentsVBD2.toolMaterials[1]).texture().registerSword();
		ContentsVBD2.spades[5] = new SpadeRegistry("zechaSpade", ContentsVBD2.toolMaterials[1]).texture(5).registerSpade();
		ContentsVBD2.pickaxes[5] = new PickaxeRegistry("zechaPickaxe", ContentsVBD2.toolMaterials[1]).texture().registerPickaxe();
		ContentsVBD2.axes[5] = new AxeRegistry("zechaAxe", ContentsVBD2.toolMaterials[1]).texture().registerAxe();
		ContentsVBD2.swords[6] = new SwordRegistry("yingsSword", ContentsVBD2.toolMaterials[2]).texture().registerSword();
		ContentsVBD2.spades[6] = new SpadeRegistry("yingsSpade", ContentsVBD2.toolMaterials[2]).texture(5).registerSpade();
		ContentsVBD2.pickaxes[6] = new PickaxeRegistry("yingsPickaxe", ContentsVBD2.toolMaterials[2]).texture().registerPickaxe();
		ContentsVBD2.axes[6] = new AxeRegistry("yingsAxe", ContentsVBD2.toolMaterials[2]).texture().registerAxe();
		ContentsVBD2.swords[7] = new SwordRegistry("yangsSword", ContentsVBD2.toolMaterials[2]).texture().registerSword();
		ContentsVBD2.spades[7] = new SpadeRegistry("yangsSpade", ContentsVBD2.toolMaterials[2]).texture(5).registerSpade();
		ContentsVBD2.pickaxes[7] = new PickaxeRegistry("yangsPickaxe", ContentsVBD2.toolMaterials[2]).texture().registerPickaxe();
		ContentsVBD2.axes[7] = new AxeRegistry("yangsAxe", ContentsVBD2.toolMaterials[2]).texture().registerAxe();
		ContentsVBD2.swords[8] = new SwordRegistry("deathFusionSword", ContentsVBD2.toolMaterials[2]).texture().registerSword();
		ContentsVBD2.spades[8] = new SpadeRegistry("deathFusionSpade", ContentsVBD2.toolMaterials[2]).texture(11).registerSpade();
		ContentsVBD2.pickaxes[8] = new PickaxeRegistry("deathFusionPickaxe", ContentsVBD2.toolMaterials[2]).texture().registerPickaxe();
		ContentsVBD2.axes[8] = new AxeRegistry("deathFusionAxe", ContentsVBD2.toolMaterials[2]).texture().registerAxe();
		ContentsVBD2.swords[9] = new SwordRegistry("shedBlade", ContentsVBD2.toolMaterials[2]).texture().registerSword();
		ContentsVBD2.spades[9] = new SpadeRegistry("shedSpade", ContentsVBD2.toolMaterials[2]).texture(0).registerSpade();
		ContentsVBD2.pickaxes[9] = new PickaxeRegistry("shedPick", ContentsVBD2.toolMaterials[2]).texture().registerPickaxe();
		ContentsVBD2.axes[9] = new AxeRegistry("shedWaraxe", ContentsVBD2.toolMaterials[2]).texture().registerAxe();
		ContentsVBD2.swords[10] = new SwordRegistry("hyperizedDiamondSword", ContentsVBD2.toolMaterials[3]).texture().registerSword();
		ContentsVBD2.spades[10] = new SpadeRegistry("hyperizedDiamondSpade", ContentsVBD2.toolMaterials[3]).texture(16).registerSpade();
		ContentsVBD2.pickaxes[10] = new PickaxeRegistry("hyperizedDiamondPickaxe", ContentsVBD2.toolMaterials[3]).texture().registerPickaxe();
		ContentsVBD2.axes[10] = new AxeRegistry("hyperizedDiamondAxe", ContentsVBD2.toolMaterials[3]).texture().registerAxe();
		ContentsVBD2.swords[11] = new SwordRegistry("negatizedRubySword", ContentsVBD2.toolMaterials[3]).texture().registerSword();
		ContentsVBD2.spades[11] = new SpadeRegistry("negatizedRubySpade", ContentsVBD2.toolMaterials[3]).texture(13).registerSpade();
		ContentsVBD2.pickaxes[11] = new PickaxeRegistry("negatizedRubyPickaxe", ContentsVBD2.toolMaterials[3]).texture().registerPickaxe();
		ContentsVBD2.axes[11] = new AxeRegistry("negatizedRubyAxe", ContentsVBD2.toolMaterials[3]).texture().registerAxe();
		ContentsVBD2.swords[12] = new SwordRegistry("hyperizedPinkPantherSword", ContentsVBD2.toolMaterials[3]).texture().registerSword();
		ContentsVBD2.spades[12] = new SpadeRegistry("hyperizedPinkPantherSpade", ContentsVBD2.toolMaterials[3]).texture(20).registerSpade();
		ContentsVBD2.pickaxes[12] = new PickaxeRegistry("hyperizedPinkPantherPickaxe", ContentsVBD2.toolMaterials[3]).texture().registerPickaxe();
		ContentsVBD2.axes[12] = new AxeRegistry("hyperizedPinkPantherAxe", ContentsVBD2.toolMaterials[3]).texture().registerAxe();
		ContentsVBD2.swords[13] = new SwordRegistry("negatizedSapphireSword", ContentsVBD2.toolMaterials[3]).texture().registerSword();
		ContentsVBD2.spades[13] = new SpadeRegistry("negatizedSapphireSpade", ContentsVBD2.toolMaterials[3]).texture(17).registerSpade();
		ContentsVBD2.pickaxes[13] = new PickaxeRegistry("negatizedSapphirePickaxe", ContentsVBD2.toolMaterials[3]).texture().registerPickaxe();
		ContentsVBD2.axes[13] = new AxeRegistry("negatizedSapphireAxe", ContentsVBD2.toolMaterials[3]).texture().registerAxe();
		ContentsVBD2.hoes[0] = new HoeRegistry("rubyHoe", ContentsVBD2.toolMaterials[0]).texture().registerHoe();
		ContentsVBD2.hoes[1] = new HoeRegistry("pinkPantherHoe", ContentsVBD2.toolMaterials[0]).texture().registerHoe();
		ContentsVBD2.hoes[2] = new HoeRegistry("sapphireHoe", ContentsVBD2.toolMaterials[0]).texture().registerHoe();
		ContentsVBD2.hoes[3] = new HoeRegistry("ultimaniumHoe", ContentsVBD2.toolMaterials[1]).texture().registerHoe();
		ContentsVBD2.hoes[4] = new HoeRegistry("zetaHoe", ContentsVBD2.toolMaterials[1]).texture().registerHoe();
		ContentsVBD2.hoes[5] = new HoeRegistry("zechaHoe", ContentsVBD2.toolMaterials[1]).texture().registerHoe();
		ContentsVBD2.hoes[6] = new HoeRegistry("yingsHoe", ContentsVBD2.toolMaterials[2]).texture().registerHoe();
		ContentsVBD2.hoes[7] = new HoeRegistry("yangsHoe", ContentsVBD2.toolMaterials[2]).texture().registerHoe();
		ContentsVBD2.hoes[8] = new HoeRegistry("deathFusionHoe", ContentsVBD2.toolMaterials[2]).texture().registerHoe();
		ContentsVBD2.hoes[9] = new HoeRegistry("shedTill", ContentsVBD2.toolMaterials[2]).texture().registerHoe();
		ContentsVBD2.hoes[10] = new HoeRegistry("hyperizedDiamondHoe", ContentsVBD2.toolMaterials[3]).texture().registerHoe();
		ContentsVBD2.hoes[11] = new HoeRegistry("negatizedRubyHoe", ContentsVBD2.toolMaterials[3]).texture().registerHoe();
		ContentsVBD2.hoes[12] = new HoeRegistry("hyperizedPinkPantherHoe", ContentsVBD2.toolMaterials[3]).texture().registerHoe();
		ContentsVBD2.hoes[13] = new HoeRegistry("negatizedSapphireHoe", ContentsVBD2.toolMaterials[3]).texture().registerHoe();
		ContentsVBD2.helmets[0] = new ArmorRegistry("rubyHelmet", ContentsVBD2.armorMaterials[0], 3, 0).textures(4).registerArmor();
		ContentsVBD2.chestplates[0] = new ArmorRegistry("rubyChestplate", ContentsVBD2.armorMaterials[0], 3, 1).textures(4).registerArmor();
		ContentsVBD2.leggings[0] = new ArmorRegistry("rubyLeggings", ContentsVBD2.armorMaterials[0], 3, 2).textures(4).registerArmor();
		ContentsVBD2.boots[0] = new ArmorRegistry("rubyBoots", ContentsVBD2.armorMaterials[0], 3, 3).textures(4).registerArmor();
		ContentsVBD2.helmets[1] = new ArmorRegistry("pinkPantherHelmet", ContentsVBD2.armorMaterials[0], 3, 0).textures(11).registerArmor();
		ContentsVBD2.chestplates[1] = new ArmorRegistry("pinkPantherChestplate", ContentsVBD2.armorMaterials[0], 3, 1).textures(11).registerArmor();
		ContentsVBD2.leggings[1] = new ArmorRegistry("pinkPantherLeggings", ContentsVBD2.armorMaterials[0], 3, 2).textures(11).registerArmor();
		ContentsVBD2.boots[1] = new ArmorRegistry("pinkPantherBoots", ContentsVBD2.armorMaterials[0], 3, 3).textures(11).registerArmor();
		ContentsVBD2.helmets[2] = new ArmorRegistry("sapphireHelmet", ContentsVBD2.armorMaterials[0], 3, 0).textures(8).registerArmor();
		ContentsVBD2.chestplates[2] = new ArmorRegistry("sapphireChestplate", ContentsVBD2.armorMaterials[0], 3, 1).textures(8).registerArmor();
		ContentsVBD2.leggings[2] = new ArmorRegistry("sapphireLeggings", ContentsVBD2.armorMaterials[0], 3, 2).textures(8).registerArmor();
		ContentsVBD2.boots[2] = new ArmorRegistry("sapphireBoots", ContentsVBD2.armorMaterials[0], 3, 3).textures(8).registerArmor();
		ContentsVBD2.helmets[3] = new ArmorRegistry("ultimaniumHelmet", ContentsVBD2.armorMaterials[1], 2, 0).textures(10).registerArmor();
		ContentsVBD2.chestplates[3] = new ArmorRegistry("ultimaniumChestplate", ContentsVBD2.armorMaterials[1], 2, 1).textures(10).registerArmor();
		ContentsVBD2.leggings[3] = new ArmorRegistry("ultimaniumLeggings", ContentsVBD2.armorMaterials[1], 2, 2).textures(10).registerArmor();
		ContentsVBD2.boots[3] = new ArmorRegistry("ultimaniumBoots", ContentsVBD2.armorMaterials[1], 2, 3).textures(10).registerArmor();
		ContentsVBD2.helmets[4] = new ArmorRegistry("zetaHelmet", ContentsVBD2.armorMaterials[1], 2, 0).textures(4).registerArmor();
		ContentsVBD2.chestplates[4] = new ArmorRegistry("zetaChestplate", ContentsVBD2.armorMaterials[1], 2, 1).textures(4).registerArmor();
		ContentsVBD2.leggings[4] = new ArmorRegistry("zetaLeggings", ContentsVBD2.armorMaterials[1], 2, 2).textures(4).registerArmor();
		ContentsVBD2.boots[4] = new ArmorRegistry("zetaBoots", ContentsVBD2.armorMaterials[1], 2, 3).textures(4).registerArmor();
		ContentsVBD2.helmets[5] = new ArmorRegistry("zechaHelmet", ContentsVBD2.armorMaterials[1], 2, 0).textures(5).registerArmor();
		ContentsVBD2.chestplates[5] = new ArmorRegistry("zechaChestplate", ContentsVBD2.armorMaterials[1], 2, 1).textures(5).registerArmor();
		ContentsVBD2.leggings[5] = new ArmorRegistry("zechaLeggings", ContentsVBD2.armorMaterials[1], 2, 2).textures(5).registerArmor();
		ContentsVBD2.boots[5] = new ArmorRegistry("zechaBoots", ContentsVBD2.armorMaterials[1], 2, 3).textures(5).registerArmor();
		ContentsVBD2.helmets[6] = new ArmorRegistry("yingsHelmet", ContentsVBD2.armorMaterials[2], 2, 0).textures(4).registerArmor();
		ContentsVBD2.chestplates[6] = new ArmorRegistry("yingsChestplate", ContentsVBD2.armorMaterials[2], 2, 1).textures(4).registerArmor();
		ContentsVBD2.leggings[6] = new ArmorRegistry("yingsLeggings", ContentsVBD2.armorMaterials[2], 2, 2).textures(4).registerArmor();
		ContentsVBD2.boots[6] = new ArmorRegistry("yingsBoots", ContentsVBD2.armorMaterials[2], 2, 3).textures(4).registerArmor();
		ContentsVBD2.helmets[7] = new ArmorRegistry("yangsHelmet", ContentsVBD2.armorMaterials[2], 2, 0).textures(4).registerArmor();
		ContentsVBD2.chestplates[7] = new ArmorRegistry("yangsChestplate", ContentsVBD2.armorMaterials[2], 2, 1).textures(4).registerArmor();
		ContentsVBD2.leggings[7] = new ArmorRegistry("yangsLeggings", ContentsVBD2.armorMaterials[2], 2, 2).textures(4).registerArmor();
		ContentsVBD2.boots[7] = new ArmorRegistry("yangsBoots", ContentsVBD2.armorMaterials[2], 2, 3).textures(4).registerArmor();
		ContentsVBD2.helmets[8] = new ArmorRegistry("deathFusionHelmet", ContentsVBD2.armorMaterials[2], 3, 0).textures(11).registerArmor();
		ContentsVBD2.chestplates[8] = new ArmorRegistry("deathFusionChestplate", ContentsVBD2.armorMaterials[2], 3, 1).textures(11).registerArmor();
		ContentsVBD2.leggings[8] = new ArmorRegistry("deathFusionLeggings", ContentsVBD2.armorMaterials[2], 3, 2).textures(11).registerArmor();
		ContentsVBD2.boots[8] = new ArmorRegistry("deathFusionBoots", ContentsVBD2.armorMaterials[2], 3, 3).textures(11).registerArmor();
	}

	public static void initEquipMaterials() {
		ContentsVBD2.toolMaterials[0] = EnumHelper.addToolMaterial("JEMS", 3, 1561, 8.0f, 3.0f, 10);
		ContentsVBD2.toolMaterials[1] = EnumHelper.addToolMaterial("METALIC", 4, 6250, 150.0f, 50.0f, 5);
		ContentsVBD2.toolMaterials[2] = EnumHelper.addToolMaterial("KING", 5, 46830, 240.0f, 90.0f, 25);
		ContentsVBD2.toolMaterials[3] = EnumHelper.addToolMaterial("VOID_JEMS", 6, 130750, 4184.0f, 3138.0f, 50);
		ContentsVBD2.armorMaterials[0] = EnumHelper.addArmorMaterial("JEMS", 33, new int[] { 3, 8, 6, 3 }, 10);
		ContentsVBD2.armorMaterials[1] = EnumHelper.addArmorMaterial("METALIC", 375, new int[] { 50, 150, 125, 50 }, 5);
		ContentsVBD2.armorMaterials[2] = EnumHelper.addArmorMaterial("KING", 990, new int[] { 90, 180, 240, 90 }, 25);
		ContentsVBD2.armorMaterials[3] = EnumHelper.addArmorMaterial("VOID_JEMS", 7845, new int[] { 1046, 3138, 2615, 1046 }, 50);
	}

	public static void initItems() {
		GameRegistry.registerItem(ContentsVBD2.items[0] = new Jems().setUnlocalizedName("jem"), "jems");
		ContentsVBD2.items[1] = new ItemRegistry("ultimaniumIngot").texture().registerItem();
		ContentsVBD2.items[2] = new ItemRegistry("ultimaniumStick").texture().registerItem();
		ContentsVBD2.items[3] = new ItemRegistry("ultimaniumBowl").maxStack(16).texture().registerItem();
		ContentsVBD2.items[4] = new ItemRegistry("zetaDust").texture().registerItem();
		ContentsVBD2.items[5] = new ItemRegistry("zetaIngot").texture().registerItem();
		ContentsVBD2.items[6] = new ItemRegistry("zechaIngot").texture().registerItem();
		GameRegistry.registerItem(ContentsVBD2.items[7] = new VoidJems().setUnlocalizedName("voidJem"), "voidJems");
		ContentsVBD2.items[8] = new ItemRegistry("yingsItem").maxStack(16).texture().registerItem();
		ContentsVBD2.items[9] = new ItemRegistry("yangsItem").maxStack(16).texture().registerItem();
		ContentsVBD2.items[10] = new ItemRegistry("deathFusion").maxStack(4).texture().registerItem();
		ContentsVBD2.items[11] = new ItemRegistry("nothing").maxStack(32).texture().registerItem();
		GameRegistry.registerItem(ContentsVBD2.items[12] = new CrystalShard().setUnlocalizedName("crystalShard"), "crystalShard");
		ContentsVBD2.items[13] = new ItemRegistry("foun").texture().registerItem();
		GameRegistry.registerItem(ContentsVBD2.items[14] = new Essence().setUnlocalizedName("essence"), "essence");
		ContentsVBD2.items[15] = new ItemRegistry("orange").texture().registerItem();
		ContentsVBD2.items[16] = new ItemRegistry("orangePeel").texture().registerItem();
		ContentsVBD2.items[17] = new ItemRegistry("blood").texture().registerItem();
		ContentsVBD2.drinks[0] = new DrinkRegistry("hyperianSoup", 8, 4.0f, false).texture().registerDrink();
		ContentsVBD2.drinks[1] = new DrinkRegistry("negativeSoup", 16, 8.0f, false).texture().registerDrink();
		ContentsVBD2.food[0] = new FoodRegistry("edibleSugar", 6, 6.0f, false).texture().registerFood();
		ContentsVBD2.food[1] = new FoodRegistry("antiSugar", 3, 3.0f, false).texture().registerFood();
		ContentsVBD2.food[2] = new FoodRegistry("orangeWedge", 6, 4.0f, false).texture().registerFood();
		ContentsVBD2.drinks[2] = new DrinkRegistry("orangeJuice", 7, 4.5f, false).texture().registerDrink();
	}

	public static void initTileEntities(){}

}
