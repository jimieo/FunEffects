package me.heyimblake.FunEffects;

import me.heyimblake.FunEffects.Commands.giveEnderPurrCMD;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Main extends JavaPlugin {
    public static Main plugin;
    @Override
    public void onEnable(){
        plugin = this;
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new Events(), this);
        getCommand("giveenderpurr").setExecutor(new giveEnderPurrCMD());
    }
    @Override
    public void onDisable(){
        plugin = null;
    }
    public static Plugin getPlugin() {
        return plugin;
    }
}
