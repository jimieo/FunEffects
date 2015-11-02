package me.heyimblake.FunEffects.ItemStacks;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.Dye;

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
    public static ItemStack togglesItem(){
        ItemStack cmd = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
        ItemMeta cmdMeta = cmd.getItemMeta();
        cmdMeta.setDisplayName(ChatColor.YELLOW+"Toggles");
        cmdMeta.setLore(Arrays.asList(ChatColor.GRAY+"Use this to toggle settings on or off.","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Select"));
        cmd.setItemMeta(cmdMeta);
        return cmd;
    }
    public static ItemStack toggledOffItem(){
        ItemStack is = new ItemStack (Material.SULPHUR);
        ItemMeta isIM = is.getItemMeta();
        isIM.setDisplayName(ChatColor.RED+"Toggled Off");
        isIM.setLore(Arrays.asList(ChatColor.GRAY+"This setting is toggled off.",ChatColor.GRAY+"Click on the item to toggle it."));
        is.setItemMeta(isIM);
        return is;
    }
    public static ItemStack toggledOnItem(){
        ItemStack dyeON = new ItemStack (Material.GLOWSTONE_DUST);
        ItemMeta isIM = dyeON.getItemMeta();
        isIM.setDisplayName(ChatColor.GREEN+"Toggled On");
        isIM.setLore(Arrays.asList(ChatColor.GRAY+"This setting is toggled on.",ChatColor.GRAY+"Click on the item to toggle it."));
        dyeON.setItemMeta(isIM);
        return dyeON;
    }
    public static ItemStack toggleChairsItem(){
        ItemStack chair = new ItemStack(Material.COBBLESTONE_STAIRS, 1);
        ItemMeta chairMeta = chair.getItemMeta();
        chairMeta.setDisplayName(ChatColor.AQUA+"Toggle Chairs");
        chairMeta.setLore(Arrays.asList(ChatColor.GRAY+"Toggles chairs usability.","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Toggle"));
        chair.setItemMeta(chairMeta);
        return chair;
    }
    public static ItemStack toggleEnderPurr(){
        ItemStack ep = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta epMeta = ep.getItemMeta();
        epMeta.setDisplayName("Toggle "+EnderPurrName);
        epMeta.setLore(Arrays.asList(ChatColor.GRAY+"Toggles EnderPurrs usability.","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Toggle"));
        ep.setItemMeta(epMeta);
        return ep;
    }
    public static ItemStack toggleFireBall(){
        ItemStack fb = new ItemStack(Material.SNOW_BALL, 1);
        ItemMeta fbMeta = fb.getItemMeta();
        fbMeta.setDisplayName("Toggle "+FireBallName);
        fbMeta.setLore(Arrays.asList(ChatColor.GRAY+"Toggles FireBalls usability.","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Toggle"));
        fb.setItemMeta(fbMeta);
        return fb;
    }
    public static ItemStack toggleAutoInv(Player p){
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setDisplayName(ChatColor.AQUA+"Toggle Automatic Inventory");
        skullMeta.setLore(Arrays.asList(ChatColor.GRAY+"Toggles Automatic Inventory Handling","",ChatColor.DARK_GRAY+""+heavyarrow+ChatColor.GOLD+" Click to Toggle"));
        skullMeta.setOwner(p.getName());
        skull.setItemMeta(skullMeta);
        return skull;
    }
}
