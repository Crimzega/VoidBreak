package com.sulvic.voidbreak.level.world.biome;

import static com.sulvic.voidbreak.common.SulvicObjects.getBiomeId;

import java.util.Random;

import com.sulvic.voidbreak.level.world.gen.SulvicTreeGenerator;

import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

@SuppressWarnings({"unchecked"})
public class BiomeCitrusGrove extends BiomeGenBase{

	public BiomeCitrusGrove(){
		super(getBiomeId());
		setBiomeName("Citrus Grove");
		setHeight(new BiomeGenBase.Height(0.255f, 0.005f));
		setColor(0xAA7F47);
		setTemperatureRainfall(0.24f, 0.27f);
		theBiomeDecorator.treesPerChunk = 3;
		theBiomeDecorator.mushroomsPerChunk = 0;
		theBiomeDecorator.flowersPerChunk = 0;
		theBiomeDecorator.grassPerChunk = 0;
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySpider.class, 2, 1, 4));
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random rand){ return SulvicTreeGenerator.CITRUS_TREE; }

}
