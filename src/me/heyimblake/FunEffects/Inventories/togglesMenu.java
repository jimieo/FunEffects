package me.heyimblake.FunEffects.Inventories;

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

import static me.heyimblake.FunEffects.Utils.Booleans.*;
import static me.heyimblake.FunEffects.Utils.Strings.*;

/**
 * Created by heyimblake on 11/1/2015.
 */
public class togglesMenu implements Listener {
    public static void showTogglesMenu(Player p) {

        Inventory togglesMenu = Bukkit.createInventory(p, 45, "FunEffects Toggles");

        togglesMenu.setItem(1, InventoryItems.toggleChairsItem());
        togglesMenu.setItem(3, InventoryItems.toggleEnderPurr());
        togglesMenu.setItem(5, InventoryItems.toggleFireBall());
        togglesMenu.setItem(7, InventoryItems.toggleEggsplosion());
        togglesMenu.setItem(19+9, InventoryItems.toggleAutoInv(p));
        togglesMenu.setItem(21+9, InventoryItems.toggleCreeper());
        togglesMenu.setItem(23+9, InventoryItems.toggleSpiders());
        togglesMenu.setItem(25+9, InventoryItems.toggleSheep());

        togglesMenu.setItem(27+9, InventoryItems.backArrow());

        if (chairson) {
            togglesMenu.setItem(10, InventoryItems.toggledOnItem());
        } else {
            togglesMenu.setItem(10, InventoryItems.toggledOffItem());
        }
        if (enderpurron) {
            togglesMenu.setItem(12, InventoryItems.toggledOnItem());
        } else {
            togglesMenu.setItem(12, InventoryItems.toggledOffItem());
        }
        if (fireballon) {
            togglesMenu.setItem(14, InventoryItems.toggledOnItem());
        } else {
            togglesMenu.setItem(14, InventoryItems.toggledOffItem());
        }
        if (eggon) {
            togglesMenu.setItem(16, InventoryItems.toggledOnItem());
        } else {
            togglesMenu.setItem(16, InventoryItems.toggledOffItem());
        }
        if (autoinvon) {
            togglesMenu.setItem(28+9, InventoryItems.toggledOnItem());
        } else {
            togglesMenu.setItem(28+9, InventoryItems.toggledOffItem());
        }
        if (creeperon) {
            togglesMenu.setItem(30+9, InventoryItems.toggledOnItem());
        } else {
            togglesMenu.setItem(30+9, InventoryItems.toggledOffItem());
        }
        if (spiderson) {
            togglesMenu.setItem(32+9, InventoryItems.toggledOnItem());
        } else {
            togglesMenu.setItem(32+9, InventoryItems.toggledOffItem());
        }
        if (sheepon) {
            togglesMenu.setItem(34+9, InventoryItems.toggledOnItem());
        } else {
            togglesMenu.setItem(34+9, InventoryItems.toggledOffItem());
        }
        p.openInventory(togglesMenu);
    }

    @EventHandler
    public static void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null) {
            if (e.getInventory().getName().equalsIgnoreCase("FunEffects Toggles")) {
                if (e.getClickedInventory() == p.getInventory()) {
                    e.setCancelled(true);
                    return;
                }
                if (e.getCurrentItem() == null)
                    return;
                if (e.getCurrentItem().getItemMeta() == null)
                    return;
                if (e.getCurrentItem().equals(InventoryItems.backArrow())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.CLICK, 10, 1);
                    p.closeInventory();
                    adminMain.showAdminMainMenu(p);
                } else if (e.getCurrentItem().equals(InventoryItems.toggledOffItem())) {
                    e.setCancelled(true);
                    p.sendMessage(TAG + ChatColor.DARK_RED + "Click on the actual item to toggle the setting.");
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 1);
                } else if (e.getCurrentItem().equals(InventoryItems.toggledOnItem())) {
                    e.setCancelled(true);
                    p.sendMessage(TAG + ChatColor.DARK_RED + "Click on the actual item to toggle the setting.");
                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 10, 1);
                } else if (e.getCurrentItem().equals(InventoryItems.toggleChairsItem())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                    if (chairson) {
                        chairson = false;
                    } else {
                        chairson = true;
                    }
                    p.closeInventory();
                    showTogglesMenu(p);
                } else if (e.getCurrentItem().equals(InventoryItems.toggleFireBall())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                    if (fireballon) {
                        fireballon = false;
                    } else {
                        fireballon = true;
                    }
                    p.closeInventory();
                    showTogglesMenu(p);
                } else if (e.getCurrentItem().equals(InventoryItems.toggleEnderPurr())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                    if (enderpurron) {
                        enderpurron = false;
                    } else {
                        enderpurron = true;
                    }
                    p.closeInventory();
                    showTogglesMenu(p);
                } else if (e.getCurrentItem().equals(InventoryItems.toggleEggsplosion())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                    if (eggon) {
                        eggon = false;
                    } else {
                        eggon = true;
                    }
                    p.closeInventory();
                    showTogglesMenu(p);
                } else if (e.getCurrentItem().getType().equals(Material.SKULL_ITEM)) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                    if (autoinvon) {
                        autoinvon = false;
                    } else {
                        autoinvon = true;
                    }
                    p.closeInventory();
                    showTogglesMenu(p);
                } else if (e.getCurrentItem().equals(InventoryItems.toggleCreeper())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                    if (creeperon) {
                        creeperon = false;
                    } else {
                        creeperon = true;
                    }
                    p.closeInventory();
                    showTogglesMenu(p);
                } else if (e.getCurrentItem().equals(InventoryItems.toggleSheep())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                    if (sheepon) {
                        sheepon = false;
                    } else {
                        sheepon = true;
                    }
                    p.closeInventory();
                    showTogglesMenu(p);
                } else if (e.getCurrentItem().equals(InventoryItems.toggleSpiders())) {
                    e.setCancelled(true);
                    p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                    if (spiderson) {
                        spiderson = false;
                    } else {
                        spiderson = true;
                    }
                    p.closeInventory();
                    showTogglesMenu(p);
                }
            }
        }
    }
}
