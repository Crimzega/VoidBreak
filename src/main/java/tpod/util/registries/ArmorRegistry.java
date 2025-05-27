package tpod.util.registries;

import tpod.lib.*;
import net.minecraft.entity.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;

public class ArmorRegistry extends ItemArmor{

	public String armorTexture;
	public String regContent;

	public ArmorRegistry(String unlName, ItemArmor.ArmorMaterial material, int slot, int type){
		super(material, slot, type);
		setCreativeTab(ContentsVBD2.creativeTabs[4]);
		setMaxStackSize(1);
		setUnlocalizedName(unlName);
		regContent = unlName;
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(slot == 2) return "VoidBreakDemo2:textures/armor/" + armorTexture + "_layer2.png";
		return "VoidBreakDemo2:textures/armor/" + armorTexture + "_layer1.png";
	}

	public ArmorRegistry textures(int stop){
		armorTexture = regContent.substring(0, stop);
		setTextureName("VoidBreakDemo2:armor/" + regContent);
		return this;
	}

	public ArmorRegistry registerArmor(){
		GameRegistry.registerItem((Item)this, regContent);
		return this;
	}

}
