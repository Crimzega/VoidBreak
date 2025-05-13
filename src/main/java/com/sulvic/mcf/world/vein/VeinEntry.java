package com.sulvic.mcf.world.vein;

import static net.minecraft.util.MathHelper.*;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class VeinEntry{

	private Block minableOre;
	private boolean hasMetadata;
	private List<BiomeGenBase> allowedBiomes = Lists.newArrayList();
	private int dimensionId, minableMetadata, veinChance;
	private VeinEntry.Range veinRange;
	private VeinEntry.Size veinSize;

	public VeinEntry(Block ore, int chance){
		minableOre = ore;
		veinChance = chance;
	}

	public VeinEntry(Block ore, int chance, int metadata){
		this(ore, chance);
		hasMetadata = true;
		minableMetadata = metadata;
	}

	public boolean hasAllowedBiomes(){ return allowedBiomes.size() > 0; }

	public boolean hasMetadata(){ return hasMetadata; }

	public Block getMinableOre(){ return minableOre; }

	public int getDimensionId(){ return dimensionId; }

	public int getVeinChance(){ return veinChance; }

	public int getMetadata(){ return minableMetadata; }

	public List<BiomeGenBase> getAllowedBiomes(){ return allowedBiomes; }

	public VeinEntry setAllowedBiomes(BiomeGenBase... biomes){
		for(BiomeGenBase biome: biomes) allowedBiomes.add(biome);
		return this;
	}

	public VeinEntry setDimensionId(int id){
		dimensionId = id;
		return this;
	}

	public VeinEntry setVeinRange(int min, int max){
		veinRange = VeinEntry.Range.createRange(min, max);
		return this;
	}

	public VeinEntry setVeinFullRange(){
		veinRange = VeinEntry.Range.createFullRange();
		return this;
	}

	public VeinEntry setSize(int min, int max){
		veinSize = new VeinEntry.Size(min, max);
		return this;
	}

	public VeinEntry.Range getVeinRange(){ return veinRange; }

	public VeinEntry.Size getVeinSize(){ return veinSize; }

	public static class Range{

		private int maxY, minY;

		private Range(int min, int max){
			minY = Math.max(Math.min(min, max), 0);
			maxY = Math.min(Math.max(min, max), 255);
		}

		public static Range createRange(int min, int max){ return new Range(min, max); }

		public static Range createFullRange(){ return createRange(0, 255); }

		public int getMaxY(){ return maxY; }

		public int getMinY(){ return minY; }

		public int getPosY(Random rand){ return getRandomIntegerInRange(rand, minY, maxY); }

	}

	public static class Size{

		private int maxSize, minSize;

		public Size(int min, int max){
			minSize = Math.min(min, max);
			maxSize = Math.max(min, max);
		}

		public int getMaxSize(){ return maxSize; }

		public int getMinSize(){ return minSize; }

		public int getSize(Random rand){ return getRandomIntegerInRange(rand, minSize, maxSize); }

	}

}
