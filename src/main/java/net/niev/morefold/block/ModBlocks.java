package net.niev.morefold.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.niev.morefold.Morefold;

public class ModBlocks {
    public static final Block ZINC_BLOCK = registerBlock("zinc_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(5F, 6F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            )
    );
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(5F, 6F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            )
    );


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Morefold.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Morefold.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Morefold.LOGGER.info("Registering mod block for " + Morefold.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.ZINC_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.TIN_BLOCK);
        });
    }
}
