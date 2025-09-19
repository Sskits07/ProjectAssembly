package com.crumb.projectassembly.datagen;

import com.crumb.projectassembly.ProjectAssembly;
import com.crumb.projectassembly.block.ModBlocks;
import com.crumb.projectassembly.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, ProjectAssembly.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.IRON_CLUMP.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(ModBlocks.CRUSHER_MK1.get());
    }
}