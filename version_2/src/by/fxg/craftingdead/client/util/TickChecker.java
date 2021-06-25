package by.fxg.craftingdead.client.util;

import java.util.Calendar;

import by.fxg.Defaults;
import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;

public class TickChecker {
   private int tickCounter = 0;
   private int lastSecond = 0;
   private int fastTickCount = 0;

   public void onClientUpdateTick(Minecraft mc) {
      if (mc.theWorld != null) {
         int var1 = Calendar.getInstance().get(13);
         ++this.tickCounter;
         if (this.lastSecond != var1) {
            if (this.tickCounter > 25 && mc.inGameHasFocus && mc.currentScreen == null) {
               ++this.fastTickCount;
            }

            this.tickCounter = 0;
            this.lastSecond = var1;
         }
      }

      if (this.fastTickCount > 40 && mc.inGameHasFocus && mc.currentScreen == null) {
         if (!Defaults.disabled) mc.crashed(new CrashReport("Tick rate out of sync! Do not alter Minecraft's tick rate!", new Throwable()));
         else {
        	 System.err.println("Tick rate out of sync!!! " + this.fastTickCount + "/" + this.tickCounter + "/" + this.lastSecond);
         }
      }
   }
}
