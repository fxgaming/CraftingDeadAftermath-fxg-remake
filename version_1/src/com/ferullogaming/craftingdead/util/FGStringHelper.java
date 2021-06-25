package com.ferullogaming.craftingdead.util;

import java.util.ArrayList;

public class FGStringHelper {
   public static String appendStringList(ArrayList par1, boolean par2) {
      String var1 = "";

      for(int i = 0; i < par1.size(); ++i) {
         var1 = var1 + (String)par1.get(i);
         if (i != par1.size() - 1) {
            var1 = var1 + (par2 ? ", " : " ");
         }
      }

      return var1;
   }
}
