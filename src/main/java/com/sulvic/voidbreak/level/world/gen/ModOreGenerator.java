package com.sulvic.voidbreak.level.world.gen;

import static com.sulvic.voidbreak.common.SulvicObjects.*;
import static net.minecraft.world.biome.BiomeGenBase.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sulvic.mcf.world.vein.DimensionStoneHelper;
import com.sulvic.mcf.world.vein.VeinEntry;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class ModOreGenerator implements IWorldGenerator{

	private static final Map<Integer, List<VeinEntry>> ADDITIONAL_VEINS = Maps.newHashMap();
	public static final ModOreGenerator INSTANCE = new ModOreGenerator();
	private static final VeinEntry RUBY_VEIN = new VeinEntry(GEM_ORE, 5, 0).setVeinRange(2, 12).setSize(2, 8);
	private static final VeinEntry PINK_PANTHER_VEIN = new VeinEntry(GEM_ORE, 6, 1).setVeinRange(8, 20).setSize(3, 6).setAllowedBiomes(plains, desert, desertHills, extremeHills, jungle);
	private static final VeinEntry SAPPHIRE_VEIN = new VeinEntry(GEM_ORE, 2, 2).setVeinRange(4, 12).setSize(2, 5).setAllowedBiomes(forest, taiga, swampland, stoneBeach);
	private static final VeinEntry CASSITERITE_VEIN = new VeinEntry(GEM_ORE, 3, 3).setVeinRange(6, 17).setSize(6, 9);
	private static final VeinEntry ENSTATITE_VEIN = new VeinEntry(GEM_ORE, 4, 4).setVeinRange(4, 12).setSize(4, 9).setAllowedBiomes(ocean, river, frozenOcean, frozenRiver, deepOcean, mesa);
	private static final VeinEntry MOONSTONE_VEIN = new VeinEntry(GEM_ORE, 6, 5).setVeinRange(6, 16).setSize(2, 5);
	private static final VeinEntry SPECIAL_VEIN = new VeinEntry(SPECIAL_ORE, 18).setVeinFullRange().setSize(3, 9);
	private static final VeinEntry ZECHA_VEIN = new VeinEntry(ZECHA_ORE, 9).setVeinFullRange().setSize(2, 4);

	private ModOreGenerator(){}

	public static void addGeneratableVein(int dimId, VeinEntry entry){
		if(!ADDITIONAL_VEINS.containsKey(dimId)) ADDITIONAL_VEINS.put(dimId, Lists.newArrayList());
		if(!ADDITIONAL_VEINS.get(dimId).contains(entry)) ADDITIONAL_VEINS.get(dimId).add(entry);
	}

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider provider, IChunkProvider provider1){
		int x = chunkX * 16, z = chunkZ * 16;
		switch(world.provider.dimensionId){
			case 1:
				generateEnd(world, rand, x, z);
			break;
			case 0:
				generateOverworld(world, rand, x, z);
			break;
			case -1:
				generateNether(world, rand, x, z);
			break;
			default:
				generateCustomDimension(world, rand, x, z);
			break;
		}
	}

	private void generateCustomDimension(World world, Random rand, int x, int z){
		int dimId = world.provider.dimensionId;
		Block stone = DimensionStoneHelper.getDimensionStone(dimId);
		List<VeinEntry> veins = ADDITIONAL_VEINS.get(dimId);
		if(veins != null && veins.size() > 0) for(VeinEntry vein: veins) if(vein != null) generateVein(world, rand, x, z, vein, stone);
	}

	private void generateEnd(World world, Random rand, int x, int z){
		Block stone = DimensionStoneHelper.getDimensionStone(1);
		generateVein(world, rand, x, z, ZECHA_VEIN, stone);
		List<VeinEntry> veins = ADDITIONAL_VEINS.get(1);
		if(veins != null && veins.size() > 0) for(VeinEntry vein: veins) if(vein != null) generateVein(world, rand, x, z, vein, stone);
	}

	private void generateOverworld(World world, Random rand, int x, int z){
		Block stone = DimensionStoneHelper.getDimensionStone(0);
		generateVein(world, rand, x, z, RUBY_VEIN, stone);
		generateVein(world, rand, x, z, PINK_PANTHER_VEIN, stone);
		generateVein(world, rand, x, z, SAPPHIRE_VEIN, stone);
		generateVein(world, rand, x, z, CASSITERITE_VEIN, stone);
		generateVein(world, rand, x, z, ENSTATITE_VEIN, stone);
		generateVein(world, rand, x, z, MOONSTONE_VEIN, stone);
		List<VeinEntry> veins = ADDITIONAL_VEINS.get(0);
		if(veins != null && veins.size() > 0) for(VeinEntry vein: veins) if(vein != null) generateVein(world, rand, x, z, vein, stone);
	}

	private void generateNether(World world, Random rand, int x, int z){
		Block stone = DimensionStoneHelper.getDimensionStone(-1);
		generateVein(world, rand, x, z, SPECIAL_VEIN, stone);
		List<VeinEntry> veins = ADDITIONAL_VEINS.get(-1);
		if(veins != null && veins.size() > 0) for(VeinEntry vein: veins) if(vein != null) generateVein(world, rand, x, z, vein, stone);
	}

	private void generateVein(World world, Random rand, int x, int z, VeinEntry vein, Block stone){
		Block ore = vein.getMinableOre();
		int veinSize = vein.getVeinSize().getSize(rand);
		List<BiomeGenBase> biomes = vein.getAllowedBiomes();
		WorldGenMinable worldGen;
		if(!vein.hasMetadata()) worldGen = new WorldGenMinable(ore, veinSize, stone);
		else worldGen = new WorldGenMinable(ore, vein.getMetadata(), veinSize, stone);
		for(int i = 0; i < vein.getVeinChance(); i++){
			int posX = MathHelper.getRandomIntegerInRange(rand, x, x + 15), posY = vein.getVeinRange().getPosY(rand), posZ = MathHelper.getRandomIntegerInRange(rand, z, z + 15);
			BiomeGenBase biome = world.getBiomeGenForCoords(posX, posZ);
			if(biomes.size() == 0 || (biomes.size() > 0 && biomes.contains(biome))) worldGen.generate(world, rand, posX, posY, posZ);
		}
	}

}
