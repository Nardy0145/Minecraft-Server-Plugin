package me.nardy.commands.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEnterLoveModeEvent;

import java.util.SplittableRandom;

public class IfCatFed implements Listener {

    @EventHandler
    public void GaveFood(EntityEnterLoveModeEvent event) {
        SplittableRandom random = new SplittableRandom();
        String name = event.getEntity().getName();
        if (name.equals("Wolf")) {
            if (random.nextInt(1, 101) <= 25) {

                Bukkit.broadcastMessage(ChatColor.GRAY + "Гав! Гав! Я люблю тебя, хозяин!");
            }
        } else if (name.equals("Cat")) {
            if (random.nextInt(1, 101) <= 25) {
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Мрр ~~ Я люблю тебя, хозяин!");
            }
        }
    }
}
