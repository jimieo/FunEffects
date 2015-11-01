package me.heyimblake.FunEffects;

import me.heyimblake.FunEffects.ItemStacks.EnderPurr;
import me.heyimblake.FunEffects.ItemStacks.FireBall;
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

import static me.heyimblake.FunEffects.Utils.Strings.*;
import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Events implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        ItemStack enderPurr = EnderPurr.createEnderPurr(16);
        ItemStack sb = FireBall.createFireball(16);
        if (autoinvon) {
            if (!p.getInventory().contains(enderPurr)) {
                p.getInventory().remove(Material.ENDER_PEARL);
                p.getInventory().addItem(EnderPurr.createEnderPurr(16));
            }
            if (!p.getInventory().contains(sb)) {
                p.getInventory().remove(Material.SNOW_BALL);
                p.getInventory().addItem(FireBall.createFireball(16));
            }
        }
    }

    @EventHandler
    public void onSheepPunch(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            if (e.getEntity() instanceof Sheep) {
                if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                    final Sheep sheep = (Sheep) e.getEntity();
                    Location sheeploc = sheep.getLocation();
                    e.setCancelled(true);
                    sheep.setColor(DyeColor.values()[(new Random()).nextInt(DyeColor.values().length)]);
                    sheep.getWorld().playEffect(sheeploc.add(0, 0, 0), Effect.SMOKE, 3);
                    sheep.setVelocity(new Vector(0, 2.2, 0));
                    damager.getWorld().playSound(damager.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                }
            }
        }
    }

    @EventHandler
    public void sheepFallDmg(EntityDamageEvent e) {
        if (e.getEntity() instanceof Sheep && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
        }
    }
}