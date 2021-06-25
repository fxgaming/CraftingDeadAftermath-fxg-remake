package com.ferullogaming.craftingdead.item.gun;

import net.minecraft.util.EnumChatFormatting;

public enum EnumAmmoType {
   NORMAL("Обычные", EnumChatFormatting.GRAY),
   INFERNO("Воспламеняющиеся", EnumChatFormatting.GOLD),
   EXPLOSIVE("Взрывные", EnumChatFormatting.DARK_RED);

   private EnumChatFormatting format;
   private String label;

   public EnumChatFormatting getFormat() {
      return this.format;
   }

   private EnumAmmoType(String label, EnumChatFormatting format) {
      this.format = format;
      this.label = label;
   }

   public String getLabel() {
      return this.label;
   }
}
