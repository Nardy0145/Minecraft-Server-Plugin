package me.nardy.commands.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class IfPlayerJoin implements Listener {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(ChatColor.YELLOW + "Привет, солнышко!");
    }

}
