package io.github.andrew6rant.directional.mixin;

import io.github.andrew6rant.directional.PlacementUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;

import static net.minecraft.block.LanternBlock.HANGING;
import static net.minecraft.block.LanternBlock.WATERLOGGED;

@Mixin(LanternBlock.class)
public class LanternBlockMixin extends Block {
    public LanternBlockMixin(Settings settings) {
        super(settings);
    }
    // this is probably incompatible with "wall lantern" mods. I'll change the mixin later

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        Direction[] ctxDirections = ctx.getPlacementDirections();

        for (Direction direction : ctxDirections) {
            if (direction.getAxis() == Direction.Axis.Y) {
                BlockState blockState = this.getDefaultState().with(HANGING, direction == Direction.UP);
                if (blockState.canPlaceAt(ctx.getWorld(), ctx.getBlockPos())) {
                    return PlacementUtil.calcPlacementState(ctx, blockState.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER));
                }
            }
        }
        return null;
    }
}
