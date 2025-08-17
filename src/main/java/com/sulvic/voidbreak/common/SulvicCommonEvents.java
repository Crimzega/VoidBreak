package com.sulvic.voidbreak.common;

import static com.sulvic.voidbreak.VoidBreak.*;
import static com.sulvic.voidbreak.common.SulvicObjects.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import com.google.common.collect.Maps;
import com.sulvic.voidbreak.VoidBreak;
import com.sulvic.voidbreak.level.world.provider.WorldProviderNothing;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.event.world.BlockEvent;

@SuppressWarnings({"unused"})
public class SulvicCommonEvents{

	private static final SulvicCommonEvents INSTANCE = new SulvicCommonEvents();
	private Map<UUID, Integer> playerTimers = Maps.newHashMap(), playerDamageTimers = Maps.newHashMap();
	private Map<UUID, Boolean> playersTraveled = Maps.newHashMap();

	private SulvicCommonEvents(){}

	public static void register(){
		FMLCommonHandler.instance().bus().register(INSTANCE);
		MinecraftForge.EVENT_BUS.register(INSTANCE);
	}

	@SubscribeEvent
	public void onBlockPlace(PlayerInteractEvent evt){
		EntityPlayer player = evt.entityPlayer;
		World world = player.worldObj;
		PlayerInteractEvent.Action action = evt.action;
		if(world.provider.dimensionId == WorldProviderNothing.dimensionID){
			switch(action){
				case RIGHT_CLICK_BLOCK:
					ItemStack stack = player.getHeldItem();
					if(stack != null && stack.getItem() != Items.flint_and_steel) evt.setCanceled(true);
				break;
				default:
				break;
			}
		}
	}

	@SubscribeEvent
	public void onBreakBlock(BlockEvent.BreakEvent evt){
		EntityPlayer player = evt.getPlayer();
		World world = player.worldObj;
		if(world.provider.dimensionId == WorldProviderNothing.dimensionID) evt.setCanceled(true);
	}

	@SubscribeEvent
	public void onCrafted(PlayerEvent.ItemCraftedEvent evt){
		EntityPlayer player = evt.player;
		ItemStack stack = evt.crafting;
		if(stack != null && stack.getItem() != null){
			Item item = stack.getItem();
			if(getConfig().allowEnchantedRecipes()){

			}
			AcroxliAchievement achievement = AcroxliAchievement.grabAchievement(AcroxliAchievement.Type.CRAFT, stack);
			if(achievement != null) player.triggerAchievement(achievement);
		}
	}

	@SubscribeEvent
	public void onItemPickup(PlayerEvent.ItemPickupEvent evt){
		EntityPlayer player = evt.player;
		EntityItem entityItem = evt.pickedUp;
		ItemStack stack = entityItem.getEntityItem();
		if(stack != null && stack.getItem() != null){
			Item item = stack.getItem();
			if(item == Item.getItemFromBlock(CITRUS_LOG)) player.triggerAchievement(AchievementList.mineWood);
			AcroxliAchievement achievement = AcroxliAchievement.grabAchievement(AcroxliAchievement.Type.PICK_UP, stack);
			if(achievement != null) player.triggerAchievement(achievement);
		}
	}

	@SubscribeEvent
	public void onItemUseFinish(PlayerUseItemEvent.Finish evt){
		ItemStack stack = evt.item;
		EntityPlayer player = evt.entityPlayer;
		if(stack != null && stack.getItem() != null){
			Item item = stack.getItem();
			if(item == Items.sugar){
				player.getFoodStats().addStats(1, 0.25f);
				if(stack.stackSize > 0) stack.stackSize--;
				evt.result = stack.stackSize > 0? stack: null;
			}
		}
	}

	@SubscribeEvent
	public void onItemUseStart(PlayerUseItemEvent.Start evt){
		EntityPlayer player = evt.entityPlayer;
		ItemStack stack = evt.item;
		if(stack != null && stack.getItem() != null){
			Item item = stack.getItem();
			if(player.canEat(Loader.isModLoaded("spiderqueen")) && item == Items.sugar) evt.duration = 32;
		}
	}

	@SubscribeEvent
	public void onItemUseStop(PlayerUseItemEvent.Stop evt){
		ItemStack stack = evt.item;
		if(stack != null && stack.getItem() != null){
			Item item = stack.getItem();
			if(item == Items.sugar) evt.duration = 32;
		}
	}

