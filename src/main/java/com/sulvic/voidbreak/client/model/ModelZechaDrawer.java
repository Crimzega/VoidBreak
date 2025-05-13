package com.sulvic.voidbreak.client.model;

import static com.sulvic.mcf.client.renderer.ModelHelper.*;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelZechaDrawer extends ModelBase{

	public ModelRenderer base, doorL, doorR;

	public ModelZechaDrawer(){
		super();
		textureWidth = 52;
		textureHeight = 42;
		base = new ModelRenderer(this, 0, 0);
		base.addBox(-7f, -14f, -7f, 14, 14, 12);
		base.setRotationPoint(0f, 24f, 2f);
		setRotationOffset(base, 0f, 0f, 0f);
		doorL = new ModelRenderer(this, 18, 26);
		doorL.addBox(-7f, -7f, -2f, 7, 14, 2);
		doorL.setRotationPoint(7f, 17f, -5f);
		setRotationOffset(doorL, 0f, 0f, 0f);
		doorR = new ModelRenderer(this, 0, 26);
		doorR.addBox(0f, -7f, -2f, 7, 14, 2);
		doorR.setRotationPoint(-7f, 17f, -5f);
		setRotationOffset(doorR, 0f, 0f, 0f);
	}

	@Override
	public void render(Entity entity, float limbSwing, float limbSwingAmount, float time, float rotationYaw, float rotationPitch, float partialTicks){
		super.render(entity, limbSwing, limbSwingAmount, time, rotationYaw, rotationPitch, partialTicks);
		setRotationAngles(limbSwing, limbSwingAmount, time, rotationYaw, rotationPitch, partialTicks, entity);
		base.render(partialTicks);
		doorL.render(partialTicks);
		doorR.render(partialTicks);
	}

	public void renderAll(){
		float partialTicks = 0.0325f;
		base.render(partialTicks);
		doorL.render(partialTicks);
		doorR.render(partialTicks);
	}

}
