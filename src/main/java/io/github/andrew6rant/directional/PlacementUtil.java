package io.github.andrew6rant.directional;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.WallShape;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class PlacementUtil {
    public static final EnumProperty<DirectionalEnum> DIRECTIONAL;
    public static BlockState calcPlacementState(ItemPlacementContext ctx, BlockState state) {
        int playerYaw = RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()) % 4;
        System.out.println("playerYaw: "+playerYaw+", yaw%4: "+(playerYaw % 4));
        switch (playerYaw) {
            case 1 -> {
                return state.with(DIRECTIONAL, DirectionalEnum._67_5);
            }
            case 2 -> {
                return state.with(DIRECTIONAL, DirectionalEnum._45);
            }
            case 3 -> {
                return state.with(DIRECTIONAL, DirectionalEnum._22_5);
            }
            default -> {
                return state.with(DIRECTIONAL, DirectionalEnum._0);
            }
        }
    }

    static {
        DIRECTIONAL = EnumProperty.of("directional", DirectionalEnum.class);
    }
}
