package net.niev.morefold.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.niev.morefold.Morefold;

public class ModBlocks {
    public static final Block ZINC_BLOCK = registerBlock("zinc_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool().strength(3F, 6F)
                    .sounds(BlockSoundGroup.METAL)
            ));
    public static final Block ZINC_ORE = registerBlock("zinc_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                            .requiresTool().strength(3F, 3F)
                            .sounds(BlockSoundGroup.STONE)
                            .mapColor(MapColor.STONE_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
            ));
    public static final Block DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    AbstractBlock.Settings.create()
                            .requiresTool().strength(4F, 4F)
                            .sounds(BlockSoundGroup.DEEPSLATE)
                            .mapColor(MapColor.DEEPSLATE_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
            ));
    public static final Block RAW_ZINC_BLOCK = registerBlock("raw_zinc_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool().strength(5F, 6F)
                    .sounds(BlockSoundGroup.METAL)
                    .instrument(NoteBlockInstrument.BASEDRUM)
            ));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool().strength(3F, 6F)
                    .sounds(BlockSoundGroup.METAL)
            ));
    public static final Block TIN_ORE = registerBlock("tin_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create()
                            .requiresTool().strength(3F, 3F)
                            .sounds(BlockSoundGroup.STONE)
                            .mapColor(MapColor.STONE_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
            ));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                    AbstractBlock.Settings.create()
                            .requiresTool().strength(4F, 4F)
                            .sounds(BlockSoundGroup.DEEPSLATE)
                            .mapColor(MapColor.DEEPSLATE_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
            ));
    public static final Block RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool().strength(5F, 6F)
                    .sounds(BlockSoundGroup.METAL)
                    .instrument(NoteBlockInstrument.BASEDRUM)
            ));
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool().strength(4F, 6F)
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block CRACKED_STONE_BRICK_WALL = registerBlock("cracked_stone_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_WALL)));
    public static final Block CRACKED_STONE_BRICK_SLAB = registerBlock("cracked_stone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICK_SLAB)));
    public static final Block CRACKED_STONE_BRICK_STAIRS = registerBlock("cracked_stone_brick_stairs",
            new StairsBlock(Blocks.STONE_BRICK_STAIRS.getDefaultState(), AbstractBlock.Settings.copyShallow(Blocks.STONE_BRICK_STAIRS)));

    public static final Block CRACKED_NETHER_BRICK_WALL = registerBlock("cracked_nether_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_WALL)));
    public static final Block CRACKED_NETHER_BRICK_SLAB = registerBlock("cracked_nether_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_SLAB)));
    public static final Block CRACKED_NETHER_BRICK_STAIRS = registerBlock("cracked_nether_brick_stairs",
            new StairsBlock(Blocks.NETHER_BRICK_STAIRS.getDefaultState(), AbstractBlock.Settings.copyShallow(Blocks.NETHER_BRICK_STAIRS)));

    public static final Block CRACKED_DEEPSLATE_BRICK_WALL = registerBlock("cracked_deepslate_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICK_WALL)));
    public static final Block CRACKED_DEEPSLATE_BRICK_SLAB = registerBlock("cracked_deepslate_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICK_SLAB)));
    public static final Block CRACKED_DEEPSLATE_BRICK_STAIRS = registerBlock("cracked_deepslate_brick_stairs",
            new StairsBlock(Blocks.DEEPSLATE_BRICK_STAIRS.getDefaultState(), AbstractBlock.Settings.copyShallow(Blocks.DEEPSLATE_BRICK_STAIRS)));

    public static final Block CRACKED_DEEPSLATE_TILE_WALL = registerBlock("cracked_deepslate_tile_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILE_WALL)));
    public static final Block CRACKED_DEEPSLATE_TILE_SLAB = registerBlock("cracked_deepslate_tile_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILE_SLAB)));
    public static final Block CRACKED_DEEPSLATE_TILE_STAIRS = registerBlock("cracked_deepslate_tile_stairs",
            new StairsBlock(Blocks.DEEPSLATE_TILE_STAIRS.getDefaultState(), AbstractBlock.Settings.copyShallow(Blocks.DEEPSLATE_TILE_STAIRS)));

    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = registerBlock("cracked_polished_blackstone_brick_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICK_WALL)));
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = registerBlock("cracked_polished_blackstone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB)));
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = registerBlock("cracked_polished_blackstone_brick_stairs",
            new StairsBlock(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS.getDefaultState(), AbstractBlock.Settings.copyShallow(Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS)));




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
            entries.add(ModBlocks.ZINC_BLOCK);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.ZINC_ORE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.DEEPSLATE_ZINC_ORE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.RAW_ZINC_BLOCK);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.TIN_BLOCK);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.TIN_ORE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.DEEPSLATE_TIN_ORE);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.RAW_TIN_BLOCK);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.BRONZE_BLOCK);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_STONE_BRICK_WALL);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_STONE_BRICK_SLAB);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_STONE_BRICK_STAIRS);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_NETHER_BRICK_WALL);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_NETHER_BRICK_SLAB);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_NETHER_BRICK_STAIRS);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_DEEPSLATE_TILE_WALL);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS);});

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);});
    }
}
