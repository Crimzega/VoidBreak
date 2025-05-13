package com.sulvic.mcf.world.gen;

import java.util.Random;

import net.minecraft.world.World;

public interface IStructureGenerator{

	boolean generate(World world, Random rand, int x, int y, int z);

}
