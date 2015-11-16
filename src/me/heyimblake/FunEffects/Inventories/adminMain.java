package me.heyimblake.FunEffects.Inventories;

import me.heyimblake.FunEffects.ItemStacks.InventoryItems;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by heyimblake on 10/31/2015.
 */
public class adminMain implements Listener {
    public static void showAdminMainMenu(Player p) {
        Inventory adminMainInv = Bukkit.createInventory(p, 9, "FunEffects Admin GUI");
        adminMainInv.setItem(2, InventoryItems.enderPurrMainMenu());
        adminMainInv.setItem(4, InventoryItems.togglesItem());
        adminMainInv.setItem(6, InventoryItems.fireBallMainMenu());
        adminMainInv.setItem(8, InventoryItems.eggsplosionMainMenu());
        p.openInventory(adminMainInv);
    }

    @EventHandler
    public static void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null) {
            if (e.getInventory().getName().equalsIgnoreCase("FunEffects Admin GUI")) {
                if (e.getClickedInventory() == p.getInventory()) {
                    e.setCancelled(true);
                    return;
                }
                if (e.getCurrentItem() == null)
                    return;
                if (e.getCurrentItem().getItemMeta() == null)
                    return;
                if (e.getCurrentItem().equals(InventoryItems.enderPurrMainMenu())) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
                    sendToWho.showSendToWhoMenu(p, InventoryItems.enderPurrMainMenu());
                } else if (e.getCurrentItem().equals(InventoryItems.fireBallMainMenu())) {
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
                    sendToWho.showSendToWhoMenu(p, InventoryItems.fireBallMainMenu());
                } else if (e.getCurrentItem().equals(InventoryItems.togglesItem())){
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
                    togglesMenu.showTogglesMenu(p);
                } else if (e.getCurrentItem().equals(InventoryItems.eggsplosionMainMenu())){
                    e.setCancelled(true);
                    p.closeInventory();
                    p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
                    sendToWho.showSendToWhoMenu(p, InventoryItems.eggsplosionMainMenu());
                }
            }
        }
    }
}