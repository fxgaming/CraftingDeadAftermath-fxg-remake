package by.fxg.craftingdead.client.fake;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class FakeCDPlayerHead extends AbstractClientPlayer {
   public FakeCDPlayerHead(World world, String name) {
      super(world, name);
   }

   public void sendChatToPlayer(String s) {
   }

   public boolean canCommandSenderUseCommand(int i, String s) {
      return false;
   }

   public ChunkCoordinates getPlayerCoordinates() {
      return new ChunkCoordinates(0, 0, 0);
   }

   public void sendChatToPlayer(ChatMessageComponent chatmessagecomponent) {
   }
}
