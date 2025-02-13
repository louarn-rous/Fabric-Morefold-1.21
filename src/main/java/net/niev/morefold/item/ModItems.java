package net.niev.morefold.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.niev.morefold.Morefold;

public class ModItems {
    public static final Item VEGETABLE_STEW = registerItem("vegetable_stew", new Item(new Item.Settings()));
    public static final Item MALLET = registerItem("mallet", new Item(new Item.Settings()));
    public static final Item ZINC_ORE = registerItem("zinc_ore", new Item(new Item.Settings()));
    public static final Item ZINC_BLOCK = registerItem("zinc_block", new Item(new Item.Settings()));
    public static final Item TIN_ORE = registerItem("tin_ore", new Item(new Item.Settings()));
    public static final Item TIN_BLOCK = registerItem("tin_block", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Morefold.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Morefold.LOGGER.info("Registering mod items for " + Morefold.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(VEGETABLE_STEW);
            entries.add(MALLET);
            entries.add(ZINC_ORE);
            entries.add(ZINC_BLOCK);
            entries.add(TIN_ORE);
            entries.add(TIN_BLOCK);
        });
    }
}
