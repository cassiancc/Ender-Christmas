package cc.cassian.ender_christmas.config.fabric;

import cc.cassian.ender_christmas.EnderChristmas;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import static cc.cassian.ender_christmas.helpers.ModHelpers.clothConfigInstalled;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        //Display Cloth Config screen if mod present, else error.
        if (clothConfigInstalled()) return new ModConfigFactory();
        else {
            EnderChristmas.LOGGER.warn("User attempted to edit config, but Cloth Config is not present!");
            return parent -> null;
        }
    }
}