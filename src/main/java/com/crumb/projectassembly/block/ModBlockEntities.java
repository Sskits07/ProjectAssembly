package com.crumb.projectassembly.block;

import com.crumb.projectassembly.ProjectAssembly;
import com.crumb.projectassembly.block.entity.CrusherMK1BlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ProjectAssembly.MOD_ID);

    public static final Supplier<BlockEntityType<CrusherMK1BlockEntity>> CRUSHER_MK1_BE =
            BLOCK_ENTITIES.register("crusher_mk1_be", () -> new BlockEntityType<>(
                    CrusherMK1BlockEntity::new, ModBlocks.CRUSHER_MK1.get()));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}