package io.github.andrew6rant.directional.model;

import io.github.andrew6rant.directional.DirectionalClient;
import net.fabricmc.fabric.api.client.model.BakedModelManagerHelper;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.BakedModelManager;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class FlowerPotModelProvider implements ModelResourceProvider {

    @Override
    public @Nullable UnbakedModel loadModelResource(Identifier resourceId, ModelProviderContext context) throws ModelProviderException {
        //System.out.println("Loading model"+ BakedModelManager.getModel(resourceId));
        BakedModelManager modelManager = MinecraftClient.getInstance().getBakedModelManager();
        System.out.println("Loading model"+ BakedModelManagerHelper.getModel(modelManager, resourceId));
        if(Registries.BLOCK.get(resourceId) instanceof FlowerPotBlock) {
            System.out.println("found! "+resourceId);
            return new FlowerPotModel();
        } else {
            return null;
        }
    }
}
