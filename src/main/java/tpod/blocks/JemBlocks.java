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
    private static String[] subBlocks = {"ruby", "pinkPanther", "sapphire", "cassiterite"};

    public JemBlocks() {
        super(Material.rock);
        setCreativeTab(ContentsVBD2.creativeTabs[0]);
        setHardness(3f);
        setHarvestLevel("pickaxe", 2);
        setResistance(5f);
        setStepSound(Block.soundTypePiston);
    }

    public int getMetadata(int meta){ return meta; }

    public int damageDropped(int meta){ return meta; }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){ return texture[meta]; }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list){ for(int i = 0; i < JemBlocks.subBlocks.length; ++i) list.add(new ItemStack(block, 1, i)); }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        texture = new IIcon[JemBlocks.subBlocks.length];
        for(int i = 0; i < JemBlocks.subBlocks.length; ++i) texture[i] = iconRegister.registerIcon("VoidBreakDemo2:" + JemBlocks.subBlocks[i] + "Block");
    }

}
