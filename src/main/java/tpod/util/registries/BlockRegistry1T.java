package tpod.util.registries;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import tpod.lib.*;
import cpw.mods.fml.common.registry.*;

public class BlockRegistry1T extends Block
{
    private String regContent;
    
    public BlockRegistry1T(final String unlName, final Material material) {
        super(material);
        this.setBlockName(unlName);
        this.setCreativeTab(ContentsVBD2.creativeTabs[0]);
        this.regContent = unlName;
    }
    
    public BlockRegistry1T hardResist(final float hardness, final float resistance) {
        this.setHardness(hardness);
        this.setResistance(resistance);
        return this;
    }
    
    public BlockRegistry1T harvestLvl(final String tool, final int lvl) {
        this.setHarvestLevel(tool, lvl);
        return this;
    }
    
    public BlockRegistry1T lightLvlOpc(final float lvl, final int opc) {
        this.setLightLevel(lvl);
        this.setLightOpacity(opc);
        return this;
    }
    
    public BlockRegistry1T stepSound(final Block.SoundType sound) {
        this.setStepSound(sound);
        return this;
    }
    
    public BlockRegistry1T texture() {
        this.setBlockTextureName("VoidBreakDemo2:" + this.regContent);
        return this;
    }
    
    public BlockRegistry1T registerBlock() {
        GameRegistry.registerBlock((Block)this, this.regContent);
        return this;
    }
}
