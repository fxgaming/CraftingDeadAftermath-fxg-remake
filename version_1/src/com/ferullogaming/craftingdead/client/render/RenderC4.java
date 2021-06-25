package com.ferullogaming.craftingdead.client.render;

import com.ferullogaming.craftingdead.client.model.ModelC4;
import com.ferullogaming.craftingdead.entity.EntityGrenade;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderC4 extends Render {
   public ModelBase c4Model = new ModelC4();

   public void renderGrenade(EntityGrenade par1Grenade, double par2, double par4, double par6, float par8, float par9) {
      super.renderManager.renderEngine.bindTexture(this.getEntityTexture(par1Grenade));
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2, (float)par4 - 0.03F, (float)par6);
      double scale = 0.04D;
      GL11.glScaled(scale, scale, scale);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      if (par1Grenade.motionX != 0.0D || par1Grenade.motionY != 0.0D) {
         GL11.glRotatef(par1Grenade.rotationTick * 35.0F, 1.0F, 0.0F, 1.0F);
      }

      float par7 = 0.625F;
      this.c4Model.render(par1Grenade, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
      GL11.glPopMatrix();
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderGrenade((EntityGrenade)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      return new ResourceLocation("craftingdead:textures/models/c4model.png");
   }
}
