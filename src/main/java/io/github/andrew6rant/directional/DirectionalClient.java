package io.github.andrew6rant.directional;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.BakedModelManager;


@Environment(EnvType.CLIENT)

public class DirectionalClient implements ClientModInitializer {
    public static BakedModelManager modelManager;
    @Override
    public void onInitializeClient() {

    }
}
