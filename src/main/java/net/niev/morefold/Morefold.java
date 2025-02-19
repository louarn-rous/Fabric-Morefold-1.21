package net.niev.morefold;

import net.fabricmc.api.ModInitializer;

import net.niev.morefold.block.ModBlocks;
import net.niev.morefold.item.ModItemGroups;
import net.niev.morefold.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Morefold implements ModInitializer {
	public static final String MOD_ID = "morefold";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
	}
}