package net.deechael.tweaks.forge;

import net.deechael.tweaks.Constants;
import net.deechael.tweaks.DeesTweaks;
import net.deechael.tweaks.forge.registry.RecipeSerializerRegistry;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class DeesTweaksForge {
    
    public DeesTweaksForge() {
        DeesTweaks.init();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        RecipeSerializerRegistry.init(eventBus);
    }

}