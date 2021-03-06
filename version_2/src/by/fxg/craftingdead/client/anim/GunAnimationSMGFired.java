package by.fxg.craftingdead.client.anim;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class GunAnimationSMGFired extends GunAnimation {
   private float rotation1 = 0.0F;
   private float lastRotation1 = 0.0F;
   private float maxRotation1 = 2.0F;
   private float trans1 = 0.0F;
   private float lastTrans1 = 0.0F;
   private float maxTrans1 = 0.15F;
   private boolean up = true;

   public void onUpdate(Minecraft par1, EntityPlayer par2, ItemStack par3) {
      this.lastRotation1 = this.rotation1;
      this.lastTrans1 = this.trans1;
      float roation1Speed = 600.0F;
      float transSpeed = 0.05F;
      if (super.animationTicker == 2) {
         this.up = false;
      }

      if (this.up) {
         this.rotation1 += roation1Speed;
         this.trans1 += transSpeed;
      } else {
         this.rotation1 -= roation1Speed;
         this.trans1 -= transSpeed;
      }

      if (this.trans1 > this.maxTrans1) {
         this.trans1 = this.maxTrans1;
      }

      if (this.trans1 < 0.0F) {
         this.trans1 = 0.0F;
      }

      if (this.rotation1 > this.maxRotation1) {
         this.rotation1 = this.maxRotation1;
      }

      if (this.rotation1 < 0.0F) {
         this.rotation1 = 0.0F;
      }

   }

   public void doRender(ItemStack par1, float par2, boolean par3, boolean pre) {
	   if (!pre) {
	      float transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
	      float rotprogress = this.lastRotation1 + (this.rotation1 - this.lastRotation1) * par2;
	      if (par3) {
	    	  transprogress = transprogress/2;
	    	  rotprogress = rotprogress/2;
	      }
	      GL11.glTranslatef(-transprogress, 0.0F, 0.0F);
	      GL11.glRotatef(-rotprogress, 0.0F, 0.0F, 1.0F);
	   }
   }

   public void doRenderHand(ItemStack par1, float par2, boolean par3) {
      float transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
      GL11.glTranslatef(-transprogress, 0.0F, 0.0F);
      float rotprogress = this.lastRotation1 + (this.rotation1 - this.lastRotation1) * par2;
      GL11.glRotatef(-rotprogress, 0.0F, 0.0F, 1.0F);
   }

   public void doRenderAmmo(ItemStack par1, float par2) {
   }

   public void onAnimationStopped(ItemStack par1) {
   }

   public float getMaxAnimationTick() {
      return 4.0F;
   }
}
