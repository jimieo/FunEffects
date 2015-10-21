package me.heyimblake.FunEffects.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.heyimblake.FunEffects.Utils.Strings.*;
import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 10/20/15.
 */
public class toggleFireBallCMD implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("togglefireball")) {
            if (!(sender.hasPermission("funeffects.togglefireball"))) {
                sender.sendMessage(NOPERMERR);
                return true;
            } else {
                if (fireballon){
                    fireballon = false;
                    sender.sendMessage(TAG+"Toggled off FireBalls.");
                } else {
                    fireballon = true;
                    sender.sendMessage(TAG+"Toggled on FireBalls.");
                }
            }
        }
        return true;
    }
}