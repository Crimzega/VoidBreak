package tpod.tabs;

import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import tpod.lib.*;

public class TabTools extends CreativeTabs{

	public TabTools(final int id, final String name){ super(id, name); }

	public Item getTabIconItem(){ return ContentsVBD2.spades[0]; }

}
