package com.sulvic.mcf.world.gen;

import java.io.*;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.sulvic.mcf.logger.MezidaLogger;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldStructure extends WorldGenerator{

	private static final MezidaLogger logger = new MezidaLogger(WorldStructure.class);
	private List<BlockEntry> blockPalette = Lists.newArrayList();
	private List<BlockPos> blockPosList = Lists.newArrayList();
	private boolean canPlaceAir = false;

	private WorldStructure(){}

	private static InputStream asInputStream(String pos){
		ResourceLocation resLoc = new ResourceLocation(pos);
		String streamPos = String.format("/assets/%s/structures/{}.nbt", resLoc.getResourceDomain(), resLoc.getResourcePath());
		return WorldStructure.class.getResourceAsStream(streamPos);
	}

	public static WorldStructure getStructure(String domainPath){
		WorldStructure result = new WorldStructure();
		InputStream stream = asInputStream(domainPath);
		if(stream != null){
			try{
				NBTTagCompound nbtCompound = CompressedStreamTools.readCompressed(stream);
				result.readFromNBT(nbtCompound);
				stream.close();
			}
			catch(IOException ex){
				logger.error("Could not read structure data", ex);
			}
		}
		else logger.error(new RuntimeException("Could not find structure data"));
		return result;
	}

	public static WorldStructure getStructure(String domain, String path){ return getStructure(domain + ':' + path); }

	private void addBlock(int index, int[] pos){
		if(pos.length == 3) blockPosList.add(new BlockPos(index, pos[0], pos[1], pos[2]));
		else logger.catching(new IllegalArgumentException("Not enough data for position"));
	}

	private void readFromNBT(NBTTagCompound nbtCompound){
		NBTTagList paletteList = nbtCompound.getTagList("palette", 0xA);
		for(int i = 0; i < paletteList.tagCount(); i++){
			NBTTagCompound entryTag = paletteList.getCompoundTagAt(i);
			String[] split = entryTag.getString("name").split(":");
			Block block = GameRegistry.findBlock(split[0], split[1]);
			BlockEntry entry = new BlockEntry(block);
			if(entryTag.hasKey("properties", 0xA)){
				NBTTagCompound propertiesTag = entryTag.getCompoundTag("properties");
				if(propertiesTag.hasKey("damage", 0x3)) entry.setMetadata(propertiesTag.getInteger("damage"));
			}
			blockPalette.add(entry);
		}
		NBTTagList posList = nbtCompound.getTagList("blocks", 0xA);
		for(int i = 0; i < posList.tagCount(); i++){
			NBTTagCompound posTag = posList.getCompoundTagAt(i);
			int index = posTag.getInteger("state");
			int[] pos = posTag.getIntArray("pos");
			addBlock(index, pos);
		}
	}

	public boolean canPlaceAir(){ return canPlaceAir; }

	public boolean generate(World world, Random rand, int x, int y, int z){
		if(blockPalette.size() == 0 && blockPosList.size() == 0) return false;
		for(BlockPos pos: blockPosList){
			int index = Math.min(Math.max(pos.index, 0), blockPalette.size());
			BlockEntry entry = blockPalette.get(index);
			Block block = entry.getBlock();
			int posX = x + pos.offsetX, posY = y + pos.offsetY, posZ = z + pos.offsetZ;
			boolean canPlace = block != Blocks.air || (block == Blocks.air && canPlaceAir && !world.isAirBlock(posX, posY, posZ));
			if(canPlace){
				world.setBlock(posX, posY, posZ, block);
				if(entry.usesMetadata()){
					world.setBlockMetadataWithNotify(posX, posY, posZ, entry.getBlockMetadata(), 3);
				}
			}
		}
		return true;
	}

	public WorldStructure setPlaceAir(boolean placeAir){
		canPlaceAir = placeAir;
		return this;
	}

	private static class BlockEntry{

		private final Block theBlock;
		private boolean usesMetadata = false;
		private int blockMetadata = 0;

		public BlockEntry(Block block){ theBlock = block; }

		public boolean usesMetadata(){ return usesMetadata; }

		public Block getBlock(){ return theBlock; }

		public BlockEntry setMetadata(int metadata){
			usesMetadata = true;
			blockMetadata = metadata;
			return this;
		}

		public int getBlockMetadata(){ return blockMetadata; }

	}

	private static class BlockPos{

		private final int index, offsetX, offsetY, offsetZ;

		private BlockPos(int id, int x, int y, int z){
			index = id;
			offsetX = x;
			offsetY = y;
			offsetZ = z;
		}

	}

}
