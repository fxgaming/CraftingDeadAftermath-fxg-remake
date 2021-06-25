package by.fxg.craftingdead.client.fake;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class FakeCDPlayerFactory {
   private String username = Minecraft.getMinecraft().getSession().getUsername();
   private World world = FakeCDWorldFactory.getDefault();
   private FakeCDPlayer fakePlayer;

   public FakeCDPlayerFactory() {
      this.fakePlayer = new FakeCDPlayer(this.world, this.username);
   }

   public EntityPlayer getFakePlayer() {
      return this.fakePlayer;
   }

   public void setFakePlayer(EntityPlayer player) {
      this.fakePlayer = (FakeCDPlayer)player;
   }
}
