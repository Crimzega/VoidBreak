package tpod.util.registries;

import tpod.lib.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;

public class FoodRegistry extends ItemFood
{
    private String regContent;
    
    public FoodRegistry(final String unlName, final int health, final float foodRegen, final boolean wolfFood) {
        super(health, foodRegen, wolfFood);
        this.setCreativeTab(ContentsVBD2.creativeTabs[2]);
        this.setUnlocalizedName(unlName);
        this.regContent = unlName;
    }
    
    public ItemStack onEaten(final ItemStack itemStack, final World world, final EntityPlayer player) {
        super.onEaten(itemStack, world, player);
        if (this == ContentsVBD2.food[2]) {
            player.inventory.addItemStackToInventory(new ItemStack(ContentsVBD2.items[16]));
        }
        return itemStack;
    }
    
    public FoodRegistry maxStack(final int max) {
        this.setMaxStackSize(max);
        return this;
    }
    
    public FoodRegistry texture() {
        this.setTextureName("VoidBreakDemo2:" + this.regContent);
        return this;
    }
    
    public FoodRegistry registerFood() {
        GameRegistry.registerItem((Item)this, this.regContent);
        return this;
    }
}
