package tpod.util.registries;

import tpod.lib.*;
import net.minecraft.entity.*;
import cpw.mods.fml.common.registry.*;
import net.minecraft.item.*;

public class ArmorRegistry extends ItemArmor{

	public String armorTexture;
	public String regContent;

	public ArmorRegistry(final String unlName, final ItemArmor.ArmorMaterial material, final int slot, final int type){
		super(material, slot, type);
		this.setCreativeTab(ContentsVBD2.creativeTabs[4]);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(unlName);
		this.regContent = unlName;
	}

	public String getArmorTexture(final ItemStack stack, final Entity entity, final int slot, final String type){
		if(slot == 2){ return "VoidBreakDemo2:textures/armor/" + this.armorTexture + "_layer2.png"; }
		return "VoidBreakDemo2:textures/armor/" + this.armorTexture + "_layer1.png";
	}

	public ArmorRegistry textures(final int stop){
		this.armorTexture = this.regContent.substring(0, stop);
		this.setTextureName("VoidBreakDemo2:armor/" + this.regContent);
		return this;
	}

	public ArmorRegistry registerArmor(){
		GameRegistry.registerItem((Item)this, this.regContent);
		return this;
	}

}
