package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class SwordRegistry extends ItemSword{

	private String regContent;

	public SwordRegistry(String unlName, Item.ToolMaterial material) {
		super(material);
		setCreativeTab(ContentsVBD2.creativeTabs[4]);
		setMaxStackSize(1);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public SwordRegistry texture() {
		setTextureName("VoidBreakDemo2:tools/" + regContent);
		return this;
	}

	public SwordRegistry registerSword() {
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
