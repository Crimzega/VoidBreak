package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.common.FolkrumTabs;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class LogCitrus extends BlockLog{

	public LogCitrus(){
		setCreativeTab(FolkrumTabs.BLOCKS);
		setBlockName("logCitrus");
		setHarvestLevel("axe", 0);
	}

	@Override
	@ZaranthaClient
	public void registerBlockIcons(IIconRegister registry){
		field_150166_b = new IIcon[]{registry.registerIcon(MODID + ":citrus/log_top")};
		field_150167_a = new IIcon[]{registry.registerIcon(MODID + ":citrus/log_side")};
	}

}
