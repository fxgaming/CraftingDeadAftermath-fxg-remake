package by.fxg.craftingdead.client.gui;

import net.minecraft.util.EnumChatFormatting;

public class CDServerData {
   public int status = 0;
   public String serverIP;
   public String serverMOTD = "???";
   public String serverRegion = "???";
   public String gameVersion = "???";
   public String modVersion = "???";
   public String serverPlayers = "?/?";
   public String pingStatus;

   public CDServerData(String par1) {
      this.pingStatus = EnumChatFormatting.RED + "null";
      String[] split = par1.split("-");
      this.serverRegion = split[0];
      this.serverIP = split[1];
   }

   public void setServerPing(long par1) {
      if (par1 < 200L) {
         this.pingStatus = EnumChatFormatting.GREEN + "" + par1 + "ms";
      } else if (par1 < 400L) {
         this.pingStatus = EnumChatFormatting.YELLOW + "" + par1 + "ms";
      } else if (par1 < 1200L) {
         this.pingStatus = EnumChatFormatting.RED + "" + par1 + "ms";
      } else {
         this.pingStatus = EnumChatFormatting.DARK_RED + "" + par1 + "ms";
      }

   }
}
