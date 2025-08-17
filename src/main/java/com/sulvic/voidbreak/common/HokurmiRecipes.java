package com.sulvic.voidbreak.common;

import static com.sulvic.voidbreak.common.SulvicObjects.*;

import com.sulvic.voidbreak.lib.GemstoneData;
import com.sulvic.voidbreak.lib.VoidGemstoneData;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@SuppressWarnings({"unused"})
public class HokurmiRecipes{

	private static final String[] AXE_RECIPE = {"TT", "TP", " P"};
	private static final String[] BOOTS_RECIPE = {"T T", "T T"};
	private static final String[] CHESTPLATE_RECIPE = {"T T", "TTT", "TTT"};
	private static final String[] FULL_BLOCK_RECIPE = {"TTT", "TTT", "TTT"};
	private static final String[] HELMET_RECIPE = {"TTT", "T T"};
	private static final String[] HOE_RECIPE = {"TT", " P", " P"};
	private static final String[] HOLLOW_RECIPE = {"TTT", "T T", "TTT"};
	private static final String[] LEGGINGS_RECIPE = {"TTT", "T T", "T T"};
	private static final String[] PICKAXE_RECIPE = {"TTT", " P ", " P "};
	private static final String[] SLAB_RECIPE = {"TTT"};
	private static final String[] SMALL_BLOCK_RECIPE = {"TT", "TT"};
	private static final String[] SPADE_RECIPE = {"T", "P", "P"};
	private static final String[] STAIRS_RECIPE = {"T  ", "TT ", "TTT"};
	private static final String[] SWORD_RECIPE = {"T", "T", "P"};
	private static final String[] WRAPPED_BLOCK_RECIPE = {"TTT", "TPT", "TTT"};

	public static void addRecipes(){
		GameRegistry.addShapelessRecipe(new ItemStack(CITRUS_PLANKS, 4), CITRUS_LOG);
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.crafting_table), SMALL_BLOCK_RECIPE, 'T', CITRUS_PLANKS);
		GameRegistry.addShapedRecipe(new ItemStack(CITRUS_STAIRS, 4), STAIRS_RECIPE, 'T', CITRUS_PLANKS);
		GameRegistry.addShapedRecipe(new ItemStack(CITRUS_SLAB, 3), SLAB_RECIPE, 'T', CITRUS_PLANKS);
		for(GemstoneData.Type type: GemstoneData.Type.values()){
			int metadata = type.getMetadata();
			ItemStack gemBlockStack = new ItemStack(GEM_BLOCK, 1, metadata), gemStack = new ItemStack(GEM, 1, metadata);
			GameRegistry.addSmelting(new ItemStack(GEM_ORE, 1, metadata), gemStack, 0.75f);
			GameRegistry.addShapedRecipe(gemBlockStack, FULL_BLOCK_RECIPE, 'T', gemStack);
			ItemStack splitGemStack = gemStack.copy();
			splitGemStack.stackSize = 9;
			GameRegistry.addShapelessRecipe(splitGemStack, gemBlockStack);
		}
		GameRegistry.addShapedRecipe(new ItemStack(SPECIAL_BLOCK), SMALL_BLOCK_RECIPE, 'T', SPECIAL_DUST);
		GameRegistry.addShapelessRecipe(new ItemStack(SPECIAL_DUST, 4), SPECIAL_BLOCK);
		GameRegistry.addShapedRecipe(new ItemStack(SPECIAL_METAL_BLOCK), FULL_BLOCK_RECIPE, 'T', SPECIAL_INGOT);
		GameRegistry.addShapelessRecipe(new ItemStack(SPECIAL_INGOT, 9), SPECIAL_METAL_BLOCK);
		GameRegistry.addShapedRecipe(new ItemStack(ZECHA_BLOCK), FULL_BLOCK_RECIPE, 'T', ZECHA_INGOT);
		GameRegistry.addShapedRecipe(new ItemStack(SUGAR_BLOCK), FULL_BLOCK_RECIPE, 'T', Items.sugar);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar, 9), SUGAR_BLOCK);
//		GameRegistry.addShapedRecipe(new ItemStack(BURNT_SUGAR_BLOCK), FULL_BLOCK_RECIPE, 'T', BURNT_SUGAR);
//		GameRegistry.addShapelessRecipe(new ItemStack(BURNT_SUGAR, 9), BURNT_SUGAR_BLOCK);
//		GameRegistry.addShapedRecipe(new ItemStack(SPECIAL_WORKBENCH), SMALL_BLOCK_RECIPE, 'T', SPECIAL_INGOT);
		GameRegistry.addShapedRecipe(new ItemStack(ZECHA_DRAWER), HOLLOW_RECIPE, 'T', ZECHA_INGOT);
//		for(VoidGemstoneData.Type type: VoidGemstoneData.Type.values()){
//			
//		}
		GameRegistry.addSmelting(SPECIAL_DUST, new ItemStack(SPECIAL_INGOT), 0.15f);
		GameRegistry.addSmelting(ZECHA_ORE, new ItemStack(ZECHA_INGOT, 4), 1.2f);
		GameRegistry.addSmelting(SWEET_POTATO, new ItemStack(BAKED_SWEET_POTATO), 0.35f);
		GameRegistry.addShapedRecipe(new ItemStack(ENERGY_BAR), new String[]{"TPT", "POP"}, 'T', new ItemStack(Items.dye, 1, 3), 'P', Items.wheat, 'O', Items.sugar);
		GameRegistry.addShapelessRecipe(new ItemStack(ORANGE_SLICE, 2), ORANGE);
		GameRegistry.addShapelessRecipe(new ItemStack(ORANGE_WEDGE, 4), ORANGE_SLICE);
	}

}
