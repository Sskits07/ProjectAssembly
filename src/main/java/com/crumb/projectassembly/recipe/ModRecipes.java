package com.crumb.projectassembly.recipe;

import com.crumb.projectassembly.ProjectAssembly;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, ProjectAssembly.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, ProjectAssembly.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CrusherMK1Recipe>> CRUSHER_MK1_SERIALIZER =
            SERIALIZERS.register("crusher_mk1", CrusherMK1Recipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<CrusherMK1Recipe>> CRUSHER_MK1_TYPE =
            TYPES.register("crusher_mk1", () -> new RecipeType<CrusherMK1Recipe>() {
                @Override
                public String toString() {
                    return "crusher_mk1";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}