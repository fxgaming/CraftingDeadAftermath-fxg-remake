package com.ferullogaming.craftingdead;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.ferullogaming.craftingdead.block.BlockLoot;
import com.ferullogaming.craftingdead.block.BlockManager;
import com.ferullogaming.craftingdead.damage.DamageSourceBleeding;
import com.ferullogaming.craftingdead.damage.DamageSourceBullet;
import com.ferullogaming.craftingdead.damage.DamageSourceBulletHeadshot;
import com.ferullogaming.craftingdead.damage.DamageSourceCD;
import com.ferullogaming.craftingdead.damage.DamageSourceRBInfection;
import com.ferullogaming.craftingdead.damage.DamageSourceThirst;
import com.ferullogaming.craftingdead.entity.EntityC4;
import com.ferullogaming.craftingdead.entity.EntityCDZombie;
import com.ferullogaming.craftingdead.entity.EntityCorpse;
import com.ferullogaming.craftingdead.entity.EntityGroundItem;
import com.ferullogaming.craftingdead.events.EnumBulletCollision;
import com.ferullogaming.craftingdead.events.EventBulletCollision;
import com.ferullogaming.craftingdead.events.EventFlamethrowerSetFire;
import com.ferullogaming.craftingdead.events.EventGunBroken;
import com.ferullogaming.craftingdead.events.ItemCraftedEvent;
import com.ferullogaming.craftingdead.item.ItemClothing;
import com.ferullogaming.craftingdead.item.ItemClothingArmor;
import com.ferullogaming.craftingdead.item.ItemClothingJuggernaut;
import com.ferullogaming.craftingdead.item.ItemHatHelmet;
import com.ferullogaming.craftingdead.item.ItemManager;
import com.ferullogaming.craftingdead.item.gun.ItemAmmo;
import com.ferullogaming.craftingdead.item.gun.ItemGun;
import com.ferullogaming.craftingdead.item.potion.PotionManager;
import com.ferullogaming.craftingdead.network.CDAPacketACLInCombat;
import com.ferullogaming.craftingdead.network.CDAPacketHandcuffInteract;
import com.ferullogaming.craftingdead.network.CDAPacketSound;
import com.ferullogaming.craftingdead.player.PlayerData;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockTNT;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.ChunkEvent.Load;

public class CommonEvents {
	public static final int PACKET_DISPATCH_DISTANCE = 128;
	public static final boolean BULLET_INTERACT_BLOCKS = true;
	public static final boolean BULLET_INTERACT_TNT = true;
	private boolean playerAttacked = true;

