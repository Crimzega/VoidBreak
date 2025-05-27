package tpod.util.registries;

import tpod.lib.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;

public class FoodRegistry extends ItemFood{

	private String regContent;

	public FoodRegistry(String unlName, int health, float foodRegen, boolean wolfFood) {
		super(health, foodRegen, wolfFood);
		setCreativeTab(ContentsVBD2.creativeTabs[2]);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player){
		super.onEaten(itemStack, world, player);
		if(this == ContentsVBD2.food[2]) player.inventory.addItemStackToInventory(new ItemStack(ContentsVBD2.items[16]));
		return itemStack;
	}

	public FoodRegistry maxStack(int max){
		setMaxStackSize(max);
		return this;
	}

	public FoodRegistry texture(){
		setTextureName("VoidBreakDemo2:" + regContent);
		return this;
	}

	public FoodRegistry registerFood(){
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
