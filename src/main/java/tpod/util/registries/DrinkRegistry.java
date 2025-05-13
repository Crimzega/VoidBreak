package tpod.util.registries;

import tpod.lib.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;

public class DrinkRegistry extends ItemFood
{
    private String regContent;
    
    public DrinkRegistry(final String unlName, final int health, final float foodRegen, final boolean wolfFood) {
        super(health, foodRegen, wolfFood);
        this.setCreativeTab(ContentsVBD2.creativeTabs[2]);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(unlName);
        this.regContent = unlName;
    }
    
    public ItemStack onEaten(final ItemStack itemStack, final World world, final EntityPlayer player) {
        if (this == ContentsVBD2.drinks[0] || this == ContentsVBD2.drinks[1]) {
            return new ItemStack(ContentsVBD2.items[3]);
        }
        return new ItemStack(Items.bucket);
    }
    
    public EnumAction getItemUseAction(final ItemStack itemStack) {
        return EnumAction.drink;
    }
    
    public DrinkRegistry texture() {
        this.setTextureName("VoidBreakDemo2:" + this.regContent);
        return this;
    }
    
    public DrinkRegistry registerDrink() {
        GameRegistry.registerItem((Item)this, this.regContent);
        return this;
    }
}
