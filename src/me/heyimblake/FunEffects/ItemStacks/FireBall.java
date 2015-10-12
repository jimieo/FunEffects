package me.heyimblake.FunEffects.ItemStacks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.heyimblake.FunEffects.APIs.Strings.FireBallLore;
import static me.heyimblake.FunEffects.APIs.Strings.FireBallName;

/**
 * Created by heyimblake on 10/9/15.
 */
public class FireBall {
    public static ItemStack createFireball(int amount){
        ItemStack sb = new ItemStack(Material.SNOW_BALL, amount);
        ItemMeta sbmeta = sb.getItemMeta();
        sbmeta.setDisplayName(FireBallName);
        sbmeta.setLore(FireBallLore);
        sb.setItemMeta(sbmeta);
        return sb;
    }
    public static ItemStack createFireball(){
        ItemStack sb = new ItemStack(Material.SNOW_BALL, 1);
        ItemMeta sbmeta = sb.getItemMeta();
        sbmeta.setDisplayName(FireBallName);
        sbmeta.setLore(FireBallLore);
        sb.setItemMeta(sbmeta);
        return sb;
    }
}
