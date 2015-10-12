package me.heyimblake.FunEffects.EnderPurr;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * Created by heyimblake on 10/12/15.
 */
public class Events implements Listener {
    @EventHandler
    public void projectileLand(ProjectileHitEvent e) {
        Player p = (Player) e.getEntity().getShooter();
        if (e.getEntity() instanceof EnderPearl) {
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
        }
    }

    @EventHandler
    public void enderpearlTP(PlayerTeleportEvent e) {
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
            e.setCancelled(true);
        }
    }
}
