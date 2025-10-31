/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.glone.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.glone.item.XPSyringeFullItem;
import net.mcreator.glone.item.XPSyringeEmptyItem;
import net.mcreator.glone.item.CorruptedEnderPearlItem;
import net.mcreator.glone.GloneMod;

public class GloneModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, GloneMod.MODID);
	public static final RegistryObject<Item> CORRUPTED_ENDER_PEARL = REGISTRY.register("corrupted_ender_pearl", () -> new CorruptedEnderPearlItem());
	public static final RegistryObject<Item> XP_SYRINGE_EMPTY = REGISTRY.register("xp_syringe_empty", () -> new XPSyringeEmptyItem());
	public static final RegistryObject<Item> XP_SYRINGE_FULL = REGISTRY.register("xp_syringe_full", () -> new XPSyringeFullItem());
	// Start of user code block custom items
	// End of user code block custom items
}