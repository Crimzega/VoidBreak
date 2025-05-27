package tpod.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import tpod.lib.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;

public class ZechaOre extends Block{

	public ZechaOre(){
		super(Material.rock);
		setBlockName("zechaOre");
		setBlockTextureName("VoidBreakDemo2:zechaOre");
		setCreativeTab(ContentsVBD2.creativeTabs[0]);
		setHardness(15f);
		setHarvestLevel("pickaxe", 3);
		setResistance(25f);
		setStepSound(Block.soundTypePiston);
	}

	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity){ return !(entity instanceof EntityDragon) && !(entity instanceof EntityWither); }

}
