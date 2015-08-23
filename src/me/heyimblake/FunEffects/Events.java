package me.heyimblake.FunEffects;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Stairs;
import org.bukkit.util.Vector;

import java.util.Random;

import static me.heyimblake.FunEffects.APIs.Strings.*;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Events implements Listener {
    @EventHandler
    public void onSheepPunch(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            if (e.getEntity() instanceof Sheep) {
                if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                    Sheep sheep = (Sheep) e.getEntity();
                    Location sheeploc = sheep.getLocation();
                    e.setCancelled(true);
                    sheep.setHealth(8);
                    sheep.getWorld().playEffect(sheeploc.add(0,2,0), Effect.COLOURED_DUST, 3);
                    sheep.setVelocity(new Vector(0, 2.5, 0));
                    damager.sendMessage(TAG + ChatColor.WHITE + "You hit a sheep into the air!");
                    sheep.setColor(DyeColor.values()[(new Random()).nextInt(DyeColor.values().length)]);
                } else {
                    e.setCancelled(false);
                }
            } else {
                e.setCancelled(false);
            }
        } else {
            e.setCancelled(false);
        }
    }
    @EventHandler
    public void sheepFallDmg(EntityDamageEvent e){
        if (e.getEntity() instanceof Sheep){
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL ){
                e.setCancelled(true);
                e.setDamage(0);
            }
        }
    }
}