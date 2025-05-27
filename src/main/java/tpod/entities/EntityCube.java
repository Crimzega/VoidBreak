package tpod.entities;

import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

@SuppressWarnings({"unused"})
public class EntityCube extends EntityCreature{

	private boolean persistenceRequired;
	protected boolean isImmuneToFire;
	protected int experienceValue;

	public EntityCube(World world){
		super(world);
		persistenceRequired = true;
		isImmuneToFire = true;
		experienceValue = 0;
		applyTasks();
	}

	public EntityCube(World world, float x, float y, float z){
		super(world);
		persistenceRequired = true;
		isImmuneToFire = true;
		experienceValue = 0;
		applyTasks();
		setLocationAndAngles((double)x, (double)y, (double)z, worldObj.rand.nextFloat() * 360f, 0f);
	}

	private void applyTasks(){ tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 0d, true)); }

	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		getAttributeMap().registerAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100d);
		getAttributeMap().registerAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(400d);
		getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50d);
	}

	public boolean isAIEnabled(){ return true; }

	public void onDeath(DamageSource source) {
		if(source.getEntity() instanceof EntityLiving){
			int i = (int)posX;
			int j = (int)posY;
			int k = (int)posZ;
			worldObj.spawnEntityInWorld((Entity)new EntityCube(worldObj, (float)i, (float)j, (float)k));
		}
	}

}
