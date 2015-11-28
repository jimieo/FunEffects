package me.heyimblake.FunEffects.EnderPurr;

import me.heyimblake.FunEffects.ItemStacks.Gadgets;
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
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 10/12/15.
 */
public class Events implements Listener {

    private void doEffects(Location loc, EnderPearl pearl){

        World world = pearl.getWorld();
        world.playEffect(loc.add(0, 1, 0), Effect.HEART, 5);
        world.playEffect(loc.add(0, 0, 0), Effect.MOBSPAWNER_FLAMES, 5);
        world.playEffect(loc.add(0, 0, 0), Effect.FIREWORKS_SPARK, 5);
        world.playEffect(loc.add(0, 1, 0), Effect.MAGIC_CRIT, 5);
        world.playSound(pearl.getLocation(), Sound.CAT_MEOW, 1, 1);
    }

    private HashMap<UUID, Long> cooldowns = new HashMap<>();
    final int seconds = 1;

    private boolean hasCooldown(Player player) {
        if (cooldowns.get(player.getUniqueId()) < (System.currentTimeMillis() - seconds * 1000)) {
            cooldowns.remove(player.getUniqueId());
            return false;
        } else {
            return true;
        }
    }

    private void activateCooldown(Player player) {
        cooldowns.put(player.getUniqueId(), System.currentTimeMillis());
    }

    @EventHandler
    public void projectileLand(ProjectileHitEvent e) {
        Player p = (Player) e.getEntity().getShooter();
        if (e.getEntity() instanceof EnderPearl) {
            if (e.getEntity().getType() == EntityType.ENDER_PEARL) {
                if (enderpurron) {
                    if (p.hasPermission("funeffects.useEnderPurr") || p.isOp()) {
                        Location loc = e.getEntity().getLocation();
                        EnderPearl pearl = (EnderPearl) e.getEntity();
                        if (p.isOp() || p.hasPermission("funeffects.bypasscooldown")) {
                            doEffects(loc, pearl);
                            return;
                        } else if ((cooldowns.get(p.getUniqueId()) == null) || !hasCooldown(p)) {
                            activateCooldown(p);
                            doEffects(loc, pearl);
                        } else if (hasCooldown(p)) {
                            ItemStack enderPurr = Gadgets.createEnderPurr(1);
                            p.getInventory().addItem(enderPurr);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void enderpearlTP(PlayerTeleportEvent e) {
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
            if (enderpurron) {
                e.setCancelled(true);
            }
        }
    }
}
