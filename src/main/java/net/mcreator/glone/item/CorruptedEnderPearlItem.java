package net.mcreator.glone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CorruptedEnderPearlItem extends Item {
	public CorruptedEnderPearlItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}
}