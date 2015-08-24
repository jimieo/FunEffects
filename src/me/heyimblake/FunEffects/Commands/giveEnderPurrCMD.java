package me.heyimblake.FunEffects.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import static me.heyimblake.FunEffects.APIs.Strings.*;

/**
 * Created by heyimblake on 8/24/2015.
 */
public class giveEnderPurrCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("giveenderpurr")) {
            ItemStack enderPurr = new ItemStack(Material.ENDER_PEARL , 16);
            ItemMeta enderMeta = enderPurr.getItemMeta();
            enderMeta.setDisplayName(EnderPurrName);
            enderMeta.setLore(EnderPurrLore);
            enderPurr.setItemMeta(enderMeta);
            if (!(sender instanceof Player)) {
                sender.sendMessage(TAG+"You must be a player to use this command.");
                return false;
            }
            else if (args.length == 0){
                Player p = (Player) sender;
                p.getInventory().setItem(0, enderPurr);
                p.sendMessage(TAG+"You have recieved 16 EnderPurrs.");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            Player p = (Player) sender;
            if (args.length == 1) {
                if (target == null) {
                    p.sendMessage(TAG+ ChatColor.DARK_RED + "Couldn't find " + args[0] +" . Are they online?");
                    return true;
                } else {
                    target.getInventory().setItem(0, enderPurr);
                    target.sendMessage(TAG + "You have recieved 16 EnderPurrs.");
                    p.sendMessage(TAG+"You have sent 16 EnderPurrs to "+args[0]);
                    return true;
                }
            }
        }
    return true;
    }
}