	@SubscribeEvent
	public void onItemUseTick(PlayerUseItemEvent.Tick evt){
		ItemStack stack = evt.item;
		EntityPlayer player = evt.entityPlayer;
		World world = player.worldObj;
		if(stack != null && stack.getItem() != null){
			Item item = stack.getItem();
			if(item == Items.sugar){
				double posX = player.posX, posY = player.posY, posZ = player.posZ;
				String particle = String.format("ironcrack_%d", Item.getIdFromItem(item));
				if(item.getHasSubtypes()) particle += String.format("_%d", stack.getItemDamage());
				world.spawnParticle(particle, posX, posY, posZ, posX, posY + 0.5d, posZ);
			}
		}
	}

	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent evt){
		EntityLivingBase livingBase = evt.entityLiving;
		World world = livingBase.worldObj;
		Random rand = world.rand;
		if(livingBase instanceof EntityZombie){
			EntityZombie zombie = (EntityZombie)livingBase;
			float chance = rand.nextFloat();
			if(chance <= 0.12f && !world.isRemote){
				int entry = rand.nextInt(4);
				EntityItem item = zombie.entityDropItem(new ItemStack(entry == 0? BAKED_SWEET_POTATO: SWEET_POTATO), 1f);
				world.spawnEntityInWorld(item);
			}
		}
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent evt){
		Entity entity = evt.entity;
		DamageSource dmgSrc = evt.source;
		if(entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			UUID id = player.getUniqueID();
			if(dmgSrc == DamageSource.outOfWorld && !player.isDead){
				int time = playerDamageTimers.getOrDefault(player, 0) + 1;
				if(time == 200 && player instanceof EntityPlayerMP){
					EntityPlayerMP playerMp = (EntityPlayerMP)player;
					MinecraftServer server = playerMp.mcServer;
					int targetDimId = playersTraveled.get(id)? 0: WorldProviderNothing.dimensionID;
					WorldServer serverWorld = server.worldServerForDimension(targetDimId);
					ChunkCoordinates spawnCoords = serverWorld.getSpawnPoint();
					if(playerMp.dimension != targetDimId) server.getConfigurationManager().transferPlayerToDimension(playerMp, targetDimId);
					if(targetDimId == WorldProviderNothing.dimensionID) playersTraveled.put(id, true);
					player.setPositionAndUpdate(spawnCoords.posX, spawnCoords.posY, spawnCoords.posZ);
				}
				else playerTimers.remove(id);
			}
			else playerTimers.remove(id);
		}
	}

	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent evt){
		EntityPlayer player = evt.player;
		UUID id = player.getUniqueID();
		World world = player.worldObj;
		ISaveHandler handler = world.getSaveHandler();
		File saveFolder = handler.getWorldDirectory();
		File modDataFolder = new File(saveFolder, "playerdata-vb");
		if(!modDataFolder.exists()){
			modDataFolder.mkdirs();
			playerTimers.put(id, 0);
			playerDamageTimers.put(id, 0);
			playersTraveled.put(id, false);
		}
		else{
			File playerData = new File(modDataFolder, String.format("%s.dat", id));
			if(playerData.exists()){
				try{
					FileInputStream stream = new FileInputStream(playerData);
					NBTTagCompound nbtCompound = CompressedStreamTools.readCompressed(stream);
					playerTimers.put(id, nbtCompound.getInteger("TimeInNothing"));
					playerDamageTimers.put(id, nbtCompound.getInteger("VoidDamageTime"));
					playersTraveled.put(id, nbtCompound.getBoolean("HasTraveled"));
				}
				catch(IOException ex){
					VoidBreak.getLogger().warn("Could not read player data", ex);
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent evt){
		EntityPlayer player = evt.player;
		UUID id = player.getUniqueID();
		World world = player.worldObj;
		ISaveHandler handler = world.getSaveHandler();
		File saveFolder = handler.getWorldDirectory();
		File modDataFolder = new File(saveFolder, "playerdata-vb");
		if(!modDataFolder.exists()) modDataFolder.mkdirs();
		File playerData = new File(modDataFolder, String.format("%s.dat", id));
		try{
			FileOutputStream stream = new FileOutputStream(playerData);
			NBTTagCompound nbtCompound = new NBTTagCompound();
			nbtCompound.setInteger("TimeInNothing", playerTimers.get(id));
			nbtCompound.setInteger("VoidDamageTime", playerDamageTimers.get(id));
			nbtCompound.setBoolean("HasTraveled", playersTraveled.get(id));
			CompressedStreamTools.writeCompressed(nbtCompound, stream);
		}
		catch(IOException ex){
			VoidBreak.getLogger().warn("Could not write player data", ex);
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent evt){
		EntityPlayer player = evt.player;
		World world = player.worldObj;
		UUID id = player.getUniqueID();
		if(world.provider.dimensionId == WorldProviderNothing.dimensionID){
			int time = playerTimers.getOrDefault(id, 0) + 1;
			if(time >= 12000 && player instanceof EntityPlayerMP){
				EntityPlayerMP playerMp = (EntityPlayerMP)player;
				MinecraftServer server = playerMp.mcServer;
				WorldServer serverWorld = server.worldServerForDimension(0);
				ChunkCoordinates spawnCoords = serverWorld.getSpawnPoint();
				server.getConfigurationManager().transferPlayerToDimension(playerMp, 0);
				player.setPositionAndUpdate(spawnCoords.posX, spawnCoords.posY, spawnCoords.posZ);
				playerTimers.remove(id);
			}
			else playerTimers.put(id, time);
		}
		else playerTimers.remove(id);
	}

}
