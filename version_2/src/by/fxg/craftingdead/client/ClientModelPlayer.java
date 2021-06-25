package by.fxg.craftingdead.client;

import org.lwjgl.opengl.GL11;

import api.player.model.ModelPlayerAPI;
import api.player.model.ModelPlayerBase;
import by.fxg.craftingdead.CDReloaded;
import by.fxg.craftingdead.client.model.ModelBush;
import by.fxg.craftingdead.client.render.guns.LeftHand;
import by.fxg.craftingdead.client.render.guns.RenderAKM;
import by.fxg.craftingdead.client.render.guns.RenderAS50;
import by.fxg.craftingdead.client.render.guns.RenderFNFAL;
import by.fxg.craftingdead.client.render.guns.RenderGun;
import by.fxg.craftingdead.client.render.guns.RenderM4A1;
import by.fxg.craftingdead.client.render.guns.RenderScarh;
import by.fxg.craftingdead.client.render.guns.RightHand;
import by.fxg.craftingdead.item.ItemManager;
import by.fxg.craftingdead.item.gun.ItemGun;
import by.fxg.craftingdead.player.PlayerData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ClientModelPlayer extends ModelPlayerBase {
	protected RightHand rh = new RightHand();
	protected LeftHand lh = new LeftHand();
	protected ModelBush bush = new ModelBush();

	public ClientModelPlayer(ModelPlayerAPI var1) {
		super(var1);
	}

	public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		EntityPlayer player = (EntityPlayer) var1;
		PlayerData data = CDReloaded.instance.playerDataHandler().getPlayerData(player);
		if (player.getHeldItem() != null) {
			ItemStack item = player.getHeldItem();
			if (item.getItem() instanceof ItemGun) {
				ItemGun gun = (ItemGun)item.getItem();
				boolean isOneHanded = gun == ItemManager.m1911 || gun == ItemManager.g18 || gun == ItemManager.m9 || gun == ItemManager.mac10 || gun == ItemManager.p90;
				this.modelPlayer.aimedBow = true;
				if (isOneHanded) {
					this.hide();
					this.hand(0, 0.0625F, player);
				} else {
					this.show();
				}
			} else {
				this.show();
			}
		} else {
			this.show();
		}
		super.render(var1, var2, var3, var4, var5, var6, var7);
	}
	
	private void hide() {
		this.modelPlayerAPI.getBipedLeftArmField().isHidden = true;
	}
	
	private void show() {
		this.modelPlayerAPI.getBipedLeftArmField().isHidden = false;
		this.modelPlayerAPI.getBipedRightArmField().isHidden = false;
	}
	
	private void hand(int handId, float f, EntityPlayer player) {
		if (handId == 0) {
			this.lh.render(f, player);
		} else {
			this.rh.render(f, player);
		}
	}
	
	private void handRotation(RenderGun igun, int h) {
		if (igun instanceof RenderAS50) {
			if (h == 0) {
				GL11.glTranslatef(0.1F, 0.1F, 0.25F);
				GL11.glRotatef(92.5F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 1.35F, 1.0F);
			} else if (h == 1) {
				GL11.glTranslatef(0.0F, -0.0F, 0.05F);
				GL11.glRotatef(40.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 0.75F, 1.0F);
			} else if (h == 2) {
				GL11.glScalef(1.0F, 1.0F, 0.70F);
				GL11.glTranslatef(0.0F, 0.1F, 0.1F);
				GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
			} else if (h == 3) {
				GL11.glTranslatef(0.0F, -0.05F, 0.075F);
				GL11.glRotatef(35.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F);
				GL11.glScalef(1.0F, 0.75F, 1.0F);
			}
		} else if (igun instanceof RenderM4A1) {
			if (h == 0) {
				GL11.glTranslatef(0.1F, 0.1F, 0.25F);
				GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(48.5F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 1.25F, 1.0F);
			} else if (h == 1) {
				GL11.glTranslatef(0.0F, -0.0F, 0.05F);
				GL11.glRotatef(33.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 0.9F, 1.0F);
			} else if (h == 2) {
				GL11.glScalef(1.0F, 1.0F, 0.675F);
				GL11.glTranslatef(0.0F, 0.1F, 0.1F);
				GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(5.0F, 0.0F, 0.0F, -1.0F);
			} else if (h == 3) {
				GL11.glTranslatef(0.0F, -0.05F, 0.075F);
				GL11.glRotatef(32.5F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F);
				GL11.glScalef(1.0F, 0.8F, 1.0F);
			}
		} else if (igun instanceof RenderScarh) {
			if (h == 0) {
				GL11.glTranslatef(0.1F, 0.1F, 0.25F);
				GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(48.5F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 1.25F, 1.0F);
			} else if (h == 1) {
				GL11.glTranslatef(0.0F, -0.0F, 0.05F);
				GL11.glRotatef(33.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 0.9F, 1.0F);
			} else if (h == 2) {
				GL11.glScalef(1.0F, 1.0F, 0.675F);
				GL11.glTranslatef(0.0F, 0.1F, 0.1F);
				GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(5.0F, 0.0F, 0.0F, -1.0F);
			} else if (h == 3) {
				GL11.glTranslatef(0.0F, -0.05F, 0.075F);
				GL11.glRotatef(32.5F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F);
				GL11.glScalef(1.0F, 0.85F, 1.0F);
			}
		} if (igun instanceof RenderAKM) {
			if (h == 0) {
				GL11.glTranslatef(0.1F, 0.1F, 0.25F);
				GL11.glRotatef(91.5F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(40.0F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 1.375F, 1.0F);
			} else if (h == 1) {
				GL11.glTranslatef(0.0F, -0.0F, 0.05F);
				GL11.glRotatef(33.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 0.9F, 1.0F);
			} else if (h == 2) {
				GL11.glScalef(1.0F, 1.0F, 0.75F);
				GL11.glTranslatef(0.0F, 0.1F, 0.1F);
				GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(10.0F, 0.0F, 0.0F, -1.0F);
			} else if (h == 3) {
				GL11.glTranslatef(0.0F, -0.05F, 0.075F);
				GL11.glRotatef(32.5F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F);
				GL11.glScalef(1.0F, 0.75F, 1.0F);
			}
		} else if (igun instanceof RenderFNFAL) {
			if (h == 0) {
				GL11.glTranslatef(0.1F, 0.1F, 0.25F);
				GL11.glRotatef(92.5F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(42.5F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 1.375F, 1.0F);
			} else if (h == 1) {
				GL11.glTranslatef(0.0F, -0.0F, 0.05F);
				GL11.glRotatef(33.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(5.0F, 0.0F, 0.0F, 1.0F);
				GL11.glScalef(1.0F, 0.9F, 1.0F);
			} else if (h == 2) {
				GL11.glScalef(1.0F, 1.0F, 0.75F);
				GL11.glTranslatef(0.0F, 0.1F, 0.1F);
				GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(10.0F, 0.0F, 0.0F, -1.0F);
			} else if (h == 3) {
				GL11.glTranslatef(0.0F, -0.05F, 0.075F);
				GL11.glRotatef(32.5F, -1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, -1.0F);
				GL11.glScalef(1.0F, 0.75F, 1.0F);
			}
		}
	}
}
