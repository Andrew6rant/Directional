package io.github.andrew6rant.directional;

import io.github.andrew6rant.directional.model.FlowerPotModelProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.registry.Registries;
import virtuoel.statement.api.StateRefresher;

import static io.github.andrew6rant.directional.PlacementUtil.DIRECTIONAL;

@Environment(EnvType.CLIENT)

public class DirectionalClient implements ClientModInitializer {
    public static BakedModelManager modelManager;
    @Override
    public void onInitializeClient() {
        for (Block block : Registries.BLOCK) {
            if (block instanceof RedstoneBlock || block instanceof PistonBlock) {
                //block.
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
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
