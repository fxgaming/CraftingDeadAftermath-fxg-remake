package com.ferullogaming.craftingdead.util;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import org.lwjgl.opengl.GL11;

public class EntityRendererUtils {
   private static Minecraft mc = FMLClientHandler.instance().getClient();

   public static void renderStringFacingPlayer(String par1, double par2, double par3, double par4, RenderManager par5) {
      GL11.glPushMatrix();
      FontRenderer fontrenderer = mc.fontRenderer;
      float f122 = 1.8F;
      float scale2 = 0.017F;
      GL11.glTranslatef((float)par2 + 0.0F, (float)par3 + 0.5F, (float)par4);
      GL11.glNormal3f(0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-par5.playerViewY, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(par5.playerViewX, 1.0F, 0.0F, 0.0F);
      GL11.glScalef(-scale2, -scale2, scale2);
      GL11.glDisable(2896);
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      Tessellator tessellator = Tessellator.instance;
      byte b0 = 0;
      GL11.glDisable(3553);
      tessellator.startDrawingQuads();
      int j = fontrenderer.getStringWidth(par1) / 2;
      tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
      tessellator.addVertex((double)(-j - 1), (double)(-1 + b0), 0.0D);
      tessellator.addVertex((double)(-j - 1), (double)(8 + b0), 0.0D);
      tessellator.addVertex((double)(j + 1), (double)(8 + b0), 0.0D);
      tessellator.addVertex((double)(j + 1), (double)(-1 + b0), 0.0D);
      tessellator.draw();
      GL11.glEnable(3553);
      fontrenderer.drawString(par1, -fontrenderer.getStringWidth(par1) / 2, b0, 553648127);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      fontrenderer.drawString(par1, -fontrenderer.getStringWidth(par1) / 2, b0, -1);
      GL11.glEnable(2896);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }
}
