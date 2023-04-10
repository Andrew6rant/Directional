package io.github.andrew6rant.directional.mixin;

import com.google.gson.JsonObject;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.model.ModelRotation;
import net.minecraft.util.JsonHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(targets="net/minecraft/client/render/model/json/ModelVariant$Deserializer")
public class ModelVariantMixin {

    // thanks to unascribed of Lib39 for inspiration for this mixin
    @Inject(at=@At("HEAD"), method="deserializeRotation", cancellable=true)
    private void deserializeRotation(JsonObject object, CallbackInfoReturnable<ModelRotation> cir) {

    }
}
