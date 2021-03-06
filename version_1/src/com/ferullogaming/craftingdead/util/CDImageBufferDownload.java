package com.ferullogaming.craftingdead.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import net.minecraft.client.renderer.ImageBufferDownload;

@SideOnly(Side.CLIENT)
public class CDImageBufferDownload extends ImageBufferDownload {
   private int[] a;
   private int b;
   private int c;

   public BufferedImage parseUserSkin(BufferedImage par1BufferedImage) {
      if (par1BufferedImage == null) {
         return null;
      } else {
         this.b = 924;
         this.c = 192;
         BufferedImage bufferedimage1 = new BufferedImage(this.b, this.c, 2);
         Graphics graphics = bufferedimage1.getGraphics();
         graphics.drawImage(par1BufferedImage, 0, 0, (ImageObserver)null);
         graphics.dispose();
         this.a = ((DataBufferInt)bufferedimage1.getRaster().getDataBuffer()).getData();
         return bufferedimage1;
      }
   }

   private void setAreaTransparent(int par1, int par2, int par3, int par4) {
      if (!this.hasTransparency(par1, par2, par3, par4)) {
         for(int i1 = par1; i1 < par3; ++i1) {
            for(int j1 = par2; j1 < par4; ++j1) {
               this.a[i1 + j1 * this.b] &= 16777215;
            }
         }
      }

   }

   private void setAreaOpaque(int par1, int par2, int par3, int par4) {
      for(int i1 = par1; i1 < par3; ++i1) {
         for(int j1 = par2; j1 < par4; ++j1) {
            this.a[i1 + j1 * this.b] |= -16777216;
         }
      }

   }

   private boolean hasTransparency(int par1, int par2, int par3, int par4) {
      for(int i1 = par1; i1 < par3; ++i1) {
         for(int j1 = par2; j1 < par4; ++j1) {
            int k1 = this.a[i1 + j1 * this.b];
            if ((k1 >> 24 & 255) < 128) {
               return true;
            }
         }
      }

      return false;
   }
}
