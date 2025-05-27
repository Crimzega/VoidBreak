package tpod.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import tpod.lib.*;

public class TabItems extends CreativeTabs{

	public TabItems(final int id, final String name){ super(id, name); }

	public Item getTabIconItem(){ return ContentsVBD2.items[6]; }

}
