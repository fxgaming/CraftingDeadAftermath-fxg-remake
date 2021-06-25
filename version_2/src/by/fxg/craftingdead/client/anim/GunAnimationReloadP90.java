package by.fxg.craftingdead.client.anim;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class GunAnimationReloadP90 extends GunAnimationReload {
   private float rotation1 = 0.0F;
   private float lastRotation1 = 0.0F;
   private float maxRotation1 = -30.0F;
   private float trans1 = -1.0F;
   private float lastTrans1 = 0.0F;
   private float maxTrans1 = -0.3F;
   private boolean up = true;
   public boolean ejectingClip = false;

   public GunAnimationReloadP90() {
      this.ejectingClip = true;
      this.trans1 = 0.0F;
   }

   public GunAnimationReloadP90(boolean par1) {
      this.ejectingClip = par1;
      this.trans1 = this.ejectingClip ? 0.0F : -1.0F;
   }

   public void setEjectingClip(boolean par1) {
      this.ejectingClip = par1;
      this.trans1 = this.ejectingClip ? 0.0F : 1.0F;
   }

   public void onUpdate(Minecraft par1, EntityPlayer par2, ItemStack par3) {
      if (super.animationTicker == 15) {
         this.up = false;
      }

      this.lastRotation1 = this.rotation1;
      this.lastTrans1 = this.trans1;
      float roation1Speed = 20.0F;
      float transSpeed = 0.2F;
      if (this.ejectingClip) {
         this.trans1 += transSpeed;
      } else {
         this.trans1 -= transSpeed;
         if (this.trans1 < 0.0F) {
            this.trans1 = 0.0F;
         }
      }

      if (this.up) {
         this.rotation1 -= roation1Speed;
      } else {
         this.rotation1 += roation1Speed;
      }

      if (this.rotation1 < this.maxRotation1) {
         this.rotation1 = this.maxRotation1;
      }

      if (this.rotation1 > 0.0F) {
         this.rotation1 = 0.0F;
      }

   }

   public void doRender(ItemStack par1, float par2) {
      float progress = this.lastRotation1 + (this.rotation1 - this.lastRotation1) * par2;
      GL11.glRotatef(progress, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(progress, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(-progress * 0.25F, 0.0F, 0.0F, 1.0F);
   }

   public void doRenderAmmo(ItemStack par1, float par2) {
      float transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
      GL11.glTranslatef(-transprogress, -transprogress * 0.5F, 0.0F);
   }

   public void onAnimationStopped(ItemStack par1) {
   }

   public float getMaxAnimationTick() {
      return 20.0F;
   }
}
