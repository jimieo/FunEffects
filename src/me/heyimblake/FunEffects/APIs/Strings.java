package me.heyimblake.FunEffects.APIs;

import org.bukkit.ChatColor;

import java.util.*;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Strings {
    public static char heavyline = '\u2502';

    public static final String TAG = ChatColor.DARK_GRAY+""+heavyline+ChatColor.AQUA+" Fun"+ChatColor.YELLOW+""+ChatColor.BOLD+"Effects "+ChatColor.DARK_GRAY+""+heavyline+ChatColor.RESET+" ";

    public static final String EnderPurrName = ChatColor.AQUA+"Ender"+ChatColor.YELLOW+ChatColor.BOLD+"Purr"+ChatColor.RESET+ChatColor.GRAY+" (Right Click)";
    public static final List EnderPurrLore = Arrays.asList(ChatColor.GRAY + "Meow? MEOW!");

    public static final String FireBallName = ChatColor.RED+"Fire"+ChatColor.YELLOW+""+ChatColor.BOLD+"Ball"+ChatColor.GRAY+" (Right Click)";
    public static final List FireBallLore = Arrays.asList(ChatColor.GRAY+"*insert firework sound here*");
}
