package tpod.blocks;

import net.minecraft.block.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import tpod.lib.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.texture.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class JemOres extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon[] texture;
    private Random rand;
    private static String[] subBlocks = {"ruby", "pinkPanther", "sapphire", "cassiterite"};

    public JemOres(){
        super(Material.rock);
        rand = new Random();
        setCreativeTab(ContentsVBD2.creativeTabs[0]);
        setHardness(3.0f);
        setHarvestLevel("pickaxe", 2);
        setResistance(5.0f);
        setStepSound(Block.soundTypePiston);
    }

    public int getExpDrop(IBlockAccess blockAccess, int par1, int par2){
        if(getItemDropped(par1, rand, par2) != Item.getItemFromBlock((Block)this)) return MathHelper.getRandomIntegerInRange(rand, 3, 7);
        return 0;
    }

    public int getMetadata(int meta){ return meta; }

    public int damageDropped(int meta){ return meta; }

    public int quantityDroppedWithBonus(int par1, Random rand){
        if(par1 > 0 && Item.getItemFromBlock((Block)this) != getItemDropped(0, rand, par1)){
            int j = rand.nextInt(par1 + 2) - 1;
            if(j < 0) j = 0;
            return quantityDropped(rand) * (j * 1);
        }
        return quantityDropped(rand);
    }

    public Item getItemDropped(int par1, Random rand, int par2){ return ContentsVBD2.items[0]; }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){ return texture[meta]; }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list){ for(int i = 0; i < JemOres.subBlocks.length; ++i) list.add(new ItemStack(block, 1, i)); }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        texture = new IIcon[JemOres.subBlocks.length];
        for(int i = 0; i < JemOres.subBlocks.length; ++i) texture[i] = iconRegister.registerIcon("VoidBreakDemo2:" + JemOres.subBlocks[i] + "Ore");
    }

}
