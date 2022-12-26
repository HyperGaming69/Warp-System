package de.hypergaming.warpplugin;

import de.hypergaming.warpplugin.commands.WarpCommand;
import de.hypergaming.warpplugin.utils.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class WarpPlugin extends JavaPlugin {

    private static Config cfg;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("warp").setExecutor(new WarpCommand());
        cfg = new Config("warps.yml", getDataFolder());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Config getCfg() {
        return cfg;
    }
}
