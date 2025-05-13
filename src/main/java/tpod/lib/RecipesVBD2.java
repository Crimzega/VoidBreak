package tpod.lib;

import net.minecraft.item.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.init.*;
import tpod.util.*;

public class RecipesVBD2
{
    public static void shaped() {
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[0], 1, 0), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[0], 1, 1), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[0], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[0], 1, 2), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[0], 1, 3), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[0], 1, 3) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[1]), new Object[] { ContentsVBD2.basics[1], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[2]), new Object[] { ContentsVBD2.basics[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[3]), new Object[] { ContentsVBD2.basics[1], 'T', ContentsVBD2.items[6] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[4]), new Object[] { ContentsVBD2.basics[0], 'T', Items.sugar });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[4]), new Object[] { ContentsVBD2.basics[0], 'T', ContentsVBD2.food[0] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[5]), new Object[] { ContentsVBD2.basics[0], 'T', ContentsVBD2.food[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 0), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 0), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.blocks[4], 'P', Blocks.diamond_block });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 1), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 1), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.blocks[4], 'P', new ItemStack(ContentsVBD2.blocks[0], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 2), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 2), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.blocks[4], 'P', new ItemStack(ContentsVBD2.blocks[0], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 3), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 3), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.blocks[4], 'P', new ItemStack(ContentsVBD2.blocks[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 4), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 4) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 4), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.blocks[4], 'P', Blocks.emerald_block });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 5), new Object[] { ContentsVBD2.basics[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 5) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[6], 1, 5), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.blocks[4], 'P', new ItemStack(ContentsVBD2.blocks[0], 1, 3) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[7]), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.items[8], 'P', ContentsVBD2.items[9] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[8]), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.items[9], 'P', ContentsVBD2.items[8] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[9]), new Object[] { ContentsVBD2.basics[1], 'T', ContentsVBD2.items[10] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.blocks[10]), new Object[] { ContentsVBD2.basics[0], 'T', ContentsVBD2.items[11] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[2], 4), new Object[] { ContentsVBD2.basics[4], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[3], 4), new Object[] { ContentsVBD2.basics[5], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 0), new Object[] { ContentsVBD2.basics[2], 'T', Items.sugar, 'P', Items.diamond });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 0), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.food[0], 'P', Items.diamond });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 1), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.food[1], 'P', new ItemStack(ContentsVBD2.items[0], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 2), new Object[] { ContentsVBD2.basics[2], 'T', Items.sugar, 'P', new ItemStack(ContentsVBD2.items[0], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 2), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.food[0], 'P', new ItemStack(ContentsVBD2.items[0], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 3), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.food[1], 'P', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 4), new Object[] { ContentsVBD2.basics[2], 'T', Items.sugar, 'P', Items.emerald });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 4), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.food[0], 'P', Items.emerald });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[7], 2, 5), new Object[] { ContentsVBD2.basics[2], 'T', ContentsVBD2.food[1], 'P', new ItemStack(ContentsVBD2.items[0], 1, 3) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[8]), new Object[] { ContentsVBD2.basics[2], 'T', new ItemStack(Items.dye, 1, 15), 'P', new ItemStack(Items.dye, 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.items[9]), new Object[] { ContentsVBD2.basics[2], 'T', new ItemStack(Items.dye, 1, 0), 'P', new ItemStack(Items.dye, 1, 15) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[0]), new Object[] { ContentsVBD2.tools[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[0]), new Object[] { ContentsVBD2.tools[1], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[0]), new Object[] { ContentsVBD2.tools[2], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[0]), new Object[] { ContentsVBD2.tools[3], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.hoes[0]), new Object[] { ContentsVBD2.tools[4], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[1]), new Object[] { ContentsVBD2.tools[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[1]), new Object[] { ContentsVBD2.tools[1], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[1]), new Object[] { ContentsVBD2.tools[2], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[1]), new Object[] { ContentsVBD2.tools[3], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[1]), new Object[] { ContentsVBD2.tools[4], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[2]), new Object[] { ContentsVBD2.tools[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[2]), new Object[] { ContentsVBD2.tools[1], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[2]), new Object[] { ContentsVBD2.tools[2], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[2]), new Object[] { ContentsVBD2.tools[3], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[2]), new Object[] { ContentsVBD2.tools[4], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0), 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[3]), new Object[] { ContentsVBD2.tools[0], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[3]), new Object[] { ContentsVBD2.tools[1], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[3]), new Object[] { ContentsVBD2.tools[2], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[3]), new Object[] { ContentsVBD2.tools[3], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[3]), new Object[] { ContentsVBD2.tools[4], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[4]), new Object[] { ContentsVBD2.tools[0], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[4]), new Object[] { ContentsVBD2.tools[1], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[4]), new Object[] { ContentsVBD2.tools[2], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[4]), new Object[] { ContentsVBD2.tools[3], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[4]), new Object[] { ContentsVBD2.tools[4], 'T', ContentsVBD2.items[1], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[5]), new Object[] { ContentsVBD2.tools[0], 'T', ContentsVBD2.items[6], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[5]), new Object[] { ContentsVBD2.tools[1], 'T', ContentsVBD2.items[6], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[5]), new Object[] { ContentsVBD2.tools[2], 'T', ContentsVBD2.items[6], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[5]), new Object[] { ContentsVBD2.tools[3], 'T', ContentsVBD2.items[6], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[5]), new Object[] { ContentsVBD2.tools[4], 'T', ContentsVBD2.items[6], 'P', Items.stick });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[6]), new Object[] { ContentsVBD2.tools[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[6]), new Object[] { ContentsVBD2.tools[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[6]), new Object[] { ContentsVBD2.tools[2], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[6]), new Object[] { ContentsVBD2.tools[3], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[6]), new Object[] { ContentsVBD2.tools[4], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[7]), new Object[] { ContentsVBD2.tools[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[7]), new Object[] { ContentsVBD2.tools[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[7]), new Object[] { ContentsVBD2.tools[2], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[7]), new Object[] { ContentsVBD2.tools[3], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[7]), new Object[] { ContentsVBD2.tools[4], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[8]), new Object[] { ContentsVBD2.tools[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 2), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[8]), new Object[] { ContentsVBD2.tools[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 2), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[8]), new Object[] { ContentsVBD2.tools[2], 'T', new ItemStack(ContentsVBD2.items[7], 1, 2), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[8]), new Object[] { ContentsVBD2.tools[3], 'T', new ItemStack(ContentsVBD2.items[7], 1, 2), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[8]), new Object[] { ContentsVBD2.tools[4], 'T', new ItemStack(ContentsVBD2.items[7], 1, 2), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.swords[9]), new Object[] { ContentsVBD2.tools[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.spades[9]), new Object[] { ContentsVBD2.tools[1], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.pickaxes[9]), new Object[] { ContentsVBD2.tools[2], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[9]), new Object[] { ContentsVBD2.tools[3], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.axes[9]), new Object[] { ContentsVBD2.tools[4], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3), 'P', ContentsVBD2.items[2] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[0]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[0]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[0]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[0]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[1]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[1]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[1]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[1]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[2]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[2]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[2]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[2]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[3]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[3]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[3]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[3]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[4]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[4]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[4]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[4]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[1] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[5]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[6] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[5]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[6] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[5]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[6] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[5]), new Object[] { ContentsVBD2.armor[0], 'T', ContentsVBD2.items[6] });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[6]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[6]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[6]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[6]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 0) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[7]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[7]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7]) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[7]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[7]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 1) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[8]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[8]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[8]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[8]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[0], 1, 2) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.helmets[9]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.chestplates[9]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.leggings[9]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3) });
        GameRegistry.addShapedRecipe(new ItemStack(ContentsVBD2.boots[9]), new Object[] { ContentsVBD2.armor[0], 'T', new ItemStack(ContentsVBD2.items[7], 1, 3) });
        if (ConfigVBD2.enchantedRecipes) {
            if (ConfigVBD2.enchantedRecipes) {}
        }
    }
    
    public static void shapeless() {
        GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar), new Object[] { ContentsVBD2.food[0] });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[0], 9, 0), new Object[] { new ItemStack(ContentsVBD2.blocks[0], 1, 0) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[0], 9, 1), new Object[] { new ItemStack(ContentsVBD2.blocks[0], 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[0], 9, 2), new Object[] { new ItemStack(ContentsVBD2.blocks[0], 1, 2) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[0], 9, 3), new Object[] { new ItemStack(ContentsVBD2.blocks[0], 1, 3) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[1], 9), new Object[] { ContentsVBD2.blocks[1] });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[1], 3), new Object[] { ContentsVBD2.items[3] });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[7], 9, 0), new Object[] { new ItemStack(ContentsVBD2.blocks[6], 1, 0) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[7], 9, 1), new Object[] { new ItemStack(ContentsVBD2.blocks[6], 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[7], 9, 2), new Object[] { new ItemStack(ContentsVBD2.blocks[6], 1, 2) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[7], 9, 3), new Object[] { new ItemStack(ContentsVBD2.blocks[6], 1, 3) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[7], 9, 4), new Object[] { new ItemStack(ContentsVBD2.blocks[6], 1, 4) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[7], 9, 5), new Object[] { new ItemStack(ContentsVBD2.blocks[6], 1, 5) });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[10], 9), new Object[] { ContentsVBD2.blocks[9] });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[11], 4), new Object[] { ContentsVBD2.blocks[10] });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.food[0]), new Object[] { Items.sugar });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.food[0], 4), new Object[] { ContentsVBD2.blocks[4] });
        GameRegistry.addShapelessRecipe(new ItemStack(ContentsVBD2.items[11], 4), new Object[] { ContentsVBD2.blocks[10] });
    }
    
    public static void smelting() {
        GameRegistry.addSmelting(ContentsVBD2.blocks[5], new ItemStack(ContentsVBD2.blocks[4]), 0.0f);
        GameRegistry.addSmelting(ContentsVBD2.ores[1], new ItemStack(ContentsVBD2.items[1]), 0.9f);
        GameRegistry.addSmelting(ContentsVBD2.items[4], new ItemStack(ContentsVBD2.items[5]), 0.9f);
        GameRegistry.addSmelting(ContentsVBD2.ores[3], new ItemStack(ContentsVBD2.items[6], 4), 0.9f);
        GameRegistry.addSmelting(ContentsVBD2.food[1], new ItemStack(Items.sugar), 0.0f);
        GameRegistry.addSmelting(ContentsVBD2.food[1], new ItemStack(ContentsVBD2.food[0]), 0.0f);
    }
    
    public static void hyperize() {
    }
    
    public static void negatize() {
    }
    
    public static void smashing() {
    }
}
