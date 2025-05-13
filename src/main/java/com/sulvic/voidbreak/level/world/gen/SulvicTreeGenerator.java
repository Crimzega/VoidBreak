package com.sulvic.voidbreak.level.world.gen;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sulvic.voidbreak.level.world.gen.tree.CitrusTreeGen;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class SulvicTreeGenerator implements IWorldGenerator{

	private static final List<SulvicTreeGenerator.Data> TREE_DATA_LIST = Lists.newArrayList();
	public static final CitrusTreeGen CITRUS_TREE = new CitrusTreeGen(true);
	public static final SulvicTreeGenerator INSTANCE = new SulvicTreeGenerator();

	private SulvicTreeGenerator(){}

	public static SulvicTreeGenerator.Data createTreeData(WorldGenAbstractTree treeGen){ return new SulvicTreeGenerator.Data(treeGen); }

	public static void addTreeData(SulvicTreeGenerator.Data data){ TREE_DATA_LIST.add(data); }

	private void generateTree(World world, Random rand, int chunkX, int chunkZ, SulvicTreeGenerator.Data data){
		int posX = MathHelper.getRandomIntegerInRange(rand, chunkX, chunkX + 15), posZ = MathHelper.getRandomIntegerInRange(rand, chunkZ, chunkZ + 15);
		BiomeGenBase biome = world.getBiomeGenForCoords(posX, posZ);
		int posY = world.getTopSolidOrLiquidBlock(posX, posZ);
		if(data.shouldGenerate(biome)){
			double weight = data.getBiomeWeight(biome);
			double d = MathHelper.getRandomDoubleInRange(rand, 0d, weight);
			if(d == 0d) data.generate(world, rand, posX, posY, posZ);
		}
	}

	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider generator, IChunkProvider provider){
		if(!TREE_DATA_LIST.isEmpty()) for(SulvicTreeGenerator.Data data: TREE_DATA_LIST) generateTree(world, rand, chunkX, chunkZ, data);
	}

	public static class Data{

		private WorldGenAbstractTree theGenerator;
		private Map<BiomeGenBase, Double> biomeWeight = Maps.newHashMap();

		private Data(WorldGenAbstractTree treeGen){ theGenerator = treeGen; }

		public Data setBiomeWeight(BiomeGenBase biome, double weight){
			biomeWeight.put(biome, weight);
			return this;
		}

		public boolean shouldGenerate(BiomeGenBase biome){ return biomeWeight.isEmpty() || biomeWeight.containsKey(biome); }

		public boolean generate(World world, Random rand, int x, int y, int z){ return theGenerator.generate(null, rand, x, y, z); }

		public double getBiomeWeight(BiomeGenBase biome){ return biomeWeight.isEmpty()? 1d: biomeWeight.containsKey(biome)? biomeWeight.get(biome): 0d; }

	}

}
