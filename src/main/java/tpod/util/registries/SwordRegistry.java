package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class SwordRegistry extends ItemSword
{
    private String regContent;
    
    public SwordRegistry(final String unlName, final Item.ToolMaterial material) {
        super(material);
        this.setCreativeTab(ContentsVBD2.creativeTabs[4]);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(unlName);
        this.regContent = unlName;
    }
    
    public SwordRegistry texture() {
        this.setTextureName("VoidBreakDemo2:tools/" + this.regContent);
        return this;
    }
    
    public SwordRegistry registerSword() {
        GameRegistry.registerItem((Item)this, this.regContent);
        return this;
    }
}
