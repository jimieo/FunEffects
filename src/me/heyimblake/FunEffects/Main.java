package me.heyimblake.FunEffects;

import me.heyimblake.FunEffects.Commands.giveEnderPurrCMD;
import me.heyimblake.FunEffects.Commands.giveFireBallCMD;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static me.heyimblake.FunEffects.APIs.Strings.*;

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
        getCommand("givefireball").setExecutor(new giveFireBallCMD());
    }
    @Override
    public void onDisable(){
        plugin = null;
    }
    public static Plugin getPlugin() {
        return plugin;
    }
}
