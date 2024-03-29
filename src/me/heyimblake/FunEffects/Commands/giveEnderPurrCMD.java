package me.heyimblake.FunEffects.Commands;

import me.heyimblake.FunEffects.ItemStacks.Gadgets;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.heyimblake.FunEffects.Utils.Strings.*;

/**
 * Created by heyimblake on 8/24/2015.
 */
public class giveEnderPurrCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("giveenderpurr")) {
           ItemStack enderPurr = Gadgets.createEnderPurr(16);
            if (!(sender instanceof Player)) {
                sender.sendMessage(NONPLAYERERR);
                return true;
            }
            if (!(sender.hasPermission("funeffects.giveender"))) {
                sender.sendMessage(NOPERMERR);
                return true;
            }
            else if (args.length == 0){
                Player p = (Player) sender;
                p.getInventory().addItem(enderPurr);
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
                    target.getInventory().addItem(enderPurr);
                    target.sendMessage(TAG + "You have recieved 16 EnderPurrs.");
                    p.sendMessage(TAG+"You have sent 16 EnderPurrs to "+args[0]);
                    return true;
                }
            }
            if (args.length >= 2) {
                p.sendMessage(TAG+ChatColor.DARK_RED+"Usage /giveenderpurr (player)");
                return true;
            }
        }
    return true;
    }
}