package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class ItemRegistry extends Item
{
    private String regContent;
    
    public ItemRegistry(final String unlName) {
        this.setCreativeTab(ContentsVBD2.creativeTabs[1]);
        this.setUnlocalizedName(unlName);
        this.regContent = unlName;
    }
    
    public ItemRegistry maxStack(final int max) {
        this.setMaxStackSize(max);
        return this;
    }
    
    public ItemRegistry texture() {
        this.setTextureName("VoidBreakDemo2:" + this.regContent);
        return this;
    }
    
    public ItemRegistry registerItem() {
        GameRegistry.registerItem((Item)this, this.regContent);
        return this;
    }
}
