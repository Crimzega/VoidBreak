package com.sulvic.mcf.integration;

import cpw.mods.fml.common.event.*;

public class DummyModHandler implements IModHandler{

	@Override
	public void preInit(FMLPreInitializationEvent evt){}

	@Override
	public void init(FMLInitializationEvent evt){}

	@Override
	public void postInit(FMLPostInitializationEvent evt){}

	@Override
	public void serverAboutToStart(FMLServerAboutToStartEvent evt){}

	@Override
	public void serverStarted(FMLServerStartedEvent evt){}

	@Override
	public void serverStarting(FMLServerStartedEvent evt){}

	@Override
	public void serverStopped(FMLServerStoppedEvent evt){}

	@Override
	public void serverStopping(FMLServerStoppingEvent evt){}

}
