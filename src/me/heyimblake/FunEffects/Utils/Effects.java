package me.heyimblake.FunEffects.Utils;

import me.heyimblake.FunEffects.Main;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

/**
 * Created by heyimblake on 1/21/16.
 *
 * @author heyimblake
 *         Copyright (c) 2016 heyimblake.
 *         All rights reserved.
 */
public class Effects {
    static Random rdm = new Random();

    static Color[] colors1 = new Color[]{Color.AQUA, Color.ORANGE, Color.RED,
            Color.FUCHSIA, Color.GREEN, Color.LIME, Color.WHITE};

    static Color[] colors2 = new Color[]{Color.TEAL, Color.BLUE, Color.PURPLE,
            Color.BLACK, Color.OLIVE, Color.NAVY, Color.GRAY};

    static FireworkEffect.Type[] types = new FireworkEffect.Type[]{FireworkEffect.Type.BALL,
            FireworkEffect.Type.BURST, FireworkEffect.Type.STAR};

    static Boolean[] flicker = new Boolean[]{true, false};

    public static FireworkEffect getRandomFireworkEffect(){
        return FireworkEffect.builder().trail(false).flicker(flicker[rdm.nextInt(flicker.length)])
                .withColor(colors1[rdm.nextInt(colors1.length)]).withColor(colors2[rdm.nextInt(colors2.length)])
                .with(types[rdm.nextInt(types.length)]).build();
    }
    public static void doFirework(Location loc) {
        final Firework fw = loc.getWorld().spawn(loc.add(0, 1, 0), Firework.class);
        FireworkMeta meta = fw.getFireworkMeta();
        meta.addEffect(Effects.getRandomFireworkEffect());
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
