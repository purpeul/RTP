package fr.purple.rtp;

import org.bukkit.plugin.java.JavaPlugin;

public class RTPPlugin extends JavaPlugin {

    private static RTPPlugin plugin;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("rtp").setExecutor(new RTPCommand());
    }

    public static RTPPlugin inst() {
        return plugin;
    }
}