package me.heyimblake.FunEffects.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.heyimblake.FunEffects.APIs.Strings.*;

/**
 * Created by heyimblake on 10/20/15.
 */
public class toggleAutoInvCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("toggleautoinv")) {
            if (!(sender.hasPermission("funeffects.toggleautoinv"))) {
                sender.sendMessage(NOPERMERR);
                return true;
            } else {
                if (autoinvon) {
                    autoinvon = false;
                    sender.sendMessage(TAG + "Toggled off automatic inventory handling on player join.");
                } else {
                    autoinvon = true;
                    sender.sendMessage(TAG + "Toggled on automatic inventory handling on player join.");
                }
            }
        }
        return true;
    }
}
