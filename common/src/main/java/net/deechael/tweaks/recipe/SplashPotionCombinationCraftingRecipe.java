
package net.deechael.tweaks.recipe;

import net.deechael.tweaks.platform.Services;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;

public class SplashPotionCombinationCraftingRecipe extends AbstractPotionCombinationCraftingRecipe {

    public SplashPotionCombinationCraftingRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    protected Item getPotionType() {
        return Items.SPLASH_POTION;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Services.PLATFORM.getSplashPotionCombinationSerializer();
    }

}
