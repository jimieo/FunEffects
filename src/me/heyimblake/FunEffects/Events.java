package me.heyimblake.FunEffects;

import me.heyimblake.FunEffects.APIs.ActionBar;
import org.bukkit.*;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.Random;

import static me.heyimblake.FunEffects.APIs.Strings.*;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        ItemStack enderPurr = new ItemStack(Material.ENDER_PEARL , 64);
        ItemMeta enderMeta = enderPurr.getItemMeta();
        enderMeta.setDisplayName(EnderPurrName);
        enderMeta.setLore(EnderPurrLore);
        enderPurr.setItemMeta(enderMeta);
        p.getInventory().setItem(0, enderPurr);
    }

    @EventHandler
    public void enderLand(ProjectileHitEvent e) {
        Player p = (Player) e.getEntity().getShooter();
        if (e.getEntity().getType() == EntityType.ENDER_PEARL) {
            Location loc = e.getEntity().getLocation();
            EnderPearl pearl = (EnderPearl) e.getEntity();
            World world = pearl.getWorld();
            pearl.getWorld().playEffect(loc.add(0, 1, 0), Effect.HEART, 5);
            pearl.getWorld().playEffect(loc.add(0, 0, 0), Effect.MOBSPAWNER_FLAMES, 5);
            pearl.getWorld().playEffect(loc.add(0, 0, 0), Effect.FIREWORKS_SPARK, 5);
            pearl.getWorld().playEffect(loc.add(0, 1, 0), Effect.MAGIC_CRIT, 5);
            world.playSound(pearl.getLocation(), Sound.CAT_MEOW, 1, 1);
        }
        else {
        }
    }

    @EventHandler
    public void enderpearlTP(PlayerTeleportEvent e){
        e.setCancelled(true);
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
                    sheep.setHealth(8);
                    sheep.setColor(DyeColor.values()[(new Random()).nextInt(DyeColor.values().length)]);
                    sheep.getWorld().playEffect(sheeploc.add(0, 0, 0), Effect.SMOKE, 3);
                    sheep.setVelocity(new Vector(0, 2.5, 0));
                    ActionBar.send(damager, ChatColor.YELLOW + "" + ChatColor.BOLD + "Baaaaaahh! " + ChatColor.RESET + ChatColor.AQUA + "You launched a sheep!");
                    damager.getWorld().playSound(damager.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                }
            }
        }
    }

    @EventHandler
    public void sheepFallDmg(EntityDamageEvent e) {
        if (e.getEntity() instanceof Sheep && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
            e.setDamage(0);
        }
        else {
        }
    }
}