package net.mcreator.glone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class XPSyringeEmptyItem extends Item {
	public XPSyringeEmptyItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}