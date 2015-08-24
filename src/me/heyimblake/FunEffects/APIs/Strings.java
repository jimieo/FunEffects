package me.heyimblake.FunEffects.APIs;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Strings {
    public static char arrow = '\u00BB';
    public static char larrow = '\u00AB';
    public static char xsymbol = '\u2716';
    public static char plus = '\u271A';
    public static char BLOCK = '\u2588';

    public static char heavyline = '\u2502';
    public static char lightline = '\u2503';

    public static final String TAG = ChatColor.DARK_GRAY+""+heavyline+ChatColor.AQUA+" Fun"+ChatColor.YELLOW+""+ChatColor.BOLD+"Effects "+ChatColor.DARK_GRAY+""+heavyline+ChatColor.RESET+" ";
    public static final String EnderPurrName = ChatColor.AQUA+"Ender"+ChatColor.YELLOW+ChatColor.BOLD+"Purr"+ChatColor.RESET+ChatColor.GRAY+" (Right Click)";
    public static final List EnderPurrLore = Arrays.asList(ChatColor.DARK_AQUA + "Aim and throw this special EnderPearl for a fun surprise!");

}
