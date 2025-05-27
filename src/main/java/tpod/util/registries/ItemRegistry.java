package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class ItemRegistry extends Item{

	private String regContent;

	public ItemRegistry(String unlName) {
		setCreativeTab(ContentsVBD2.creativeTabs[1]);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public ItemRegistry maxStack(int max) {
		setMaxStackSize(max);
		return this;
	}

	public ItemRegistry texture() {
		setTextureName("VoidBreakDemo2:" + regContent);
		return this;
	}

	public ItemRegistry registerItem() {
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
