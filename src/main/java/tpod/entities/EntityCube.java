package tpod.entities;

import net.minecraft.world.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

@SuppressWarnings({"unused"})
public class EntityCube extends EntityCreature
{
    private boolean persistenceRequired;
    protected boolean isImmuneToFire;
    protected int experienceValue;
    
    public EntityCube(final World world) {
        super(world);
        this.persistenceRequired = true;
        this.isImmuneToFire = true;
        this.experienceValue = 0;
        this.applyTasks();
    }
    
    public EntityCube(final World world, final float x, final float y, final float z) {
        super(world);
        this.persistenceRequired = true;
        this.isImmuneToFire = true;
        this.experienceValue = 0;
        this.applyTasks();
        this.setLocationAndAngles((double)x, (double)y, (double)z, this.worldObj.rand.nextFloat() * 360.0f, 0.0f);
    }
    
    private void applyTasks() {
        this.tasks.addTask(1, (EntityAIBase)new EntityAIAttackOnCollide((EntityCreature)this, 0.0, true));
    }
    
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100.0);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(400.0);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(50.0);
    }
    
    public boolean isAIEnabled() {
        return true;
    }
    
    public void onDeath(final DamageSource source) {
        if (source.getEntity() instanceof EntityLiving) {
            final int i = (int)this.posX;
            final int j = (int)this.posY;
            final int k = (int)this.posZ;
            this.worldObj.spawnEntityInWorld((Entity)new EntityCube(this.worldObj, (float)i, (float)j, (float)k));
        }
    }
}
