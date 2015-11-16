package me.heyimblake.FunEffects.Eggsplosion;

import me.heyimblake.FunEffects.ItemStacks.Gadgets;
import org.bukkit.*;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 11/16/15.
 */
public class Events implements Listener {
    private void doEffects(Location loc, Egg egg){
        World world = egg.getWorld();
        world.playEffect(loc, Effect.EXPLOSION_HUGE, 1);
        world.playEffect(loc.add(0, .5, 0), Effect.SMOKE, 3);
        world.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 2);
        world.playSound(loc, Sound.CHICKEN_IDLE, 10, 1);
        world.playSound(loc, Sound.EXPLODE, 10, 1);
    }

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
        if (e.getEntity() instanceof Egg) {
            if (e.getEntity().getType() == EntityType.EGG) {
                if (eggon) {
                    if (p.hasPermission("funeffects.useEggsplosions") || p.isOp()) {
                        Location loc = e.getEntity().getLocation();
                        Egg egg = (Egg) e.getEntity();
                        if (p.isOp() || p.hasPermission("funeffects.bypasscooldown") || p.getGameMode().equals(GameMode.CREATIVE)) {
                            doEffects(loc, egg);
                        } else if ((cooldowns.get(p.getUniqueId()) == null) || !hasCooldown(p)) {
                            activateCooldown(p);
                            doEffects(loc, egg);
                        } else if (hasCooldown(p)) {
                            ItemStack eggItem = Gadgets.createEggsplosion(1);
                            p.getInventory().addItem(eggItem);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void throwEgg(PlayerEggThrowEvent e){
        if (eggon) {
            e.setHatching(false);
        }
    }
}

