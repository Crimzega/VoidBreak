package com.sulvic.voidbreak.client.renderer.tileentity;

import static com.sulvic.voidbreak.ReferenceVB.*;
import static com.sulvic.voidbreak.network.proxy.ClientVB.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;

import com.sulvic.voidbreak.client.model.ModelZechaDrawer;
import com.sulvic.voidbreak.level.tileentity.TileZechaDrawer;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

public class ZechaDrawerRenderer extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler{

	private static final ResourceLocation TEXTURE = new ResourceLocation(MODID, "textures/models/zecha_drawer.png");
	private ModelZechaDrawer drawerModel = new ModelZechaDrawer();
	private TileZechaDrawer drawerTile = new TileZechaDrawer();

	@Override
	public boolean renderWorldBlock(IBlockAccess access, int x, int y, int z, Block block, int id, RenderBlocks renderer){ return false; }

	@Override
	public boolean shouldRender3DInInventory(int id){ return id == getRenderId(); }

	@Override
	public int getRenderId(){ return zechaDrawerRenderID; }

	@Override
	public void renderInventoryBlock(Block block, int metadata, int id, RenderBlocks renderer){
		glRotated(90f, 0f, 1f, 0f);
		glTranslatef(-0.5f, -0.5f, -0.5f);
		renderTileEntityAt(drawerTile, 0d, 0d, 0d, 0f);
		glEnable(GL_RESCALE_NORMAL);
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTicks){ renderZechaDrawerAt((TileZechaDrawer)tile, x, y, z, partialTicks); }

	public void renderZechaDrawerAt(TileZechaDrawer drawer, double x, double y, double z, float partialTicks){
		int metadata = drawer.hasWorldObj()? drawer.getBlockMetadata(): 0;
		bindTexture(TEXTURE);
		glPushMatrix();
		glEnable(GL_RESCALE_NORMAL);
		glColor4f(1f, 1f, 1f, 1f);
		glTranslated(x, y + 1d, z + 1d);
		glScalef(1f, -1f, -1f);
		glTranslatef(0.5f, 0.5f, 0.5f);
		float rot = 0f;
		switch(metadata){
			case 2:
				rot = 180f;
			break;
			case 3:
				rot = 0f;
			break;
			case 4:
				rot = 90f;
			break;
			case 5:
				rot = -90f;
			break;
		}
		glRotatef(rot, 0f, 1f, 0f);
		glScalef(1.9275f, 1.9275f, 1.9275f);
		glTranslatef(0f, -0.52f, 0f);
		double doorAngle = (double)(drawer.prevDoorAngle + (drawer.doorAngle - drawer.prevDoorAngle) * partialTicks);
		doorAngle = 1f - doorAngle;
		doorAngle = 1f - Math.pow((double)doorAngle, 3d);
		drawerModel.doorL.rotateAngleY = -(drawerModel.doorR.rotateAngleY = (float)(doorAngle * Math.PI / 2d));
		drawerModel.renderAll();
		glDisable(GL_RESCALE_NORMAL);
		glPopMatrix();
	}

}
