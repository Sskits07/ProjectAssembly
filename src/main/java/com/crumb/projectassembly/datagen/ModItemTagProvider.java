package com.crumb.projectassembly.datagen;

import com.crumb.projectassembly.ProjectAssembly;
import com.crumb.projectassembly.item.ModItems;
import com.crumb.projectassembly.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ProjectAssembly.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.CRUSHABLE_ITEMS)
                .add(Items.RAW_COPPER)
                .add(Items.RAW_IRON)
                .add(Items.RAW_GOLD);

        tag(ModTags.Items.GRINDABLE_ITEMS)
                .add(ModItems.IRON_CLUMP.get());
    }
}