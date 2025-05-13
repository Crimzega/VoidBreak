package tpod.util.world;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class EndGenMinable extends WorldGenerator{

	private Block minableBlock;
	private Block replaceableStone;
	private int numberOfBlocks;
	private int mineableBlockMetadata;

	public EndGenMinable(Block block, int numb){ this(block, numb, Blocks.end_stone); }

	public EndGenMinable(Block block, int numb, Block block2){
		minableBlock = block;
		numberOfBlocks = numb;
		replaceableStone = block2;
	}

	public EndGenMinable(Block block, int number, int meta, Block target){
		this(block, number, target);
		mineableBlockMetadata = meta;
	}

	public boolean generate(World world, Random rand, int posX, int posY, int posZ){
		float f = rand.nextFloat() * (float)Math.PI;
		double d0 = posX + 8 + MathHelper.sin(f) * numberOfBlocks / 8f;
		double d2 = posX + 8 - MathHelper.sin(f) * numberOfBlocks / 8f;
		double d3 = posZ + 8 + MathHelper.cos(f) * numberOfBlocks / 8f;
		double d4 = posZ + 8 - MathHelper.cos(f) * numberOfBlocks / 8f;
		double d5 = posY + rand.nextInt(3) - 2;
		double d6 = posY + rand.nextInt(3) - 2;
		for(int l = 0; l <= numberOfBlocks; ++l){
			double d7 = d0 + (d2 - d0) * l / numberOfBlocks;
			double d8 = d5 + (d6 - d5) * l / numberOfBlocks;
			double d9 = d3 + (d4 - d3) * l / numberOfBlocks;
			double d10 = rand.nextDouble() * numberOfBlocks / 16d;
			double d11 = (MathHelper.sin(l * (float)Math.PI / numberOfBlocks) + 1f) * d10 + 1d;
			double d12 = (MathHelper.sin(l * (float)Math.PI / numberOfBlocks) + 1f) * d10 + 1d;
			int i1 = MathHelper.floor_double(d7 - d11 / 2d);
			int j1 = MathHelper.floor_double(d8 - d12 / 2d);
			int k1 = MathHelper.floor_double(d9 - d11 / 2d);
			int l2 = MathHelper.floor_double(d7 + d11 / 2d);
			int i2 = MathHelper.floor_double(d8 + d12 / 2d);
			int j2 = MathHelper.floor_double(d9 + d11 / 2d);
			for(int k2 = i1; k2 <= l2; ++k2){
				double d13 = (k2 + 0.5d - d7) / (d11 / 2d);
				if(d13 * d13 < 1d){
					for(int l3 = j1; l3 <= i2; ++l3){
						final double d14 = (l3 + 0.5d - d8) / (d12 / 2d);
						if(d13 * d13 + d14 * d14 < 1d){
							for(int i3 = k1; i3 <= j2; ++i3){
								final double d15 = (i3 + 0.5d - d9) / (d11 / 2d);
								if(d13 * d13 + d14 * d14 + d15 * d15 < 1d && world.getBlock(k2, l3, i3).isReplaceableOreGen(world, k2, l3, i3, replaceableStone))
									world.setBlock(k2, l3, i3, minableBlock, mineableBlockMetadata, 2);
							}
						}
					}
				}
			}
		}
		return true;
	}

}
