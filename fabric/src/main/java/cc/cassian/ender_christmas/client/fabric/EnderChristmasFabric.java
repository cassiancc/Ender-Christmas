package cc.cassian.ender_christmas.client.fabric;

import cc.cassian.ender_christmas.EnderChristmas;
import net.fabricmc.api.ClientModInitializer;

public final class EnderChristmasFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        EnderChristmas.init();
    }

}
