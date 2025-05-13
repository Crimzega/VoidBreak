package com.sulvic.voidbreak.network.proxy;

import java.util.List;

import com.google.common.collect.Lists;
import com.sulvic.mcf.client.IFancy;
import com.sulvic.voidbreak.client.SulvicClientEvents;
import com.sulvic.voidbreak.client.renderer.tileentity.ZechaDrawerRenderer;
import com.sulvic.voidbreak.common.SulvicObjects;
import com.sulvic.voidbreak.level.tileentity.TileZechaDrawer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class ClientVB extends CommonVB{

	public static final int zechaDrawerRenderID = RenderingRegistry.getNextAvailableRenderId();
	public static final int energizerRenderID = RenderingRegistry.getNextAvailableRenderId();
	private List<IFancy> fancyTextureables = Lists.newArrayList();

	private <TileRenderer extends TileEntitySpecialRenderer & ISimpleBlockRenderingHandler> void registerTileRenderer(Class<? extends TileEntity> tileClass, TileRenderer renderer){
		ClientRegistry.bindTileEntitySpecialRenderer(tileClass, renderer);
		RenderingRegistry.registerBlockHandler(renderer);
	}

	@Override
	public void init(FMLInitializationEvent evt){
		super.init(evt);
		fancyTextureables.add(SulvicObjects.CITRUS_LEAVES);
	}

	@Override
	public void preInit(FMLPreInitializationEvent evt){
		super.preInit(evt);
		FMLCommonHandler.instance().bus().register(SulvicClientEvents.INSTANCE);
	}

	@Override
	public void registerRenders(){
//		RenderingRegistry.registerEntityRenderingHandler(EntityBrokenSkull.class, new RenderBrokenSkul());
		registerTileRenderer(TileZechaDrawer.class, new ZechaDrawerRenderer());
	}

	public void setFancyRender(boolean isFancy){ for(IFancy fancyTextureable: fancyTextureables) fancyTextureable.setFancyGraphics(isFancy); }

}
