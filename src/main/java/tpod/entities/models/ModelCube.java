package tpod.entities.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelCube extends ModelBase
{
    public ModelRenderer cube;
    
    public ModelCube() {
        this.textureWidth = 16;
        this.textureHeight = 8;
        (this.cube = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-2.0f, -4.0f, -2.0f, 4, 4, 4);
        this.cube.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.cube.setTextureOffset(this.textureWidth, this.textureHeight);
        this.setRotation(this.cube, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        super.render(entity, par1, par2, par3, par4, par5, par6);
        this.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        this.cube.render(par6);
    }
    
    public void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
    }
}
