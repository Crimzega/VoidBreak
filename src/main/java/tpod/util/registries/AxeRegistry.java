package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class AxeRegistry extends ItemAxe{

	private String regContent;

	public AxeRegistry(String unlName, Item.ToolMaterial material) {
		super(material);
		setCreativeTab(ContentsVBD2.creativeTabs[3]);
		setMaxStackSize(1);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public AxeRegistry texture() {
		setTextureName("VoidBreakDemo2:tools/" + regContent);
		return this;
	}

	public AxeRegistry registerAxe() {
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
