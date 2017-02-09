package com.guardian.extenders;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityLivingBaseExtender extends EntityLivingBase {

	public EntityLivingBaseExtender(World p_i1594_1_) {
		super(p_i1594_1_);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Returns whether the entity is in a server world
     */
    public boolean isServerWorld()
    {
        return !this.worldObj.isRemote;
    }
	
	@Override
	public ItemStack getHeldItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getEquipmentInSlot(int p_71124_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentItemOrArmor(int p_70062_1_, ItemStack p_70062_2_) {
		// TODO Auto-generated method stub

	}

	@Override
	public ItemStack[] getLastActiveItems() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SideOnly(Side.CLIENT)
    public Vec3i getPositionEyes(float partialTicks)
    {
        if (partialTicks == 1.0F)
        {
            return new Vec3i(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
        }
        else
        {
            double d0 = this.prevPosX + (this.posX - this.prevPosX) * (double)partialTicks;
            double d1 = this.prevPosY + (this.posY - this.prevPosY) * (double)partialTicks + (double)this.getEyeHeight();
            double d2 = this.prevPosZ + (this.posZ - this.prevPosZ) * (double)partialTicks;
            return new Vec3i(d0, d1, d2);
        }
    }
}
