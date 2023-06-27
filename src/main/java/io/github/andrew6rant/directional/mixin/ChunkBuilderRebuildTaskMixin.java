package io.github.andrew6rant.directional.mixin;

import io.github.andrew6rant.directional.Directional;
import io.github.andrew6rant.directional.DirectionalEnum;
import io.github.andrew6rant.directional.PlacementUtil;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.chunk.BlockBufferBuilderStorage;
import net.minecraft.client.render.chunk.ChunkBuilder;
import net.minecraft.client.render.chunk.ChunkOcclusionDataBuilder;
import net.minecraft.client.render.chunk.ChunkRendererRegion;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Set;

@Mixin(ChunkBuilder.BuiltChunk.RebuildTask.class)
public class ChunkBuilderRebuildTaskMixin {
    /*@ModifyVariable(method = "render",
            at = @At("STORE"), ordinal = 0)
    private MatrixStack inject(MatrixStack matrixStack) {
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
        return value;
    }*/

    /*@Redirect(method = "render",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"))//, shift = At.Shift.AFTER
    private void translateModel(MatrixStack matrices, float x, float y, float z) {
        //System.out.println("testing2!!!!");
        matrices.translate(x, y, z);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(10));
    }*/
    @Inject(method = "render",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V", shift = At.Shift.AFTER),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void translateModel(float cameraX, float cameraY, float cameraZ, BlockBufferBuilderStorage blockBufferBuilderStorage, CallbackInfoReturnable<ChunkBuilder.BuiltChunk.RebuildTask.RenderData> cir, ChunkBuilder.BuiltChunk.RebuildTask.RenderData renderData, int i, BlockPos blockPos, BlockPos blockPos2, ChunkOcclusionDataBuilder chunkOcclusionDataBuilder, ChunkRendererRegion chunkRendererRegion, MatrixStack matrixStack, Set set, Random random, BlockRenderManager blockRenderManager, Iterator var15, BlockPos blockPos3, BlockState blockState, BlockState blockState2, FluidState fluidState, RenderLayer renderLayer, BufferBuilder bufferBuilder) {
        //    private void translateModel(float cameraX, float cameraY, float cameraZ, BlockBufferBuilderStorage blockBufferBuilderStorage, CallbackInfoReturnable<ChunkBuilder.BuiltChunk.RebuildTask.RenderData> cir, ChunkBuilder.BuiltChunk.RebuildTask.RenderData renderData, int i, BlockPos blockPos, BlockPos blockPos2, ChunkOcclusionDataBuilder chunkOcclusionDataBuilder, ChunkRendererRegion chunkRendererRegion, MatrixStack matrixStack, Set set, Random random, BlockRenderManager blockRenderManager, Iterator var15, BlockPos blockPos3, BlockState blockState, BlockState blockState2, FluidState fluidState, RenderLayer renderLayer, BufferBuilder bufferBuilder) {
        //System.out.println("testing2!!!!");

        if(blockState.contains(PlacementUtil.DIRECTIONAL)) {
            matrixStack.translate(0.5, 0, 0.5);
            switch (blockState.get(PlacementUtil.DIRECTIONAL)) {
                // do nothing for case _0
                case _22_5 -> matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(22.5f));
                case _45 -> matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(45));
                case _67_5 -> matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(67.5f));
            }

            matrixStack.translate(-0.5, 0, -0.5);
        }
        //matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(10));
    }
    /*@ModifyVariable(method = "render",
            at = @At(value = "STORE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V", shift = At.Shift.AFTER))
    private ChunkBuilder.BuiltChunk.RebuildTask render(ChunkBuilder.BuiltChunk.RebuildTask value) {
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
        return value;
    }*/
}
