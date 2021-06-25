package by.fxg.craftingdead.client.util;

import by.fxg.craftingdead.client.fake.FakeCDPlayerFactory;
import by.fxg.craftingdead.client.fake.FakeCDWorldFactory;
import by.fxg.craftingdead.events.EventGUIPlayerGenerated;
import by.fxg.craftingdead.events.EventGUIWorldGenerated;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class FakePlayerManager {
   private EntityPlayer player;
   private FakeCDPlayerFactory fakePlayerFactory;
   private FakeCDWorldFactory fakeBlockFactory;
   private World world;

   public void clearFakePlayer() {
      this.fakePlayerFactory = null;
      this.player = null;
   }

   public EntityPlayer getFakePlayer() {
      if (this.fakePlayerFactory == null) {
         this.fakePlayerFactory = new FakeCDPlayerFactory();
      }

      if (this.player == null) {
         this.player = this.fakePlayerFactory.getFakePlayer();
         EventGUIPlayerGenerated event = new EventGUIPlayerGenerated(this.player);
         MinecraftForge.EVENT_BUS.post(event);
      }

      return this.player;
   }
   public EntityPlayer getFakeWorld() {
	      if (this.fakeBlockFactory == null) {
	         this.fakeBlockFactory = new FakeCDWorldFactory();
	      }

	      if (this.world == null) {
	         this.world = this.fakeBlockFactory.getDefault();
	         EventGUIWorldGenerated event = new EventGUIWorldGenerated(this.world);
	         MinecraftForge.EVENT_BUS.post(event);
	      }

	      return this.player;
	   }
}
