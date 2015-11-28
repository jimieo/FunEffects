package me.heyimblake.FunEffects;

import me.heyimblake.FunEffects.ItemStacks.Gadgets;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.Random;

import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        ItemStack enderPurr = Gadgets.createEnderPurr(16);
        ItemStack sb = Gadgets.createFireball(16);
        ItemStack egg = Gadgets.createEggsplosion(16);
        if (autoinvon) {
            if (!p.getInventory().contains(enderPurr)) {
                p.getInventory().remove(Material.ENDER_PEARL);
                p.getInventory().addItem(Gadgets.createEnderPurr(16));
            } if (!p.getInventory().contains(sb)) {
                p.getInventory().remove(Material.SNOW_BALL);
                p.getInventory().addItem(Gadgets.createFireball(16));
            }  if (!p.getInventory().contains(egg)) {
                p.getInventory().remove(Material.EGG);
                p.getInventory().addItem(Gadgets.createEggsplosion(16));
            }
        }
    }
}