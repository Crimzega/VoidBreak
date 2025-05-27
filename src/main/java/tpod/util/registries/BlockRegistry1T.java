package tpod.util.registries;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class BlockRegistry1T extends Block{

	private String regContent;

	public BlockRegistry1T(String unlName, Material material) {
		super(material);
		setBlockName(unlName);
		setCreativeTab(ContentsVBD2.creativeTabs[0]);
		regContent = unlName;
	}

	public BlockRegistry1T hardResist(float hardness, float resistance) {
		setHardness(hardness);
		setResistance(resistance);
		return this;
	}

	public BlockRegistry1T harvestLvl(String tool, int lvl) {
		setHarvestLevel(tool, lvl);
		return this;
	}

	public BlockRegistry1T lightLvlOpc(float lvl, int opc) {
		setLightLevel(lvl);
		setLightOpacity(opc);
		return this;
	}

	public BlockRegistry1T stepSound(Block.SoundType sound) {
		setStepSound(sound);
		return this;
	}

	public BlockRegistry1T texture() {
		setBlockTextureName("VoidBreakDemo2:" + regContent);
		return this;
	}

	public BlockRegistry1T registerBlock() {
		GameRegistry.registerBlock((Block)this, regContent);
		return this;
	}

}
