package cc.cassian.ender_christmas.config.fabric;


import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

import static cc.cassian.ender_christmas.EnderChristmas.MOD_ID;

public class ModConfigImpl {
    public static Path configPath() {
        return FabricLoader.getInstance().getConfigDir().resolve(MOD_ID+".json");
    }
}
