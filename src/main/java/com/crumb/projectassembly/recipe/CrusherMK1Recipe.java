package com.crumb.projectassembly.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public record CrusherMK1Recipe(Ingredient inputItem, ItemStack output) implements Recipe<CrusherMK1RecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // GrowthChamberRecipeInput --> INVENTORY of the Block Entity

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(CrusherMK1RecipeInput crusherMK1RecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(crusherMK1RecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(CrusherMK1RecipeInput crusherMK1RecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<CrusherMK1RecipeInput>> getSerializer() {
        return ModRecipes.CRUSHER_MK1_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<CrusherMK1RecipeInput>> getType() {
        return ModRecipes.CRUSHER_MK1_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(inputItem);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<CrusherMK1Recipe> {
        public static final MapCodec<CrusherMK1Recipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(CrusherMK1Recipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CrusherMK1Recipe::output)
        ).apply(inst, CrusherMK1Recipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CrusherMK1Recipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, CrusherMK1Recipe::inputItem,
                        ItemStack.STREAM_CODEC, CrusherMK1Recipe::output,
                        CrusherMK1Recipe::new);

        @Override
        public MapCodec<CrusherMK1Recipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CrusherMK1Recipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}