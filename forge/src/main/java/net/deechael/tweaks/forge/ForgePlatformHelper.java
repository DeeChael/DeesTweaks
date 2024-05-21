package net.deechael.tweaks.forge;

import net.deechael.tweaks.forge.registry.RecipeSerializerRegistry;
import net.deechael.tweaks.platform.services.IPlatformHelper;
import net.deechael.tweaks.recipe.LingeringPotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.PotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.SplashPotionCombinationCraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public RecipeSerializer<PotionCombinationCraftingRecipe> getPotionCombinationSerializer() {
        return RecipeSerializerRegistry.POTION_COMBINATION.get();
    }

    @Override
    public RecipeSerializer<SplashPotionCombinationCraftingRecipe> getSplashPotionCombinationSerializer() {
        return RecipeSerializerRegistry.SPLASH_POTION_COMBINATION.get();
    }

    @Override
    public RecipeSerializer<LingeringPotionCombinationCraftingRecipe> getLingeringPotionCombinationSerializer() {
        return RecipeSerializerRegistry.LINGERING_POTION_COMBINATION.get();
    }

    @Override
    public String getPlatformName() {
        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

}