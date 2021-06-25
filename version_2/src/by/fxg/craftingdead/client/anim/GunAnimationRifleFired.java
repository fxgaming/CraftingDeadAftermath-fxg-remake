package by.fxg.craftingdead.client.anim;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class GunAnimationRifleFired extends GunAnimation {
	private float trans1 = 0.0F;
	private float lastTrans1 = 0.0F;
	private float maxTrans1 = 0.3F;
	private boolean up = true;

	public void onUpdate(Minecraft par1, EntityPlayer par2, ItemStack par3) {
		this.lastTrans1 = this.trans1;
		float transSpeed = 0.075F;
		if (super.animationTicker == 1) this.up = false;
		if (this.up) this.trans1 += transSpeed * 40;
		else this.trans1 -= transSpeed * 2;
		if (this.trans1 > this.maxTrans1) this.trans1 = this.maxTrans1;
		if (this.trans1 < 0.0F) this.trans1 = 0.0F;
	}

	public void doRender(ItemStack par1, float par2, boolean isScope, boolean pre) {
		if (pre) {
			float transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
			if (isScope) {
				GL11.glTranslatef(-transprogress / 5.0F, -transprogress / 7.5F, -transprogress / 40.0F);
			} else {
				GL11.glTranslatef(-transprogress / 5.0F, -transprogress / 5.0F, 0.0F);
			}
		} else {
			float transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
			if (!isScope) {
				GL11.glTranslatef(-transprogress / 5.0F, -transprogress / 5.0F, 0.0F);
			}
		}
	}

	public void doRenderHand(ItemStack par1, float par2, boolean par3) {
		float transprogress;
		float rotprogress;
		if (par3) {
			transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
			GL11.glTranslatef(-transprogress, 0.0F, 0.0F);
		} else {
			transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
			GL11.glTranslatef(-transprogress, -transprogress * 0.5F, 0.0F);
		}
	}

	public void doRenderAmmo(ItemStack par1, float par2) {
	}

	public void onAnimationStopped(ItemStack par1) {
	}

	public float getMaxAnimationTick() {
		return 10.0F;
	}
}
