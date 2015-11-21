package me.heyimblake.FunEffects.Mobs;

import me.heyimblake.FunEffects.Main;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

/**
 * Created by heyimblake on 11/21/2015.
 */
public class Events implements Listener {

    private void spawnRandomFirework(Location loc){
        //First random color
        Random r = new Random();
        int rc = r.nextInt(7);
        Color color = null;
        if (rc == 0) color = Color.AQUA;
        if (rc == 1) color = Color.ORANGE;
        if (rc == 2) color = Color.RED;
        if (rc == 3) color = Color.FUCHSIA;
        if (rc == 4) color = Color.GREEN;
        if (rc == 5) color = Color.LIME;
        if (rc == 6) color = Color.WHITE;

        //Second random color
        int rc2 = r.nextInt(7);
        Color color2 = null;
        if (rc2 == 0) color2 = Color.TEAL;
        if (rc2 == 1) color2 = Color.BLUE;
        if (rc2 == 2) color2 = Color.PURPLE;
        if (rc2 == 3) color2 = Color.BLACK;
        if (rc2 == 4) color2 = Color.OLIVE;
        if (rc2 == 5) color2 = Color.NAVY;
        if (rc2 == 6) color2 = Color.GRAY;

        //Random Shape
        FireworkEffect.Type shape = null;
        int rs = r.nextInt(4);
        if (rs == 0) shape = FireworkEffect.Type.BALL;
        if (rs == 1) shape = FireworkEffect.Type.BURST;
        if (rs == 2) shape = FireworkEffect.Type.STAR;
        if (rs == 3) shape = FireworkEffect.Type.CREEPER;

        //Randomly decide if a flicker will be added
        Boolean flicker = null;
        int rf = r.nextInt(2) + 1;
        if (rf == 1) flicker = true;
        if (rf == 2) flicker = false;

        FireworkEffect effect = FireworkEffect.builder().trail(false).flicker(flicker).withColor(color).withColor(color2).with(shape).build();
        final Firework fw = loc.getWorld().spawn(loc.add(0, 1, 0), Firework.class);
        FireworkMeta meta = fw.getFireworkMeta();
        meta.addEffect(effect);
        meta.setPower(0);
        fw.setFireworkMeta(meta);
        new BukkitRunnable() {
            @Override
            public void run() {
                fw.detonate();
            }
        }.runTaskLater(Main.getPlugin(), 2L);
    }

    @EventHandler
    public void onPunch(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            if (e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                if (e.getEntity() instanceof Sheep) {
                    e.setCancelled(true);
                    Sheep sheep = (Sheep) e.getEntity();
                    Location sheeploc = sheep.getLocation();
                    sheep.setColor(DyeColor.values()[(new Random()).nextInt(DyeColor.values().length)]);
                    sheep.getWorld().playEffect(sheeploc.add(0, 0, 0), Effect.SMOKE, 1);
                    sheep.setVelocity(new Vector(0, 2.2, 0));
                    damager.getWorld().playSound(damager.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                } else if (e.getEntity() instanceof Creeper) {
                    e.setCancelled(true);
                    final Creeper creeper = ((Creeper) e.getEntity());
                    creeper.setVelocity(new Vector(0, 2.2, 0));
                    creeper.setPowered(true);
                    creeper.getWorld().playSound(creeper.getLocation(), Sound.CREEPER_HISS, 10, 1);
                    creeper.getWorld().playSound(creeper.getLocation(), Sound.EXPLODE, 10, 1);
                    creeper.getWorld().playEffect(creeper.getLocation(), Effect.EXPLOSION_HUGE, 1);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            creeper.getWorld().playSound(creeper.getLocation(), Sound.EXPLODE, 10, 1);
                            creeper.getWorld().playEffect(creeper.getLocation(), Effect.EXPLOSION_LARGE, 1);
                            spawnRandomFirework(creeper.getLocation());
                        }
                    }.runTaskLater(Main.getPlugin(), 10L);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            creeper.setPowered(false);
                        }
                    }.runTaskLater(Main.getPlugin(), 40L);

                }
            }
        }
    }

    @EventHandler
    public void fallDmg(EntityDamageEvent e) {
        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
            if (e.getEntity() instanceof Sheep) {
                e.setCancelled(true);
            } else if (e.getEntity() instanceof Creeper) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent e){
        if (e.getEntity() instanceof Creeper){
            e.setCancelled(true);
        }
    }
}
