package com.sulvic.voidbreak.level.world.biome;

import static com.sulvic.voidbreak.common.SulvicObjects.*;

import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

@SuppressWarnings({"unchecked"})
public class BiomeFlatlands extends BiomeGenBase{

	protected static final int T = 9286496;

	public BiomeFlatlands(){
		super(getBiomeId());
		setColor(0x8DB360);
		setBiomeName("Flatlands");
		setHeight(new Height(0.252f, 0.004f));
		setTemperatureRainfall(0.25f, 0.45f);
		topBlock = Blocks.grass;
		fillerBlock = Blocks.dirt;
		theBiomeDecorator.flowersPerChunk = 5;
		theBiomeDecorator.grassPerChunk = 9;
		theBiomeDecorator.treesPerChunk = 0;
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
	}

}
