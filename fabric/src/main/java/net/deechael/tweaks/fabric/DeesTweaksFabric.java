package net.deechael.tweaks.fabric;

import net.deechael.tweaks.Constants;
import net.deechael.tweaks.DeesTweaks;
import net.deechael.tweaks.fabric.registry.RecipeSerializerRegistry;
import net.fabricmc.api.ModInitializer;

public class DeesTweaksFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        DeesTweaks.init();
        RecipeSerializerRegistry.init();
    }

}
