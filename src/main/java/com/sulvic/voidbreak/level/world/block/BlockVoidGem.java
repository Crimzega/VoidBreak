package com.sulvic.voidbreak.level.world.block;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;
import static com.sulvic.voidbreak.common.JemurinMaterial.*;
import static com.sulvic.voidbreak.common.FolkrumTabs.*;

import java.util.*;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.lib.VoidGemstoneData;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

@SuppressWarnings({"rawtypes", "unchecked"})
public class BlockVoidGem extends Block{

	private static final int MAX_DEPOWER_TIME = 12000;
	@ZaranthaClient
	public IIcon[] textures;
	private int depowerTimer;

	public BlockVoidGem(){
		super(GEM_MATERIAL);
		setBlockName("voidGem");
		setCreativeTab(BLOCKS);
		setHardness(40f);
		setLightLevel(1f);
		setLightOpacity(255);
		setResistance(120f);
		setStepSound(soundTypeMetal);
		setTickRandomly(true);
	}

	@Override
	public int damageDropped(int metadata){ return metadata; }

	@Override
	public int tickRate(World world){ return 40; }

	@Override
	public MapColor getMapColor(int metadata){
		VoidGemstoneData.Type type = VoidGemstoneData.Type.byMetadata(metadata);
		switch(type){
			case PINK_PANTHER:
				return MapColor.pinkColor;
			case SAPPHIRE:
				return MapColor.purpleColor;
			case EMERALD:
				return MapColor.emeraldColor;
			case CASSITERITE:
				return MapColor.blackColor;
			case ENSTATITE:
				return MapColor.goldColor;
			case MOONSTONE:
				return MapColor.yellowColor;
			default:
				return super.getMapColor(metadata);
		}
	}

	@Override
	public IIcon getIcon(int side, int metadata){ return textures[metadata]; }

	@Override
	@ZaranthaClient
	public void getSubBlocks(Item item, CreativeTabs tabs, List list){
		if(tabs == CreativeTabs.tabAllSearch || tabs == BLOCKS) for(VoidGemstoneData.Type type: VoidGemstoneData.Type.values()) list.add(new ItemStack(item, 1, type.getMetadata()));
	}

	@Override
	@ZaranthaClient
	public void registerBlockIcons(IIconRegister registry){
		textures = new IIcon[VoidGemstoneData.Type.size()];
		for(VoidGemstoneData.Type type: VoidGemstoneData.Type.values()) textures[type.getMetadata()] = registry.registerIcon(MODID + ":void_gems/" + type.getTextureName());
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand){
		int metadata = world.getBlockMetadata(x, y, z);
		boolean airExposure = world.canBlockSeeTheSky(x, y, z);
		if(airExposure){
			if(world.isRaining()) depowerTimer += 5;
			else depowerTimer--;
		}
		setLightLevel(depowerTimer > 0? 0f: 1f);
		if(depowerTimer >= MAX_DEPOWER_TIME){
			switch(metadata){
				case 0:
					world.setBlock(x, y, z, Blocks.diamond_block);
				break;
				case 4:
					world.setBlock(x, y, z, Blocks.emerald_block);
				break;
				default:
					int gemMetadata = metadata;
					if(metadata >= 0) gemMetadata--;
					if(metadata >= 4) gemMetadata--;
					world.setBlock(x, y, z, GEM_BLOCK);
					world.setBlockMetadataWithNotify(x, y, z, gemMetadata, 3);
				break;
			}
		}
		world.scheduleBlockUpdate(x, y, z, this, tickRate(world));
	}

}
