package net.mcreator.glone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class XPSyringeFullItem extends Item {
	public XPSyringeFullItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}