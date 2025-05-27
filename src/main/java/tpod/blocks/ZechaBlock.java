package tpod.blocks;

import net.minecraft.block.*;
import net.minecraft.util.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.material.*;
import tpod.lib.*;
import net.minecraft.client.renderer.texture.*;

public class ZechaBlock extends Block{

	@SideOnly(Side.CLIENT)
	private IIcon topIcon, bottomIcon;

	public ZechaBlock() {
		super(Material.iron);
		setBlockName("zechaBlock");
		setCreativeTab(ContentsVBD2.creativeTabs[0]);
		setHardness(25f);
		setHarvestLevel("pickaxe", 3);
		setResistance(50f);
		setStepSound(Block.soundTypeMetal);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if(side == 0) return bottomIcon;
		if(side == 1) return topIcon;
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegistry) {
		blockIcon = iconRegistry.registerIcon("VoidBreakDemo2:zechaBlock");
		topIcon = iconRegistry.registerIcon("VoidBreakDemo2:zechaBlockTop");
		bottomIcon = iconRegistry.registerIcon("VoidBreakDemo2:zechaBlockBottom");
	}

}
