package me.heyimblake.FunEffects.ItemStacks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.heyimblake.FunEffects.APIs.Strings.EnderPurrLore;
import static me.heyimblake.FunEffects.APIs.Strings.EnderPurrName;

/**
 * Created by blakekhan on 10/9/15.
 */
public class EnderPurr {
    public static ItemStack createEnderPurr(int amount){
        ItemStack enderPurr = new ItemStack(Material.ENDER_PEARL , amount);
        ItemMeta enderMeta = enderPurr.getItemMeta();
        enderMeta.setDisplayName(EnderPurrName);
        enderMeta.setLore(EnderPurrLore);
        enderPurr.setItemMeta(enderMeta);
        return enderPurr;
    }
}
