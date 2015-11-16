package me.heyimblake.FunEffects.Inventories;

import me.heyimblake.FunEffects.ItemStacks.Gadgets;
import me.heyimblake.FunEffects.ItemStacks.InventoryItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;

import static me.heyimblake.FunEffects.Utils.Strings.*;

/**
 * Created by heyimblake on 10/31/2015.
 */
public class choosePlayer implements Listener {
    private static ItemStack selected;
    private static ArrayList<Player> online = new ArrayList<>();
    private static int invsize;
    public static void showSendToWhoMenu(Player p, ItemStack selectedItem) {
        if (Bukkit.getOnlinePlayers().size() <= 54) {

            if (Bukkit.getOnlinePlayers().size() <= 9) invsize = 9;
            else if (Bukkit.getOnlinePlayers().size() <= 27) invsize = 27;
            else if (Bukkit.getOnlinePlayers().size() <= 36) invsize = 36;
            else if (Bukkit.getOnlinePlayers().size() <= 45) invsize = 45;
            else if (Bukkit.getOnlinePlayers().size() <= 54) invsize = 54;

            online.clear();
            online.addAll(Bukkit.getOnlinePlayers());
            Inventory choosePInv = Bukkit.createInventory(p, invsize, "Select a Player");
            for (int i = 0; i < online.size(); i++) {
                String playerName = online.get(i).getName();
                ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
                SkullMeta meta = (SkullMeta) skull.getItemMeta();
                meta.setDisplayName(playerName);
                meta.setLore(Arrays.asList(ChatColor.GRAY + "Give to this player.", "", ChatColor.DARK_GRAY + "" + heavyarrow + ChatColor.GOLD + " Click to Select"));
                meta.setOwner(playerName);
                skull.setItemMeta(meta);
                choosePInv.addItem(skull);
            }
            selected = selectedItem;
            p.openInventory(choosePInv);
        }
        else {
            p.sendMessage(TAG+ChatColor.DARK_RED+"Too many players are online to use this feature. Use the direct commands instead.");
        }
    }

    @EventHandler
    public static void clickEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null) {
            if (e.getClickedInventory().getName().equals("Select a Player")) {
                if (e.getClickedInventory() == p.getInventory()) {
                    e.setCancelled(true);
                    return;
                }
                if (e.getCurrentItem() == null)
                    return;
                if (e.getCurrentItem().getItemMeta() == null)
                    return;
                if (e.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
                    e.setCancelled(true);
                    Player target = Bukkit.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 10 ,1 );
                    p.closeInventory();
                    if (selected.equals(InventoryItems.enderPurrMainMenu())) {
                        target.getInventory().addItem(Gadgets.createEnderPurr(16));
                        target.sendMessage(TAG+"You have recieved some EnderPearls.");
                    } else if (selected.equals(InventoryItems.fireBallMainMenu())) {
                        target.getInventory().addItem(Gadgets.createFireball(16));
                        target.sendMessage(TAG+"You have recieved some FireBalls.");
                    } else if (selected.equals(InventoryItems.eggsplosionMainMenu())) {
                        target.getInventory().addItem(Gadgets.createEggsplosion(16));
                        target.sendMessage(TAG+"You have recieved some Eggsplosions.");
                    }
                }
            }
        }
    }
}