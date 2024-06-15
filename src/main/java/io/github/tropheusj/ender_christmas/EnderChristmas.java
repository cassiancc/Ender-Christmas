package io.github.tropheusj.ender_christmas;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class EnderChristmas implements ClientModInitializer {
	public static final Identifier CHRISTMAS_ENDER_CHEST_LOCATION = new Identifier("ender_christmas", "ender_christmas");
	public static final SpriteIdentifier CHRISTMAS_ENDER_CHEST_MATERIAL = new SpriteIdentifier(
			PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, EnderChristmas.CHRISTMAS_ENDER_CHEST_LOCATION
	);

	@Override
	public void onInitializeClient() {
		ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) ->
				registry.register(CHRISTMAS_ENDER_CHEST_LOCATION)
		);
	}
}