	public CommonEvents() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@ForgeSubscribe
	public void onPlayerInteractWithEntity(EntityInteractEvent event) {
		if (event.entityPlayer != null) {
			PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(event.entityPlayer);
			if (data.isHandCuffed) {
				event.setCanceled(true);
			}
		}
	}

	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.entityPlayer != null) {
			EntityPlayer player = event.entityPlayer;
			PlayerData playerdata = CDAftermath.instance.playerDataHandler().getPlayerData(player);
			if (playerdata.isHandCuffed) {
				if (player.worldObj.isRemote) {
					PacketDispatcher.sendPacketToServer(CDAPacketHandcuffInteract.buildPacket());
				}
				if (event.action == Action.LEFT_CLICK_BLOCK || event.action == Action.RIGHT_CLICK_BLOCK) {
					event.setCanceled(true);
				}
			}
		}
	}

	@ForgeSubscribe
	public void onItemLeftClick(AttackEntityEvent event) {
		if (event.entityPlayer != null) {
			PlayerData playerdata = CDAftermath.instance.playerDataHandler().getPlayerData(event.entityPlayer);
			if (playerdata.isHandCuffed) {
				event.setCanceled(true);
			}
		}
	}

	@ForgeSubscribe
	public void onFlamethrowerDamages(EventFlamethrowerSetFire event) {
		if (event.entityHit instanceof EntityPlayer) {
			EntityPlayer playerHit = (EntityPlayer) event.entityHit;
			PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(playerHit);
			if (data.getCDInventory() != null && data.getCDInventory().getStack("clothing") != null) {
				ItemStack clothStack = data.getCDInventory().getStack("clothing");
				ItemClothing clothItem = (ItemClothing) clothStack.getItem();
				if (clothItem.isFireResistant()) {
					event.damageDealing = 0;
					event.fireTime /= 2.0D;
				}
			}
		}
	}

	@ForgeSubscribe
	public void onServerCommand(CommandEvent event) {
		if (FMLCommonHandler.instance().getSide() == Side.SERVER && event.command.getCommandName().equals("stop")) {
			World world = MinecraftServer.getServer().getEntityWorld();
			for (int i = 0; i < world.playerEntities.size(); ++i) {
				EntityPlayer player = (EntityPlayer) world.playerEntities.get(i);
				PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
				data.antiCombatLoggingWaitTick = -1;
			}
		}
	}

	@ForgeSubscribe
	public void onCraftingEvent(ItemCraftedEvent event) {
		if (event.materialsCrafting.size() == 2) {
			ItemStack ammoStack = null;
			ItemStack rbiStack = null;
			for (int i = 0; i < event.materialsCrafting.size(); ++i) {
				if (((ItemStack) event.materialsCrafting.get(i)).getItem() instanceof ItemAmmo) {
					ammoStack = (ItemStack) event.materialsCrafting.get(i);
				} else if (((ItemStack) event.materialsCrafting.get(i)).itemID == ItemManager.needleRBI.itemID) {
					rbiStack = (ItemStack) event.materialsCrafting.get(i);
				}
			}
			if (ammoStack != null && rbiStack != null) {
				ItemAmmo itemAmmo = (ItemAmmo) ammoStack.getItem();
				event.craftedStack.setItemDamage(ammoStack.getItemDamage());
				itemAmmo.setAmmoInfected(event.craftedStack, true);
				return;
			}
		}
	}

	@ForgeSubscribe
	public void onItemDroppedByEntity(LivingDropsEvent event) {
		if (!event.entityLiving.worldObj.isRemote) {
			if (event.drops.size() > 0) {
				ArrayList items = event.drops;
				Iterator var3 = items.iterator();
				while (var3.hasNext()) {
					EntityItem item = (EntityItem) var3.next();
					ItemStack itemstack = item.getEntityItem();
					EntityGroundItem groundItem = new EntityGroundItem(event.entityLiving.worldObj, item.posX, item.posY, item.posZ);
					groundItem.setEntityItemStack(itemstack);
					event.entityLiving.worldObj.spawnEntityInWorld(groundItem);
				}
				event.setCanceled(true);
			}
		}
	}

	@ForgeSubscribe
	public void onItemTossed(ItemTossEvent event) {
		World world = event.player.worldObj;
		EntityItem entityItem = event.entityItem;
		ItemStack stack = entityItem.getEntityItem();
		if (!world.isRemote) {
			if (!(stack.getItem() instanceof ItemBlock)) {
				EntityGroundItem groundItem = new EntityGroundItem(world, entityItem.posX, entityItem.posY, entityItem.posZ);
				groundItem.setEntityItemStack(stack);
				world.spawnEntityInWorld(groundItem);
				event.setCanceled(true);
			}
		}
	}

	@ForgeSubscribe
	public void onItemDropped(PlayerDropsEvent event) {
		EntityPlayer player = event.entityPlayer;
		if (!player.worldObj.isRemote) {
			PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
			ItemStack[] cdinv = data.getCDInventory().getInventoryContents();
			if (data.isHandCuffed) {
				ItemStack itemstack = new ItemStack(ItemManager.handcuffs);
				itemstack.setItemDamage(data.handcuffDamage);
				EntityGroundItem groundItem = new EntityGroundItem(player.worldObj, player.posX, player.posY, player.posZ);
				groundItem.setEntityItemStack(itemstack);
				player.worldObj.spawnEntityInWorld(groundItem);
				data.isHandCuffed = false;
			}
			EntityCorpse corpse = new EntityCorpse(player);
			int i;
			for (i = 0; i < cdinv.length; ++i) {
				if (cdinv[i] != null) {
					event.drops.add(new EntityItem(player.worldObj, player.posX, player.posY, player.posZ, cdinv[i]));
				}
			}
			for (i = 0; i < event.drops.size(); ++i) {
				if (event.drops.get(i) != null && ((EntityItem) event.drops.get(i)).getEntityItem().getItem() instanceof ItemClothingArmor) {
					event.drops.remove(i);
				}
			}
			data.clearPlayerInventory();
			corpse.setInventoryContentsFromEntities(event.drops);
			if (!data.killPlayerForCombatLogging) {
				player.worldObj.spawnEntityInWorld(corpse);
			}
		}
		event.setCanceled(true);
	}

	@ForgeSubscribe
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event.source.getSourceOfDamage() != null) {
			EntityLivingBase entityAttacked = event.entityLiving;
			if (entityAttacked instanceof EntityPlayer) {
				this.playerAttacked = !this.playerAttacked;
				EntityPlayer player = (EntityPlayer) entityAttacked;
				PlayerData playerData = CDAftermath.instance.playerDataHandler().getPlayerData(player);
				Random random = new Random();
				if (player.isDead) {
					return;
				}
				if (this.playerAttacked) {
					return;
				}
				if (player.worldObj.isRemote) {
					return;
				}
				if (player.capabilities.isCreativeMode) {
					return;
				}
				if (!(event.source instanceof DamageSourceBleeding) && !(event.source instanceof DamageSourceThirst) && !(event.source instanceof DamageSourceRBInfection) && event.ammount > 0.0F) {
					PacketDispatcher.sendPacketToPlayer(CDAPacketACLInCombat.buildPacket(), (Player) player);
				}
				int var1Random;
				int var2Percentage;
				ItemStack stack;
				int armorLevel;
				if (event.source.getSourceOfDamage() instanceof EntityCDZombie) {
					var1Random = random.nextInt(100);
					var2Percentage = 10;
					if (playerData.getCDInventory().getStack("clothing") != null) {
						stack = playerData.getCDInventory().getStack("clothing");
						armorLevel = ((ItemClothing) stack.getItem()).getArmorLevel();
						if (armorLevel == 2 || armorLevel == 3) {
							var2Percentage /= 2;
						}
					}
					if (var1Random <= var2Percentage && !player.isPotionActive(PotionManager.RBInfection.id)) {
						player.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "Вы были инфицированы RBI!"));
						player.addPotionEffect(new PotionEffect(PotionManager.RBInfection.id, 9999999));
						return;
					}
				}
				var1Random = random.nextInt(100);
				var2Percentage = 22;
				if (playerData.getCDInventory().getStack("clothing") != null) {
					stack = playerData.getCDInventory().getStack("clothing");
					armorLevel = ((ItemClothing) stack.getItem()).getArmorLevel();
					if (armorLevel == 2 || armorLevel == 3) {
						var2Percentage /= 2;
					}
				}
				if (var1Random <= var2Percentage && !player.isPotionActive(PotionManager.bleeding.id) && event.ammount >= 4.0F) {
					player.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "У вас кровотечение!"));
					player.addPotionEffect(new PotionEffect(PotionManager.bleeding.id, 9999999));
				}
			}
		}
	}

	@ForgeSubscribe
	public void onChunkLoaded(Load event) {
		boolean flag = false;
		int var1 = 0;

		for (int x = 0; x < 16; ++x) {
			for (int y = 0; y < 256; ++y) {
				for (int z = 0; z < 16; ++z) {
					int blockid = event.getChunk().getBlockID(x, y, z);
					int var3 = BlockManager.isBlockIDOldSpawner(blockid);
					if (blockid != 0 && var3 != -1) {
						event.getChunk().setBlockIDWithMetadata(x, y, z, var3, 0);
						++var1;
						flag = true;
					}
				}
			}
		}
		if (flag) {
			System.out.println("Заменено всего " + var1 + " Старых лут-спавнер(ов) в 1 чанке.");
		}
	}

	@ForgeSubscribe
	public void onEntityKilled(LivingDeathEvent event) {
		EntityPlayer player;
		PlayerData data;
		if (event.entityLiving instanceof EntityPlayer) {
			player = (EntityPlayer) event.entityLiving;
			if (!player.worldObj.isRemote) {
				data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
				data.onPlayerDeath();
			}
			if (event.source.getSourceOfDamage() instanceof EntityPlayer) {
				EntityPlayer playerKilling = (EntityPlayer) event.source.getSourceOfDamage();
				if (!playerKilling.worldObj.isRemote) {
					data = CDAftermath.instance.playerDataHandler().getPlayerData(playerKilling);
					++data.killedPlayers;
				}
			}
		}
		if (event.entityLiving instanceof EntityCDZombie && event.source.getSourceOfDamage() instanceof EntityPlayer) {
			player = (EntityPlayer) event.source.getSourceOfDamage();
			if (!player.worldObj.isRemote) {
				data = CDAftermath.instance.playerDataHandler().getPlayerData(player);
				++data.killedZombies;
			}
		}
	}

