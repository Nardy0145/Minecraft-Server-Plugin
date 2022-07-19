package me.nardy.commands.cmds;

import me.nardy.commands.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.*;

public class CountNearbyEntities implements CommandExecutor {
    private final Main main;

    public CountNearbyEntities(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            return true;
        }
        Player p = (Player) sender;
        List<Entity> entities = p.getNearbyEntities(16,16,16);
        int num = entities.size();
        int cows = 0;
        int sheeps = 0;
        int chickens = 0;
        p.sendMessage(String.valueOf(num));
        for (Entity entity : entities) {
            if (entity.getName().equals("Cow")) {
                cows += 1;
            } else if (entity.getName().equals("Sheep")) {
                sheeps += 1;
            } else if (entity.getName().equals("Chicken")) {
                chickens += 1;
            }
        }
        p.sendMessage(ChatColor.BLUE + "Куриц: " + chickens);
        p.sendMessage(ChatColor.DARK_RED + "Коров: " + cows);
        p.sendMessage(ChatColor.WHITE + "Овец: " + sheeps);
        return true;
    }
}
