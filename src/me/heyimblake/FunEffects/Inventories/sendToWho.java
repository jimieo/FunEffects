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


/**
 * Created by heyimblake on 10/31/2015.
 */
public class sendToWho implements Listener {
    private static ItemStack selected;
    public static void showSendToWhoMenu(Player p, ItemStack selectedItem) {
        Inventory adminMainInv = Bukkit.createInventory(p, 27, "Who do you want to give this to?");
        adminMainInv.setItem(11, InventoryItems.selfPlayerHead(p));
        adminMainInv.setItem(15, InventoryItems.anotherPlayerItem());

        if (selectedItem.equals(InventoryItems.enderPurrMainMenu())) {
            adminMainInv.setItem(22, Gadgets.createEnderPurr());
        } else if (selectedItem.equals(InventoryItems.fireBallMainMenu())) {
            adminMainInv.setItem(22, Gadgets.createFireball());
        } else if (selectedItem.equals(InventoryItems.eggsplosionMainMenu())) {
            adminMainInv.setItem(22, Gadgets.createEggsplosion());
        }
        adminMainInv.setItem(18, InventoryItems.backArrow());
        adminMainInv.setItem(21, InventoryItems.currentItem());
        adminMainInv.setItem(23, InventoryItems.currentItem());

        p.openInventory(adminMainInv);
        selected = selectedItem;
    }

    @EventHandler
    public static void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null) {
            if (e.getInventory().getName().equalsIgnoreCase("Who do you want to give this to?")) {
                if (e.getClickedInventory() == p.getInventory()) {
                    e.setCancelled(true);
                    return;
                }
                if (e.getCurrentItem() == null)
                    return;
                if (e.getCurrentItem().getItemMeta() == null)
                    return;
                if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN+"Give to Yourself")) {
                        e.setCancelled(true);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 1);
                        p.closeInventory();
                        if (selected.equals(InventoryItems.enderPurrMainMenu())) {
                            p.getInventory().addItem(Gadgets.createEnderPurr(16));
                        } else if (selected.equals(InventoryItems.fireBallMainMenu())) {
                            p.getInventory().addItem(Gadgets.createFireball(16));
                        } else if (selected.equals(InventoryItems.eggsplosionMainMenu())) {
                            p.getInventory().addItem(Gadgets.createEggsplosion(16));
                        }
                    }
                    else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN+"Give to Another Player")) {
                        e.setCancelled(true);
                        p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
                        p.closeInventory();
                        choosePlayer.showSendToWhoMenu(p, selected);
                    }
                } else if (e.getCurrentItem().equals(InventoryItems.currentItem())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 1);
                } else if (e.getCurrentItem().equals(Gadgets.createFireball())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 1);
                } else if (e.getCurrentItem().equals(Gadgets.createEnderPurr())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 1);
                } else if (e.getCurrentItem().equals(Gadgets.createEggsplosion())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 1);
                } else if (e.getCurrentItem().equals(InventoryItems.backArrow())){
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
                    p.closeInventory();
                    adminMain.showAdminMainMenu(p);
                }
            }
        }
    }
}