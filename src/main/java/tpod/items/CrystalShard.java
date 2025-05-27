package tpod.items;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import tpod.lib.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CrystalShard extends Item{

	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	private static String[] subItems = {"", ".crafting", ".smelting", ".dimensional"}, subTextures = new String[] {"", "Crafting", "Smelting", "Dimensional"};

	public CrystalShard() {
		setCreativeTab(ContentsVBD2.creativeTabs[1]);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(final ItemStack itemstack){
		int i = itemstack.getItemDamage();
		if(i < 0 || i >= CrystalShard.subItems.length) i = 0;
		return getUnlocalizedName() + CrystalShard.subItems[i];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(final int meta){ return texture[meta]; }

	@SideOnly(Side.CLIENT)
	public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list){ for(int i = 0; i < CrystalShard.subItems.length; ++i) list.add(new ItemStack(item, 1, i)); }

	@SideOnly(Side.CLIENT)
	public void registerIcons(final IIconRegister iconRegister){
		texture = new IIcon[CrystalShard.subItems.length];
		for(int i = 0; i < CrystalShard.subItems.length; ++i) texture[i] = iconRegister.registerIcon("VoidBreakDemo2:crystalShard" + CrystalShard.subTextures[i]);
	}

}
