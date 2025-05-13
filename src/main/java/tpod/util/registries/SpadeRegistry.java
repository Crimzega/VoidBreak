package tpod.util.registries;

import net.minecraft.item.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class SpadeRegistry extends ItemSpade
{
    private String regContent;
    
    public SpadeRegistry(final String unlName, final Item.ToolMaterial material) {
        super(material);
        this.setCreativeTab(ContentsVBD2.creativeTabs[3]);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(unlName);
        this.regContent = unlName;
    }
    
    public SpadeRegistry texture(final int stop) {
        this.setTextureName("VoidBreakDemo2:tools/" + this.regContent.substring(0, stop) + "Shovel");
        if (stop == 0 || this.regContent == "shedSpade") {
            this.setTextureName("VoidBreakDemo2:tools/" + this.regContent);
        }
        return this;
    }
    
    public SpadeRegistry registerSpade() {
        GameRegistry.registerItem((Item)this, this.regContent);
        return this;
    }
}
