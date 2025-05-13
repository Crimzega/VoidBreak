package com.sulvic.voidbreak.network.proxy;

import com.sulvic.mcf.network.proxy.AlvontixProxy;
import com.sulvic.voidbreak.VoidBreak;
import com.sulvic.voidbreak.client.gui.SulvicGuis;
import com.sulvic.voidbreak.common.*;
import com.sulvic.voidbreak.level.world.block.BlockPile;
import com.sulvic.voidbreak.level.world.gen.*;

import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class CommonVB extends AlvontixProxy{

	@Override
	public void preInit(FMLPreInitializationEvent evt){
		BlockPile.addConfigBlocks();
		JemurinMaterial.addRepairItems();
		OreDictionary.registerOre("button", Blocks.wooden_button);
		OreDictionary.registerOre("button", Blocks.stone_button);
		GameRegistry.registerFuelHandler(FuelHandlerVB.instance);
		SulvicObjects.registerItems();
		SulvicCommonEvents.register();
		NetworkRegistry.INSTANCE.registerGuiHandler(VoidBreak.instance, new SulvicGuis());
	}

	@Override
	public void init(FMLInitializationEvent evt){
		HokurmiRecipes.addRecipes();
		SulvicObjects.registerBiomes();
		AcroxliAchievement.registerAchievements();
	}

	@Override
	public void postInit(FMLPostInitializationEvent evt){
		GameRegistry.registerWorldGenerator(ModOreGenerator.INSTANCE, 4);
		GameRegistry.registerWorldGenerator(SulvicTreeGenerator.INSTANCE, 2);
		super.postInit(evt);
	}

}
