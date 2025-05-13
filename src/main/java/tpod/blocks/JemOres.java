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
    private static String[] subBlocks;
    
    public JemOres() {
        super(Material.rock);
        this.rand = new Random();
        this.setCreativeTab(ContentsVBD2.creativeTabs[0]);
        this.setHardness(3.0f);
        this.setHarvestLevel("pickaxe", 2);
        this.setResistance(5.0f);
        this.setStepSound(Block.soundTypePiston);
    }
    
    public int getExpDrop(final IBlockAccess blockAccess, final int par1, final int par2) {
        if (this.getItemDropped(par1, this.rand, par2) != Item.getItemFromBlock((Block)this)) {
            return MathHelper.getRandomIntegerInRange(this.rand, 3, 7);
        }
        return 0;
    }
    
    public int getMetadata(final int meta) {
        return meta;
    }
    
    public int damageDropped(final int meta) {
        return meta;
    }
    
    public int quantityDroppedWithBonus(final int par1, final Random rand) {
        if (par1 > 0 && Item.getItemFromBlock((Block)this) != this.getItemDropped(0, rand, par1)) {
            int j = rand.nextInt(par1 + 2) - 1;
            if (j < 0) {
                j = 0;
            }
            return this.quantityDropped(rand) * (j * 1);
        }
        return this.quantityDropped(rand);
    }
    
    public Item getItemDropped(final int par1, final Random rand, final int par2) {
        return ContentsVBD2.items[0];
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        return this.texture[meta];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(final Item block, final CreativeTabs creativeTabs, final List list) {
        for (int i = 0; i < JemOres.subBlocks.length; ++i) {
            list.add(new ItemStack(block, 1, i));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.texture = new IIcon[JemOres.subBlocks.length];
        for (int i = 0; i < JemOres.subBlocks.length; ++i) {
            this.texture[i] = iconRegister.registerIcon("VoidBreakDemo2:" + JemOres.subBlocks[i] + "Ore");
        }
    }
    
    static {
        JemOres.subBlocks = new String[] { "ruby", "pinkPanther", "sapphire", "cassiterite" };
    }
}
