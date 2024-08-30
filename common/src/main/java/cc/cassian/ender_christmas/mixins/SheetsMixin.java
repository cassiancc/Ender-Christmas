package cc.cassian.ender_christmas.mixins;

import cc.cassian.ender_christmas.config.ModConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.EnderChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

import net.minecraft.util.Identifier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.client.render.TexturedRenderLayers.*;


@Environment(EnvType.CLIENT)
@Mixin(TexturedRenderLayers.class)
public abstract class SheetsMixin {

	@Inject(cancellable = true, at = @At("RETURN"), method = "getChestTextureId(Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/block/enums/ChestType;Z)Lnet/minecraft/client/util/SpriteIdentifier;")
	private static void enderChristmas$chooseMaterial(BlockEntity blockEntity, ChestType chestType, boolean christmas, CallbackInfoReturnable<SpriteIdentifier> cir) {
		if (ModConfig.get().christmasEveryday)
			christmas = true;
		if (blockEntity instanceof EnderChestBlockEntity && christmas) {
			cir.setReturnValue(new SpriteIdentifier(CHEST_ATLAS_TEXTURE, Identifier.of("ender_christmas", "entity/chest/ender_christmas")));
		}
		if (blockEntity instanceof ChestBlockEntity && christmas) {
			cir.setReturnValue(getChestTextureId(chestType, CHRISTMAS, CHRISTMAS_LEFT, CHRISTMAS_RIGHT));
		}
	}

	private static SpriteIdentifier getChestTextureId(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };
	}


}
