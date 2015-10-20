package me.heyimblake.FunEffects.FireBall;

import me.heyimblake.FunEffects.Main;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

import static me.heyimblake.FunEffects.APIs.Strings.*;

/**
 * Created by heyimblake on 10/12/15.
 */
public class Events implements Listener {
    @EventHandler
    public void projectileLand(ProjectileHitEvent e) {
        Player p = (Player) e.getEntity().getShooter();
        if (e.getEntity() instanceof Snowball) {
            if (e.getEntityType() == EntityType.SNOWBALL) {
                if (fireballon) {
                    Location loc = e.getEntity().getLocation();

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
                    Random r2 = new Random();
                    int rc2 = r2.nextInt(7);
                    Color color2 = null;
                    if (rc2 == 0) color2 = Color.TEAL;
                    if (rc2 == 1) color2 = Color.BLUE;
                    if (rc2 == 2) color2 = Color.PURPLE;
                    if (rc2 == 3) color2 = Color.BLACK;
                    if (rc2 == 4) color2 = Color.OLIVE;
                    if (rc2 == 5) color2 = Color.NAVY;
                    if (rc2 == 6) color2 = Color.GRAY;

                    //Random Shape
                    Random r3 = new Random();
                    FireworkEffect.Type shape = null;
                    int rs = r3.nextInt(4);
                    if (rs == 0) shape = FireworkEffect.Type.BALL;
                    if (rs == 1) shape = FireworkEffect.Type.BURST;
                    if (rs == 2) shape = FireworkEffect.Type.STAR;
                    if (rs == 3) shape = FireworkEffect.Type.CREEPER;

                    //Randomly decide if a flicker will be added
                    Random r4 = new Random();
                    Boolean flicker = null;
                    int rf = r4.nextInt(2) + 1;
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
            }
        }
    }
}
