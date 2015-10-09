package me.heyimblake.FunEffects;

import me.heyimblake.FunEffects.ItemStacks.EnderPurr;
import me.heyimblake.FunEffects.ItemStacks.FireBall;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import java.util.Random;

/**
 * Created by heyimblake on 8/23/2015.
 */
public class Events implements Listener {

    @EventHandler
    public void onChairClick(PlayerInteractEvent e){
        final Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (e.getClickedBlock().getType() == Material.ACACIA_STAIRS || e.getClickedBlock().getType() == Material.QUARTZ_STAIRS || e.getClickedBlock().getType() == Material.BIRCH_WOOD_STAIRS || e.getClickedBlock().getType() == Material.BRICK_STAIRS || e.getClickedBlock().getType() == Material.COBBLESTONE_STAIRS || e.getClickedBlock().getType() == Material.DARK_OAK_STAIRS || e.getClickedBlock().getType() == Material.JUNGLE_WOOD_STAIRS || e.getClickedBlock().getType() == Material.NETHER_BRICK_STAIRS || e.getClickedBlock().getType() == Material.RED_SANDSTONE_STAIRS || e.getClickedBlock().getType() == Material.SANDSTONE_STAIRS || e.getClickedBlock().getType() == Material.SMOOTH_STAIRS || e.getClickedBlock().getType() == Material.QUARTZ_STAIRS || e.getClickedBlock().getType() == Material.SPRUCE_WOOD_STAIRS || e.getClickedBlock().getType() == Material.WOOD_STAIRS) {
                Block block = e.getClickedBlock();
                if (e.getBlockFace() == BlockFace.UP) {
                    Location stair = block.getLocation().add(.5, 0, .5);
                    World world = block.getWorld();
                    p.teleport(stair);
                    final Arrow arrow = world.spawnArrow(stair, new Vector(0, -1, 0), 6/10, 12);
                    arrow.setPassenger(p);
                    BukkitScheduler removearrow = Bukkit.getServer().getScheduler();
                    removearrow.scheduleSyncDelayedTask(me.heyimblake.FunEffects.Main.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            arrow.remove();
                        }
                    }, 600);
                }
            }
        }
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        ItemStack enderPurr = EnderPurr.createEnderPurr(16);
        ItemStack sb = FireBall.createFireball(16);

        if (!p.getInventory().contains(enderPurr)){
            p.getInventory().addItem(enderPurr);
        }
        if (!p.getInventory().contains(sb)){
            p.getInventory().addItem(sb);
        }
    }

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
        else if (e.getEntity() instanceof Snowball) {
            if (e.getEntityType() == EntityType.SNOWBALL) {
                Location loc = e.getEntity().getLocation();
                Random r = new Random();
                int rc = r.nextInt(6);
                Color color = Color.WHITE;
                if (rc == 0) color = Color.AQUA;
                if (rc == 1) color = Color.ORANGE;
                if (rc == 2) color = Color.RED;
                if (rc == 3) color = Color.FUCHSIA;
                if (rc == 4) color = Color.GREEN;
                if (rc == 5) color = Color.LIME;

                Random r2 = new Random();
                int rc2 = r2.nextInt(6);
                Color color2 = Color.WHITE;
                if (rc2 == 0) color2 = Color.TEAL;
                if (rc2 == 1) color2 = Color.BLUE;
                if (rc2 == 2) color2 = Color.PURPLE;
                if (rc2 == 3) color2 = Color.BLACK;
                if (rc2 == 4) color2 = Color.OLIVE;
                if (rc2 == 5) color2 = Color.NAVY;
                FireworkEffect effect = FireworkEffect.builder().trail(false).flicker(false).withColor(color).withColor(color2).withFade(Color.GRAY).with(FireworkEffect.Type.BALL).build();
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

    @EventHandler
    public void enderpearlTP(PlayerTeleportEvent e) {
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
            e.setCancelled(true);
        }
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
                    damager.getWorld().playSound(damager.getLocation(), Sound.ITEM_PICKUP, 10, 1);
                }
            }
        }
    }

    @EventHandler
    public void sheepFallDmg(EntityDamageEvent e) {
        if (e.getEntity() instanceof Sheep && e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            e.setCancelled(true);
        }
    }
}