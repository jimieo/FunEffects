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
import static me.heyimblake.FunEffects.APIs.Strings.FireBallLore;

/**
 * Created by heyimblake on 9/12/2015.
 */
public class giveFireBallCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("givefireball")) {
            ItemStack sb = new ItemStack(Material.SNOW_BALL, 16);
            ItemMeta sbmeta = sb.getItemMeta();
            sbmeta.setDisplayName(FireBallName);
            sbmeta.setLore(FireBallLore);
            sb.setItemMeta(sbmeta);
            if (!(sender instanceof Player)) {
                sender.sendMessage(TAG+"You must be a player to use this command.");
                return false;
            }
            else if (args.length == 0){
                Player p = (Player) sender;
                p.getInventory().addItem(sb);
                p.sendMessage(TAG+"You have recieved 16 FireBalls.");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            Player p = (Player) sender;
            if (args.length == 1) {
                if (target == null) {
                    p.sendMessage(TAG+ ChatColor.DARK_RED + "Couldn't find " + args[0] +" . Are they online?");
                    return true;
                } else {
                    target.getInventory().addItem(sb);
                    target.sendMessage(TAG + "You have recieved 16 FireBalls.");
                    p.sendMessage(TAG+"You have sent 16 FireBalls to "+args[0]);
                    return true;
                }
            }
        }
        return true;
    }
}
