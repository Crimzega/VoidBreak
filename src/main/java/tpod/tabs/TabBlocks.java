package tpod.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import tpod.lib.*;

public class TabBlocks extends CreativeTabs
{
    public TabBlocks(final int id, final String name) {
        super(id, name);
    }
    
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ContentsVBD2.ores[1]);
    }
}
