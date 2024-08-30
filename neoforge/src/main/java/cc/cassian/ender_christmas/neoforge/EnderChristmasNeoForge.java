package cc.cassian.ender_christmas.neoforge;

import cc.cassian.ender_christmas.EnderChristmas;
import cc.cassian.ender_christmas.config.neoforge.ModConfigFactory;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import static cc.cassian.ender_christmas.helpers.ModHelpers.clothConfigInstalled;


@Mod(EnderChristmas.MOD_ID)
public final class EnderChristmasNeoForge {
    public EnderChristmasNeoForge() {
        // Run our common setup.
        EnderChristmas.init();
        registerModsPage();


    }

    //Integrate Cloth Config screen (if mod present) with NeoForge mod menu.
    public void registerModsPage() {
        if (clothConfigInstalled()) ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, ModConfigFactory::new);
    }

}
