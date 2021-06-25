package com.ferullogaming.craftingdead.client.anim;

import com.ferullogaming.craftingdead.CDAftermath;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class AnimationManager {
   private GunAnimation currentAnimation;

   public void onClientUpdate(Minecraft par1) {
      if (par1.thePlayer != null) {
         ItemStack itemstack = par1.thePlayer.getCurrentEquippedItem();
         if (itemstack != null && this.currentAnimation != null) {
            this.currentAnimation.onUpdate(par1, par1.thePlayer, itemstack);
            ++this.currentAnimation.animationTicker;
            if ((float)this.currentAnimation.animationTicker > this.currentAnimation.getMaxAnimationTick()) {
               this.currentAnimation.onAnimationStopped(itemstack);
               this.currentAnimation = null;
            }
         }
      }

   }

   public void setGunAnimation(GunAnimation par1) {
      if (this.currentAnimation != null) {
         this.currentAnimation.onAnimationStopped((ItemStack)null);
         this.currentAnimation = null;
      }

      this.currentAnimation = par1;
   }

   public void cancelCurrentAnimation() {
      if (this.currentAnimation != null) {
         this.currentAnimation.onAnimationStopped((ItemStack)null);
         this.currentAnimation = null;
      }

   }

   public GunAnimation getCurrentAnimation() {
      return this.currentAnimation;
   }

   public static AnimationManager instance() {
      return CDAftermath.instance.getClientManager().getClientTickHandler().animationManager;
   }
}
