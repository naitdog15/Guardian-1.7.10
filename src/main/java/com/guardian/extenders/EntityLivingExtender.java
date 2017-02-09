package com.guardian.extenders;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityLivingExtender extends EntityLiving {
	
	private boolean persistenceRequired;
	private EntityLivingBaseExtender ELBExtender;

	public EntityLivingExtender(World p_i1595_1_) {
		super(p_i1595_1_);
		
	}
	
	 /**
     * Enable the Entity persistence
     */
    public void enablePersistence()
    {
        this.persistenceRequired = true;
    }
    
    /**
     * Get whether this Entity's AI is disabled
     */
    public boolean isAIDisabled()
    {
        return this.dataWatcher.getWatchableObjectByte(15) != 0;
    }


    /**
     * Returns whether the entity is in a server world
     */
    public boolean isServerWorld()
    {
        return this.ELBExtender.isServerWorld() && !this.isAIDisabled();
    }
    
    
}
