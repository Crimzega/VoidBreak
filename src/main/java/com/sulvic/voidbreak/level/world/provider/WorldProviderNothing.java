package com.sulvic.voidbreak.level.world.provider;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.common.SulvicObjects;
import com.sulvic.voidbreak.level.world.chunk.generator.WorldChunkManagerNothing;

import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderNothing extends WorldProvider{

	public static int dimensionID = SulvicObjects.getDimensionId();

	@Override
	protected void generateLightBrightnessTable(){
		float f = 0.1f;
		for(int i = 0; i <= 15; ++i){
			float f1 = 1f - (float)i / 15f;
			lightBrightnessTable[i] = (1f - f1) / (f1 * 3f + 1f) * (1f - f) + f;
		}
	}

	@Override
	protected void registerWorldChunkManager(){
		worldChunkMgr = new WorldChunkManagerNothing();
		super.registerWorldChunkManager();
		isHellWorld = false;
		hasNoSky = true;
		dimensionId = dimensionID;
	}

	public IChunkProvider createChunkGeneration(){ return null; }

	@Override
	public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks){ return null; }

	@Override
	@ZaranthaClient
	public boolean isSkyColored(){ return false; }

	@Override
	public boolean canRespawnHere(){ return false; }

	@Override
	public boolean isSurfaceWorld(){ return false; }

	@Override
	@ZaranthaClient
	public float getCloudHeight(){ return -1f; }

	@Override
	public int getAverageGroundLevel(){ return 34; }

	@Override
	@ZaranthaClient
	public Vec3 getFogColor(float celestianAngle, float partialTicks){ return Vec3.createVectorHelper(0f, 0f, 0f); }

	@Override
	public boolean canCoordinateBeSpawn(int x, int z){ return false; }

	@Override
	public String getDimensionName(){ return "Nothing (Dimension Veriation)"; }

}
