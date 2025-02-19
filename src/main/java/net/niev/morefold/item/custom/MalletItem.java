package net.niev.morefold.item.custom;

import java.util.Collection;
import java.util.Map;

import net.minecraft.block.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.DebugStickStateComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.item.ItemUsageContext;
import net.niev.morefold.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class MalletItem extends Item {
    private static final Map<Block, Block> MALLET_MAP =
            Map.of(
                    Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS,
                    // Blocks.STONE_BRICK_SLAB, ModBlocks.CRACKED_STONE_BRICK_SLAB,
                    // Blocks.STONE_BRICK_STAIRS, ModBlocks.CRACKED_STONE_BRICK_STAIRS,
                    // Blocks.STONE_BRICK_WALL, ModBlocks.CRACKED_STONE_BRICK_WALL,
                    Blocks.DEEPSLATE_BRICKS, Blocks.CRACKED_DEEPSLATE_BRICKS,
                    // Blocks.DEEPSLATE_BRICK_SLAB, ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB,
                    // Blocks.DEEPSLATE_BRICK_STAIRS, ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS,
                    // Blocks.DEEPSLATE_BRICK_WALL, ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL,
                    Blocks.DEEPSLATE_TILES, Blocks.CRACKED_DEEPSLATE_TILES,
                    // Blocks.DEEPSLATE_TILE_SLAB, ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB,
                    // Blocks.DEEPSLATE_TILE_STAIRS, ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS,
                    // Blocks.DEEPSLATE_TILE_WALL, ModBlocks.CRACKED_DEEPSLATE_TILE_WALL,
                    Blocks.NETHER_BRICKS, Blocks.CRACKED_NETHER_BRICKS,
                    // Blocks.NETHER_BRICK_SLAB, ModBlocks.CRACKED_NETHER_BRICK_SLAB,
                    // Blocks.NETHER_BRICK_STAIRS, ModBlocks.CRACKED_NETHER_BRICK_STAIRS,
                    // Blocks.NETHER_BRICK_WALL, ModBlocks.CRACKED_NETHER_BRICK_WALL,
                    Blocks.POLISHED_BLACKSTONE_BRICKS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS
                    // Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB
                    //Blocks.POLISHED_BLACKSTONE_BRICK_STAIRS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS,
                    //Blocks.POLISHED_BLACKSTONE_BRICK_WALL, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL
            );

    public MalletItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        Block targetBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(MALLET_MAP.containsKey(targetBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), MALLET_MAP.get(targetBlock).getDefaultState());

                // use up durability
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                // play a sound
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
            // if (!this.use(player, world.getBlockState(pos), world, pos, true, context.getStack())) {return ActionResult.FAIL;}
        }
        return ActionResult.SUCCESS;
    }

    private boolean use(PlayerEntity player, BlockState state, WorldAccess world, BlockPos pos, boolean update, ItemStack stack) {
        Block block = state.getBlock();

        // Allow only Stairs, Walls, and Slabs
        if (!(block instanceof StairsBlock || block instanceof WallBlock || block instanceof SlabBlock)) {
            return false;
        }

        RegistryEntry<Block> registryEntry = state.getRegistryEntry();
        StateManager<Block, BlockState> stateManager = registryEntry.value().getStateManager();
        Collection<Property<?>> properties = stateManager.getProperties();

        // Remove 'waterlogged' property from consideration
        properties.removeIf(prop -> prop.getName().equals("waterlogged"));

        if (properties.isEmpty()) {
            sendMessage(player, Text.translatable(this.getTranslationKey() + ".empty", registryEntry.getIdAsString()));
            return false;
        }

        DebugStickStateComponent debugStickStateComponent = stack.get(DataComponentTypes.DEBUG_STICK_STATE);
        if (debugStickStateComponent == null) {
            return false;
        }

        Property<?> property = debugStickStateComponent.properties().get(registryEntry);
        if (update) {
            if (property == null) {
                property = properties.iterator().next();
            }

            BlockState blockState = cycle(state, property, player.shouldCancelInteraction());
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS | Block.FORCE_STATE);
            sendMessage(player, Text.translatable(this.getTranslationKey() + ".update", property.getName(), getValueString(blockState, property)));
        } else {
            property = cycle(properties, property, player.shouldCancelInteraction());
            stack.set(DataComponentTypes.DEBUG_STICK_STATE, debugStickStateComponent.with(registryEntry, property));
            sendMessage(player, Text.translatable(this.getTranslationKey() + ".select", property.getName(), getValueString(state, property)));
        }

        return true;
    }

    private static <T extends Comparable<T>> BlockState cycle(BlockState state, Property<T> property, boolean inverse) {
        return state.with(property, cycle(property.getValues(), state.get(property), inverse));
    }

    private static <T> T cycle(Iterable<T> elements, @Nullable T current, boolean inverse) {
        return inverse ? Util.previous(elements, current) : Util.next(elements, current);
    }

    private static void sendMessage(PlayerEntity player, Text message) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            serverPlayer.sendMessageToClient(message, true);
        }
    }

    private static <T extends Comparable<T>> String getValueString(BlockState state, Property<T> property) {
        return property.name(state.get(property));
    }
}
