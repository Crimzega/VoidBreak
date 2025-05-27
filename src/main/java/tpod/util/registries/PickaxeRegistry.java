package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class PickaxeRegistry extends ItemPickaxe{

	private String regContent;

	public PickaxeRegistry(String unlName, Item.ToolMaterial material) {
		super(material);
		setCreativeTab(ContentsVBD2.creativeTabs[3]);
		setMaxStackSize(1);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public PickaxeRegistry texture() {
		setTextureName("VoidBreakDemo2:tools/" + regContent);
		return this;
	}

	public PickaxeRegistry registerPickaxe() {
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
