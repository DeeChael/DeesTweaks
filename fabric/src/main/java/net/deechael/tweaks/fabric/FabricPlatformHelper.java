package net.deechael.tweaks.fabric;

import net.deechael.tweaks.fabric.registry.RecipeSerializerRegistry;
import net.deechael.tweaks.platform.services.IPlatformHelper;
import net.deechael.tweaks.recipe.LingeringPotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.PotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.SplashPotionCombinationCraftingRecipe;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public RecipeSerializer<PotionCombinationCraftingRecipe> getPotionCombinationSerializer() {
        return RecipeSerializerRegistry.POTION_COMBINATION;
    }

    @Override
    public RecipeSerializer<SplashPotionCombinationCraftingRecipe> getSplashPotionCombinationSerializer() {
        return RecipeSerializerRegistry.SPLASH_POTION_COMBINATION;
    }

    @Override
    public RecipeSerializer<LingeringPotionCombinationCraftingRecipe> getLingeringPotionCombinationSerializer() {
        return RecipeSerializerRegistry.LINGERING_POTION_COMBINATION;
    }

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

}
