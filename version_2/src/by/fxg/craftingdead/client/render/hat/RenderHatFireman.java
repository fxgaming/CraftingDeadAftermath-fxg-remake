package by.fxg.craftingdead.client.render.hat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.model.hats.ModelHatFireman;

public class RenderHatFireman extends RenderHat {
   public RenderHatFireman(boolean par1) {
      super.hatModel = new ModelHatFireman();
      super.texture = par1 ? "fireman" : "firemanblack";
   }

   public void renderHat(EntityPlayer par1, ItemStack par2) {
      double scale = 0.1D;
      GL11.glScaled(scale, scale, scale);
      GL11.glTranslated(-0.25D, -3.0D, -0.25D);
      this.bindTexture();
      this.renderModel(par1);
   }
}
