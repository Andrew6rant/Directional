package io.github.andrew6rant.directional.mixin;

import io.github.andrew6rant.directional.PlacementUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Shadow private BlockState defaultState;

    ///**
    // * @author Andrew6rant (Andrew Grant)
    // * @reason a little trolling
    // */
    //@Overwrite
    //public final BlockState getDefaultState() {
    //    return PlacementUtil.calcPlacementState(ctx);
    //}

    @Shadow public abstract BlockState getDefaultState();

    /**
     * @author Andrew6rant (Andrew Grant)
     * @reason a little trolling
     */
    @Overwrite
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return PlacementUtil.calcPlacementState(ctx, this.getDefaultState());
    }

    /**
     * @author Andrew6rant (Andrew Grant)
     * @reason a little trolling
     */
    @Overwrite
    public static VoxelShape createCuboidShape(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return VoxelShapes.cuboid(minX / 15.999f, minY / 15.999f, minZ / 15.999f, maxX / 15.999f, maxY / 15.999f, maxZ / 15.999f);
    }
}
