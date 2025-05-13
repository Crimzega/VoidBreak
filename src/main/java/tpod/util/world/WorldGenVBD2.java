package tpod.util.world;

import cpw.mods.fml.common.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import tpod.lib.*;
import net.minecraft.block.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.init.*;

public class WorldGenVBD2 implements IWorldGenerator
{
    public void generate(final Random rand, final int chunkX, final int chunkZ, final World world, final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
            case 1: {
                this.generateEnd(world, rand, chunkX * 16, chunkZ * 16);
            }
            case 0: {
                this.generateSurface(world, rand, chunkX * 16, chunkZ * 16);
            }
            case -1: {
                this.generateNether(world, rand, chunkX * 16, chunkZ * 16);
                break;
            }
        }
    }
    
    private void generateSurface(final World world, final Random rand, final int x, final int z) {
        this.addOreSpawn(ContentsVBD2.ores[0], 0, world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 5, 0, 16);
        this.addOreSpawn(ContentsVBD2.ores[0], 1, world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 5, 0, 16);
        this.addOreSpawn(ContentsVBD2.ores[0], 2, world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 5, 0, 16);
        this.addOreSpawn(ContentsVBD2.ores[0], 3, world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 5, 0, 16);
        this.addOreSpawn(ContentsVBD2.ores[1], world, rand, x, z, 16, 16, 5 + rand.nextInt(15), 18, 30, 60);
    }
    
    private void generateNether(final World world, final Random rand, final int x, final int z) {
        this.addNetherOreSpawn(ContentsVBD2.ores[2], world, rand, x, z, 16, 16, 3 + rand.nextInt(8), 35, 0, 256);
    }
    
    private void generateEnd(final World world, final Random rand, final int x, final int z) {
        this.addEndOreSpawn(ContentsVBD2.ores[3], world, rand, x, z, 16, 16, 4 + rand.nextInt(12), 20, 0, 256);
    }
    
    private void addOreSpawn(final Block block, final World world, final Random rand, final int blockPosX, final int blockPosZ, final int maxX, final int maxZ, final int veinSize, final int spawnChance, final int minY, final int maxY) {
        for (int i = 0; i < spawnChance; ++i) {
            final int posX = blockPosX + rand.nextInt(maxX);
            final int posY = minY + rand.nextInt(maxY - minY);
            final int posZ = blockPosZ + rand.nextInt(maxZ);
            new WorldGenMinable(block, veinSize).generate(world, rand, posX, posY, posZ);
        }
    }
    
    private void addOreSpawn(final Block block, final int meta, final World world, final Random rand, final int blockPosX, final int blockPosZ, final int maxX, final int maxZ, final int veinSize, final int spawnChance, final int minY, final int maxY) {
        for (int i = 0; i < spawnChance; ++i) {
            final int posX = blockPosX + rand.nextInt(maxX);
            final int posY = minY + rand.nextInt(maxY - minY);
            final int posZ = blockPosZ + rand.nextInt(maxZ);
            new WorldGenMinable(block, meta, veinSize, Blocks.stone).generate(world, rand, posX, posY, posZ);
        }
    }
    
    private void addNetherOreSpawn(final Block block, final World world, final Random rand, final int blockPosX, final int blockPosZ, final int maxX, final int maxZ, final int veinSize, final int spawnChance, final int minY, final int maxY) {
        for (int i = 0; i < spawnChance; ++i) {
            final int posX = blockPosX + rand.nextInt(maxX);
            final int posY = minY + rand.nextInt(maxY - minY);
            final int posZ = blockPosZ + rand.nextInt(maxZ);
            new NetherGenMinable(block, veinSize).generate(world, rand, posX, posY, posZ);
        }
    }
    
    private void addEndOreSpawn(final Block block, final World world, final Random rand, final int blockPosX, final int blockPosZ, final int maxX, final int maxZ, final int veinSize, final int spawnChance, final int minY, final int maxY) {
        for (int i = 0; i < spawnChance; ++i) {
            final int posX = blockPosX + rand.nextInt(maxX);
            final int posY = minY + rand.nextInt(maxY - minY);
            final int posZ = blockPosZ + rand.nextInt(maxZ);
            new EndGenMinable(block, veinSize).generate(world, rand, posX, posY, posZ);
        }
    }
}
