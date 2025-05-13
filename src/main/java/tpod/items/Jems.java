package tpod.items;

import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import tpod.lib.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Jems extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon[] texture;
    private static String[] subItems;
    
    public Jems() {
        this.setCreativeTab(ContentsVBD2.creativeTabs[1]);
        this.setHasSubtypes(true);
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        int i = itemstack.getItemDamage();
        if (i < 0 || i >= Jems.subItems.length) {
            i = 0;
        }
        return this.getUnlocalizedName() + "." + Jems.subItems[i];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int meta) {
        return this.texture[meta];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(final Item item, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < Jems.subItems.length; ++i) {
            list.add(new ItemStack(item, 1, i));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.texture = new IIcon[Jems.subItems.length];
        for (int i = 0; i < Jems.subItems.length; ++i) {
            this.texture[i] = iconRegister.registerIcon("VoidBreakDemo2:" + Jems.subItems[i]);
        }
    }
    
    static {
        Jems.subItems = new String[] { "ruby", "pinkPanther", "sapphire", "cassiterite" };
    }
}
