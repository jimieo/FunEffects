package me.heyimblake.FunEffects.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static me.heyimblake.FunEffects.Utils.Strings.NOPERMERR;
import static me.heyimblake.FunEffects.Utils.Booleans.eggon;
import static me.heyimblake.FunEffects.Utils.Strings.TAG;

/**
 * Created by heyimblake on 11/16/15.
 */
public class toggleEggsplosionsCMD implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("toggleeggsplosions")) {
            if (!(sender.hasPermission("funeffects.toggleeggs"))) {
                sender.sendMessage(NOPERMERR);
                return true;
            } else {
                if (eggon){
                    eggon = false;
                    sender.sendMessage(TAG+"Toggled off Eggsplosions.");
                } else {
                    eggon = true;
                    sender.sendMessage(TAG+"Toggled on Eggsplosions.");
                }
            }
        }
        return true;
    }
}