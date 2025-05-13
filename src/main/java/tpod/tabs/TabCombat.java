package tpod.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import tpod.lib.*;

public class TabCombat extends CreativeTabs
{
    public TabCombat(final int id, final String name) {
        super(id, name);
    }
    
    public Item getTabIconItem() {
        return ContentsVBD2.swords[4];
    }
}
