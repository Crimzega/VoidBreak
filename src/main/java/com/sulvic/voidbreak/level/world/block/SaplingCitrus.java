package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import java.util.List;
import java.util.Random;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.level.world.gen.SulvicTreeGenerator;

import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SaplingCitrus extends BlockSapling{

	public SaplingCitrus(){
		setBlockName("saplingCitrus");
		setCreativeTab(BLOCKS);
		setStepSound(soundTypeGrass);
	}

	@Override
	public IIcon getIcon(int side, int metadata){ return blockIcon; }

	@Override
	public void func_149878_d(World world, int x, int y, int z, Random rand){ SulvicTreeGenerator.CITRUS_TREE.generate(world, rand, x, y, z); }

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list){ if(tab == CreativeTabs.tabAllSearch || tab == BLOCKS) list.add(new ItemStack(item, 1, 0)); }

	@Override
	@ZaranthaClient
	public void registerBlockIcons(IIconRegister registry){ blockIcon = registry.registerIcon(MODID + ":citrus/sapling"); }

}
