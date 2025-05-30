package tpod.blocks;

import net.minecraft.block.material.*;
import tpod.lib.*;
import net.minecraft.block.*;
import java.util.*;

import com.sulvic.mcf.network.proxy.ZaranthaClient;

import net.minecraft.item.*;
import net.minecraft.world.*;

public class ZetaOre extends BlockBreakable{

	public ZetaOre(){
		super("VoidBreakDemo2:zetaOre", Material.glass, false);
		setBlockName("zetaOre");
		setBlockTextureName("VoidBreakDemo2:zetaOre");
		setCreativeTab(ContentsVBD2.creativeTabs[0]);
		setHardness(3f);
		setHarvestLevel("pickaxe", 2);
		setResistance(5f);
		setStepSound(Block.soundTypeGlass);
	}

	public Item getItemDropped(final int par1, final Random rand, final int par2){ return ContentsVBD2.items[4]; }

	public int quantityDropped(final Random random){ return 5 + random.nextInt(8); }

	@ZaranthaClient
	public boolean shouldSideBeRendered(final IBlockAccess blockAccess, final int x, final int y, final int z, final int side){ return super.shouldSideBeRendered(blockAccess, x, y, z, 1 - side); }

	@ZaranthaClient
	public int getRenderBlockPass(){ return 1; }

}
