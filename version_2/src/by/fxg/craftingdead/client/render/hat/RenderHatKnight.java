package by.fxg.craftingdead.client.render.hat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.model.hats.ModelHatKnight;

public class RenderHatKnight extends RenderHat {
   public RenderHatKnight() {
      super.hatModel = new ModelHatKnight();
      super.texture = "knight";
   }

   public void renderHat(EntityPlayer par1, ItemStack par2) {
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glTranslated(0.0D, -2.5D, 0.0D);
      this.bindTexture();
      this.renderModel(par1);
   }
}
