package io.github.andrew6rant.directional.mixin;

import io.github.andrew6rant.directional.PlacementUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(value = BlockModelRenderer.class, priority = 2)
public class BlockModelRendererMixin {

    @Inject(method = "render(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/client/render/model/BakedModel;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;ZLnet/minecraft/util/math/random/Random;JI)V",
            at = @At(value = "HEAD"))
    private void rotateModel(BlockRenderView world, BakedModel model, BlockState state, BlockPos pos, MatrixStack matrices, VertexConsumer vertexConsumer, boolean cull, Random random, long seed, int overlay, CallbackInfo ci) {
        System.out.println("not ok");
        if (state.contains(PlacementUtil.DIRECTIONAL)) {
            //MatrixStack matrixStack = new MatrixStack();
            //matrixStack.translate();
            //matrixStack.push();
            //Matrix4f positionMatrix = matrixStack.peek().getPositionMatrix();
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(10));
            //matrixStack.pop();
            System.out.println("okay");
        }
    }

    /*@Inject(method = "render(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/client/render/model/BakedModel;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;ZLnet/minecraft/util/math/random/Random;JI)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(DDD)V", shift = At.Shift.AFTER))
    private void rotateModel(BlockRenderView world, BakedModel model, BlockState state, BlockPos pos, MatrixStack matrices, VertexConsumer vertexConsumer, boolean cull, Random random, long seed, int overlay, CallbackInfo ci) {
        System.out.println("not ok");
        if (state.contains(PlacementUtil.DIRECTIONAL)) {
            //MatrixStack matrixStack = new MatrixStack();
            //matrixStack.translate();
            //matrixStack.push();
            //Matrix4f positionMatrix = matrixStack.peek().getPositionMatrix();
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(10));
            //matrixStack.pop();
            System.out.println("okay");
        }
    }*/
}
