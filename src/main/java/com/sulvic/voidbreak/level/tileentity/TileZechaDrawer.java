package com.sulvic.voidbreak.level.tileentity;

import static com.sulvic.voidbreak.common.SulvicObjects.*;

import com.sulvic.mcf.util.ZimedaMath;
import com.sulvic.mcf.util.ZimedaString;
import com.sulvic.voidbreak.level.world.block.BlockZechaDrawer;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileZechaDrawer extends TileEntity implements IInventory{

	private ItemStack[] drawerInventory = new ItemStack[96];
	private int ticksSinceSync;
	private String customName;
	public float doorAngle, prevDoorAngle;
	public int numPlayersUsing;

	@Override
	public boolean hasCustomInventoryName(){ return !ZimedaString.isNullOrEmpty(customName); }

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack){ return true; }

	@Override
	public boolean isUseableByPlayer(EntityPlayer player){ return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && ZimedaMath.tileEntityWithinRange(this, player, 64d); }

	@Override
	public boolean receiveClientEvent(int id, int value){
		switch(id){
			case 1:
				numPlayersUsing = value;
				return true;
			default:
				return super.receiveClientEvent(id, value);
		}
	}

	@Override
	public int getInventoryStackLimit(){ return 64; }

	@Override
	public int getSizeInventory(){ return drawerInventory.length; }

	@Override
	public ItemStack decrStackSize(int index, int amount){
		ItemStack stack = getStackInSlot(index);
		if(stack != null){
			ItemStack result;
			if(stack.stackSize <= amount){
				result = stack;
				drawerInventory[index] = null;
				markDirty();
				return result;
			}
			result = stack.splitStack(amount);
			if(stack.stackSize == 0) drawerInventory[index] = null;
			markDirty();
			return result;
		}
		else return null;
	}

	@Override
	public ItemStack getStackInSlot(int index){ return drawerInventory[index]; }

	@Override
	public ItemStack getStackInSlotOnClosing(int index){
		if(getStackInSlot(index) != null){
			ItemStack stack = getStackInSlot(index);
			drawerInventory[index] = null;
			return stack;
		}
		else return null;
	}

	@Override
	public String getInventoryName(){ return hasCustomInventoryName()? customName: "container.zechaDrawer"; }

	@Override
	public void closeInventory(){
		Block block = getBlockType();
		if(block instanceof BlockZechaDrawer){
			numPlayersUsing--;
			if(numPlayersUsing < 0) numPlayersUsing = 0;
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, block, 1, numPlayersUsing);
		}
	}

	@Override
	public void openInventory(){
		if(numPlayersUsing < 0) numPlayersUsing = 0;
		numPlayersUsing++;
		Block block = getBlockType();
		worldObj.addBlockEvent(xCoord, yCoord, zCoord, block, 1, numPlayersUsing);
		worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, block);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtCompound){
		super.readFromNBT(nbtCompound);
		if(nbtCompound.hasKey("CustomName", 0x8)) customName = nbtCompound.getString("CustomName");
		NBTTagList nbtList = nbtCompound.getTagList("Items", 0xA);
		for(int i = 0; i < nbtList.tagCount(); i++){
			NBTTagCompound nbtCompound1 = nbtList.getCompoundTagAt(i);
			int slotIndex = nbtCompound1.getByte("Slot") & 0xFF;
			if(slotIndex >= 0 && slotIndex < getSizeInventory()) drawerInventory[i] = ItemStack.loadItemStackFromNBT(nbtCompound1);
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack){
		drawerInventory[index] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit()) stack.stackSize = getInventoryStackLimit();
		markDirty();
	}

	public void setCustomInventoryName(String name){ customName = name; }

	@Override
	public void updateEntity(){
		super.updateEntity();
		if(ticksSinceSync++ % 200 == 0) worldObj.addBlockEvent(xCoord, yCoord, zCoord, ZECHA_DRAWER, 1, numPlayersUsing);
		prevDoorAngle = doorAngle;
		double posX = (double)xCoord + 0.5d, posY = (double)yCoord + 0.5d, posZ = (double)zCoord + 0.5d;
		if(numPlayersUsing > 0 && doorAngle == 0f) worldObj.playSoundEffect(posX, posY, posZ, "random.chestopen", 0.5f, worldObj.rand.nextFloat() * 0.1f + 0.9f);
		if((numPlayersUsing == 0 && doorAngle > 0f) || (numPlayersUsing > 0 && doorAngle < 1f)){
			float angle = doorAngle;
			if(numPlayersUsing > 0) doorAngle += 0.1f;
			else doorAngle -= 0.1f;
			doorAngle = Math.min(Math.max(doorAngle, 0f), 1f);
			if(doorAngle < 0.5f && angle >= 0.5f) worldObj.playSoundEffect(posX, posY, posZ, "random.chestclosed", 0.5f, worldObj.rand.nextFloat() * 0.1f + 0.9f);
		}
		if(worldObj.isRemote && worldObj.getChunkFromBlockCoords(xCoord, zCoord).isEmpty()) return;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtCompound){
		super.writeToNBT(nbtCompound);
		NBTTagList nbtList = new NBTTagList();
		for(int i = 0; i < getSizeInventory(); i++){
			ItemStack stack = getStackInSlot(i);
			if(stack != null){
				NBTTagCompound nbtCompound1 = new NBTTagCompound();
				nbtCompound1.setByte("Slot", (byte)i);
				stack.writeToNBT(nbtCompound1);
				nbtList.appendTag(nbtCompound1);
			}
		}
		nbtCompound.setTag("Items", nbtList);
		if(hasCustomInventoryName()) nbtCompound.setString("CustomName", customName);
	}

}
