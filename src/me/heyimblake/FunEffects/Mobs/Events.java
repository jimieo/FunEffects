package me.heyimblake.FunEffects.Mobs;

import me.heyimblake.FunEffects.Main;
import me.heyimblake.FunEffects.Utils.Effects;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static me.heyimblake.FunEffects.Utils.Booleans.*;

import java.util.Random;

/**
 * Created by heyimblake on 11/21/2015.
 */
public class Events implements Listener {

    private void creeperEffects(final Creeper creeper){
        creeper.setVelocity(new Vector(0, 1.5, 0));
        creeper.setPowered(true);
        creeper.getWorld().playSound(creeper.getLocation(), Sound.CREEPER_HISS, 10, 1);
        creeper.getWorld().playSound(creeper.getLocation(), Sound.EXPLODE, 10, 1);
        creeper.getWorld().playEffect(creeper.getLocation(), Effect.EXPLOSION_HUGE, 1);
        new BukkitRunnable() {
            @Override
            public void run() {
                creeper.getWorld().playSound(creeper.getLocation(), Sound.EXPLODE, 10, 1);
                creeper.getWorld().playEffect(creeper.getLocation(), Effect.EXPLOSION_LARGE, 1);
                Effects.doFirework(creeper.getLocation());
            }
        }.runTaskLater(Main.getPlugin(), 10L);
        new BukkitRunnable() {
            @Override
            public void run() {
                creeper.setPowered(false);
            }
        }.runTaskLater(Main.getPlugin(), 40L);
    }

    @EventHandler
    public void onPunch(EntityDamageByEntityEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
            if (e.getDamager() instanceof Player) {
                final Player damager = (Player) e.getDamager();
                if (e.getEntity() instanceof Sheep && sheepon) {
                    e.setCancelled(true);
                    Sheep sheep = (Sheep) e.getEntity();
                    Location sheeploc = sheep.getLocation();
                    sheep.setColor(DyeColor.values()[(new Random()).nextInt(DyeColor.values().length)]);
                    sheep.getWorld().playEffect(sheeploc.add(0, 0, 0), Effect.EXPLOSION_LARGE, 1);
                    sheep.setVelocity(new Vector(0, 1.5, 0));
                    damager.getWorld().playSound(damager.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                } else if (e.getEntity() instanceof Creeper && creeperon) {
                    e.setCancelled(true);
                    Creeper creeper = ((Creeper) e.getEntity());
                    creeperEffects(creeper);
                } else if ((e.getEntity() instanceof Spider || e.getEntity() instanceof CaveSpider) && spiderson) {
                    e.setCancelled(true);
                    final Entity entity = e.getEntity();
                    entity.setVelocity(new Vector(0, 1.7, 0));
                    entity.setPassenger(damager);
                    entity.getWorld().playEffect(entity.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                    entity.getWorld().playEffect(entity.getLocation(), Effect.EXPLOSION_LARGE, 1);
                    damager.playSound(damager.getLocation(), Sound.SPIDER_IDLE, 10, 1);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Effects.doFirework(entity.getLocation());
                            entity.getWorld().playEffect(entity.getLocation(), Effect.MAGIC_CRIT, 1);
                        }
                    }.runTaskLater(Main.getPlugin(), 20L);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            entity.eject();
                        }
                    }.runTaskLater(Main.getPlugin(), 45L);
                }
            }
        }
    }

    @EventHandler
    public void noDmg(EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
            if (e.getEntity() instanceof Sheep && sheepon) {
                e.setCancelled(true);
            } else if (e.getEntity() instanceof Creeper && creeperon) {
                e.setCancelled(true);
            } else if (e.getEntity() instanceof Spider && spiderson) {
                e.setCancelled(true);
            } else if (e.getEntity() instanceof CaveSpider && spiderson) {
                e.setCancelled(true);
            } else if (e.getEntity() instanceof Player) {
                e.setCancelled(true);
            }
        } else if (e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e){
        if (e.getEntity() instanceof Creeper && creeperon){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void mobTracking(EntityTargetLivingEntityEvent e){
        if (e.getEntity() instanceof Creeper && creeperon){
            e.setCancelled(true);
        } else if (e.getEntity() instanceof Spider && spiderson){
            e.setCancelled(true);
        } else if (e.getEntity() instanceof CaveSpider && spiderson){
            e.setCancelled(true);
        }
    }
}
