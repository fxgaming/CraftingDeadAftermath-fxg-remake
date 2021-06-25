package com.ferullogaming.craftingdead.core;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.launchwrapper.IClassTransformer;

public class CDAClassTransformer implements IClassTransformer {
   public byte[] transform(String arg0, String arg1, byte[] arg2) {
      if (arg0.equals("bhj") || arg0.equals("bhj.class") || arg0.equals(RenderPlayer.class.getName()) || arg0.equals("RenderPlayer") || arg0.equals("RenderPlayer.class")) {
         CDADummyContainer.log("PATCHING! RenderPlayer: " + arg0);
         return this.patchClassInJar(arg0, arg2, arg0, CDAFMLLoadingPlugin.location);
      } else if (arg0.equals("bbj")) {
         CDADummyContainer.log("PATCHING! ModelBiped: " + arg0);
         return this.patchClassInJar(arg0, arg2, arg0, CDAFMLLoadingPlugin.location);
      } else if (arg0.equals("bfe")) {
          CDADummyContainer.log("PATCHING! something bfe: " + arg0);
          return this.patchClassInJar(arg0, arg2, arg0, CDAFMLLoadingPlugin.location);
       } else {
         return arg2;
      }
      
   }

   public byte[] patchClassInJar(String name, byte[] bytes, String ObfName, File location) {
      try {
         ZipFile zip = new ZipFile(location);
         ZipEntry entry = zip.getEntry(name.replace('.', '/') + ".class");
         if (entry == null) {
            System.out.println(name + " not found in " + location.getName());
         } else {
            InputStream zin = zip.getInputStream(entry);
            bytes = new byte[(int)entry.getSize()];
            zin.read(bytes);
            zin.close();
            System.out.println("[CDAftermathCore]: Class " + name + " patched!");
         }

         zip.close();
         return bytes;
      } catch (Exception var8) {
         throw new RuntimeException("Error overriding " + name + " from " + location.getName(), var8);
      }
   }
}
