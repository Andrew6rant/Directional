package io.github.andrew6rant.directional.mixin;

import io.github.andrew6rant.directional.PlacementUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.item.ItemPlacementContext;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TorchBlock.class)
public class TorchBlockMixin extends Block {
    public TorchBlockMixin(Settings settings) {
        super(settings);
    }
    // don't worry, WallTorchBlock's placement state is handled elsewhere - this override shouldn't be too incompatible with other mods
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return PlacementUtil.calcPlacementState(ctx, this.getDefaultState());
    }
}
