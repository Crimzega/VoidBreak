package com.sulvic.mcf.integration;

import cpw.mods.fml.common.event.*;

public interface IModHandler{

	void preInit(FMLPreInitializationEvent evt);

	void init(FMLInitializationEvent evt);

	void postInit(FMLPostInitializationEvent evt);

	void serverAboutToStart(FMLServerAboutToStartEvent evt);

	void serverStarted(FMLServerStartedEvent evt);

	void serverStarting(FMLServerStartedEvent evt);

	void serverStopped(FMLServerStoppedEvent evt);

	void serverStopping(FMLServerStoppingEvent evt);

}
