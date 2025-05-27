package tpod.items;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import tpod.lib.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class VoidJems extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon[] texture;
    private static String[] subItems = { "hyperizedDiamond", "negatizedRuby", "hyperizedPinkPanther", "negatizedSapphire", "hyperizedEmerald", "negatizedCassiterite" };

    public VoidJems(){
        setCreativeTab(ContentsVBD2.creativeTabs[1]);
        setHasSubtypes(true);
    }

    public String getUnlocalizedName(ItemStack itemstack){
        int i = itemstack.getItemDamage();
        if(i < 0 || i >= VoidJems.subItems.length) i = 0;
        return getUnlocalizedName() + "." + VoidJems.subItems[i];
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta){ return texture[meta]; }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){ for(int i = 0; i < VoidJems.subItems.length; ++i) list.add(new ItemStack(item, 1, i)); }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        texture = new IIcon[VoidJems.subItems.length];
        for(int i = 0; i < VoidJems.subItems.length; ++i) texture[i] = iconRegister.registerIcon("VoidBreakDemo2:" + VoidJems.subItems[i]);
    }

}
