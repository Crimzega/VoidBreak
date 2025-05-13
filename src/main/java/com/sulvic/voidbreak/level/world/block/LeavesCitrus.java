package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import java.util.Random;

import static com.sulvic.voidbreak.client.SulvicClientEvents.*;

import com.sulvic.mcf.client.IFancy;
import com.sulvic.mcf.network.proxy.ZaranthaClient;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class LeavesCitrus extends BlockLeaves implements IFancy{

	@ZaranthaClient
	private static final String[][] TEXTURE_BASES = {{"leaves"}, {"leaves_opaque"}};

	public LeavesCitrus(){
		setBlockName("leavesCitrus");
		setCreativeTab(BLOCKS);
		switch(FMLCommonHandler.instance().getSide()){
			case CLIENT:
				setGraphicsLevel(usingFancyGraphics());
			break;
			default:
			break;
		}
		setStepSound(soundTypeGrass);
	}

	@Override
	protected void func_150124_c(World world, int x, int y, int z, int metadata, int chance){ if(world.rand.nextInt(chance) <= 25) dropBlockAsItem(world, x, y, z, new ItemStack(ORANGE)); }

	@Override
	public String[] func_150125_e(){ return new String[]{"citrus"}; }

	@Override
	public IIcon getIcon(int side, int metadata){ return field_150129_M[field_150127_b][0]; }

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune){ return Item.getItemFromBlock(CITRUS_SAPLING); }

	@Override
	@ZaranthaClient
	public void setFancyGraphics(boolean fancy){ setGraphicsLevel(fancy); }

	@Override
	@ZaranthaClient
	public void registerBlockIcons(IIconRegister registry){
		for(int i = 0; i < TEXTURE_BASES.length; i++){
			field_150129_M[i] = new IIcon[TEXTURE_BASES[i].length];
			for(int j = 0; j < field_150129_M[i].length; j++) field_150129_M[i][j] = registry.registerIcon(MODID + ":citrus/" + TEXTURE_BASES[i][j]);
		}
	}

}
