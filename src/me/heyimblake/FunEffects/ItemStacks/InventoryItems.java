package me.heyimblake.FunEffects.ItemStacks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

import static me.heyimblake.FunEffects.Utils.Strings.*;

/**
 * Created by heyimblake on 10/31/2015.
 */
public class InventoryItems {
    public static ItemStack enderPurrMainMenu(){
        ItemStack ep = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta epMeta = ep.getItemMeta();
        epMeta.setDisplayName("Give "+EnderPurrName);
        epMeta.setLore(Arrays.asList(ChatColor.GRAY+"Give somebody some EnderPurrs!","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Select"));
        ep.setItemMeta(epMeta);
        return ep;
    }
    public static ItemStack fireBallMainMenu(){
        ItemStack fb = new ItemStack(Material.SNOW_BALL, 1);
        ItemMeta fbMeta = fb.getItemMeta();
        fbMeta.setDisplayName("Give "+FireBallName);
        fbMeta.setLore(Arrays.asList(ChatColor.GRAY+"Give somebody some FireBalls!","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Select"));
        fb.setItemMeta(fbMeta);
        return fb;
    }
    public static ItemStack selfPlayerHead(Player p){
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(ChatColor.GREEN+"Give to Yourself");
        skullMeta.setLore(Arrays.asList(ChatColor.GRAY+"Greedy much?","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Select"));
        skullMeta.setOwner(p.getName());
        skull.setItemMeta(skullMeta);
        return skull;
    }
    public static ItemStack anotherPlayerItem(){
        ItemStack skullPlayer = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullPMeta = (SkullMeta) skullPlayer.getItemMeta();
        skullPMeta.setDisplayName(ChatColor.GREEN+"Give to Another Player");
        skullPMeta.setLore(Arrays.asList(ChatColor.GRAY+"Aww, how nice of you!","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Select"));
        skullPlayer.setItemMeta(skullPMeta);
        return skullPlayer;
    }
    public static ItemStack currentItem(){
        ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1 , (short) 7);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW+"Selected Item");
        item.setItemMeta(itemMeta);
        return item;
    }
    public static ItemStack backArrow(){
        ItemStack arrow = new ItemStack(Material.ARROW, 1);
        ItemMeta arrowItemMeta = arrow.getItemMeta();
        arrowItemMeta.setDisplayName(ChatColor.RED+"Back");
        arrowItemMeta.setLore(Arrays.asList(ChatColor.GRAY+"Go back a page.","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Select"));
        arrow.setItemMeta(arrowItemMeta);
        return arrow;
    }
}
