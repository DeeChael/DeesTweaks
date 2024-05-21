package net.deechael.tweaks.forge.registry;

import net.deechael.tweaks.Constants;
import net.deechael.tweaks.recipe.LingeringPotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.PotionCombinationCraftingRecipe;
import net.deechael.tweaks.recipe.SplashPotionCombinationCraftingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializerRegistry {

    private final static DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Constants.MOD_ID);

    public final static RegistryObject<RecipeSerializer<PotionCombinationCraftingRecipe>> POTION_COMBINATION = SERIALIZERS.register("potion_combination", () -> new SimpleCraftingRecipeSerializer<>(PotionCombinationCraftingRecipe::new));
    public final static RegistryObject<RecipeSerializer<SplashPotionCombinationCraftingRecipe>> SPLASH_POTION_COMBINATION = SERIALIZERS.register("splash_potion_combination", () -> new SimpleCraftingRecipeSerializer<>(SplashPotionCombinationCraftingRecipe::new));
    public final static RegistryObject<RecipeSerializer<LingeringPotionCombinationCraftingRecipe>> LINGERING_POTION_COMBINATION = SERIALIZERS.register("lingering_potion_combination", () -> new SimpleCraftingRecipeSerializer<>(LingeringPotionCombinationCraftingRecipe::new));

    public static void init(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

}
