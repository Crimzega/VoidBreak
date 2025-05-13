package tpod.blocks.subtypes;

import net.minecraft.block.*;
import net.minecraft.item.*;

public class ItemJemBlocks extends ItemBlock
{
    private static String[] subBlocks;
    
    public ItemJemBlocks(final Block blocks) {
        super(blocks);
        this.setHasSubtypes(true);
    }
    
    public int getMetadata(final int meta) {
        return meta;
    }
    
    public String getUnlocalizedName(final ItemStack itemstack) {
        int i = itemstack.getItemDamage();
        if (i < 0 || i >= ItemJemBlocks.subBlocks.length) {
            i = 0;
        }
        return this.getUnlocalizedName() + "." + ItemJemBlocks.subBlocks[i];
    }
    
    static {
        ItemJemBlocks.subBlocks = new String[] { "ruby", "pinkPanther", "sapphire", "cassiterite" };
    }
}
