package io.github.andrew6rant.directional;

import net.fabricmc.api.ModInitializer;

import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.BooleanProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import virtuoel.statement.api.StateRefresher;

import static io.github.andrew6rant.directional.PlacementUtil.DIRECTIONAL;

public class Directional implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("directional");

	@Override
	public void onInitialize() {
		for (Block block : Registries.BLOCK) {
			if (block instanceof FlowerPotBlock || block instanceof TorchBlock || block instanceof LanternBlock || block instanceof RedstoneBlock || block instanceof PistonBlock || block instanceof PistonHeadBlock || block instanceof PistonExtensionBlock || block instanceof DispenserBlock) {
				StateRefresher.INSTANCE.addBlockProperty(block, DIRECTIONAL, DirectionalEnum._0);
			}
		}
		StateRefresher.INSTANCE.reorderBlockStates();
	}
}