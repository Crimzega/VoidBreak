package com.sulvic.voidbreak.client;

import com.sulvic.mcf.network.proxy.ZaranthaClient;
import com.sulvic.voidbreak.VoidBreak;
import com.sulvic.voidbreak.network.proxy.ClientVB;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;

public class SulvicClientEvents{

	public static final SulvicClientEvents INSTANCE = new SulvicClientEvents();

	private SulvicClientEvents(){}

	@ZaranthaClient
	private static boolean isFancy = Minecraft.isFancyGraphicsEnabled();

	@ZaranthaClient
	public static boolean usingFancyGraphics(){ return isFancy; }

	@SubscribeEvent
	@ZaranthaClient
	public void onRender(TickEvent.RenderTickEvent evt){ if(isFancy != Minecraft.isFancyGraphicsEnabled()) ((ClientVB)VoidBreak.proxy).setFancyRender(isFancy = Minecraft.isFancyGraphicsEnabled()); }

}
