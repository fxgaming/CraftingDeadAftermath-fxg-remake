package by.fxg.craftingdead.block;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LootType {
   private String lootType;
   private String lootDisplayName;
   private double lootSpawnChance;
   private ArrayList lootContent = new ArrayList();

   public LootType(String par1, String par2, double par3) {
      this.lootType = par1;
      this.lootDisplayName = par2;
      this.lootSpawnChance = par3;
   }

   public String getID() {
      return this.lootType;
   }

   public String getDisplayName() {
      return this.lootDisplayName;
   }

   public boolean canSpawn() {
      Random rand = new Random();
      return (double)rand.nextInt(101) <= this.lootSpawnChance;
   }

   public LootType addContent(Item par1, double par2) {
      this.lootContent.add(new LootContent(par1.itemID, par2));
      return this;
   }

   public void addContent(int par1, double par2) {
      this.lootContent.add(new LootContent(par1, par2));
   }

   public double getItemStackChance(ItemStack par1) {
      int var1 = 0;
      ArrayList list = this.getPossibleItemStacksWithAmount();

      for(int i = 0; i < list.size(); ++i) {
         if (((ItemStack)list.get(i)).itemID == par1.itemID) {
            ++var1;
         }
      }

      if (var1 == 0) {
         return 0.0D;
      } else {
         double var2 = (double)(var1 * 100 / (list.size() / 4));
         double var3 = var2 == 0.0D ? 0.1D : var2;
         return var3;
      }
   }

   public ArrayList getPossibleItemStacks() {
      ArrayList list = new ArrayList();

      for(int i = 0; i < this.lootContent.size(); ++i) {
         LootContent content = (LootContent)this.lootContent.get(i);
         list.add(content.getItemStack());
      }

      return list;
   }

   public ArrayList getPossibleItemStacksWithAmount() {
      ArrayList list = new ArrayList();

      for(int i = 0; i < this.lootContent.size(); ++i) {
         LootContent content = (LootContent)this.lootContent.get(i);

         for(int i1 = 0; (double)i1 < content.contentChance; ++i1) {
            list.add(content.getItemStack());
         }
      }

      return list;
   }

   public ItemStack getRandomItemStack() {
      Random rand = new Random();
      ArrayList list = new ArrayList();

      for(int i = 0; i < this.lootContent.size(); ++i) {
         LootContent content = (LootContent)this.lootContent.get(i);

         for(int i1 = 0; (double)i1 < content.contentChance; ++i1) {
            list.add(content.getItemStack());
         }
      }

      return (ItemStack)list.get(rand.nextInt(list.size()));
   }
}
