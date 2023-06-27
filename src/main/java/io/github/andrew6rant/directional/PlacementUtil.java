package io.github.andrew6rant.directional;

import com.google.common.collect.Table;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.RotationPropertyHelper;

public class PlacementUtil {
    public static final EnumProperty<DirectionalEnum> DIRECTIONAL;
    private Table<Property<?>, Comparable<?>, Object> withTable;
    public static BlockState calcPlacementState(ItemPlacementContext ctx, BlockState state) {
        if(!state.contains(DIRECTIONAL)) return state;
        int playerYaw = RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()) % 4;
        //System.out.println("playerYaw: "+playerYaw+", yaw%4: "+(playerYaw % 4));
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

    public static DirectionalEnum calcPlacementState(ItemPlacementContext ctx) {
        int playerYaw = RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()) % 4;
        switch (playerYaw) {
            case 1 -> {
                return DirectionalEnum._67_5;
            }
            case 2 -> {
                return DirectionalEnum._45;
            }
            case 3 -> {
                return DirectionalEnum._22_5;
            }
            default -> {
                return DirectionalEnum._0;
            }
        }
    }



    static {
        DIRECTIONAL = EnumProperty.of("directional", DirectionalEnum.class);
    }
}
