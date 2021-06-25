package com.ferullogaming.craftingdead.core;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import java.io.File;
import java.util.Map;

@MCVersion("1.6.4")
public class CDAFMLLoadingPlugin implements IFMLLoadingPlugin {
   public static File location;

   public String[] getLibraryRequestClass() {
      return null;
   }

   public String[] getASMTransformerClass() {
      return new String[]{CDAClassTransformer.class.getName()};
   }

   public String getModContainerClass() {
      return CDADummyContainer.class.getName();
   }

   public String getSetupClass() {
      return null;
   }

   public void injectData(Map data) {
      location = (File)data.get("coremodLocation");
   }
}
