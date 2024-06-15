package io.github.tropheusj.ender_christmas.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.tropheusj.ender_christmas.EnderChristmas.CHRISTMAS_ENDER_CHEST_MATERIAL;

@Environment(EnvType.CLIENT)
@Mixin(TexturedRenderLayers.class)
public abstract class SheetsMixin {
	@Inject(cancellable = true, at = @At("RETURN"), method = "getChestTexture(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;")
	private static void enderChristmas$chooseMaterial(BlockEntity blockEntity, ChestType chestType, boolean christmas, CallbackInfoReturnable<SpriteIdentifier> cir) {
		if (blockEntity instanceof EnderChestBlockEntity && christmas) {
			cir.setReturnValue(CHRISTMAS_ENDER_CHEST_MATERIAL);
		}
	}
}
