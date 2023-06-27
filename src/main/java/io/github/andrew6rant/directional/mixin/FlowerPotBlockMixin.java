package io.github.andrew6rant.directional.mixin;

import io.github.andrew6rant.directional.PlacementUtil;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;
import java.util.function.Supplier;

@Mixin(FlowerPotBlock.class)
public class FlowerPotBlockMixin extends Block implements FabricBakedModel {
	@Shadow @Final private static Map<Block, Block> CONTENT_TO_POTTED;
	@Mutable
	@Shadow @Final private final Block content;

	@Shadow
	private boolean isEmpty() {
		return this.content == Blocks.AIR;
	}

	public FlowerPotBlockMixin(Block content, AbstractBlock.Settings settings) {
		super(settings);
		this.content = content;
		CONTENT_TO_POTTED.put(content, this);
	}

	@Override // yes, I know an override is a bad idea, but I believe other mods shouldn't mess with onUse itself and just interact with the CONTENT_TO_POTTED map
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		System.out.println("state directional: " + state.get(PlacementUtil.DIRECTIONAL));
		ItemStack itemStack = player.getStackInHand(hand);
		Item item = itemStack.getItem();
		///if (item instanceof BlockItem) {
		//	Block block = CONTENT_TO_POTTED.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR);
		//}
		BlockState blockState = (item instanceof BlockItem ? CONTENT_TO_POTTED.getOrDefault(((BlockItem)item).getBlock(), Blocks.AIR) : Blocks.AIR).getDefaultState();
		boolean bl = blockState.isOf(Blocks.AIR);
		if (!bl) {
			blockState = blockState.getBlock().getDefaultState().with(PlacementUtil.DIRECTIONAL, state.get(PlacementUtil.DIRECTIONAL));
		}
		boolean bl2 = this.isEmpty();
		System.out.println("bl: " + bl + " bl2: " + bl2);
		System.out.println("blockState: " + blockState + " stateeee: " + state);
		if (bl != bl2) {
			if (bl2) {
				world.setBlockState(pos, blockState, 3);
				player.incrementStat(Stats.POT_FLOWER);
				if (!player.getAbilities().creativeMode) {
					itemStack.decrement(1);
				}
			} else {
				ItemStack itemStack2 = new ItemStack(this.content);
				if (itemStack.isEmpty()) {
					player.setStackInHand(hand, itemStack2);
				} else if (!player.giveItemStack(itemStack2)) {
					player.dropItem(itemStack2, false);
				}

				world.setBlockState(pos, Blocks.FLOWER_POT.getDefaultState().with(PlacementUtil.DIRECTIONAL, state.get(PlacementUtil.DIRECTIONAL)), 3);
			}

			world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
			return ActionResult.success(world.isClient);
		} else {
			return ActionResult.CONSUME;
		}
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return PlacementUtil.calcPlacementState(ctx, this.getDefaultState());
	}

	@Override
	public boolean isVanillaAdapter() {
		return false;
	}

	@Override
	public void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context) {
	}

	@Override
	public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {
	}
}