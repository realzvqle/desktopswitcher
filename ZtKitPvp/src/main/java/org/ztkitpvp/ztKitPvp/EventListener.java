package org.ztkitpvp.ztKitPvp;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().sendMessage(ChatColor.AQUA + event.getPlayer().getName() + ".\nType /kit to get a kit!");
    }
}
