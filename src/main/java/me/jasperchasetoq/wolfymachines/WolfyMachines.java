package me.jasperchasetoq.wolfymachines;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.GitHubBuildsUpdater;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import java.io.File;

public class WolfyMachines extends JavaPlugin implements SlimefunAddon {


    @Override
    public void onEnable() {

        Config cfg = new Config(this);

        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
        }

        if (getConfig().getBoolean("options.auto-update") && getDescription().getVersion().startsWith("DEV - ")) {
            new GitHubBuildsUpdater(this, getFile(), "JasperChaseTOQ/WolfyMachines/master").start();

        }
    }
    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
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
    public static String getVersion() {
        return instance.getDescription().getVersion();
    }
}