package me.heyimblake.FunEffects.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.heyimblake.FunEffects.Utils.Strings.*;
import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 10/20/15.
 */
public class toggleEnderPurrCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("toggleenderpurr")) {
            if (!(sender.hasPermission("funeffects.toggleenderpurr"))) {
                sender.sendMessage(NOPERMERR);
                return true;
            } else {
                if (enderpurron){
                    enderpurron = false;
                    sender.sendMessage(TAG+"Toggled off EnderPurrs.");
                } else {
                    enderpurron = true;
                    sender.sendMessage(TAG+"Toggled on EnderPurrs.");
                }
            }
        }
        return true;
    }
}