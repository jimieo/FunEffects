package me.heyimblake.FunEffects.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.heyimblake.FunEffects.Utils.Strings.*;
import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 10/28/15.
 */
public class toggleChairsCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("togglechairs")) {
            if (!(sender.hasPermission("funeffects.togglechairs"))) {
                sender.sendMessage(NOPERMERR);
                return true;
            } else {
                if (chairson){
                    chairson = false;
                    sender.sendMessage(TAG+"Toggled chairs off.");
                } else {
                    chairson = true;
                    sender.sendMessage(TAG+"Toggled chairs on.");
                }
            }
        }
        return true;
    }
}
