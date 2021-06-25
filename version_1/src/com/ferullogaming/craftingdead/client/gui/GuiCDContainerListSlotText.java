package com.ferullogaming.craftingdead.client.gui;

import com.ferullogaming.craftingdead.client.CDRenderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.util.EnumChatFormatting;

public class GuiCDContainerListSlotText extends GuiCDContainerListSlot {
   private String displayText;

   public GuiCDContainerListSlotText(String par1) {
      this.displayText = par1;
   }

   public boolean canSelect() {
      return this.displayText != null && !this.displayText.equals("");
   }

   public void onDoubleClick() {
      String[] split = this.displayText.split(" ");
      if (split.length >= 1) {
         String[] var2 = split;
         int var3 = split.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            String var1 = var2[var4];
            if (var1.contains(".") && (var1.contains(".com") || var1.contains(".net") || var1.contains("f") || var1.startsWith("http://"))) {
               this.openURL(var1);
            }
         }
      }

   }

   public void doRender(int x, int y, boolean selected, int width, int height) {
      CDRenderHelper.renderText((selected ? EnumChatFormatting.GOLD : "") + this.displayText, x + 2, y);
   }

   public static ArrayList getListFromStrings(ArrayList par1) {
      ArrayList list = new ArrayList();
      Iterator var2 = par1.iterator();

      while(var2.hasNext()) {
         String var1 = (String)var2.next();
         GuiCDContainerListSlot slot = new GuiCDContainerListSlotText(var1);
         list.add(slot);
      }

      return list;
   }
}
