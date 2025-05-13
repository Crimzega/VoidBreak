package tpod.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import tpod.lib.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class JemBlocks extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon[] texture;
    private static String[] subBlocks;
    
    public JemBlocks() {
        super(Material.rock);
        this.setCreativeTab(ContentsVBD2.creativeTabs[0]);
        this.setHardness(3.0f);
        this.setHarvestLevel("pickaxe", 2);
        this.setResistance(5.0f);
        this.setStepSound(Block.soundTypePiston);
    }
    
    public int getMetadata(final int meta) {
        return meta;
    }
    
    public int damageDropped(final int meta) {
        return meta;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return this.texture[meta];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(final Item block, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < JemBlocks.subBlocks.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.texture = new IIcon[JemBlocks.subBlocks.length];
        for (int i = 0; i < JemBlocks.subBlocks.length; ++i) {
            this.texture[i] = iconRegister.registerIcon("VoidBreakDemo2:" + JemBlocks.subBlocks[i] + "Block");
        }
    }
    
    static {
        JemBlocks.subBlocks = new String[] { "ruby", "pinkPanther", "sapphire", "cassiterite" };
    }
}
