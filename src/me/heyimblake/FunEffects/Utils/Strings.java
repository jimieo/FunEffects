package me.heyimblake.FunEffects.Utils;

import org.bukkit.ChatColor;

import java.util.*;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Strings {
    public static char heavyline = '\u2502';
    public static char heavyarrow = '\u27A4';
    public static char doublerightarrow ='\u00BB';

    public static final String TAG = ChatColor.DARK_GRAY+""+heavyline+ChatColor.AQUA+" FunEffects"+ChatColor.DARK_GRAY+""+heavyline+ChatColor.GRAY+" ";
    public static final String NONPLAYERERR = TAG+ChatColor.DARK_RED+"You must be a player to use this.";
    public static final String NOPERMERR = TAG+ChatColor.DARK_RED+"Insufficient Permissions";

    public static final String EnderPurrName = ChatColor.AQUA+"Ender"+ChatColor.YELLOW+ChatColor.BOLD+"Purr";
    public static final List EnderPurrLore = Arrays.asList(ChatColor.GRAY + "Meow? MEOW!"," ",ChatColor.DARK_AQUA+""+heavyarrow+ChatColor.AQUA+" Right Click to use.");

    public static final String FireBallName = ChatColor.RED+"Fire"+ChatColor.YELLOW+""+ChatColor.BOLD+"Ball";
    public static final List FireBallLore = Arrays.asList(ChatColor.GRAY+"Pew pew!"," ",ChatColor.DARK_AQUA+""+heavyarrow+ChatColor.AQUA+" Right Click to use.");
}
