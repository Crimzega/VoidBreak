package tpod.util.world;

import net.minecraft.world.gen.feature.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.*;

public class NetherGenMinable extends WorldGenerator
{
    private Block field_150519_a;
    private Block field_150518_c;
    private int numberOfBlocks;
    private int mineableBlockMeta;
    
    public NetherGenMinable(final Block block, final int numb) {
        this(block, numb, Blocks.netherrack);
    }
    
    public NetherGenMinable(final Block block, final int numb, final Block block2) {
        this.field_150519_a = block;
        this.numberOfBlocks = numb;
        this.field_150518_c = block2;
    }
    
    public NetherGenMinable(final Block block, final int number, final int meta, final Block target) {
        this(block, number, target);
        this.mineableBlockMeta = meta;
    }
    
    public boolean generate(final World world, final Random rand, final int posX, final int posY, final int posZ) {
        final float f = rand.nextFloat() * 3.1415927f;
        final double d0 = posX + 8 + MathHelper.sin(f) * this.numberOfBlocks / 8.0f;
        final double d2 = posX + 8 - MathHelper.sin(f) * this.numberOfBlocks / 8.0f;
        final double d3 = posZ + 8 + MathHelper.cos(f) * this.numberOfBlocks / 8.0f;
        final double d4 = posZ + 8 - MathHelper.cos(f) * this.numberOfBlocks / 8.0f;
        final double d5 = posY + rand.nextInt(3) - 2;
        final double d6 = posY + rand.nextInt(3) - 2;
        for (int l = 0; l <= this.numberOfBlocks; ++l) {
            final double d7 = d0 + (d2 - d0) * l / this.numberOfBlocks;
            final double d8 = d5 + (d6 - d5) * l / this.numberOfBlocks;
            final double d9 = d3 + (d4 - d3) * l / this.numberOfBlocks;
            final double d10 = rand.nextDouble() * this.numberOfBlocks / 16.0;
            final double d11 = (MathHelper.sin(l * 3.1415927f / this.numberOfBlocks) + 1.0f) * d10 + 1.0;
            final double d12 = (MathHelper.sin(l * 3.1415927f / this.numberOfBlocks) + 1.0f) * d10 + 1.0;
            final int i1 = MathHelper.floor_double(d7 - d11 / 2.0);
            final int j1 = MathHelper.floor_double(d8 - d12 / 2.0);
            final int k1 = MathHelper.floor_double(d9 - d11 / 2.0);
            final int l2 = MathHelper.floor_double(d7 + d11 / 2.0);
            final int i2 = MathHelper.floor_double(d8 + d12 / 2.0);
            final int j2 = MathHelper.floor_double(d9 + d11 / 2.0);
            for (int k2 = i1; k2 <= l2; ++k2) {
                final double d13 = (k2 + 0.5 - d7) / (d11 / 2.0);
                if (d13 * d13 < 1.0) {
                    for (int l3 = j1; l3 <= i2; ++l3) {
                        final double d14 = (l3 + 0.5 - d8) / (d12 / 2.0);
                        if (d13 * d13 + d14 * d14 < 1.0) {
                            for (int i3 = k1; i3 <= j2; ++i3) {
                                final double d15 = (i3 + 0.5 - d9) / (d11 / 2.0);
                                if (d13 * d13 + d14 * d14 + d15 * d15 < 1.0 && world.getBlock(k2, l3, i3).isReplaceableOreGen(world, k2, l3, i3, this.field_150518_c)) {
                                    world.setBlock(k2, l3, i3, this.field_150519_a, this.mineableBlockMeta, 2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
