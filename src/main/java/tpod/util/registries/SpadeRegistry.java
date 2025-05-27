package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class SpadeRegistry extends ItemSpade{

	private String regContent;

	public SpadeRegistry(String unlName, Item.ToolMaterial material) {
		super(material);
		setCreativeTab(ContentsVBD2.creativeTabs[3]);
		setMaxStackSize(1);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public SpadeRegistry texture(int stop){
		setTextureName("VoidBreakDemo2:tools/" + regContent.substring(0, stop) + "Shovel");
		if(stop == 0 || regContent == "shedSpade") setTextureName("VoidBreakDemo2:tools/" + regContent);
		return this;
	}

	public SpadeRegistry registerSpade(){
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
