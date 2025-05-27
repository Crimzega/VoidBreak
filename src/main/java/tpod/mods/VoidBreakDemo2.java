package tpod.mods;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import tpod.lib.ClientVBD2;
import tpod.lib.ContentsVBD2;
import tpod.lib.RecipesVBD2;
import tpod.lib.RegistrationVBD2;
import tpod.lib.ServerVBD2;
import tpod.util.ConfigVBD2;
import tpod.util.EventsVBD2;
import tpod.util.world.WorldGenVBD2;

//@Mod(modid = "VoidBreakDemo2", name = "Void Break (Demo 2)", version = "PreBeta v1 r1")
public class VoidBreakDemo2{

	public static Configuration config;
	public static Logger log = FMLLog.getLogger();;
	public static WorldGenVBD2 modWorldGen = new WorldGenVBD2();
	public static ContentsVBD2 modContents = new ContentsVBD2();
//	@Mod.Instance("VoidBreakDemo2")
	public static VoidBreakDemo2 instance;
	@SidedProxy(clientSide = "tpod.lib.ClientVBD2", serverSide = "tpod.lib.ServerVBD2")
	public static ServerVBD2 proxyS;
	public static ClientVBD2 proxyC;
	EventsVBD2 masterHandler;
	
	public VoidBreakDemo2(){ masterHandler = new EventsVBD2(); }
	
	@EventHandler
	public void preInit(final FMLPreInitializationEvent event){
		log.info("Pre-Initializing");
		config = new Configuration(event.getSuggestedConfigurationFile());
		ConfigVBD2.setupDefaults();
		FMLCommonHandler.instance().bus().register((Object)masterHandler);
		MinecraftForge.EVENT_BUS.register((Object)masterHandler);
		RegistrationVBD2.initCreativeTabs();
		RegistrationVBD2.initEquipMaterials();
		log.info("Pre-Initialized");
	}
	
	@EventHandler
	public void init(final FMLInitializationEvent event){
		log.info("Initializing");
		FMLCommonHandler.instance().bus().register((Object)instance);
		RegistrationVBD2.initBlocks();
		RegistrationVBD2.initItems();
		RegistrationVBD2.initEquip();
		proxyS.registerRenders();
		log.info("Initialized");
	}
	
	@EventHandler
	public void postInit(final FMLPostInitializationEvent event) {
		log.info("Post-Initializing");
		GameRegistry.registerWorldGenerator((IWorldGenerator)modWorldGen, 0);
		RecipesVBD2.shaped();
		RecipesVBD2.shapeless();
		RecipesVBD2.smelting();
		RegistrationVBD2.initAchievements();
		RegistrationVBD2.initBiomes();
		log.info("Post-Initialized");
	}
	
}
