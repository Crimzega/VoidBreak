package com.sulvic.mcf.common;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sulvic.mcf.logger.MezidaLogger;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public abstract class BezkinConfig{

	protected static final String CONFIG_BASE = "sulvic";
	protected static final MezidaLogger logger = new MezidaLogger("Bezkin Config Log");
	private static Path configDirPath;
	private Path configPath;
	protected Configuration theConfig;

	public BezkinConfig(FMLPreInitializationEvent evt, String name){ theConfig = new Configuration(setupConfigFile(evt, name)); }

	public BezkinConfig(FMLPreInitializationEvent evt, String name, boolean caseSensitive){ theConfig = new Configuration(setupConfigFile(evt, name), caseSensitive); }

	public BezkinConfig(FMLPreInitializationEvent evt, String name, String version){ theConfig = new Configuration(setupConfigFile(evt, name), version); }

	public BezkinConfig(FMLPreInitializationEvent evt, String name, String version, boolean caseSensitive){ theConfig = new Configuration(setupConfigFile(evt, name), version, caseSensitive); }

	private static File setupConfigFile(FMLPreInitializationEvent evt, String name){
		if(configDirPath == null) {
			File folder = evt.getModConfigurationDirectory();
			configDirPath = Paths.get(folder.getAbsolutePath());
		}
		return new File(configDirPath.toFile(), name);
	}

	protected abstract void makeConfig();

	public void buildConfig(){
		if(configPath == null) configPath = Paths.get(theConfig.toString());
		try{
			theConfig.load();
			makeConfig();
		}
		catch(Exception ex){
			logger.error("An error occured in the following config file: " + configDirPath.relativize(configPath), ex);
		}
		finally{
			if(theConfig.hasChanged()) theConfig.save();
		}
	}

	public void syncConfig(){ makeConfig(); }

}
