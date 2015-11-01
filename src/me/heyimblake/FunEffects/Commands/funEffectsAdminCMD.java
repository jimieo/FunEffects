package me.heyimblake.FunEffects.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.heyimblake.FunEffects.Utils.Strings.*;

/**
 * Created by heyimblake on 10/31/2015.
 */
public class funEffectsAdminCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("funeffectsadmin")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(NONPLAYERERR);
                return true;
            }
            if (!(sender.hasPermission("funeffects.admincmd"))) {
                sender.sendMessage(NOPERMERR);
                return true;
            }
            Player p = (Player) sender;
            me.heyimblake.FunEffects.Inventories.adminMain.showAdminMainMenu(p);
        }
        return true;
    }
}