package com.crumb.projectassembly.util;

import com.crumb.projectassembly.ProjectAssembly;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ProjectAssembly.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> CRUSHABLE_ITEMS = createTag("crushable_items");
        public static final TagKey<Item> GRINDABLE_ITEMS = createTag("grindable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ProjectAssembly.MOD_ID, name));
        }
    }
}