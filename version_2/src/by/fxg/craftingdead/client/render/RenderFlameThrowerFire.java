package by.fxg.craftingdead.client.render;

import by.fxg.craftingdead.entity.EntityFlameThrowerFire;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFlameThrowerFire extends Render {
   public void renderBullet(EntityFlameThrowerFire par1EntityBullet, double par2, double par4, double par6, float par8, float par9) {
   }

   public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.renderBullet((EntityFlameThrowerFire)par1Entity, par2, par4, par6, par8, par9);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      return null;
   }
}
