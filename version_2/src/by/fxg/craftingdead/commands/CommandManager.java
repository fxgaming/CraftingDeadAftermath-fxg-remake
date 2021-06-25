package by.fxg.craftingdead.commands;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandManager {
   public void init() {
   }

   public void onServerStarted(FMLServerStartingEvent event) {
      event.registerServerCommand(new CommandDebug());
   }
}
