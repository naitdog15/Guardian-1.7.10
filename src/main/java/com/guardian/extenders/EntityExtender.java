package com.guardian.extenders;

import iblock.BlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityExtender extends Entity {
	
	private WorldExtender WExtender;

	public EntityExtender(World p_i1582_1_) {
		super(p_i1582_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub

	}
	
	public static void onDataWatcherUpdate(int dataID)
    {
    }
	
	/**
     * Gets how bright this entity is.
     */
    public float getBrightness(float partialTicks)
    {
        BlockPos blockpos = new BlockPos(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
        return this.WExtender.isBlockLoaded(blockpos, false) ? this.WExtender.getLightBrightness(blockpos) : 0.0F;
    }
	
	public boolean isSilent()
    {
        return this.dataWatcher.getWatchableObjectByte(4) == 1;
    }

}
