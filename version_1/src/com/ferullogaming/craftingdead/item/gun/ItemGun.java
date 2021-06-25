package com.ferullogaming.craftingdead.item.gun;

import java.util.HashMap;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.ferullogaming.craftingdead.CDAftermath;
import com.ferullogaming.craftingdead.client.ClientTickHandler;
import com.ferullogaming.craftingdead.client.anim.AnimationManager;
import com.ferullogaming.craftingdead.client.anim.GunAnimation;
import com.ferullogaming.craftingdead.client.anim.GunAnimationReload;
import com.ferullogaming.craftingdead.client.render.guns.RenderGun;
import com.ferullogaming.craftingdead.client.util.KeyBindingManager;
import com.ferullogaming.craftingdead.events.EventGunBroken;
import com.ferullogaming.craftingdead.events.EventGunFired;
import com.ferullogaming.craftingdead.events.EventGunOutOfAmmo;
import com.ferullogaming.craftingdead.events.EventGunReload;
import com.ferullogaming.craftingdead.item.ItemCD;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.network.CDAPacketGunReload;
import com.ferullogaming.craftingdead.network.CDAPacketGunTrigger;
import com.ferullogaming.craftingdead.network.CDAPacketSound;
import com.ferullogaming.craftingdead.player.PlayerData;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ItemGun extends ItemCD {
	public int gunDamage;
	public int gunDamageHead;
	public float gunRecoil;
	public float gunAccuracy;
	public int bulletDistance = 120;
	public String soundFire;
	public String soundSupressed;
	public String soundReload;
	private String soundEmpty = "gunEmpty";
	private String soundFiremode = "gunFiremode";
	private float soundFireLevel = 1.0F;
	public static HashMap<ItemGun, RenderGun> renders = new HashMap<ItemGun, RenderGun>();
	private Class animationWhenFired;
	private Class animationWhenReloaded;
	private int[] allowedClips = new int[0];
	private EnumFireMode[] allowedFiremodes = new EnumFireMode[0];
	public EnumFireMode currentFiremode;
	private GunAttachment[] allowedAttachments;
	private GunPaint[] allowedSkins;
	public float zoomLevel;
	public boolean isClipDisposable;
	public int bulletsFired;
	public boolean spreadWhileAiming;
	private double tickFire;
	private double delayReload;
	private double delayFire;
	private double delayBurst;
	private double delayBurstFired;
	private static boolean triggerHeld;
	private static boolean lastTriggerHeld;
	private static boolean reloadKey;
	private static boolean lastReloadKey;
	private static boolean firemodeKey;
	private static boolean lastFiremodeKey;
	private static boolean aimKey;
	private static boolean lastAimKey;
	private static int aimDelay;
	private int lastInventorySlot;
	private boolean isRunningShootAllowed;
	private int maxRepair;
	// buffer
	private GunAnimation animBuffer0;
	private GunAnimation animBuffer1;
	private GunAnimation animBuffer2;
	private IItemRenderer renderBuffer0;

	public ItemGun(int par1, double par3FireRate, double par4ReloadDelay, float par5Acc, float par6Recoil, boolean par7IsRunningShootAllowed) {
		super(par1);
		this.currentFiremode = EnumFireMode.AUTO;
		this.zoomLevel = 2.0F;
		this.isClipDisposable = false;
		this.bulletsFired = 1;
		this.spreadWhileAiming = false;
		this.tickFire = 0.0D;
		this.delayReload = 40.0D;
		this.delayBurst = 0.0D;
		this.delayBurstFired = 0.0D;
		this.lastInventorySlot = 0;
		this.animationWhenReloaded = GunAnimationReload.class;
		this.delayFire = (double) ((int) (60.0D / par3FireRate * 40.0D));
		this.delayReload = (double) ((int) (par4ReloadDelay * 20.0D));
		this.gunAccuracy = par5Acc;
		this.gunRecoil = par6Recoil;
		this.isRunningShootAllowed = par7IsRunningShootAllowed;
		this.setMaxStackSize(1);
	}

	public synchronized void onClientTick(World world, EntityPlayer player, ItemStack itemstack) {
		Minecraft mc = FMLClientHandler.instance().getClient();
		if (itemstack != null && itemstack.getItem() instanceof ItemGun && mc.currentScreen == null) {
			lastTriggerHeld = triggerHeld;
			triggerHeld = Mouse.isButtonDown(Mouse.getButtonIndex("BUTTON0"));
			lastReloadKey = reloadKey;
			reloadKey = Keyboard.isKeyDown(KeyBindingManager.cd_reload.keyCode);
			lastFiremodeKey = firemodeKey;
			firemodeKey = Keyboard.isKeyDown(KeyBindingManager.cd_firemode.keyCode);
			lastAimKey = aimKey;
			aimKey = Mouse.isButtonDown(Mouse.getButtonIndex("BUTTON1"));
			PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
			int aimDelayMax = 6;
			if (aimDelay <= aimDelayMax) {
				++aimDelay;
			}

			if (data.isHandCuffed) {
				data.isAiming = false;
				aimDelay = 0;
				return;
			}

			if (aimKey && !lastAimKey && aimDelay > aimDelayMax) {
				data.isAiming = !data.isAiming;
				aimDelay = 0;
			}

			if (reloadKey && !lastReloadKey) {
				this.onClientReload(player, itemstack);
			}

			if (this.tickFire < this.delayFire) {
				++this.tickFire;
			}

			if (this.lastInventorySlot != player.inventory.currentItem) {
				this.clearFiremode();
				this.lastInventorySlot = player.inventory.currentItem;
			}

			if (firemodeKey && !lastFiremodeKey) {
				this.cycleFiremode();
			}

			if (!this.isFiremodeAloud(this.getFiremode())) {
				this.currentFiremode = this.allowedFiremodes[0];
			}

			if (!this.hasAmmo(itemstack) || this.getReloadDelay(itemstack) > 1) {
				if (this.tickFire >= this.delayFire && triggerHeld && !lastTriggerHeld) {
					Minecraft.getMinecraft().sndManager.playSoundFX("craftingdead:" + this.soundEmpty, 1.0F, 1.0F);
					this.tickFire = 0.0D;
				}

				return;
			}

			if (this.getFiremode() == EnumFireMode.AUTO) {
				if (triggerHeld && this.tickFire >= this.delayFire) {
					this.onClientTriggerPulled(player, itemstack);
					this.tickFire = 0.0D;
				}
			} else if (this.getFiremode() == EnumFireMode.SEMI) {
				if (this.tickFire >= this.delayFire && triggerHeld && !lastTriggerHeld) {
					this.onClientTriggerPulled(player, itemstack);
					this.tickFire = 0.0D;
				}
			} else if (this.getFiremode() == EnumFireMode.BURST) {
				if (this.delayBurstFired > 0.0D) {
					--this.delayBurstFired;
					return;
				}

				if (this.tickFire >= this.delayFire && triggerHeld && !lastTriggerHeld && this.delayBurst <= 0.0D) {
					this.delayBurst = 9.0D;
				}

				if (this.delayBurst > 0.0D) {
					if (this.delayBurst % 3.0D == 0.0D) {
						this.onClientTriggerPulled(player, itemstack);
						if (this.delayBurst == 3.0D) {
							this.delayBurstFired = 10.0D;
						}
					}

					--this.delayBurst;
				}
			}
		}

	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		EntityPlayer player = (EntityPlayer) entity;
		if (player != null && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == itemstack.itemID && !world.isRemote) {
			int var1 = this.getReloadDelay(itemstack);
			if (var1 > 0) {
				--var1;
				this.setReloadDelay(itemstack, var1);
			}
		}
		if (itemstack.stackTagCompound != null) {
			if (!itemstack.stackTagCompound.hasKey("maxrepair"))
				itemstack.stackTagCompound.setInteger("maxrepair", this.maxRepair);
			if (!itemstack.stackTagCompound.hasKey("repair"))
				itemstack.stackTagCompound.setInteger("repair", this.maxRepair);
		} else {
			itemstack.stackTagCompound = new NBTTagCompound("tag");
			if (!itemstack.stackTagCompound.hasKey("maxrepair"))
				itemstack.stackTagCompound.setInteger("maxrepair", this.maxRepair);
			if (!itemstack.stackTagCompound.hasKey("repair"))
				itemstack.stackTagCompound.setInteger("repair", this.maxRepair);
		}
	}

	public void onClientTriggerPulled(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
		if (this.hasAmmo(par2ItemStack)) {
			if (!par1EntityPlayer.isSprinting() && !this.isRunningShootAllowed || this.isRunningShootAllowed) {
				if (this.getClipLoaded(par2ItemStack) != null) {
					if (par2ItemStack.stackTagCompound != null && par2ItemStack.stackTagCompound.getInteger("repair") > 0) {
						PacketDispatcher.sendPacketToServer(CDAPacketGunTrigger.buildPacket());
						if (ClientTickHandler.getInstance() != null) {
							float var1 = this.gunRecoil;
							if (this.getAttachmentFromSlot(par2ItemStack, 1) != null) {
								var1 += this.getAttachmentFromSlot(par2ItemStack, 1).recoil;
							}

							ClientTickHandler.getInstance().applyRecoil(var1);

							for (int i = 0; i < this.bulletsFired; ++i) {
								try {
									ClientTickHandler.getInstance().spawnBullet(par1EntityPlayer, this);
								} catch (Exception var6) {
									System.out.println("НЕ ПОЛУЧИЛОСЬ ВЫСТРЕЛИТЬ ПУЛЮ!");
								}
							}

							if (this.animationWhenFired != null) {
								this.animBuffer0 = this.getAnimationWhenFired();
								AnimationManager.instance().setGunAnimation(animBuffer0);
							}
						}
					}

					PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(par1EntityPlayer);
					data.addSpread(this.gunAccuracy);
				}
			}
		}
	}

	public void onClientReload(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {
		if (this.getReloadDelay(par2ItemStack) <= 0) {
			PacketDispatcher.sendPacketToServer(CDAPacketGunReload.buildPacket());
			AnimationManager.instance().setGunAnimation(this.animBuffer1 = this.getAnimationWhenReloading(this.getClipLoaded(par2ItemStack) != null));
			CDAftermath.instance.playerDataHandler().getClientPlayerData().isAiming = false;
		}

	}

	public void onTriggerPulled(ItemStack itemstack, World world, EntityPlayer player) {
		if (this.hasAmmo(itemstack) && this.getClipLoaded(itemstack) != null || player.capabilities.isCreativeMode) {
			if (!player.isSprinting() && !this.isRunningShootAllowed || !player.isSprinting() && this.isRunningShootAllowed || player.isSprinting() && this.isRunningShootAllowed) {
				PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
				ItemStack itemstack1 = this.tryToShoot(itemstack, world, player);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, itemstack1);
				float soundLevel = this.soundFireLevel;
				if (this.hasAttachment(itemstack1, GunAttachment.SURPPRESSOR)) {
					if (this.getAttachmentFromSlot(itemstack1, 2) == GunAttachment.SURPPRESSOR) {
						soundLevel = 0.2F;
						if (data.soundLevels < 0.2F) {
							data.addSoundLevels(soundLevel);
						}
						return;
					}
				}
				data.addSoundLevels(soundLevel);
			}
		}
	}

	public ItemStack tryToShoot(ItemStack itemstack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			if (itemstack.stackTagCompound != null) {
				itemstack.stackTagCompound.setInteger("repair", itemstack.stackTagCompound.getInteger("repair") - 1);
				if (itemstack.stackTagCompound.getInteger("repair") <= 0 && !itemstack.stackTagCompound.hasKey("broken")) {
					itemstack.stackTagCompound.setBoolean("broken", true);
					PacketDispatcher.sendPacketToPlayer(CDAPacketSound.buildPacket(CDAPacketSound.Type.GUN_BROKEN), (Player) player);
				}
			} else if (itemstack.stackTagCompound != null && itemstack.stackTagCompound.getInteger("repair") <= 0) {
				EventGunBroken event = new EventGunBroken(itemstack, player, false);
				MinecraftForge.EVENT_BUS.post(event);
				return itemstack;
			}
			if (!player.capabilities.isCreativeMode) {
				int var1 = this.getAmmo(itemstack);
				this.setAmmoInGun(itemstack, var1 - 1);
				if (this.getAmmo(itemstack) == 0) {
					EventGunOutOfAmmo event = new EventGunOutOfAmmo(itemstack);
					MinecraftForge.EVENT_BUS.post(event);
					if (this.isClipDisposable) {
						this.clearLoadedClip(itemstack);
					}
				}
			}

			String sound = "craftingdead:" + this.soundFire;
			if (this.getAttachmentFromSlot(itemstack, 2) != null && this.getAttachmentFromSlot(itemstack, 2) == GunAttachment.SURPPRESSOR) {
				sound = "craftingdead:" + this.soundSupressed;
			}

			int max = 0;
			int min = 0;
			Double per = -1.0D;
			if (itemstack.stackTagCompound != null) {
				max = itemstack.stackTagCompound.getInteger("maxrepair");
				min = itemstack.stackTagCompound.getInteger("repair");
				per = (double) ((min / (max / 100)));
				per = per / 250;
			}

			if (per == -1.0D)
				world.playSoundAtEntity(player, sound, 1.0F, 1.0F);
			else
				world.playSoundAtEntity(player, sound, 1.0F, 0.75F + Float.valueOf("" + per));
			EventGunFired event = new EventGunFired(player.username, itemstack);
			MinecraftForge.EVENT_BUS.post(event);
		}

		return itemstack;
	}

	public void onReload(EntityPlayer player, World world, ItemStack itemstack) {
		if (this.maxRepair <= 0) {
			EventGunBroken event = new EventGunBroken(itemstack, player, true);
			MinecraftForge.EVENT_BUS.post(event);
			return;
		}
		InventoryPlayer inv = player.inventory;
		EventGunReload event = new EventGunReload(this, player);
		ItemStack clipstack = this.getClipLoaded(itemstack);
		if (this.getReloadDelay(itemstack) <= 0) {
			if (clipstack != null) {
				event.setLoadedStack(clipstack);
				if (!MinecraftForge.EVENT_BUS.post(event)) {
					if (inv.getFirstEmptyStack() != -1) {
						inv.addItemStackToInventory(clipstack);
					} else {
						player.dropPlayerItem(clipstack);
					}

					this.clearLoadedClip(itemstack);
					this.setReloadDelay(itemstack, (int) (this.delayReload / 2.0D));
					this.setAmmoInfected(itemstack, false);
				}
			} else {
				ItemStack itemstack1 = this.getPotentialClip(player);
				if (itemstack1 != null) {
					event.setLoadingStack(itemstack1);
					if (!MinecraftForge.EVENT_BUS.post(event)) {
						ItemStack itemstack2 = event.getAmmoStackLoading();
						this.loadClipIntoGun(player, itemstack, itemstack2);
						world.playSoundAtEntity(player, "craftingdead:" + this.soundReload, 1.0F, 1.0F);
						this.setReloadDelay(itemstack, (int) this.delayReload);
					}
				} else if (player.capabilities.isCreativeMode) {
					this.loadClipIntoGun(player, itemstack, new ItemStack(Item.itemsList[this.allowedClips[0]]));
					world.playSoundAtEntity(player, "craftingdead:" + this.soundReload, 1.0F, 1.0F);
				} else {
					MinecraftForge.EVENT_BUS.post(event);
				}
			}
		}
	}

	protected void cycleFiremode() {
		Minecraft.getMinecraft().sndManager.playSoundFX("craftingdead:" + this.soundFiremode, 1.0F, 1.0F);
		if (this.allowedFiremodes.length > 1) {
			for (int i = 0; i < this.allowedFiremodes.length; ++i) {
				if (this.allowedFiremodes[i] == this.currentFiremode) {
					if (i + 1 < this.allowedFiremodes.length) {
						this.currentFiremode = this.allowedFiremodes[i + 1];
						break;
					}

					this.currentFiremode = this.allowedFiremodes[0];
				}
			}
		}

		ClientTickHandler.getInstance().onFiremodeUpdated(this.currentFiremode);
	}

	protected boolean isFiremodeAloud(EnumFireMode par1) {
		for (int i = 0; i < this.allowedFiremodes.length; ++i) {
			if (this.allowedFiremodes[i] == par1) {
				return true;
			}
		}

		return false;
	}

	public EnumFireMode getFiremode() {
		if (this.currentFiremode == null) {
			this.currentFiremode = this.allowedFiremodes[0];
		}

		return this.currentFiremode;
	}

	protected void clearFiremode() {
		this.currentFiremode = this.allowedFiremodes[0];
	}

	public boolean hasAmmo(ItemStack itemstack) {
		return this.getAmmo(itemstack) > 0;
	}

	public int getAmmo(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null) {
			return tag.hasKey("gunAmmo") ? tag.getInteger("gunAmmo") : tag.getInteger("gunAmmo");
		} else {
			return 0;
		}
	}

	protected void setAmmoInGun(ItemStack itemstack, int par1) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null) {
			tag.setInteger("gunAmmo", par1);
		}

	}

	private void setAmmoInfected(ItemStack itemstack, boolean par2) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		tag.setBoolean("infectedRounds", par2);
	}

	public boolean hasInfectedRounds(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		return tag.hasKey("infectedRounds") ? tag.getBoolean("infectedRounds") : false;
	}

	public void setReloadDelay(ItemStack itemstack, int par2) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null) {
			tag.setInteger("gunreloading", par2);
		}

	}

	public int getReloadDelay(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		return tag != null ? tag.getInteger("gunreloading") : 0;
	}

	public ItemStack getClipLoaded(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null && tag.hasKey("gunLoadedClip")) {
			int var1 = tag.getInteger("gunLoadedClip");
			if (var1 != 0) {
				ItemAmmo var2Clip = (ItemAmmo) Item.itemsList[var1];
				ItemStack var3Clip = new ItemStack(var2Clip);
				int var4 = this.getAmmo(itemstack);
				var3Clip.setItemDamage(var2Clip.clipSize - var4);
				var2Clip.setAmmoInfected(var3Clip, this.hasInfectedRounds(itemstack));
				return var3Clip;
			}
		}

		return null;
	}

	public ItemAmmo getClip(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null && tag.hasKey("gunLoadedClip")) {
			int var1 = tag.getInteger("gunLoadedClip");
			if (var1 != 0) {
				return (ItemAmmo) Item.itemsList[var1];
			}
		}

		return null;
	}

	public void loadClipIntoGun(EntityPlayer entityplayer, ItemStack itemstack, ItemStack itemstackClip) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null && itemstackClip != null && this.isClipAllowed(itemstackClip.getItem())) {
			tag.setInteger("gunLoadedClip", itemstackClip.getItem().itemID);
			this.consumeClipLoading(entityplayer, itemstackClip);
			ItemAmmo itemAmmo = (ItemAmmo) itemstackClip.getItem();
			this.setAmmoInGun(itemstack, itemAmmo.clipSize - itemstackClip.getItemDamage());
			this.setAmmoInfected(itemstack, itemAmmo.isAmmoInfected(itemstackClip));
		}

	}

	protected void consumeClipLoading(EntityPlayer entityplayer, ItemStack itemstack) {
		InventoryPlayer inv = entityplayer.inventory;

		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			ItemStack itemstack1 = inv.getStackInSlot(i);
			if (itemstack1 == itemstack) {
				inv.setInventorySlotContents(i, (ItemStack) null);
			}
		}

	}

	public boolean isClipAllowed(Item item) {
		for (int i = 0; i < this.allowedClips.length; ++i) {
			if (this.allowedClips[i] == item.itemID) {
				return true;
			}
		}

		return false;
	}

	public int getDefaultAllowedClip() {
		return this.allowedClips[0];
	}

	public void clearLoadedClip(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null) {
			tag.setInteger("gunLoadedClip", 0);
			this.setAmmoInGun(itemstack, 0);
		}

	}

	public ItemStack getPotentialClip(EntityPlayer player) {
		InventoryPlayer inv = player.inventory;

		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			ItemStack itemstack = inv.getStackInSlot(i);
			if (itemstack != null && itemstack.getItem() instanceof ItemAmmo && this.isClipAllowed(itemstack.getItem()) && !this.isPotentialClipEmpty(itemstack)) {
				return itemstack;
			}
		}

		return null;
	}

	protected boolean isPotentialClipEmpty(ItemStack itemstack) {
		ItemAmmo ammo = (ItemAmmo) itemstack.getItem();
		return itemstack.getItemDamage() == ammo.clipSize;
	}

	public void setAttachment(ItemStack itemstack, GunAttachment attach) {
		if (attach != null && this.isAttachmentAloud(attach)) {
			int slot = attach.isSight ? 0 : (attach.isUnderbarrel ? 1 : 2);
			NBTTagCompound nbt = this.getNBTTagCompound(itemstack);
			if (nbt != null && this.getAttachmentFromSlot(itemstack, slot) == null) {
				nbt.setInteger("attachmentSlot" + slot, attach.attachmentID);
			}
		}

	}

	public GunAttachment getAttachmentFromSlot(ItemStack itemstack, int slot) {
		NBTTagCompound nbt = this.getNBTTagCompound(itemstack);
		if (nbt != null && nbt.hasKey("attachmentSlot" + slot)) {
			int var1 = nbt.getInteger("attachmentSlot" + slot);
			GunAttachment attachment = GunAttachment.attachmentList[var1];
			return attachment;
		} else {
			return null;
		}
	}

	public void clearAttachments(ItemStack itemstack) {
		NBTTagCompound nbt = this.getNBTTagCompound(itemstack);
		if (nbt != null) {
			for (int i = 0; i < 3; ++i) {
				nbt.setInteger("attachmentSlot" + i, 0);
			}
		}

	}

	public boolean hasAttachment(ItemStack itemstack, GunAttachment attach) {
		NBTTagCompound nbt = this.getNBTTagCompound(itemstack);
		if (nbt != null) {
			int slot = attach.isSight ? 0 : (attach.isUnderbarrel ? 1 : 2);
			if (this.getAttachmentFromSlot(itemstack, slot) != null) {
				return true;
			}
		}

		return false;
	}

	public boolean hasAttachments(ItemStack itemstack) {
		NBTTagCompound nbt = this.getNBTTagCompound(itemstack);
		if (nbt != null) {
			for (int i = 0; i < 3; ++i) {
				if (this.getAttachmentFromSlot(itemstack, i) != null) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean isAttachmentAloud(GunAttachment par1) {
		for (int i = 0; i < this.allowedAttachments.length; ++i) {
			if (this.allowedAttachments[i] == par1) {
				return true;
			}
		}

		return false;
	}

	public void removeAttachmentFromSlot(ItemStack itemstack, int slot) {
		if (slot == 0 || slot == 1 || slot == 2) {
			NBTTagCompound nbt = this.getNBTTagCompound(itemstack);
			if (nbt != null) {
				nbt.setInteger("attachmentSlot" + slot, 0);
			}
		}

	}

	public void setGunSkin(ItemStack itemstack, GunPaint paint) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null && paint != null && this.isSkinAllowed(paint)) {
			tag.setInteger("gunSkin", paint.skinID);
		}
	}

	public void setGunSpecials(ItemStack itemstack, Integer special) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null) {
			if (special != 0)
				tag.setInteger("gunSpecial", special);
			else if (special == 0)
				if (tag.getInteger("gunSpecial") != 0)
					tag.setInteger("gunSpecial", special);
		}
	}

	public Integer getGunSpecials(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null)
			return tag.getInteger("gunSpecial");
		else
			return 0;
	}

	public GunPaint getGunSkin(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null && tag.hasKey("gunSkin")) {
			int skinName = tag.getInteger("gunSkin");
			return GunPaint.gunSkinsList[skinName];
		} else {
			return null;
		}
	}

	public String getSkinName(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		if (tag != null && tag.hasKey("gunSkin")) {
			int skinName = tag.getInteger("gunSkin") - 1;
			if (skinName == 1)
				return "азимов";
			else if (skinName == 1)
				return "сайрекс";
			else if (skinName == 2)
				return "вулкан";
			else if (skinName == 3)
				return "кристалл";
			else if (skinName == 4)
				return "градиент";
			else if (skinName == 5)
				return "рубин";
			else if (skinName == 6)
				return "ультрафиолет";
			else if (skinName == 7)
				return "красное яблоко";
			else
				return "нет";
		} else {
			return "нет";
		}
	}

	public void clearGunSkin(ItemStack itemstack) {
		NBTTagCompound tag = this.getNBTTagCompound(itemstack);
		tag.setString("gunSkin", "");
	}

	public boolean isSkinAllowed(GunPaint par1) {
		for (int i = 0; i < this.allowedSkins.length; ++i) {
			if (par1.skinID == this.allowedSkins[i].skinID) {
				return true;
			}
		}

		return false;
	}

	public GunAnimation getAnimationWhenFired() {
		try {
			return this.animBuffer0 = (GunAnimation) this.animationWhenFired.newInstance();
		} catch (InstantiationException var2) {
			var2.printStackTrace();
		} catch (IllegalAccessException var3) {
			var3.printStackTrace();
		}
		return null;
	}

	public GunAnimationReload getAnimationWhenReloading(boolean par1) {
		try {
			this.animBuffer2 = (GunAnimationReload) this.animationWhenReloaded.newInstance();
			((GunAnimationReload) this.animBuffer2).setEjectingClip(par1);
			return (GunAnimationReload) this.animBuffer2;
		} catch (InstantiationException var3) {
			var3.printStackTrace();
		} catch (IllegalAccessException var4) {
			var4.printStackTrace();
		}
		return null;
	}

	public ItemGun setLoadableClips(int... par1) {
		this.allowedClips = par1;
		return this;
	}

	public ItemGun setSoundEffects(String par1, String par2, String par3) {
		this.soundFire = par1;
		this.soundSupressed = par2;
		this.soundReload = par3;
		return this;
	}

	public ItemGun setBulletAmountFired(int par1) {
		this.bulletsFired = par1;
		return this;
	}

	public ItemGun setDamage(int par1, int par2) {
		this.gunDamage = par1;
		this.gunDamageHead = par2;
		return this;
	}

	public ItemGun setBulletTravelDistance(int par1) {
		this.bulletDistance = par1;
		return this;
	}

	public ItemGun setAllowedAttachments(GunAttachment... par1) {
		this.allowedAttachments = par1;
		return this;
	}

	public ItemGun setGunFiremodes(EnumFireMode... par1) {
		this.allowedFiremodes = par1;
		return this;
	}

	public ItemGun setSoundLevel(float par1) {
		this.soundFireLevel = par1;
		return this;
	}

	public ItemGun setZoomLevels(float par1) {
		this.zoomLevel = par1;
		return this;
	}

	public ItemGun setAnimationFired(Class par1) {
		this.animationWhenFired = par1;
		return this;
	}

	public ItemGun setAnimationReload(Class par1) {
		this.animationWhenReloaded = par1;
		return this;
	}

	public ItemGun setGunRenderer(Class par1) {
		if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			try {
				this.renderBuffer0 = (IItemRenderer)par1.newInstance();
				MinecraftForgeClient.registerItemRenderer(super.itemID, this.renderBuffer0);
				this.renders.put(this, (RenderGun)this.renderBuffer0);
			} catch (InstantiationException var3) {
				var3.printStackTrace();
			} catch (IllegalAccessException var4) {
				var4.printStackTrace();
			}
		}

		return this;
	}

	public ItemGun setAllowedSkins(GunPaint... par1) {
		this.allowedSkins = par1;
		return this;
	}

	public ItemGun setSpreadWhileAiming() {
		this.spreadWhileAiming = true;
		return this;
	}

	public ItemGun setClipDisposable() {
		this.isClipDisposable = true;
		return this;
	}

	public ItemGun setRepair(int maxRepair) {
		this.maxRepair = maxRepair;
		return this;
	}

	public int getGunDamage(ItemStack par1, boolean par2) {
		int var1 = par2 ? this.gunDamageHead : this.gunDamage;
		if (this.getAttachmentFromSlot(par1, 2) != null) {
			var1 += this.getAttachmentFromSlot(par1, 2).damage;
		}

		return var1;
	}

	public float getGunAccuracy() {
		return this.gunAccuracy;
	}

	protected NBTTagCompound getNBTTagCompound(ItemStack itemstack) {
		String var1 = "cdagun";
		if (itemstack.stackTagCompound == null) {
			itemstack.setTagCompound(new NBTTagCompound());
		}

		if (!itemstack.stackTagCompound.hasKey(var1)) {
			itemstack.stackTagCompound.setTag(var1, new NBTTagCompound(var1));
		}

		return (NBTTagCompound) itemstack.stackTagCompound.getTag(var1);
	}

	public String getItemDisplayName(ItemStack par1ItemStack) {
		if (this.getGunSkin(par1ItemStack) != null) {
			String suffix = this.getGunSkin(par1ItemStack).getDisplayName();
			return EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + super.displayName + " " + suffix;
		} else {
			return super.getItemDisplayName(par1ItemStack);
		}
	}

	public boolean getShareTag() {
		return true;
	}

	public boolean hasEffect(ItemStack par1ItemStack, int pass) {
		if (this.hasAttachments(par1ItemStack)) {
			return true;
		} else {
			return this.getGunSkin(par1ItemStack) != null;
		}
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		String var1;
		if (Keyboard.isKeyDown(19)) {
			var1 = "Патроны " + EnumChatFormatting.RED + this.getAmmo(par1ItemStack);
			par3List.add(var1);
			if (this.hasInfectedRounds(par1ItemStack)) {
				par3List.add(EnumChatFormatting.RED + "Зараженные патроны");
			}

			var1 = "Урон " + EnumChatFormatting.RED + this.getGunDamage(par1ItemStack, false);
			par3List.add(var1);
			if (this.bulletsFired > 1) {
				var1 = "Довыстрелов " + EnumChatFormatting.RED + this.bulletsFired;
				par3List.add(var1);
			}

			var1 = "Выстрел в голову " + EnumChatFormatting.RED + this.getGunDamage(par1ItemStack, true);
			par3List.add(var1);

			for (int i = 0; i < 3; ++i) {
				if (this.getAttachmentFromSlot(par1ItemStack, i) != null) {
					String var2 = "Приспособление " + EnumChatFormatting.RED + this.getAttachmentFromSlot(par1ItemStack, i).getAttachmentName();
					par3List.add(var2);
				}
			}

			var1 = "Точность " + EnumChatFormatting.RED + this.gunAccuracy;
			par3List.add(var1);
			var1 = "Разброс " + EnumChatFormatting.RED + this.gunRecoil;
			par3List.add(var1);
		} else {
			var1 = "Нажмите 'R' для подробной информации!";
			par3List.add(var1);
		}

	}

	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		return true;
	}

	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		return true;
	}

	public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player) {
		return true;
	}

	public static ItemGun instance() {
		return (ItemGun)ItemManager.m4a1;
	}

	static {
		lastTriggerHeld = triggerHeld;
		lastReloadKey = !reloadKey;
		lastFiremodeKey = !firemodeKey;
		lastAimKey = aimKey;
		aimDelay = 0;
	}
}
