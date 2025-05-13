package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.MODID;
import static com.sulvic.voidbreak.common.SulvicObjects.ORANGE_PEEL;
import static com.sulvic.voidbreak.common.FolkrumTabs.EDIBLE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemOrangeWedge extends ItemFood{

	private static final ItemStack PEEL_STACK = new ItemStack(ORANGE_PEEL);

	public ItemOrangeWedge(){
		super(5, 0.8f, false);
		setCreativeTab(EDIBLE);
		setTextureName(MODID + ":snacks/orange_wedge");
		setUnlocalizedName("orangeWedge");
	}

	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player){
		if(!player.capabilities.isCreativeMode){
			stack.stackSize--;
			if(!world.isRemote) player.inventory.addItemStackToInventory(PEEL_STACK);
		}
		player.getFoodStats().func_151686_a(this, stack);
		return stack.stackSize <= 0? PEEL_STACK: stack;
	}

}
