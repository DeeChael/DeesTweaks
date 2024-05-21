package net.deechael.tweaks.recipe;

import net.deechael.tweaks.platform.Services;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.IntTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PotionCombinationCraftingRecipe extends AbstractPotionCombinationCraftingRecipe {

    public PotionCombinationCraftingRecipe(ResourceLocation id, CraftingBookCategory category) {
        super(id, category);
    }

    @Override
    protected Item getPotionType() {
        return Items.POTION;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Services.PLATFORM.getPotionCombinationSerializer();
    }

    @Override
    public @NotNull NonNullList<ItemStack> getRemainingItems(@NotNull CraftingContainer container) {
        NonNullList<ItemStack> reminder = NonNullList.create();
        boolean first = true;
        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);
            if (stack.is(Items.POTION)) {
                if (first) {
                    first = false;
                    reminder.add(ItemStack.EMPTY);
                } else {
                    reminder.add(new ItemStack(Items.GLASS_BOTTLE));
                }
            } else {
                reminder.add(ItemStack.EMPTY);
            }
        }
        return reminder;
    }

}
