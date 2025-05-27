package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class HoeRegistry extends ItemHoe{

	private String regContent;

	public HoeRegistry(String unlName, Item.ToolMaterial material) {
		super(material);
		setCreativeTab(ContentsVBD2.creativeTabs[3]);
		setMaxStackSize(1);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public HoeRegistry texture() {
		setTextureName("VoidBreakDemo2:tools/" + regContent);
		return this;
	}

	public HoeRegistry registerHoe() {
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
