package com.crumb.projectassembly.datagen;

import com.crumb.projectassembly.ProjectAssembly;
import com.crumb.projectassembly.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ProjectAssembly.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CRUSHER_MK1.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CRUSHER_MK1.get());
    }
}