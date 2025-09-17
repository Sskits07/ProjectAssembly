package com.crumb.projectassembly.datagen;

import com.crumb.projectassembly.ProjectAssembly;
import com.crumb.projectassembly.block.ModBlocks;
import com.crumb.projectassembly.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ProjectAssembly.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}