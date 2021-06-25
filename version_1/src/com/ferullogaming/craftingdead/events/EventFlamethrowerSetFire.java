package com.ferullogaming.craftingdead.events;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.Cancelable;
import net.minecraftforge.event.Event;

@Cancelable
public class EventFlamethrowerSetFire extends Event {
   public EntityPlayer playerShooting;
   public EntityLivingBase entityHit;
   public int damageDealing = 0;
   public double fireTime = 0.0D;

   public EventFlamethrowerSetFire(EntityPlayer par1, EntityLivingBase par2, int par3, double par4) {
      this.playerShooting = par1;
      this.entityHit = par2;
      this.damageDealing = par3;
      this.fireTime = par4;
   }
}
