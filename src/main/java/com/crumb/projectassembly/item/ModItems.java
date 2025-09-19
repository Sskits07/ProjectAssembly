package com.crumb.projectassembly.item;

import com.crumb.projectassembly.ProjectAssembly;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ProjectAssembly.MOD_ID);

    public static final DeferredItem<Item> IRON_CLUMP = ITEMS.registerItem("iron_clump",
            Item::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}