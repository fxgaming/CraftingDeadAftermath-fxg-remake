package by.fxg.craftingdead.client.render;

import by.fxg.craftingdead.entity.EntityCDZombie;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderCDZombie extends RenderBiped {
   public static ResourceLocation zombieSkin;

   public RenderCDZombie(ModelBiped par1ModelBiped, float par2) {
      super(par1ModelBiped, par2);
   }

   protected ResourceLocation getEntityTexture(Entity entity) {
      if (entity instanceof EntityCDZombie) {
         zombieSkin = new ResourceLocation("craftingdead:textures/mobs/zombie" + ((EntityCDZombie)entity).getRandomSkin() + ".png");
      }

      return zombieSkin;
   }
}
