package com.sulvic.mcf.client.renderer;

import net.minecraft.client.model.ModelRenderer;

public class ModelHelper{

	public static void setRotationOffset(ModelRenderer renderer, float x, float y, float z){
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
