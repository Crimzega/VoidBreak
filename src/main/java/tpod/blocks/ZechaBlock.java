package tpod.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import tpod.lib.*;
import net.minecraft.client.renderer.texture.*;

public class ZechaBlock extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon bottomIcon;
    
    public ZechaBlock() {
        super(Material.iron);
        this.setBlockName("zechaBlock");
        this.setCreativeTab(ContentsVBD2.creativeTabs[0]);
        this.setHardness(25.0f);
        this.setHarvestLevel("pickaxe", 3);
        this.setResistance(50.0f);
        this.setStepSound(Block.soundTypeMetal);
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int side, final int meta) {
        if (side == 0) {
            return this.bottomIcon;
        }
        if (side == 1) {
            return this.topIcon;
        }
        return this.blockIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegistry) {
        this.blockIcon = iconRegistry.registerIcon("VoidBreakDemo2:zechaBlock");
        this.topIcon = iconRegistry.registerIcon("VoidBreakDemo2:zechaBlockTop");
        this.bottomIcon = iconRegistry.registerIcon("VoidBreakDemo2:zechaBlockBottom");
    }
}
