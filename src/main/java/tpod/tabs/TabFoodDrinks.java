package tpod.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import tpod.lib.*;

public class TabFoodDrinks extends CreativeTabs
{
    public TabFoodDrinks(final int id, final String name) {
        super(id, name);
    }
    
    public Item getTabIconItem() {
        return ContentsVBD2.drinks[0];
    }
}
