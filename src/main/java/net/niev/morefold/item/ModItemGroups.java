package net.niev.morefold.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.niev.morefold.Morefold;
import net.niev.morefold.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup MOREFOLD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Morefold.MOD_ID, "morefold_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BRONZE_BLOCK))
                    .displayName(Text.translatable("itemgroup.morefold.morefold_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ZINC_ORE);
                        entries.add(ModBlocks.DEEPSLATE_ZINC_ORE);
                        entries.add(ModItems.RAW_ZINC);
                        entries.add(ModBlocks.RAW_ZINC_BLOCK);
                        entries.add(ModItems.ZINC_INGOT);
                        entries.add(ModBlocks.ZINC_BLOCK);
                        entries.add(ModBlocks.TIN_ORE);
                        entries.add(ModBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(ModItems.RAW_TIN);
                        entries.add(ModBlocks.RAW_TIN_BLOCK);
                        entries.add(ModItems.TIN_INGOT);
                        entries.add(ModBlocks.TIN_BLOCK);
                        entries.add(ModItems.BRONZE_INGOT);
                        entries.add(ModBlocks.BRONZE_BLOCK);

                        entries.add(ModBlocks.CRACKED_STONE_BRICK_SLAB);
                        entries.add(ModBlocks.CRACKED_STONE_BRICK_STAIRS);
                        entries.add(ModBlocks.CRACKED_STONE_BRICK_WALL);
                        entries.add(ModBlocks.CRACKED_NETHER_BRICK_SLAB);
                        entries.add(ModBlocks.CRACKED_NETHER_BRICK_STAIRS);
                        entries.add(ModBlocks.CRACKED_NETHER_BRICK_WALL);
                        entries.add(ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB);
                        entries.add(ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS);
                        entries.add(ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL);
                        entries.add(ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB);
                        entries.add(ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS);
                        entries.add(ModBlocks.CRACKED_DEEPSLATE_TILE_WALL);
                        entries.add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);
                        entries.add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);
                        entries.add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);

                        entries.add(ModItems.VEGETABLE_STEW);
                        entries.add(ModItems.MALLET);

                    }).build());

    public static void registerItemGroups() {
        Morefold.LOGGER.info("Registering item groups for " + Morefold.MOD_ID);
    }
}
