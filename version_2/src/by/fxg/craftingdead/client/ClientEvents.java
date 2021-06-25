package by.fxg.craftingdead.client;

import cpw.mods.fml.common.network.PacketDispatcher;
import java.util.Random;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.client.gui.GuiCDLoadingScreen;
import by.fxg.craftingdead.client.gui.GuiCDMainMenu;
import by.fxg.craftingdead.client.particle.EntityFlameThrowerFX;
import by.fxg.craftingdead.client.util.BulletCollisionBox;
import by.fxg.craftingdead.client.util.ClientManager;
import by.fxg.craftingdead.entity.EntityManager;
import by.fxg.craftingdead.events.EnumBulletCollision;
import by.fxg.craftingdead.events.EventBulletCollision;
import by.fxg.craftingdead.network.CDAPacketACLPaused;
import by.fxg.craftingdead.network.CDAPacketOpenGUI;
import by.fxg.craftingdead.player.PlayerData;
import by.fxg.craftingdead.player.PlayerDataHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientEvents {
	public ClientEvents() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@ForgeSubscribe
	public void onGuiOpened(GuiOpenEvent event) {
		if (ClientManager.isGameLoading && !(event.gui instanceof GuiCDLoadingScreen)) {
			event.setCanceled(true);
			Minecraft.getMinecraft().displayGuiScreen(new GuiCDLoadingScreen());
		}

		if (!ClientManager.isGameLoading && event.gui instanceof GuiMainMenu) {
			event.setCanceled(true);
			Minecraft.getMinecraft().displayGuiScreen(new GuiCDMainMenu(false));
		}

		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player != null) {
			PlayerData data = CDReloaded.instance.playerDataHandler().getClientPlayerData();
			if (event.gui instanceof GuiIngameMenu && !Minecraft.getMinecraft().isSingleplayer() && data.isInCombat()) {
				PacketDispatcher.sendPacketToServer(CDAPacketACLPaused.buildPacket());
				data.antiCombatLoggingWaitTick = 100;
			}

			if (event.gui instanceof GuiInventory && !player.capabilities.isCreativeMode) {
				event.setCanceled(true);
				PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(45));
			}
		}

	}

	public void applyFlameThrowerParticles(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		Random rand = new Random();
		int var1 = rand.nextInt(25);

		for (int i = 0; i < var1; ++i) {
			double vx = (0.5D - rand.nextDouble()) / 2.0D;
			double vy = rand.nextDouble() / 2.0D;
			double vz = (0.5D - rand.nextDouble()) / 2.0D;
			Minecraft mc = Minecraft.getMinecraft();
			mc.effectRenderer.addEffect(new EntityFlameThrowerFX(par3EntityPlayer));
		}

	}

	public void applyBulletCollisionEntity(EntityLivingBase par1, boolean par2, Vec3 hitVec3) {
		Minecraft mc = Minecraft.getMinecraft();
		World world = par1.worldObj;
		double vx = hitVec3.xCoord;
		double vy = hitVec3.yCoord;
		double vz = hitVec3.zCoord;
		Random rand = new Random();
		EventBulletCollision eventBulletCollision = new EventBulletCollision(par1 instanceof EntityPlayer ? EnumBulletCollision.PLAYER : EnumBulletCollision.ENTITY, (EntityPlayer) null, (ItemStack) null, par1.worldObj);
		eventBulletCollision.setEntityHit(par1);
		if (!MinecraftForge.EVENT_BUS.post(eventBulletCollision)) {
			byte particles;
			int i;
			if (!par1.isDead) {
				particles = 20;

				for (i = 0; i < particles; ++i) {
					double mutli = rand.nextDouble();
					double randxpos = mutli * (double) (0.5F - rand.nextFloat());
					double randypos = mutli * (double) (0.5F - rand.nextFloat());
					double randzpos = mutli * (double) (0.5F - rand.nextFloat());
					EntityManager.spawnParticle("tilecrack_152_0", vx + randxpos, vy + (double) par1.getEyeHeight() + randypos, vz + randzpos, 0.0D, 0.0D, 0.0D);
				}
			}

			if (par1 instanceof EntityPlayer && par2) {
				particles = 20;

				for (i = 0; i < particles; ++i) {
					EntityManager.spawnParticle("tilecrack_42_0", par1.posX, par1.posY + 1.75D, par1.posZ, 0.0D, 0.0D, 0.0D);
				}
			}

		}
	}

	public void applyBulletCollisionBlock(World par2, double par3, double par4, double par5, int par6, int par7, Vec3 hitVec3) {
		Minecraft mc = Minecraft.getMinecraft();
		int particles = 15;
		double vx = hitVec3.xCoord;
		double vy = hitVec3.yCoord;
		double vz = hitVec3.zCoord;
		EventBulletCollision eventBulletCollision = new EventBulletCollision(EnumBulletCollision.BLOCK, (EntityPlayer) null, (ItemStack) null, par2);
		eventBulletCollision.setBlockHit((int) par3, (int) par4, (int) par5);
		BulletCollisionBox box = new BulletCollisionBox(vx, vy, vz);
		if (!MinecraftForge.EVENT_BUS.post(eventBulletCollision)) {
			if (mc.gameSettings.fancyGraphics) {
				particles = 30;
			}

			int var1 = par2.getBlockMetadata((int) par3, (int) par4, (int) par5);

			for (int i = 0; i < particles; ++i) {
				EntityManager.spawnParticle("tilecrack_" + par6 + "_" + var1, vx, vy, vz, 0.0D, 0.0D, 0.0D);
			}

			if (mc.thePlayer.getDistance(par3, par4, par5) < 18.0D) {
				Block block = Block.blocksList[mc.theWorld.getBlockId((int) par3, (int) par4, (int) par5)];
				if (block != null) {
					Material blockMaterial = block.blockMaterial;
					String var2 = "dirt";
					if (blockMaterial == Material.wood) {
						var2 = "wood";
					}

					if (blockMaterial == Material.grass) {
						var2 = "dirt";
					}

					if (blockMaterial == Material.rock) {
						var2 = "stone";
					}

					if (blockMaterial == Material.glass || blockMaterial == Material.ice) {
						var2 = "glass";
					}

					if (block == Block.blockIron || block == Block.blockGold || block == Block.blockDiamond || block == Block.blockEmerald || block == Block.furnaceIdle || block == Block.furnaceBurning || block == Block.anvil) {
						var2 = "metal";
					}

					mc.sndManager.playSound("craftingdead:bulletimpact_" + var2, (float) par3, (float) par4, (float) par5, 0.5F, 1.0F);
				}
			}

		}
	}
}
