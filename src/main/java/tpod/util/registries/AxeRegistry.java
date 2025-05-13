package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class AxeRegistry extends ItemAxe
{
    private String regContent;
    
    public AxeRegistry(final String unlName, final Item.ToolMaterial material) {
        super(material);
        this.setCreativeTab(ContentsVBD2.creativeTabs[3]);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(unlName);
        this.regContent = unlName;
    }
    
    public AxeRegistry texture() {
        this.setTextureName("VoidBreakDemo2:tools/" + this.regContent);
        return this;
    }
    
    public AxeRegistry registerAxe() {
        GameRegistry.registerItem((Item)this, this.regContent);
        return this;
    }
}
