package com.sulvic.voidbreak.level.item;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import java.util.List;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.lib.GemstoneData;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ItemGem extends Item{

	@ZaranthaClient
	private IIcon[] textures;

	public ItemGem(){
		setCreativeTab(ITEMS);
		setHasSubtypes(true);
		setUnlocalizedName("gem");
	}

	@Override
	public IIcon getIconFromDamage(int metadata){ return textures[metadata]; }

	@Override
	public boolean isBeaconPayment(ItemStack stack){ return true; }

	@Override
	public int getMetadata(int metadata){ return metadata; }

	@Override
	public String getUnlocalizedName(ItemStack stack){
		int metadata = stack.getItemDamage();
		if(metadata < 0 || metadata >= GemstoneData.Type.size()) metadata = 0;
		return getUnlocalizedName() + '.' + GemstoneData.Type.byMetadata(metadata).getUnlocalizedName();
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list){
		if(tab == CreativeTabs.tabAllSearch || tab == ITEMS) for(GemstoneData.Type type: GemstoneData.Type.values()) list.add(new ItemStack(item, 1, type.getMetadata()));
	}

	@Override
	public void registerIcons(IIconRegister registry){
		textures = new IIcon[GemstoneData.Type.size()];
		for(GemstoneData.Type type: GemstoneData.Type.values()) textures[type.getMetadata()] = registry.registerIcon(MODID + ":gems/" + type.getTextureName());
	}

}
