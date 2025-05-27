package tpod.entities.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelCube extends ModelBase{

	public ModelRenderer cube;

	public ModelCube() {
		textureWidth = 16;
		textureHeight = 8;
		(cube = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-2f, -4f, -2f, 4, 4, 4);
		cube.setRotationPoint(0f, 24f, 0f);
		cube.setTextureOffset(textureWidth, textureHeight);
		setRotation(cube, 0f, 0f, 0f);
	}

	public void render(Entity entity, float par1, float par2, float par3, float par4, float par5, float par6) {
		super.render(entity, par1, par2, par3, par4, par5, par6);
		setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
		cube.render(par6);
	}

	public void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
	}

}
