package net.deechael.tweaks.recipe;

import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.IntTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPotionCombinationCraftingRecipe extends CustomRecipe {

    public AbstractPotionCombinationCraftingRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    public boolean matches(@NotNull CraftingContainer container, @NotNull Level level) {
        return container.hasAnyMatching(item -> item.is(this.getPotionType()) && !item.isEmpty())
                && !container.hasAnyMatching(item -> !item.is(this.getPotionType()) && !item.isEmpty());
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingContainer container, @NotNull RegistryAccess registry) {
        List<MobEffectInstance> effects = new ArrayList<>();

        int colorR = 0;
        int colorG = 0;
        int colorB = 0;
        int potionCount = 0;

        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);

            if (stack.isEmpty())
                continue;
            effects.addAll(PotionUtils.getMobEffects(stack));

            int color = PotionUtils.getColor(stack);
            colorR += color >> 16;
            colorG += color >> 8 & 0xFF;
            colorB += color & 0xFF;

            potionCount++;
        }

        ItemStack result = PotionUtils.setCustomEffects(new ItemStack(this.getPotionType()), effects);
        result.addTagElement(
                "CustomPotionColor",
                IntTag.valueOf(
                        (colorR / potionCount << 16) +
                                (colorG / potionCount << 8) +
                                (colorB / potionCount)
                )
        );
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height > 2;
    }

    protected abstract Item getPotionType();

}
