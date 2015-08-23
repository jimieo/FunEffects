package me.heyimblake.FunEffects.APIs;


import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Utility class for sending action bar messages to players.
 * @author Luca
 * https://github.com/TheLuca98/TextAPI
 */
public class ActionBar {

    /**
     * Sends an action bar message to a specific player.
     * @param player The player to send the message to.
     * @param message The message to send.
     */
    public static void send(Player player, String message) {
        PlayerConnection pc = ((CraftPlayer) player).getHandle().playerConnection;
        IChatBaseComponent component = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat packet = new PacketPlayOutChat(component, (byte) 2);
        pc.sendPacket(packet);
    }

    /**
     * Sends an action bar message to all online players.
     * @param message The message to send.
     */
    public static void sendToAll(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            send(player, message);
        }
    }

}