package com.crumb.projectassembly.item;

import com.crumb.projectassembly.ProjectAssembly;
import com.crumb.projectassembly.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectAssembly.MOD_ID);

    public static final Supplier<CreativeModeTab> PROJECTASSEMBLY_ITEMS_TAB = CREATIVE_MODE_TAB.register("projectassembly_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CRUSHER_MK1.get()))
                    .title(Component.translatable("creativetab.projectassembly.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.CRUSHER_MK1);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}