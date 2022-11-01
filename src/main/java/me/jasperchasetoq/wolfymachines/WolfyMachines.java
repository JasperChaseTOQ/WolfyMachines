package me.jasperchasetoq.wolfymachines;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.GitHubBuildsUpdater;
import me.jasperchasetoq.wolfymachines.implementation.setup.WolfyMachinesItemSetup;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import java.io.File;

public class WolfyMachines extends JavaPlugin implements SlimefunAddon {


    @Override
    public void onEnable() {

        Config cfg = new Config(this);
        WolfyMachinesItemSetup.setup(this);
        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }

        if (getConfig().getBoolean("options.auto-update") && getDescription().getVersion().startsWith("DEV - ")) {
            new GitHubBuildsUpdater(this, getFile(), "JasperChaseTOQ/WolfyMachines/master").start();

            int pluginId = 16400;
            Metrics metrics = new Metrics(this, pluginId);
        }
    }
    @Override
    public void onDisable() {
    }
    @Override
    public String getBugTrackerURL() {
        return "https://github.com/JasperChaseTOQ/WolfyMachines/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    private static WolfyMachines instance;

    public WolfyMachines() {
        instance = this;
    }

    public static WolfyMachines getInstance() {
        return instance;
    }
}