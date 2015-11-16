package me.heyimblake.FunEffects;

import me.heyimblake.FunEffects.Commands.*;
import me.heyimblake.FunEffects.Inventories.adminMain;
import me.heyimblake.FunEffects.Inventories.choosePlayer;
import me.heyimblake.FunEffects.Inventories.sendToWho;
import me.heyimblake.FunEffects.Inventories.togglesMenu;
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
        pm.registerEvents(new me.heyimblake.FunEffects.EnderPurr.Events(), this);
        pm.registerEvents(new me.heyimblake.FunEffects.FireBall.Events(), this);
        pm.registerEvents(new me.heyimblake.FunEffects.Chairs.Events(), this);
        pm.registerEvents(new adminMain(), this);
        pm.registerEvents(new sendToWho(), this);
        pm.registerEvents(new choosePlayer(), this);
        pm.registerEvents(new togglesMenu(), this);
        pm.registerEvents(new me.heyimblake.FunEffects.Eggsplosion.Events(), this);
        getCommand("giveenderpurr").setExecutor(new giveEnderPurrCMD());
        getCommand("givefireball").setExecutor(new giveFireBallCMD());
        getCommand("toggleautoinv").setExecutor(new toggleAutoInvCMD());
        getCommand("toggleenderpurr").setExecutor(new toggleEnderPurrCMD());
        getCommand("togglefireball").setExecutor(new toggleFireBallCMD());
        getCommand("togglechairs").setExecutor(new toggleChairsCMD());
        getCommand("funeffectsadmin").setExecutor(new funEffectsAdminCMD());
    }
    @Override
    public void onDisable(){
        plugin = null;
    }
    public static Plugin getPlugin() {
        return plugin;
    }
}
