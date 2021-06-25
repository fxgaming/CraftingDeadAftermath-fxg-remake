package by.fxg.craftingdead.client.anim;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class GunAnimationPistolFired extends GunAnimation {
	private float trans1 = 0.0F;
	private float lastTrans1 = 0.0F;
	private float maxTrans1 = 0.25F;
	private boolean up = true;

	public void onUpdate(Minecraft par1, EntityPlayer par2, ItemStack par3) {
		this.lastTrans1 = this.trans1;
		float transSpeed = 0.175F;
		if (super.animationTicker == 1) this.up = false;
		if (this.up) this.trans1 += transSpeed * 5;
		else this.trans1 -= transSpeed;
		if (this.trans1 > this.maxTrans1) this.trans1 = this.maxTrans1;
		if (this.trans1 < 0.0F) this.trans1 = 0.0F;
	}

	public void doRender(ItemStack par1, float par2, boolean par3, boolean pre) {
		if (!pre) {
			if (!par3) {
				float transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
				if (par3) transprogress = transprogress / 2.0F;
				GL11.glTranslatef(-transprogress / 2.0F, -transprogress / 4.0F, 0.0F);
			} else {
				float transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
				if (par3) transprogress = transprogress / 2.0F;
				GL11.glTranslatef(-transprogress * 1.5F, -transprogress / 3.0F, 0.0F);
			}
		}
	}

	public void doRenderHand(ItemStack par1, float par2, boolean par3) {
		float transprogress = this.lastTrans1 + (this.trans1 - this.lastTrans1) * par2;
		GL11.glTranslatef(-transprogress, 0.0F, 0.0F);
	}

	public void doRenderAmmo(ItemStack par1, float par2) {
	}

	public void onAnimationStopped(ItemStack par1) {
	}

	public float getMaxAnimationTick() {
		return 6.0F;
	}
}
