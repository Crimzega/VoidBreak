package tpod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import tpod.lib.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;

public class ZechaOre extends Block
{
    public ZechaOre() {
        super(Material.rock);
        this.setBlockName("zechaOre");
        this.setBlockTextureName("VoidBreakDemo2:zechaOre");
        this.setCreativeTab(ContentsVBD2.creativeTabs[0]);
        this.setHardness(15.0f);
        this.setHarvestLevel("pickaxe", 3);
        this.setResistance(25.0f);
        this.setStepSound(Block.soundTypePiston);
    }
    
    public boolean canEntityDestroy(final IBlockAccess world, final int x, final int y, final int z, final Entity entity) {
        return !(entity instanceof EntityDragon) && !(entity instanceof EntityWither);
    }
}
