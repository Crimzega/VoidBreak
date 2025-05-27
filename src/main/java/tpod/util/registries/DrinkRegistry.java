package tpod.util.registries;

import tpod.lib.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;

public class DrinkRegistry extends ItemFood{

	private String regContent;

	public DrinkRegistry(String unlName, int health, float foodRegen, boolean wolfFood) {
		super(health, foodRegen, wolfFood);
		setCreativeTab(ContentsVBD2.creativeTabs[2]);
		setMaxStackSize(1);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
		if(this == ContentsVBD2.drinks[0] || this == ContentsVBD2.drinks[1]) return new ItemStack(ContentsVBD2.items[3]);
		return new ItemStack(Items.bucket);
	}

	public EnumAction getItemUseAction(ItemStack itemStack){ return EnumAction.drink; }

	public DrinkRegistry texture() {
		setTextureName("VoidBreakDemo2:" + regContent);
		return this;
	}

	public DrinkRegistry registerDrink() {
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
