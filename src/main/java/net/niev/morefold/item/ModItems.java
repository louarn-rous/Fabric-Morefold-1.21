package net.niev.morefold.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.niev.morefold.Morefold;
import net.niev.morefold.item.custom.MalletItem;

public class ModItems {
    public static final Item RAW_ZINC = registerItem("raw_zinc", new Item(new Item.Settings()));
    public static final Item ZINC_INGOT = registerItem("zinc_ingot", new Item(new Item.Settings()));
    public static final Item RAW_TIN = registerItem("raw_tin", new Item(new Item.Settings()));
    public static final Item TIN_INGOT = registerItem("tin_ingot", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));

    public static final Item VEGETABLE_STEW = registerItem("vegetable_stew", new Item(new Item.Settings().food(ModFoodComponents.VEGETABLE_STEW)));
    public static final Item MALLET = registerItem("mallet", new MalletItem(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Morefold.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Morefold.LOGGER.info("Registering mod items for " + Morefold.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_ZINC);
            entries.add(ZINC_INGOT);
            entries.add(RAW_TIN);
            entries.add(TIN_INGOT);
            entries.add(BRONZE_INGOT);
            entries.add(VEGETABLE_STEW);
            entries.add(MALLET);
        });
    }
}
