package com.sulvic.mcf.network.proxy;

import cpw.mods.fml.common.event.*;

public class AlvontixProxy{

	public void init(FMLInitializationEvent evt){}

	public void postInit(FMLPostInitializationEvent evt){}

	public void preInit(FMLPreInitializationEvent evt){}

	public void serverAboutToStart(FMLServerAboutToStartEvent evt){}

	public void serverStarted(FMLServerStartedEvent evt){}

	public void serverStarting(FMLServerStartedEvent evt){}

	public void serverStopped(FMLServerStoppedEvent evt){}

	public void serverStopping(FMLServerStoppingEvent evt){}

	public void registerRenders(){}

	@ZaranthaClient
	public void setFancyRender(boolean fancy){}

}
