package by.fxg.craftingdead.client;

import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.client.anim.AnimationManager;
import by.fxg.craftingdead.client.anim.GunAnimation;
import by.fxg.craftingdead.client.anim.GunAnimationPulled;
import by.fxg.craftingdead.client.gui.GuiCDMainMenu;
import by.fxg.craftingdead.client.util.KeyBindingManager;
import by.fxg.craftingdead.client.util.SoundHandler;
import by.fxg.craftingdead.client.util.TickChecker;
import by.fxg.craftingdead.entity.EntityPlayerHead;
import by.fxg.craftingdead.item.ItemManager;
import by.fxg.craftingdead.item.gun.EnumFireMode;
import by.fxg.craftingdead.item.gun.ItemGun;
import by.fxg.craftingdead.network.CDAPacketACLUnpaused;
import by.fxg.craftingdead.network.CDAPacketBulletCollision;
import by.fxg.craftingdead.network.CDAPacketOpenGUI;
import by.fxg.craftingdead.network.CDAPacketPlayerDataToServer;
import by.fxg.craftingdead.network.CDAPacketSwitchItem;
import by.fxg.craftingdead.player.PlayerData;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ClientTickHandler implements ITickHandler {
	public float gunRecoil = 0.0F;
	public float pitchU, defPU, newPU, toPU, defYA, newYA, toYA;
	public float yawR;
	public float yawL;
	public int timetoram;
	public RenderTickHandler renderHandler;
	public AnimationManager animationManager;
	public float lastGameSettingGamma;
	public int lastInvSlot = 0;
	public static final float spreadSprinting = 0.6F;
	public static final float spreadJumping = 0.7F;
	public static final float decreasing = 0.2F;
	public static final float decreasingSneaking = 0.65F;
	private int sendPlayerDataTick = 0;
	private int waterShakeDelay = 0;
	private int delaySwitchGuns = 0;
	private int delaySwitchMelee = 0;
	private TickChecker ingameChecker;
	private GuiScreen lastGui = null;
	private Minecraft mc = Minecraft.getMinecraft();
	private Entity pointedEntity;
	public MovingObjectPosition objectMouseOver2;
	public EntityLivingBase pointedEntityLiving2;
	private float shootingYaw;
	private float shootingPitch;
	public GunAnimation animBuffer0;

	public ClientTickHandler() {
		TickRegistry.registerTickHandler(this, Side.CLIENT);
		this.renderHandler = new RenderTickHandler();
		this.animationManager = new AnimationManager();
		this.ingameChecker = new TickChecker();
	}

	public void tickStart(EnumSet type, Object... tickData) {
		Minecraft mc = Minecraft.getMinecraft();
		if (Minecraft.getMinecraft().currentScreen != null && Minecraft.getMinecraft().theWorld == null && (Minecraft.getMinecraft().currentScreen instanceof GuiCDMainMenu)) {
			SoundHandler.playMenuMusic();
		} else {
			SoundHandler.stopMenuMusic();
		}
	}

	public void tickEnd(EnumSet type, Object... tickData) {
		try {
			Minecraft mc = Minecraft.getMinecraft();
			if (type.equals(EnumSet.of(TickType.RENDER))) {
				float var1 = (Float) tickData[0];
				this.renderHandler.onRenderTick(mc, var1);
			} else if (type.equals(EnumSet.of(TickType.CLIENT))) {
				GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
				if (this.lastGui != guiscreen) {
					if (guiscreen == null) {
						PacketDispatcher.sendPacketToServer(CDAPacketACLUnpaused.buildPacket());
					}

					this.lastGui = guiscreen;
				}

				if (guiscreen != null) {
					this.onTickInGUI(mc, guiscreen);
				} else {
					this.onTickInGame(mc);
					this.ingameChecker.onClientUpdateTick(mc);
				}

				this.onClientTick(mc);
			} else if (type.equals(EnumSet.of(TickType.PLAYER))) {
				this.onPlayerClientTick((EntityPlayer) tickData[0]);
			}
		} catch (Exception var5) {
			if (Minecraft.getMinecraft().theWorld != null && !Minecraft.getMinecraft().isSingleplayer()) {
				PacketDispatcher.sendPacketToServer(CDAPacketACLUnpaused.buildPacket());
			}

			Minecraft.getMinecraft().crashed(new CrashReport(">>> Crafting Dead Crash <<<", var5));
		}
	}

	private void onPlayerClientTick(EntityPlayer entityPlayer) {
		if (entityPlayer != null && !entityPlayer.isDead) {
			CDReloaded.instance.getItemManager().getPotionManager().onClientPlayerTick(entityPlayer);
		}
	}

	private void onClientTick(Minecraft mc) {
		this.animationManager.onClientUpdate(mc);
		PlayerData data;
		if (mc.theWorld != null) {
			CDReloaded.instance.getSoundHandler().onIngameUpdate();
			data = CDReloaded.instance.playerDataHandler().getClientPlayerData();
			if (data.inCombatTick > 0) {
				--data.inCombatTick;
			}

			if (data.antiCombatLoggingWaitTick > 0) {
				--data.antiCombatLoggingWaitTick;
			}
		} else {
			data = CDReloaded.instance.playerDataHandler().getClientPlayerData();
			data.inCombatTick = 0;
			data.antiCombatLoggingWaitTick = 0;
		}

		if (this.renderHandler.displayFiremodeChange > 0) {
			--this.renderHandler.displayFiremodeChange;
		}

		if (mc.thePlayer != null) {
			data = CDReloaded.instance.playerDataHandler().getPlayerData(mc.thePlayer.username);
			this.updateNVGogglesState(data);

			if (this.delaySwitchGuns > 0) {
				--this.delaySwitchGuns;
			}

			if (this.delaySwitchMelee > 0) {
				--this.delaySwitchMelee;
			}
		}

	}

	private void onTickInGame(Minecraft mc) {
		if (mc.theWorld != null && mc.thePlayer != null) {
			PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(mc.thePlayer.username);
			if (data.flashTime > 0.0D) {
				data.flashTime -= 0.10000000149011612D;
			}

			if (data.isAiming && (mc.thePlayer.getCurrentEquippedItem() == null || !(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemGun))) {
				data.isAiming = false;
			}

			if (KeyBindingManager.cd_toggleHUD.isPressed()) {
				this.renderHandler.renderPlayerHUD = !this.renderHandler.renderPlayerHUD;
			}

			if (KeyBindingManager.cd_qbackpack.isPressed() && data.getCDInventory().getStack("backpack") != null) {
				PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(47));
			}

			if (KeyBindingManager.cd_qvest.isPressed() && data.getCDInventory().getStack("vest") != null) {
				PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(48));
			}

			if (KeyBindingManager.cd_meleeSwitch.isPressed() && this.delaySwitchMelee == 0) {
				PacketDispatcher.sendPacketToServer(CDAPacketSwitchItem.buildPacket(false));
				this.delaySwitchMelee = 10;
			}

			if (KeyBindingManager.cd_gunSwitch.isPressed() && this.delaySwitchGuns == 0) {
				PacketDispatcher.sendPacketToServer(CDAPacketSwitchItem.buildPacket(true));
				this.delaySwitchGuns = 10;
			}

			if (this.lastInvSlot != mc.thePlayer.inventory.currentItem) {
				if (mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemGun) {
					this.animationManager.setGunAnimation(this.animBuffer0 = new GunAnimationPulled());
				}

				this.lastInvSlot = mc.thePlayer.inventory.currentItem;
			}

			if (this.sendPlayerDataTick++ > 2) {
				PacketDispatcher.sendPacketToServer(CDAPacketPlayerDataToServer.buildPacket());
				this.sendPlayerDataTick = 0;
			}

			this.updateGunAccuracy();
			this.updateGunRecoil();
		}
	}

	public void updateNVGogglesState(PlayerData data) {
		ItemStack hatStack = data.getCDInventory().getStack("hat");
		if (hatStack != null && hatStack.itemID == ItemManager.hatNVGoggles.itemID) {
			if (KeyBindingManager.cd_nvgoggles.isPressed()) {
				data.isNightVisionActive = !data.isNightVisionActive;
			}
		} else {
			data.isNightVisionActive = false;
		}

		float var1 = 3.5F;
		if (this.mc.currentScreen == null && this.mc.inGameHasFocus) {
			if (data.isNightVisionActive) {
				if (this.mc.gameSettings.gammaSetting < var1) {
					this.lastGameSettingGamma = this.mc.gameSettings.gammaSetting;
					this.mc.gameSettings.gammaSetting = var1;
				}
			} else {
				if (this.mc.gameSettings.gammaSetting == var1) {
					this.mc.gameSettings.gammaSetting = this.lastGameSettingGamma;
				}

				if (this.mc.gameSettings.gammaSetting > 1.0F) {
					this.mc.gameSettings.gammaSetting = 0.1F;
				}
			}

		} else {
			if (this.mc.gameSettings.gammaSetting == var1) {
				this.mc.gameSettings.gammaSetting = this.lastGameSettingGamma;
			}

		}
	}

	public void updateGunAccuracy() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		PlayerData playerData = CDReloaded.instance.playerDataHandler().getPlayerData((EntityPlayer) player);
		if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemGun) {
			ItemGun gun = (ItemGun) player.getCurrentEquippedItem().getItem();
			playerData.defaultSpread = gun.getGunAccuracy();
		} else {
			playerData.defaultSpread = 0.1F;
		}

		if (playerData.spread < playerData.defaultSpread) {
			playerData.spread = playerData.defaultSpread;
		}

		if (player.isSprinting()) {
			playerData.addSpread(0.6F);
		} else if (!player.onGround) {
			playerData.addSpread(0.7F);
		}

		if (playerData.spread > playerData.defaultSpread) {
			if (player.isSneaking()) {
				playerData.spread -= 0.65F;
			} else {
				playerData.spread -= 0.2F;
			}

			if (playerData.spread < playerData.defaultSpread) {
				playerData.spread = playerData.defaultSpread;
			}
		}

	}

	public void updateGunRecoil() {
		this.defPU = this.mc.thePlayer.rotationPitch;
		this.defYA = this.mc.thePlayer.rotationYaw;
		Random rand = new Random();
		float var1 = 0.2F + (rand.nextFloat() / 7);

		if (this.gunRecoil > 0.0F) {
			float f1 = this.gunRecoil + (0.5F - rand.nextFloat());
			switch (rand.nextInt(3)) {
			case 0:
				this.pitchU += f1;
				break;
			case 1:
				this.yawL += (f1 / 100 * 75);
				break;
			case 2:
				this.yawR += (f1 / 100 * 75);
			}

			this.pitchU += f1 * 0.5F;
			this.gunRecoil = 0.0F;
		}

		if (this.pitchU > 0.0F) {
			this.pitchU *= var1;
		}
		this.mc.thePlayer.rotationPitch -= this.pitchU;

		if (this.yawR > 0.0F) {
			this.yawR *= var1;
		}
		this.mc.thePlayer.rotationYaw += this.yawR;

		if (this.yawL > 0.0F) {
			this.yawL *= var1;
		}
		this.mc.thePlayer.rotationYaw -= this.yawL;
	}

	public boolean hasItems() {
		for (int i = 0; i < this.mc.thePlayer.inventory.mainInventory.length; ++i) {
			if (this.mc.thePlayer.inventory.mainInventory[i] != null) {
				return true;
			}
		}

		return false;
	}

	private void onTickInGUI(Minecraft mc, GuiScreen guiscreen) {
		if (guiscreen instanceof GuiContainerCreative) {
			GuiContainerCreative gui = (GuiContainerCreative) guiscreen;
			if (gui.getCurrentTabIndex() == 14) {
				try {
					Field field = null;

					try {
						field = GuiContainerCreative.class.getDeclaredField("selectedTabIndex");
					} catch (Exception var9) {
						;
					}

					if (field == null) {
						try {
							field = GuiContainerCreative.class.getDeclaredField("field_74241_p");
						} catch (Exception var8) {
							;
						}
					}

					field.setAccessible(true);

					try {
						field.setInt((Object) null, 13);
						PacketDispatcher.sendPacketToServer(CDAPacketOpenGUI.buildPacket(45));
					} catch (IllegalArgumentException var6) {
						var6.printStackTrace();
					} catch (IllegalAccessException var7) {
						var7.printStackTrace();
					}
				} catch (SecurityException var10) {
					var10.printStackTrace();
				}
			}
		}

	}

	public void spawnBullet(EntityPlayer par1, ItemGun par2) throws Exception {
		if (par1 != null && par1.worldObj != null && par1.worldObj.isRemote) {
			PlayerData dataShooter = CDReloaded.instance.playerDataHandler().getClientPlayerData();
			double var1 = (double) par2.bulletDistance;
			this.getMouseOver(0.0F, var1);
			MovingObjectPosition object = this.objectMouseOver2;
			if (object != null) {
				if (object.entityHit != null) {
					Entity entity = object.entityHit;
					boolean headShot = false;
					if (entity instanceof EntityPlayerHead) {
						this.mc.sndManager.playSoundFX("random.break", 1.0F, 1.5F);
						entity = ((EntityPlayerHead) entity).player;
						headShot = true;
					}

					if (entity != par1) {
						if (entity instanceof EntityLivingBase) {
							EntityLivingBase living = (EntityLivingBase) entity;
							if (living.isDead || living.getHealth() <= 0.0F) {
								return;
							}

							if (entity instanceof EntityPlayer) {
								EntityPlayer playerHit = (EntityPlayer) entity;
								PlayerData dataHit = CDReloaded.instance.playerDataHandler().getPlayerData(playerHit.username);
								// if (dataHit.tempClan != null && dataHit.tempClan.length() > 0 &&
								// dataShooter.hasClanData() &&
								// dataHit.tempClan.equals(dataShooter.getClientClanData().clanNameTag)) {
								// return;
								// }
							}
						}

						PacketDispatcher.sendPacketToServer(CDAPacketBulletCollision.buildPacket(true, entity, headShot, object.hitVec.xCoord, object.hitVec.yCoord, object.hitVec.zCoord));
					}
				} else if (object.typeOfHit == EnumMovingObjectType.TILE) {
					World world = par1.worldObj;
					int var12 = world.getBlockId(object.blockX, object.blockY, object.blockZ);
					PacketDispatcher.sendPacketToServer(CDAPacketBulletCollision.buildPacket(false, var12, (double) object.blockX, (double) object.blockY, (double) object.blockZ, object.sideHit, object.hitVec.xCoord, object.hitVec.yCoord, object.hitVec.zCoord));
				}
			}
		}

		this.objectMouseOver2 = null;
		this.pointedEntityLiving2 = null;
		this.pointedEntity = null;
	}

	public void getMouseOver(float par1, double par2) {
		if (this.mc.thePlayer != null && this.mc.theWorld != null) {
			this.pointedEntityLiving2 = null;
			this.objectMouseOver2 = this.rayTrace(this.mc.thePlayer, par2, par1);
			double d1 = par2;
			Vec3 vec3 = this.mc.thePlayer.getPosition(par1);
			if (this.objectMouseOver2 != null) {
				d1 = this.objectMouseOver2.hitVec.distanceTo(vec3);
			}

			Vec3 vec31 = this.getLook(false, this.mc.thePlayer);
			Vec3 vec32 = vec3.addVector(vec31.xCoord * par2, vec31.yCoord * par2, vec31.zCoord * par2);
			this.pointedEntity = null;
			float f1 = 1.0F;
			List list = this.mc.theWorld.getEntitiesWithinAABBExcludingEntity(this.mc.thePlayer, this.mc.thePlayer.boundingBox.addCoord(vec31.xCoord * par2, vec31.yCoord * par2, vec31.zCoord * par2).expand((double) f1, (double) f1, (double) f1));
			double d2 = d1;
			double d21 = d1;

			int i;
			Entity entity;
			AxisAlignedBB axisalignedbb;
			MovingObjectPosition movingobjectposition;
			float f2;
			for (i = 0; i < list.size(); ++i) {
				entity = (Entity) list.get(i);
				if (!entity.isDead && entity.canBeCollidedWith() && !(entity instanceof EntityPlayerHead) && vec32 != null) {
					if (entity instanceof EntityLivingBase) {
						EntityLivingBase living = (EntityLivingBase) entity;
						if (living.deathTime != 0) {
							continue;
						}
					}

					f2 = 0.0F;
					axisalignedbb = entity.boundingBox.expand((double) f2, (double) f2, (double) f2);
					movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);
					if (axisalignedbb.isVecInside(vec3)) {
						if (0.0D < d2 || d2 == 0.0D) {
							this.pointedEntity = entity;
							d2 = 0.0D;
						}
					} else if (movingobjectposition != null) {
						double d3 = vec3.distanceTo(movingobjectposition.hitVec);
						if (d3 < d2 || d2 == 0.0D) {
							if (entity == this.mc.thePlayer.ridingEntity && !entity.canRiderInteract()) {
								if (d2 == 0.0D) {
									this.pointedEntity = entity;
								}
							} else {
								this.pointedEntity = entity;
								d2 = d3;
							}
						}
					}
				}
			}

			for (i = 0; i < list.size(); ++i) {
				entity = (Entity) list.get(i);
				if (!entity.isDead && entity.canBeCollidedWith() && entity instanceof EntityPlayerHead) {
					f2 = entity.getCollisionBorderSize();
					axisalignedbb = entity.boundingBox.expand((double) f2, (double) f2, (double) f2);
					movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);
					EntityPlayerHead head = (EntityPlayerHead) entity;
					if (head.player != this.mc.thePlayer) {
						if (axisalignedbb.isVecInside(vec3)) {
							if (0.0D < d21 || d21 == 0.0D) {
								this.pointedEntity = entity;
								d21 = 0.0D;
								break;
							}
						} else if (movingobjectposition != null) {
							double d3 = vec3.distanceTo(movingobjectposition.hitVec);
							if (d3 < d21 || d21 == 0.0D) {
								if (entity != this.mc.thePlayer.ridingEntity || entity.canRiderInteract()) {
									this.pointedEntity = entity;
									d21 = d3;
									break;
								}

								if (d21 == 0.0D) {
									this.pointedEntity = entity;
									break;
								}
							}
						}
					}
				}
			}

			if (this.pointedEntity != null && (d2 < d1 || this.objectMouseOver2 == null || d21 < d1)) {
				this.objectMouseOver2 = new MovingObjectPosition(this.pointedEntity);
				if (this.pointedEntity instanceof EntityLivingBase) {
					this.pointedEntityLiving2 = (EntityLivingBase) this.pointedEntity;
				}
			}
		}

	}

	@SideOnly(Side.CLIENT)
	public MovingObjectPosition rayTrace(EntityLivingBase living, double par1, float par3) {
		Vec3 vec3 = living.getPosition(par3);
		boolean flag = true;
		if (living instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) living;
			if (CDReloaded.instance.playerDataHandler().getPlayerData(player).isAiming) {
				flag = false;
				if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemGun) {
					ItemGun gun = (ItemGun) player.getCurrentEquippedItem().getItem();
					if (gun.spreadWhileAiming) {
						flag = true;
					}
				}
			}
		}

		Vec3 vec31 = this.getLook(flag, living);
		Vec3 vec32 = vec3.addVector(vec31.xCoord * par1, vec31.yCoord * par1, vec31.zCoord * par1);

		try {
			if (!living.isDead && living.worldObj != null) {
				return living.worldObj.clip(vec3, vec32);
			}
		} catch (Exception var10) {
			;
		}

		return null;
	}

	public Vec3 getLook(boolean isrand, EntityLivingBase living) {
		this.shootingYaw = living.rotationYaw;
		this.shootingPitch = living.rotationPitch;
		if (isrand) {
			PlayerData data = CDReloaded.instance.playerDataHandler().getClientPlayerData();
			Random rand = new Random();
			float spread = data.spread * 1.5F;
			if (rand.nextBoolean()) {
				float randSpread = (float) rand.nextInt((int) (spread * 100.0F)) / 100.0F;
				float preyaw = rand.nextBoolean() ? randSpread : -randSpread;
				this.shootingYaw += preyaw * 3.0F;
			}

			this.shootingPitch -= (float) rand.nextInt((int) (spread * 2.0F * 100.0F)) / 100.0F;
		}

		float f1 = MathHelper.cos(-this.shootingYaw * 0.017453292F - 3.1415927F);
		float f2 = MathHelper.sin(-this.shootingYaw * 0.017453292F - 3.1415927F);
		float f3 = -MathHelper.cos(-this.shootingPitch * 0.017453292F);
		float f4 = MathHelper.sin(-this.shootingPitch * 0.017453292F);
		return living.worldObj.getWorldVec3Pool().getVecFromPool((double) (f2 * f3), (double) f4, (double) (f1 * f3));
	}

	public void applyRecoil(float par1) {
		Minecraft mc = Minecraft.getMinecraft();
		ItemStack itemstack = mc.thePlayer.inventory.getCurrentItem();
		if (mc.thePlayer.isSneaking()) {
			par1 *= 0.9F;
		}

		if (itemstack != null && itemstack.getItem() instanceof ItemGun) {
			this.gunRecoil = par1;
		}

	}

	public void onFiremodeUpdated(EnumFireMode par1) {
		this.renderHandler.onFiremodeUpdated(par1);
	}

	public EnumSet ticks() {
		return EnumSet.of(TickType.RENDER, TickType.CLIENT, TickType.PLAYER);
	}

	public String getLabel() {
		return "cdaclienttick";
	}

	public static ClientTickHandler getInstance() {
		return CDReloaded.instance.getClientManager().getClientTickHandler();
	}
}
