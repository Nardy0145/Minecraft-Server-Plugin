package me.nardy.commands.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class GoBed implements Listener {
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        Player p = event.getPlayer();
        if (event.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.OK))
         {
            p.sendMessage(ChatColor.LIGHT_PURPLE + "Сладких снов!");
        }
    }

}
