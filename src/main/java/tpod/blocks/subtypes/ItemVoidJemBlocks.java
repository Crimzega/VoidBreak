package tpod.blocks.subtypes;

import net.minecraft.block.*;
import net.minecraft.item.*;

public class ItemVoidJemBlocks extends ItemBlock
{
    private static String[] subBlocks;
    
    public ItemVoidJemBlocks(final Block blocks) {
        super(blocks);
        this.setHasSubtypes(true);
    }
    
    public int getMetadata(final int meta) {
        return meta;
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        int i = itemstack.getItemDamage();
        if (i < 0 || i >= ItemVoidJemBlocks.subBlocks.length) {
            i = 0;
        }
        return this.getUnlocalizedName() + "." + ItemVoidJemBlocks.subBlocks[i];
    }
    
    static {
        ItemVoidJemBlocks.subBlocks = new String[] { "hyperizedDiamond", "negatizedRuby", "hyperizedPinkPanther", "negatizedSapphire", "hyperizedEmerald", "negatizedCassiterite" };
    }
}