//	@ForgeSubscribe
//	public void onUpdate(LivingUpdateEvent e) {
//		if (e.entity != null && e.entity.worldObj != null && !e.entity.worldObj.isRemote && e.entity instanceof EntityLiving) {
//			EntityLiving l = (EntityLiving) e.entity;
//			if (l instanceof EntityCreeper || l instanceof EntityZombie || l instanceof EntityEnderman || l instanceof EntitySpider || l instanceof EntitySkeleton || l instanceof EntityPig || l instanceof EntitySheep || l instanceof EntityCow || l instanceof EntityChicken) {
//				l.capturedDrops.clear();
//				EntityCDZombie z = new EntityCDZombie(l.worldObj);
//				z.posX = l.posX;
//				z.posY = l.posY;
//				z.posZ = l.posZ;
//				l.setDead();
//				l.worldObj.spawnEntityInWorld(z);
//			}
//		}
//	}

	@ForgeSubscribe
	public void onBulletCollision(EventBulletCollision event) {
		if (!event.getWorldObject().isRemote) {
			if (event.getCollisionType() == EnumBulletCollision.ENTITY) {
				if (event.getEntityHit() instanceof EntityC4) {
					EntityC4 c4 = (EntityC4) event.getEntityHit();
					c4.forceSetOffC4(event.getShooter(), "shot");
				}

				if (event.getEntityHit() instanceof EntityCDZombie && ItemGun.instance().hasInfectedRounds(event.getGunStack())) {
					event.setDamageDealt(event.getDamageDealt() * 2);
				}
			} else if (event.getCollisionType() == EnumBulletCollision.PLAYER) {
				EntityPlayer playerHit = event.getPlayerHit();
				PlayerData hitData = CDAftermath.instance.playerDataHandler().getPlayerData(playerHit);
				PacketDispatcher.sendPacketToPlayer(CDAPacketACLInCombat.buildPacket(), (Player) playerHit);
				if (playerHit.isEntityInvulnerable()) {
					event.setCanceled(true);
					return;
				}

				if (!hitData.canTakeBulletDamage) {
					event.setCanceled(true);
					return;
				}

				int var1;
				if (ItemGun.instance().hasInfectedRounds(event.getGunStack())) {
					Random rand = new Random();
					int var1Random = rand.nextInt(100);
					var1 = 20;
					if (hitData.getCDInventory().getStack("clothing") != null) {
						int armorLevel = ((ItemClothing) hitData.getCDInventory().getStack("clothing").getItem()).getArmorLevel();
						if (armorLevel == 2 || armorLevel == 3) {
							var1 /= 2;
						}
					}

					if (var1Random <= var1 && !playerHit.isPotionActive(PotionManager.RBInfection.id)) {
						playerHit.sendChatToPlayer(ChatMessageComponent.createFromText(EnumChatFormatting.RED + "Вы были инфицированы RBI!"));
						playerHit.addPotionEffect(new PotionEffect(PotionManager.RBInfection.id, 9999999));
						return;
					}
				}

				ItemStack stack;
				ItemAmmo ammo;
				if (event.getDamageSource() instanceof DamageSourceBulletHeadshot) {
					PacketDispatcher.sendPacketToPlayer(CDAPacketSound.buildPacket(CDAPacketSound.Type.HEADSHOT), (Player) event.getWorldObject().getPlayerEntityByName(event.getPlayerFiredName()));
					PacketDispatcher.sendPacketToPlayer(CDAPacketSound.buildPacket(CDAPacketSound.Type.HEADSHOT), (Player) event.getPlayerHit());
					stack = hitData.getCDInventory().getStack("hat");
					if (stack != null && stack.getItem() instanceof ItemHatHelmet) {
						ammo = event.getItemGunReference().getClip(event.getGunStack());
						if (ammo != null && ammo.armorPenetration > 75.0D) {
							return;
						}

						var1 = event.getDamageDealt();
						event.setDamageDealt((int) ((double) var1 * 0.8D));
					}
				} else {
					if (hitData.getCDInventory().getStack("vest") != null) {
						var1 = event.getDamageDealt();
						event.setDamageDealt((int) ((double) var1 * 0.8D));
					}
					if (hitData.getCDInventory().getStack("clothing") != null) {
						stack = hitData.getCDInventory().getStack("clothing");
						if (stack.getItem() instanceof ItemClothingJuggernaut) {
							ammo = event.getItemGunReference().getClip(event.getGunStack());
							var1 = event.getDamageDealt();
							event.setDamageDealt(1);
							Random rand = new Random();
							if (rand.nextBoolean()) {
								event.setDamageDealt((int) ((double) var1 * 0.4D));
							}
						}
					}
				}
			}
		}
	}

	@ForgeSubscribe
	public void itemPickupEvent(EntityItemPickupEvent e) {
		if (e.item.getEntityItem() != null && e.entityLiving instanceof EntityPlayer) {
			if (e.item.getEntityItem().itemID == ItemManager.silver.itemID || e.item.getEntityItem().itemID == ItemManager.gold.itemID) {
				if (!e.entity.worldObj.isRemote) {
					PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData((EntityPlayer) e.entityLiving);
					ItemStack item = e.item.getEntityItem();
					if (e.item.getEntityItem().itemID == ItemManager.silver.itemID) {
						data.coins += item.stackSize;
						e.setResult(Result.ALLOW);
					} else {
						data.donatecoins += item.stackSize;
						e.setResult(Result.ALLOW);
					}
				}
			}
		}
	}

	@ForgeSubscribe
	public void gunBrokeEvent(EventGunBroken e) {
	}

	public void applyBulletCollisionEntity(EntityPlayer par1, ItemStack par2, EntityLivingBase par3, boolean par4, Vec3 hitVec, World par6) {
		ItemGun itemGun = (ItemGun) par2.getItem();
		ItemAmmo itemAmmo = itemGun.getClip(par2);
		int damage = itemGun.getGunDamage(par2, par4);
		DamageSourceCD damageSource = par4 ? new DamageSourceBulletHeadshot(par1, par2) : new DamageSourceBullet(par1, par2);
		EventBulletCollision eventBulletCollision = new EventBulletCollision(par3 instanceof EntityPlayer ? EnumBulletCollision.PLAYER : EnumBulletCollision.ENTITY, par1, par2, par6);
		eventBulletCollision.setEntityHit(par3);
		eventBulletCollision.setDamageSource((DamageSource) damageSource, damage);
		if (!MinecraftForge.EVENT_BUS.post(eventBulletCollision)) {
			int damageDealing = eventBulletCollision.getDamageDealt();
			int preHealth = (int)par3.getHealth();
			if (par4) {
				par1.worldObj.playSoundAtEntity(par1, "random.break", 2.0F, 1.5F);
				par3.worldObj.playSoundAtEntity(par3, "random.break", 2.0F, 1.5F);
			}
			par3.hurtResistantTime = 0;
			par3.attackEntityFrom((DamageSource) damageSource, (float) damageDealing);
			par3.motionX = par3.motionY = par3.motionZ = 0.0D;
			if (par3 instanceof EntityPlayer && !par4 && !par3.isDead && par3.getHealth() > 0.0F) {
				EntityPlayer player = (EntityPlayer) par3;
				PlayerData hitData = CDAftermath.instance.playerDataHandler().getPlayerData(player);
				if (hitData.getCDInventory().getStack("clothing") != null && itemAmmo != null) {
					int damageDealt = preHealth - (int) par3.getHealth();
					double armorPenPer = itemAmmo.armorPenetration;
					if (armorPenPer <= 5.0D) {
						return;
					}
					int extraDamage = (int) ((double) ((float) (damageDealing - damageDealt)) * (armorPenPer / 100.0D));
					float newHealth = player.getHealth() - (float) extraDamage;
					player.setHealth(newHealth);
					if (newHealth <= 0.0F) {
						player.onDeath((DamageSource) damageSource);
					}
				}
			}

		}
	}

	public void applyBulletCollisionBlock(EntityPlayer par1, ItemStack itemstack, World par2, double par3, double par4, double par5, int par6, int par7, Vec3 hitVec) {
		if (par1 instanceof EntityPlayerMP) {
			EntityPlayerMP playerMP = (EntityPlayerMP) par1;
			PlayerData data = CDAftermath.instance.playerDataHandler().getPlayerData((EntityPlayer) playerMP);
			Block block = Block.blocksList[par2.getBlockId((int) par3, (int) par4, (int) par5)];
			EventBulletCollision eventBulletCollision = new EventBulletCollision(EnumBulletCollision.BLOCK, par1, itemstack, par2);
			eventBulletCollision.setBlockHit((int) par3, (int) par4, (int) par5);
			if (MinecraftForge.EVENT_BUS.post(eventBulletCollision)) {
				return;
			}

			if (block != null && (block instanceof BlockLever || block instanceof BlockTNT || block instanceof BlockButton || block instanceof BlockLoot) && data.playerBulletInteractBlockDelay <= 0) {
				if (block instanceof BlockTNT) {
					((BlockTNT) block).primeTnt(par2, (int) par3, (int) par4, (int) par5, 5, par1);
					par2.setBlock((int) par3, (int) par4, (int) par5, 0);
				}

				playerMP.theItemInWorldManager.activateBlockOrUseItem(playerMP, MinecraftServer.getServer().worldServerForDimension(playerMP.dimension), itemstack, (int) par3, (int) par4, (int) par5, par7, 0.0F, 0.0F, 0.0F);
				data.playerBulletInteractBlockDelay = 5;
			}
		}

	}
}
