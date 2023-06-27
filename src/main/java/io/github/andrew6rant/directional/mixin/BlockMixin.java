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
    @Shadow public abstract BlockState getDefaultState();

    /**
     * @author Andrew6rant (Andrew Grant)
     * @reason a little trolling
     */
    @Overwrite
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return PlacementUtil.calcPlacementState(ctx, this.getDefaultState());
    }
}
