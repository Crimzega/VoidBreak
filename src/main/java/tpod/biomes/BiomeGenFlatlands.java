package tpod.biomes;

import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;

@SuppressWarnings({"unchecked"})
public class BiomeGenFlatlands extends BiomeGenBase{

	public BiomeGenFlatlands(int id){
		super(id);
		setColor(9286496);
		setBiomeName("Flatlands");
		setHeight(new BiomeGenBase.Height(0.258f, 0.262f));
		setTemperatureRainfall(0.25f, 0.3f);
		rainfall = 0.6f;
		topBlock = Blocks.grass;
		fillerBlock = Blocks.dirt;
		theBiomeDecorator.flowersPerChunk = 3;
		theBiomeDecorator.grassPerChunk = 7;
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		creatureList();
	}

	public void creatureList(){
		spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 10, 8, 8));
		spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 14, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 12, 7, 7));
		spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
	}

}
