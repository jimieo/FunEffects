package me.heyimblake.FunEffects;

import me.heyimblake.FunEffects.APIs.ActionBar;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
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
                    sheep.setColor(DyeColor.values()[(new Random()).nextInt(DyeColor.values().length)]);
                    sheep.getWorld().playEffect(sheeploc.add(0, 2, 0), Effect.COLOURED_DUST, 3);
                    sheep.setVelocity(new Vector(0, 2.5, 0));
                    ActionBar.send(damager, ChatColor.YELLOW + "" + ChatColor.BOLD + "Baaaaaahh! " + ChatColor.RESET + ChatColor.AQUA + "You launched a sheep!");
                    damager.getWorld().playSound(damager.getLocation(), Sound.ITEM_PICKUP, 10, 1);
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
    public void sheepFallDmg(EntityDamageEvent e) {
        if (e.getEntity() instanceof Sheep && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
            e.setDamage(0);
        }
    }
}