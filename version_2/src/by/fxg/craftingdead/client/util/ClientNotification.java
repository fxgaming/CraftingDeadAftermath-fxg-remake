package by.fxg.craftingdead.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;

import by.fxg.craftingdead.client.CDRenderHelper;

public class ClientNotification {
   public String[] message;
   public double posY = -50.0D;
   public double maxPosY = 0.0D;
   public double posYInc = 2.5D;

   public ClientNotification(String par1) {
      this.message = this.trimString(par1);
   }

   public void doRender(int width, int height) {
      int var1 = width / 2;
      int boxWidth = 160;
      CDRenderHelper.drawRectWithShadow(0, (int)this.posY, boxWidth, 30, "0x262626", 1.0F);
      CDRenderHelper.drawRectWithShadow(0, (int)this.posY + 30, boxWidth, 10, "0x494949", 1.0F);
      CDRenderHelper.renderText(this.message[0].trim(), 4, (int)this.posY + 4);
      CDRenderHelper.renderText(this.message[1].trim(), 4, (int)this.posY + 14);
      CDRenderHelper.renderTextScaled(EnumChatFormatting.YELLOW + "WMC DayZ", 4, (int)this.posY + 32, 0.75D);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private String[] trimString(String par1) {
      int var1 = Minecraft.getMinecraft().fontRenderer.getStringWidth(par1);
      String[] returnMessage = new String[]{"", ""};
      int var3 = 0;
      int max = 160;
      if (var1 > max) {
         String[] var2 = par1.split(" ");

         for(int i = 0; i < var2.length; ++i) {
            String var4 = returnMessage[var3] + " " + var2[i];
            if (Minecraft.getMinecraft().fontRenderer.getStringWidth(var4) < max) {
               returnMessage[var3] = returnMessage[var3] + " " + var2[i];
            } else if (var3 != 1) {
               var3 = 1;
               returnMessage[var3] = returnMessage[var3] + " " + var2[i];
            }
         }
      } else {
         returnMessage[0] = par1;
      }

      return returnMessage;
   }

   public static void createNotification(String par1) {
      ClientNotification not = new ClientNotification(par1);
      ClientManager.instance().notifications.add(not);
   }
}
