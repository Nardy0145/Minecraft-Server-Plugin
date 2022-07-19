package me.nardy.commands.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Tameable;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class WolfTarget implements Listener {
    @EventHandler
    public void onWolfTarget(EntityTargetEvent event){
        if(event.getEntity().getName().equals("Wolf")){
            Entity w = event.getEntity();

            if (((Tameable)w).isTamed() && event.getTarget().getType().equals(EntityType.PLAYER))
            {
                event.setTarget((Entity)null);
            }
            if (((Tameable)w).isTamed() && (((Tameable)event.getTarget()).isTamed()))
            {
                event.setTarget((Entity)null);
            }
            /*

            if(String.valueOf(event.getReason()).equals("OWNER_ATTACKED_TARGET"))
            {
                if(event.getTarget().getName().equals("Nardy0145") || event.getTarget().getName().equals("LatchedTree3280"))
                {
                    event.setTarget((Entity)null);
                }
            }
            if(String.valueOf(event.getReason()).equals("TARGET_ATTACKED_OWNER")){
                if(event.getTarget().getName().equals("LatchedTree3280") || event.getTarget().getName().equals("Nardy0145"))
                {
                    event.getTarget().sendMessage(ChatColor.DARK_RED + "Плагин спас тебя от волчьей смерти...");
                    event.setTarget((Entity)null);
                }
            }

             */
        }
    }
}
