package me.heyimblake.FunEffects.ItemStacks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static me.heyimblake.FunEffects.Utils.Strings.*;

/**
 * Created by heyimblake on 11/16/15.
 */
public class Gadgets {
    public static ItemStack createEnderPurr(int amount){
        ItemStack enderPurr = new ItemStack(Material.ENDER_PEARL , amount);
        ItemMeta enderMeta = enderPurr.getItemMeta();
        enderMeta.setDisplayName(EnderPurrName);
        enderMeta.setLore(EnderPurrLore);
        enderPurr.setItemMeta(enderMeta);
        return enderPurr;
    }
    public static ItemStack createEnderPurr(){
        ItemStack enderPurr = new ItemStack(Material.ENDER_PEARL , 16);
        ItemMeta enderMeta = enderPurr.getItemMeta();
        enderMeta.setDisplayName(EnderPurrName);
        enderMeta.setLore(EnderPurrLore);
        enderPurr.setItemMeta(enderMeta);
        return enderPurr;
    }
    public static ItemStack createFireball(int amount){
        ItemStack sb = new ItemStack(Material.SNOW_BALL, amount);
        ItemMeta sbmeta = sb.getItemMeta();
        sbmeta.setDisplayName(FireBallName);
        sbmeta.setLore(FireBallLore);
        sb.setItemMeta(sbmeta);
        return sb;
    }
    public static ItemStack createFireball(){
        ItemStack sb = new ItemStack(Material.SNOW_BALL, 16);
        ItemMeta sbmeta = sb.getItemMeta();
        sbmeta.setDisplayName(FireBallName);
        sbmeta.setLore(FireBallLore);
        sb.setItemMeta(sbmeta);
        return sb;
    }
    public static ItemStack createEggsplosion(){
        ItemStack egg = new ItemStack(Material.EGG, 16);
        ItemMeta eggMeta = egg.getItemMeta();
        eggMeta.setDisplayName(EggsplosionName);
        eggMeta.setLore(EggsplosionLore);
        egg.setItemMeta(eggMeta);
        return egg;
    }
    public static ItemStack createEggsplosion(int amount){
        ItemStack egg = new ItemStack(Material.EGG, amount);
        ItemMeta eggMeta = egg.getItemMeta();
        eggMeta.setDisplayName(EggsplosionName);
        eggMeta.setLore(EggsplosionLore);
        egg.setItemMeta(eggMeta);
        return egg;
    }
}
