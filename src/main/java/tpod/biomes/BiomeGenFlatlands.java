package tpod.biomes;

import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;

@SuppressWarnings({"unchecked"})
public class BiomeGenFlatlands extends BiomeGenBase
{
    public BiomeGenFlatlands(final int id) {
        super(id);
        this.setColor(9286496);
        this.setBiomeName("Flatlands");
        this.setHeight(new BiomeGenBase.Height(0.258f, 0.262f));
        this.setTemperatureRainfall(0.25f, 0.3f);
        this.rainfall = 0.6f;
        this.topBlock = Blocks.grass;
        this.fillerBlock = Blocks.dirt;
        this.theBiomeDecorator.flowersPerChunk = 3;
        this.theBiomeDecorator.grassPerChunk = 7;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.creatureList();
    }
    
    public void creatureList() {
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
