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
public class VoidJemBlocks extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon[] texture;
    private static String[] subBlocks;
    
    public VoidJemBlocks() {
        super(Material.rock);
        this.setCreativeTab(ContentsVBD2.creativeTabs[0]);
        this.setHardness(25.0f);
        this.setHarvestLevel("pickaxe", 4);
        this.setLightLevel(0.8f);
        this.setLightOpacity(255);
        this.setResistance(50.0f);
        this.setStepSound(Block.soundTypePiston);
        this.setTickRandomly(true);
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
        for (int i = 0; i < VoidJemBlocks.subBlocks.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.texture = new IIcon[VoidJemBlocks.subBlocks.length];
        for (int i = 0; i < VoidJemBlocks.subBlocks.length; ++i) {
            this.texture[i] = iconRegister.registerIcon("VoidBreakDemo2:" + VoidJemBlocks.subBlocks[i] + "Block");
        }
    }
    
    static {
        VoidJemBlocks.subBlocks = new String[] { "hyperizedDiamond", "negatizedRuby", "hyperizedPinkPanther", "negatizedSapphire", "hyperizedEmerald", "negatizedCassiterite" };
    }
}
