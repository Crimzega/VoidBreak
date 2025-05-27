package com.sulvic.voidbreak;

import static com.sulvic.voidbreak.ReferenceVB.*;

import org.apache.logging.log4j.*;

import com.sulvic.voidbreak.common.ConfigVB;
import com.sulvic.voidbreak.network.proxy.CommonVB;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.event.*;
import net.minecraft.init.Items;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class VoidBreak{

	private Logger modLog;
	@Mod.Instance(MODID)
	public static VoidBreak instance;
	@SidedProxy(clientSide = CLIENT, serverSide = COMMON)
	public static CommonVB proxy;
	private ConfigVB modConfig;

	public VoidBreak(){
		modLog = LogManager.getLogger(MODID);
		modLog.info("Constructing...");
		Items.sign.setMaxStackSize(32);
		Items.bucket.setMaxStackSize(32);
		Items.snowball.setMaxStackSize(32);
		Items.egg.setMaxStackSize(32);
		Items.ender_pearl.setMaxStackSize(32);
		modLog.info("Constructed!");
	}

	public static ConfigVB getConfig(){ return instance.modConfig; }

	public static Logger getLogger(){ return instance.modLog; }

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt){
		modLog.info("Pre-Initializing...");
		modConfig = new ConfigVB(evt);
		modConfig.buildConfig();
		proxy.preInit(evt);
		proxy.registerRenders();
		modLog.info("Pre-Initialized!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent evt){
		modLog.info("Initializing...");
		proxy.init(evt);
		modLog.info("Initialized!");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent evt){
		modLog.info("Post-Initializing...");
		proxy.postInit(evt);
		modLog.info("Post-Initialized!");
	}

}
