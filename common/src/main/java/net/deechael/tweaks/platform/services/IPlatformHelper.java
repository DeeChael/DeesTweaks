package net.deechael.tweaks.platform.services;

import net.deechael.tweaks.recipe.LingeringPotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.PotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.SplashPotionCombinationCraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public interface IPlatformHelper {

    RecipeSerializer<PotionCombinationCraftingRecipe> getPotionCombinationSerializer();

    RecipeSerializer<SplashPotionCombinationCraftingRecipe> getSplashPotionCombinationSerializer();

    RecipeSerializer<LingeringPotionCombinationCraftingRecipe> getLingeringPotionCombinationSerializer();

    String getPlatformName();

    boolean isModLoaded(String modId);

    boolean isDevelopmentEnvironment();

    default String getEnvironmentName() {
        return isDevelopmentEnvironment() ? "development" : "production";
    }

}