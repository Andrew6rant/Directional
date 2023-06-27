package io.github.andrew6rant.directional.mixin;

import io.github.andrew6rant.directional.PlacementUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PistonBlock;
import net.minecraft.item.ItemPlacementContext;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static net.minecraft.block.PistonBlock.EXTENDED;
import static net.minecraft.state.property.Properties.FACING;

@Mixin(PistonBlock.class)
public class PistonMixin extends Block {

    public PistonMixin(Settings settings) {
        super(settings);
    }

    /**
     * @author Andrew6rant (Andrew Grant)
     * @reason a little trolling
     */
    @Overwrite
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite()).with(EXTENDED, false).with(PlacementUtil.DIRECTIONAL, PlacementUtil.calcPlacementState(ctx));
        //return calcPlacementState(ctx, this.getDefaultState());
    }
}
