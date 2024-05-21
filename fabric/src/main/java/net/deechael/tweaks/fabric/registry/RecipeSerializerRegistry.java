package net.deechael.tweaks.fabric.registry;

import net.deechael.tweaks.Constants;
import net.deechael.tweaks.recipe.LingeringPotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.PotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.SplashPotionCombinationCraftingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public final class RecipeSerializerRegistry {

    public static SimpleCraftingRecipeSerializer<PotionCombinationCraftingRecipe> POTION_COMBINATION;
    public static SimpleCraftingRecipeSerializer<SplashPotionCombinationCraftingRecipe> SPLASH_POTION_COMBINATION;
    public static SimpleCraftingRecipeSerializer<LingeringPotionCombinationCraftingRecipe> LINGERING_POTION_COMBINATION;

    public static void init() {
        POTION_COMBINATION = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                new ResourceLocation(Constants.MOD_ID, "potion_combination"),
                new SimpleCraftingRecipeSerializer<>(PotionCombinationCraftingRecipe::new)
        );
        SPLASH_POTION_COMBINATION = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                new ResourceLocation(Constants.MOD_ID, "splash_potion_combination"),
                new SimpleCraftingRecipeSerializer<>(SplashPotionCombinationCraftingRecipe::new)
        );
        LINGERING_POTION_COMBINATION = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                new ResourceLocation(Constants.MOD_ID, "lingering_potion_combination"),
                new SimpleCraftingRecipeSerializer<>(LingeringPotionCombinationCraftingRecipe::new)
        );
    }

    private RecipeSerializerRegistry() {
    }

}
