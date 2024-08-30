package cc.cassian.ender_christmas.helpers.neoforge;

import net.neoforged.fml.ModList;

public class ModHelpersImpl {
    public static boolean clothConfigInstalled() {
        return ModList.get().isLoaded("cloth_config");
    }
}
