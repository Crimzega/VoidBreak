package com.sulvic.voidbreak.level.world.chunk.generator;

import static com.sulvic.voidbreak.common.SulvicObjects.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

@SuppressWarnings({"rawtypes"})
public class WorldChunkManagerNothing extends WorldChunkManager{

	public WorldChunkManagerNothing(){}

	@Override
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int chunkX, int chunkZ, int width, int length){
		if(biomes == null || biomes.length < width * length) biomes = new BiomeGenBase[width * length];
		Arrays.fill(biomes, 0, width * length, NOTHING_BIOME);
		return biomes;
	}

	@Override
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] biomes, int chunkX, int chunkZ, int width, int length, boolean cacheFlag){
		return loadBlockGeneratorData(biomes, chunkX, chunkZ, width, length);
	}

	@Override
	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] biomes, int chunkX, int chunkZ, int width, int length){
		if(biomes == null || biomes.length < width * length) biomes = new BiomeGenBase[width * length];
		Arrays.fill(biomes, 0, width * length, NOTHING_BIOME);
		return biomes;
	}

	@Override
	public float[] getRainfall(float[] reuseable, int x, int z, int width, int length){
		if(reuseable == null || reuseable.length < width * length) reuseable = new float[width * length];
		Arrays.fill(reuseable, 0, width * length, 0f);
		return reuseable;
	}

	@Override
	public BiomeGenBase getBiomeGenAt(int x, int z){ return NOTHING_BIOME; }

	@Override
	public boolean areBiomesViable(int minX, int minZ, int max, List villageSpawnBiomeList){ return villageSpawnBiomeList.contains(NOTHING_BIOME); }

	@Override
	public ChunkPosition findBiomePosition(int minX, int minZ, int max, List biomeList, Random rand){
		return new ChunkPosition(minX - max + rand.nextInt(max * 2 + 1), 0, minZ - max + rand.nextInt(max * 2 + 1));
	}

}
