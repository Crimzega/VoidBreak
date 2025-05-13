package com.sulvic.voidbreak.level.world.biome;

import static com.sulvic.voidbreak.common.SulvicObjects.*;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeNothing extends BiomeGenBase{

	public BiomeNothing(){
		super(getBiomeId());
		setBiomeName("Nothing (Biome)");
		setColor(0x000000);
		setHeight(new BiomeGenBase.Height(0.5f, 0f));
		setDisableRain();
		setTemperatureRainfall(0f, 0f);
		topBlock = NOTHING_BLOCK;
		fillerBlock = NOTHING_BLOCK;
		explorationBiomesList.remove(this);
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableCaveCreatureList.clear();
		spawnableWaterCreatureList.clear();
	}

	@Override
	public void decorate(World world, Random rand, int x, int z){}

}
