package io.github.andrew6rant.directional;

import io.github.andrew6rant.directional.model.FlowerPotModelProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.BakedModelManager;

@Environment(EnvType.CLIENT)

public class DirectionalClient implements ClientModInitializer {
    public static BakedModelManager modelManager;
    @Override
    public void onInitializeClient() {
        //modelManager = MinecraftClient.getInstance().getBakedModelManager();
        //ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new FlowerPotModelProvider());

        //ServerLifecycleEvents.SERVER_STARTED.register(server -> {
        //    modelManager = MinecraftClient.getInstance().getBakedModelManager();
        //    ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new FlowerPotModelProvider());
        //});
        //ServerLifecycleEvents.END_DATA_PACK_RELOAD.register((server, resourceManager, success) -> {
        //    modelManager = MinecraftClient.getInstance().getBakedModelManager();
        //    ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new FlowerPotModelProvider());
        //});
    }
}
