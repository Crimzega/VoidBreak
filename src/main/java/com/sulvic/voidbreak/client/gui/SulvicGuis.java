package com.sulvic.voidbreak.client.gui;

import com.sulvic.voidbreak.level.container.*;
import com.sulvic.voidbreak.level.tileentity.*;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SulvicGuis implements IGuiHandler{

	public static final int specialWorkbenchID = 0;
	public static final int zechaDrawerID = 1;

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		InventoryPlayer playerInv = player.inventory;
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(id){
			case specialWorkbenchID:
				return new GuiSpecialWorkbench(playerInv, (TileSpecialWorkbench)tile);
			case zechaDrawerID:
				return new GuiZechaDrawer(playerInv, (TileZechaDrawer)tile);
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		InventoryPlayer playerInv = player.inventory;
		TileEntity tile = world.getTileEntity(x, y, z);
		switch(id){
			case specialWorkbenchID:
				return new ContainerSpecialWorkbench(playerInv, (TileSpecialWorkbench)tile);
			case zechaDrawerID:
				return new ContainerZechaDrawer(playerInv, (TileZechaDrawer)tile);
		}
		return null;
	}

}
