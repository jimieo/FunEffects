package me.heyimblake.FunEffects.FireBall;

import me.heyimblake.FunEffects.ItemStacks.Gadgets;
import me.heyimblake.FunEffects.Utils.Effects;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.UUID;

import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 10/12/15.
 */
public class Events implements Listener {


    private HashMap<UUID, Long> cooldowns = new HashMap<>();
    final int seconds = 2;

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
        if (e.getEntity() instanceof Snowball) {
            if (e.getEntityType() == EntityType.SNOWBALL) {
                if (fireballon) {
                    if (p.hasPermission("funeffects.useFireBall") || p.isOp()) {
                        Location loc = e.getEntity().getLocation();
                        if (p.getGameMode().equals(GameMode.CREATIVE) || p.isOp() || p.hasPermission("funeffects.bypasscooldown")) {
                            Effects.doFirework(loc);
                        } else if ((cooldowns.get(p.getUniqueId()) == null) || !hasCooldown(p)) {
                            activateCooldown(p);
                            Effects.doFirework(loc);
                        } else if (hasCooldown(p)) {
                            ItemStack fireball = Gadgets.createFireball(1);
                            p.getInventory().addItem(fireball);
                        }
                    }
                }
            }
        }
    }
}