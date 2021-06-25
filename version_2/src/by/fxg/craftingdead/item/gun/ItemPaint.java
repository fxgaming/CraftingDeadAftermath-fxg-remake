package by.fxg.craftingdead.item.gun;

import java.util.ArrayList;
import java.util.List;

import by.fxg.craftingdead.item.ItemCD;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemPaint extends ItemCD {
	public GunPaint paintReference;
	private ArrayList list = new ArrayList();

	public ItemPaint(int par1, GunPaint par2) {
		super(par1);
		this.paintReference = par2;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		par3List.add("Доступное оружие");
		int i;
		if (this.list.size() == 0) {
			for (i = 0; i < Item.itemsList.length; ++i) {
				if (Item.itemsList[i] != null && Item.itemsList[i] instanceof ItemGun && ((ItemGun) Item.itemsList[i]).isSkinAllowed(this.paintReference)) {
					this.list.add(Item.itemsList[i].itemID);
				}
			}
		}
		for (i = 0; i < this.list.size(); ++i) {
			ItemStack stack = new ItemStack((Integer) this.list.get(i), 1, 0);
			par3List.add(EnumChatFormatting.RED + "" + stack.getDisplayName());
		}
	}
}
