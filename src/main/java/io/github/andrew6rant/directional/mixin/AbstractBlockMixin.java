package io.github.andrew6rant.directional.mixin;

import io.github.andrew6rant.directional.PlacementUtil;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public class AbstractBlockMixin {
    /*@Inject(method = "hasSidedTransparency",
            at = @At(value = "HEAD"), cancellable = true)
    private void fakeCubeCulling(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.contains(PlacementUtil.DIRECTIONAL)) {
            //System.out.println(state);
            cir.setReturnValue(true);
        }
    }*/

    @Inject(method = "getOutlineShape",
            at = @At(value = "HEAD"), cancellable = true)
    private void fakeCubeCulling(BlockState state, BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
        if (state.contains(PlacementUtil.DIRECTIONAL)) {
            cir.setReturnValue(VoxelShapes.cuboid(0.01f, 0.01f, 0.01f, 0.99f, 0.99f, 0.99f));
            cir.cancel();
        }
    }

    //@Shadow
    //protected BlockState asBlockState() {
    //    return null;
    //}

    //
    /*@Inject(method = "isFullCube",
            at = @At(value = "HEAD"))
    private void fakeCubeCulling(BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        //System.out.println("yoo");
        //cir.setReturnValue(false);
        //if (this.asBlockState().contains(PlacementUtil.DIRECTIONAL)) {
        //    cir.setReturnValue(false);
        //}
    }*/
}
