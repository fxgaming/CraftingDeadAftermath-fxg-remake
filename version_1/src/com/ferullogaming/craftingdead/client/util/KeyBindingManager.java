package com.ferullogaming.craftingdead.client.util;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindingManager extends KeyHandler {
   public static KeyBinding cd_reload = new KeyBinding("Перезарядка", 19);
   public static KeyBinding cd_firemode = new KeyBinding("Режим стрельбы", 33);
   public static KeyBinding cd_zoomPlayer = new KeyBinding("Не используется.", 29); //зум. RenderTickHandler L140
   public static KeyBinding cd_gunSwitch = new KeyBinding("Быстрое оружие", 46);
   public static KeyBinding cd_meleeSwitch = new KeyBinding("Быстрое холодное оружие", 45);
   public static KeyBinding cd_qbackpack = new KeyBinding("Быстрый рюкзак", 48);
   public static KeyBinding cd_qvest = new KeyBinding("Быстрый бронежилет", 47);
   public static KeyBinding cd_nvgoggles = new KeyBinding("Включить ночное-видение", 49);
   public static KeyBinding cd_toggleHUD = new KeyBinding("Не используется.", 24);
   public static KeyBinding[] keyList;
   public static boolean[] keyListRepeat;

   public KeyBindingManager() {
      super(keyList, keyListRepeat);
   }

   public String getLabel() {
      return "Crafting Dead Keys";
   }

   public void keyDown(EnumSet types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
   }

   public void keyUp(EnumSet types, KeyBinding kb, boolean tickEnd) {
   }

   public EnumSet ticks() {
      return EnumSet.of(TickType.CLIENT);
   }

   static {
      keyList = new KeyBinding[]{cd_reload, cd_firemode, cd_zoomPlayer, cd_gunSwitch, cd_meleeSwitch, cd_qbackpack, cd_qvest, cd_nvgoggles, cd_toggleHUD};
      keyListRepeat = new boolean[]{true, true, true, true, true, true, true, true, true};
   }
}
