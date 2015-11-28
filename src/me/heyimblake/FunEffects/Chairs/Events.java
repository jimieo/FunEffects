package me.heyimblake.FunEffects.Chairs;

import me.heyimblake.FunEffects.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static me.heyimblake.FunEffects.Utils.Booleans.*;

/**
 * Created by heyimblake on 10/12/15.
 */
public class Events implements Listener {
    @EventHandler
    public void onChairClick(PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock().getType() == Material.ACACIA_STAIRS
                    || e.getClickedBlock().getType() == Material.QUARTZ_STAIRS
                    || e.getClickedBlock().getType() == Material.BIRCH_WOOD_STAIRS
                    || e.getClickedBlock().getType() == Material.BRICK_STAIRS
                    || e.getClickedBlock().getType() == Material.COBBLESTONE_STAIRS
                    || e.getClickedBlock().getType() == Material.DARK_OAK_STAIRS
                    || e.getClickedBlock().getType() == Material.JUNGLE_WOOD_STAIRS
                    || e.getClickedBlock().getType() == Material.NETHER_BRICK_STAIRS
                    || e.getClickedBlock().getType() == Material.RED_SANDSTONE_STAIRS
                    || e.getClickedBlock().getType() == Material.SANDSTONE_STAIRS
                    || e.getClickedBlock().getType() == Material.SMOOTH_STAIRS
                    || e.getClickedBlock().getType() == Material.QUARTZ_STAIRS
                    || e.getClickedBlock().getType() == Material.SPRUCE_WOOD_STAIRS
                    || e.getClickedBlock().getType() == Material.WOOD_STAIRS) {
                Block block = e.getClickedBlock();
                if (chairson) {
                    if (p.hasPermission("funeffects.usechair")) {
                        if (e.getBlockFace() == BlockFace.UP) {
                            Location stair = block.getLocation().add(.5, 0, .5);
                            World world = block.getWorld();
                            p.teleport(stair);
                            final Arrow arrow = world.spawnArrow(stair, new Vector(0, -1, 0), 6 / 10, 12);
                            arrow.setPassenger(p);
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    arrow.remove();
                                }
                            }.runTaskLater(Main.getPlugin(), 600);
                        }
                    } else {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
}