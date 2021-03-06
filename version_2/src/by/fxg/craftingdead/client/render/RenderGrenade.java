package by.fxg.craftingdead.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.model.ModelGrenadeFrag;
import by.fxg.craftingdead.entity.EntityGrenade;

public class RenderGrenade extends Render {
   public ModelBase grenadeModel = new ModelGrenadeFrag();
   public String grenadeTexture = "grenadefrag";

   public void renderGrenade(EntityGrenade par1Grenade, double par2, double par4, double par6, float par8, float par9) {
      super.renderManager.renderEngine.bindTexture(this.getEntityTexture(par1Grenade));
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2, (float)par4, (float)par6);
      double scale = 0.04D;
      GL11.glScaled(scale, scale, scale);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(par1Grenade.rotationTick * 35.0F, 1.0F, 0.0F, 1.0F);
      float par7 = 0.625F;
      this.grenadeModel.render(par1Grenade, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
      GL11.glPopMatrix();
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderGrenade((EntityGrenade)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      return new ResourceLocation("craftingdead:textures/models/" + this.grenadeTexture + ".png");
   }
}
