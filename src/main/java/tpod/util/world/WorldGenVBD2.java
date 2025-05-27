package tpod.util.world;

import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import tpod.lib.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.init.*;

public class WorldGenVBD2 implements IWorldGenerator{

	public void generate(final Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
			case 1:
				generateEnd(world, rand, chunkX * 16, chunkZ * 16);
			break;
			case 0:
				generateSurface(world, rand, chunkX * 16, chunkZ * 16);
			break;
			case -1:
				generateNether(world, rand, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateSurface(World world, Random rand, int x, int z) {
		addOreSpawn(ContentsVBD2.ores[0], 0, world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 5, 0, 16);
		addOreSpawn(ContentsVBD2.ores[0], 1, world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 5, 0, 16);
		addOreSpawn(ContentsVBD2.ores[0], 2, world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 5, 0, 16);
		addOreSpawn(ContentsVBD2.ores[0], 3, world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 5, 0, 16);
		addOreSpawn(ContentsVBD2.ores[1], world, rand, x, z, 16, 16, 5 + rand.nextInt(15), 18, 30, 60);
	}

	private void generateNether(World world, Random rand, int x, int z) {
		addNetherOreSpawn(ContentsVBD2.ores[2], world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 35, 0, 256);
	}

	private void generateEnd(World world, Random rand, int x, int z) {
		addEndOreSpawn(ContentsVBD2.ores[3], world, rand, x, z, 16, 16, 4 + rand.nextInt(12), 20, 0, 256);
	}

	private void addOreSpawn(Block block, World world, Random rand, int blockPosX, int blockPosZ, int maxX, int maxZ, int veinSize, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; ++i){
			int posX = blockPosX + rand.nextInt(maxX);
			int posY = minY + rand.nextInt(maxY - minY);
			int posZ = blockPosZ + rand.nextInt(maxZ);
			new WorldGenMinable(block, veinSize).generate(world, rand, posX, posY, posZ);
		}
	}

	private void addOreSpawn(Block block, int meta, World world, Random rand, int blockPosX, int blockPosZ, int maxX, int maxZ, int veinSize, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; ++i){
			int posX = blockPosX + rand.nextInt(maxX);
			int posY = minY + rand.nextInt(maxY - minY);
			int posZ = blockPosZ + rand.nextInt(maxZ);
			new WorldGenMinable(block, meta, veinSize, Blocks.stone).generate(world, rand, posX, posY, posZ);
		}
	}

	private void addNetherOreSpawn(Block block, World world, Random rand, int blockPosX, int blockPosZ, int maxX, int maxZ, int veinSize, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; ++i){
			int posX = blockPosX + rand.nextInt(maxX);
			int posY = minY + rand.nextInt(maxY - minY);
			int posZ = blockPosZ + rand.nextInt(maxZ);
			new NetherGenMinable(block, veinSize).generate(world, rand, posX, posY, posZ);
		}
	}

	private void addEndOreSpawn(Block block, World world, Random rand, int blockPosX, int blockPosZ, int maxX, int maxZ, int veinSize, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; ++i){
			int posX = blockPosX + rand.nextInt(maxX);
			int posY = minY + rand.nextInt(maxY - minY);
			int posZ = blockPosZ + rand.nextInt(maxZ);
			new EndGenMinable(block, veinSize).generate(world, rand, posX, posY, posZ);
		}
	}

}
