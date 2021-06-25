package by.fxg.craftingdead.client.render.hat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.model.hats.ModelHatNVGoggles;

public class RenderHatNVGoggles extends RenderHat {
   public RenderHatNVGoggles() {
      super.hatModel = new ModelHatNVGoggles();
      super.texture = "nvgoggles";
   }

   public void renderHat(EntityPlayer par1, ItemStack par2) {
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glTranslated(0.0D, -5.0D, 0.0D);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      this.bindTexture();
      this.renderModel(par1);
   }
}
