package com.sulvic.voidbreak.common;

import static com.sulvic.voidbreak.common.SulvicObjects.GEM;

import com.sulvic.voidbreak.lib.GemstoneData;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class JemurinMaterial{

	private static final int[] WEAK_GEM_ARMOR_REDUCTIONS = {2, 7, 5, 2};
	private static final int[] NORMAL_GEM_ARMOR_REDUCTIONS = {2, 7, 5, 2};
	private static final int[] STRONG_GEM_ARMOR_REDUCTIONS = {2, 7, 5, 2};
	public static final ItemArmor.ArmorMaterial RUBY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("RUBY", 33, WEAK_GEM_ARMOR_REDUCTIONS, 10);
	public static final ItemArmor.ArmorMaterial PINK_PANTHER_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("PINK_PANTHER", 33, STRONG_GEM_ARMOR_REDUCTIONS, 10);
	public static final ItemArmor.ArmorMaterial SAPPHIRE_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("SAPPHIRE", 33, NORMAL_GEM_ARMOR_REDUCTIONS, 10);
	public static final ItemArmor.ArmorMaterial CASSITERITE_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("CASSITERITE", 33, NORMAL_GEM_ARMOR_REDUCTIONS, 10);
	public static final ItemArmor.ArmorMaterial ENSTATITE_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("ENSTATITE", 33, WEAK_GEM_ARMOR_REDUCTIONS, 10);
	public static final ItemArmor.ArmorMaterial MOONSTONE_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("MOONSTONE", 33, NORMAL_GEM_ARMOR_REDUCTIONS, 10);
	public static final Material CITRUS_MATERIAL = new Material(MapColor.clayColor);
	public static final Material GEM_MATERIAL = new Material(MapColor.redColor);
	public static final Material SPECIAL_MATERIAL = new Material(MapColor.purpleColor);
	public static final Material ZECHA_MATERIAL = new Material(MapColor.yellowColor);
	public static final Material ULTINE_MATERIAL = new Material(MapColor.cyanColor);
	public static final Material ULTIMANIUM_MATERIAL = new Material(MapColor.quartzColor);
	public static final Material SUGAR_MATERIAL = new Material(MapColor.quartzColor);
	public static final Material BURNT_SUGAR_MATERIAL = new Material(MapColor.blackColor);
	public static final Material VOID_GEM_MATERIAL = new Material(MapColor.diamondColor);
	public static final Material YIN_MATERIAL = new Material(MapColor.snowColor);
	public static final Material YANG_MATERIAL = new Material(MapColor.obsidianColor);
	public static final Material NOTHING_MATERIAL = new Material(MapColor.airColor);
	public static final Item.ToolMaterial RUBY_TOOL_MATERIAL = EnumHelper.addToolMaterial("RUBY", 3, 1643, 9f, 4f, 10);
	public static final Item.ToolMaterial PINK_PANTHER_TOOL_MATERIAL = EnumHelper.addToolMaterial("PINK_PANTHER", 3, 1643, 9f, 5f, 10);
	public static final Item.ToolMaterial SAPPHIRE_TOOL_MATERIAL = EnumHelper.addToolMaterial("SAPPHIRE", 3, 1758, 10f, 2f, 10);
	public static final Item.ToolMaterial CASSITERITE_TOOL_MATERIAL = EnumHelper.addToolMaterial("CASSITERITE", 3, 1497, 7f, 4f, 10);
	public static final Item.ToolMaterial ENSTATITE_TOOL_MATERIAL = EnumHelper.addToolMaterial("ENSTATITE", 3, 1643, 9f, 2f, 10);
	public static final Item.ToolMaterial MOONSTONE_TOOL_MATERIAL = EnumHelper.addToolMaterial("MOONSTONE", 3, 1497, 7f, 3f, 10);

	public static void addRepairItems(){
		RUBY_ARMOR_MATERIAL.customCraftingMaterial = GEM;
		PINK_PANTHER_ARMOR_MATERIAL.customCraftingMaterial = GEM;
		SAPPHIRE_ARMOR_MATERIAL.customCraftingMaterial = GEM;
		CASSITERITE_ARMOR_MATERIAL.customCraftingMaterial = GEM;
		ENSTATITE_ARMOR_MATERIAL.customCraftingMaterial = GEM;
		MOONSTONE_ARMOR_MATERIAL.customCraftingMaterial = GEM;
		RUBY_TOOL_MATERIAL.setRepairItem(new ItemStack(GEM, 1, GemstoneData.Type.RUBY.getMetadata()));
		PINK_PANTHER_TOOL_MATERIAL.setRepairItem(new ItemStack(GEM, 1, GemstoneData.Type.PINK_PANTHER.getMetadata()));
		SAPPHIRE_TOOL_MATERIAL.setRepairItem(new ItemStack(GEM, 1, GemstoneData.Type.SAPPHIRE.getMetadata()));
		CASSITERITE_TOOL_MATERIAL.setRepairItem(new ItemStack(GEM, 1, GemstoneData.Type.CASSITERITE.getMetadata()));
		ENSTATITE_TOOL_MATERIAL.setRepairItem(new ItemStack(GEM, 1, GemstoneData.Type.ENSTATITE.getMetadata()));
		MOONSTONE_TOOL_MATERIAL.setRepairItem(new ItemStack(GEM, 1, GemstoneData.Type.MOONSTONE.getMetadata()));
	}

}
